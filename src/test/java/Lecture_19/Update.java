package Lecture_19;
import static mysql.UpdateHelper.getUpdate;
import org.testng.annotations.Test;


public class Update {


    @Test
    public void test1() {
        getUpdate().table("user").value("last_name =77").where("id=15").execute();

    }
}