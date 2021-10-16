package Lecture_19;
import static mysql.UpdateHelper.getUpdate;
import org.testng.annotations.Test;


public class Update {


    @Test
    public void updatetest1() {
        getUpdate().table("user").value("last_name =77").where("id=15").execute();

    }

    @Test
    public void updatetest2() {
        getUpdate().table("user").value("last_name ='test'").where("id=13").where("age='55'").execute();

    }
}