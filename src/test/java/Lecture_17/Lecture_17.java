package Lecture_17;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Lecture_17 {
    @BeforeTest
    public void preconditions() {
        baseURI = "https://reqres.in";
    }

    @Test
    public void test1(){
        String endpoint = "/api/users?id=1";
        given().get(endpoint).then().statusCode(200).extract().response().getBody().prettyPrint();

    }
}
