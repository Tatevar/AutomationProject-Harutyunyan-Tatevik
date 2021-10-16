package Lecture_19;

import org.testng.annotations.Test;

import static mysql.InsertHelper.getInsert;

public class Insert {

    @Test
    public void insertTest1() {
        getInsert().table("user").into("id").values("1").execute();
    }

    @Test
    public void insertTest2() {
        getInsert().table("user").into( "id").values("7").execute();
    }
}
