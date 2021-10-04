package Lecture_17;

import Lecture_17.User.Root;
import Lecture_17.User.RootArray;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Lecture_17 {
    @BeforeTest
    public void preconditions() {
        baseURI = "https://reqres.in";
    }

    @DataProvider(parallel = true)
    public Object[][] data() {
        return new Object[][]{
                {7},
                {8},
                {9},
                {10},
                {11},
                {12}
        };
    }

    @Test(dataProvider = "data")
    public void usersList(int integer) {
        String endpoint = "/api/users?id=" + integer;
        given().get(endpoint).then().statusCode(HttpStatus.SC_OK).extract().response().getBody().prettyPrint();
        Root root = given().when().get(endpoint).as(Root.class);
        Assert.assertEquals(root.data.id, integer);

    }

    @Test
    public void singleUser() {
        String endpoint = "/api/users/2";
        given().get(endpoint).then().statusCode(HttpStatus.SC_OK).extract().response().getBody().prettyPrint();
        Root root = given().when().get(endpoint).as(Root.class);
        Assert.assertEquals(root.data.email, "janet.weaver@reqres.in");

    }

    @Test
    public void singleUserNotFound() {
        String endpoint = "api/users/23";
        given().get(endpoint).then().statusCode(HttpStatus.SC_NOT_FOUND).extract().response().getBody();
        Response response = given().get(endpoint).then().extract().response();
        Assert.assertEquals(response.prettyPrint(), "{\n" +
                "    \n" +
                "}");

    }
//не работает 
    @Test
    public void resourceList() {
        String endpoint = "/api/unknown";
        given().get(endpoint).then().statusCode(HttpStatus.SC_OK).extract().response().getBody().prettyPrint();
        RootArray root = given().when().get(endpoint).as(RootArray.class);
        Assert.assertEquals(root.support.url, "https://reqres.in/#support-heading");
    }

    @Test
    public void singleResource() {
        String endpoint = "/api/unknown/2";
        given().get(endpoint).then().statusCode(HttpStatus.SC_OK).extract().response().getBody().prettyPrint();
        Root root = given().when().get(endpoint).as(Root.class);
        Assert.assertEquals(root.data.id, 2);
    }

    @Test
    public void singleResourceNotFound() {
        String endpoint = "/api/unknown/23";
        given().get(endpoint).then().statusCode(HttpStatus.SC_NOT_FOUND).extract().response().getBody();
        Response response = given().get(endpoint).then().extract().response();
        Assert.assertEquals(response.prettyPrint(), "{\n" +
                "    \n" +
                "}");

    }

    @Test
    public void createUser() {
        String endpoint = "/api/users";
        String requestBody = readFileAsString("post");
        Response response = given().header("Content-Type", "application/json")
                .and().body(requestBody)
                .and().post(endpoint)
                .then().statusCode(HttpStatus.SC_CREATED)
                .extract().response();
        Assert.assertEquals(response.jsonPath().get("name"), "morpheus");
        Assert.assertEquals(response.jsonPath().get("job"), "leader");
    }
    @Test
    public void updateUser() {
        String endpoint = "/api/users/2";
        String requestBody = readFileAsString("put");
        Response response = given().header("Content-Type", "application/json")
                .and().body(requestBody)
                .and().put(endpoint)
                .then().statusCode(HttpStatus.SC_OK)
                .extract().response();
        Assert.assertEquals(response.jsonPath().get("name"), "morpheus");
        Assert.assertEquals(response.jsonPath().get("job"), "zion resident");
    }

    @Test
    public void updateUser2() {
        String endpoint = "/api/users/2";
        String requestBody = readFileAsString("patch");
        Response response = given().header("Content-Type", "application/json")
                .and().body(requestBody)
                .and().patch(endpoint)
                .then().statusCode(HttpStatus.SC_OK)
                .extract().response();
        Assert.assertEquals(response.jsonPath().get("name"), "morpheus");
        Assert.assertEquals(response.jsonPath().get("job"), "zion resident");
    }

    @Test
    public void deleteUser() {
        String endpoint = "/api/users/2";
        Response response = given().delete(endpoint).then().extract().response();
        Assert.assertEquals(response.statusCode(), 204);
    }

    @Test
    public void registerUser() {
        String endpoint = "/api/register";
        String requestBody = readFileAsString("registeredUser");
        Response response = given().header("Content-Type", "application/json").body(requestBody)
                .and().post(endpoint).then().extract().response();
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(response.jsonPath().get("token"),"QpwL5tke4Pnpja7X4");
    }
    @Test
    public void notRegisterUser() {
        String endpoint = "/api/register";
        String requestBody = readFileAsString("notRegistered");
        Response response = given().header("Content-Type", "application/json").body(requestBody)
                .and().post(endpoint).then().extract().response();
        Assert.assertEquals(response.getStatusCode(), 400);
        Assert.assertEquals(response.jsonPath().get("error"), "Missing password");

    }
    @Test
    public void loginUser() {
        String endpoint = "/api/login";
        String requestBody = readFileAsString("loginPassed");
        Response response = given().header("Content-Type", "application/json").body(requestBody)
                .and().post(endpoint).then().extract().response();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("token"), "QpwL5tke4Pnpja7X4");

    }

    @Test
    public void loginFail() {
        String endpoint = "/api/login";
        String requestBody = readFileAsString("loginFail");
        Response response = given().header("Content-Type", "application/json").body(requestBody)
                .and().post(endpoint).then().extract().response();
        Assert.assertEquals(response.getStatusCode(), 400);
        Assert.assertEquals(response.jsonPath().get("error"), "Missing password");

    }
    //nоже не работает
    @Test
    public void delay() {
        String endpoint = "/api/users?delay=3";
        given().get(endpoint).then().statusCode(HttpStatus.SC_OK).extract().response().getBody();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
        RootArray root = given().when().get(endpoint).as(RootArray.class);
        Assert.assertEquals(root.support.text,"To keep ReqRes free, contributions towards server costs are appreciated!");

    }


    public static String readFileAsString(String fileName) {
        try {
            return new String(Files.readAllBytes(Paths.get("src/test/java/Lecture_17/requests/" + fileName + ".json")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
