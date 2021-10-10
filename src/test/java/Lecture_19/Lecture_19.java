package Lecture_19;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static mysql.SelectHelper.getSelect;

public class Lecture_19 {

    @Test
    public void test1() throws Exception {
        Assert.assertEquals(getSelect().select("*").from("user").where("id in (1)").getMapData().get("id").get(0), "1");
    }


    @Test
    public void test2() throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:mysql://db4free.net/testqa07?user=testqa07&password=testqa07");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from user");
        while (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            Integer age = resultSet.getInt("age");
            System.out.println("Id => " + id + ", First name => " + firstName + ", Last name => " + lastName + ", Age => " + age);
        }
    }
}
