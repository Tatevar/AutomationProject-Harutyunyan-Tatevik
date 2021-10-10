package Lecture_19;

import org.testng.Assert;
import org.testng.annotations.Test;
import static mysql.SelectHelper.getSelect;

public class Select {

    @Test
    public void test1() throws Exception {
        Assert.assertEquals(getSelect().select("*").from("user").where("id in (1,2)").getMapData().get("id").get(0), "2");
    }

    @Test
    public void test2() {
     getSelect().select("*").from("user").where("first_name=User 3");
    }

    @Test
    public void test3(){
        getSelect().select("last_name").from("user").where("last_name=Tatah");
    }
    @Test
    public void test4(){
        getSelect().select("*").from("user").where("last_name=Tatah").where("first_name=Tata").where("id=12").where("age=55");
    }
    @Test
    public void test5(){
       getSelect().select("*").from("user").getListData().get(1);
    }
}