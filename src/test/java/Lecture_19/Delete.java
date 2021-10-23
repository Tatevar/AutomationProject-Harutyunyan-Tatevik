package Lecture_19;
import org.testng.annotations.Test;
import static mysql.DeleteHelper.delete;

public class Delete {

    @Test
    public void delete_test1() {
        delete().from("user").where("id=16").execute();
    }
    @Test
    public void delete_test2() {
        delete().from("user").where("id=2").where("age='test'").execute();
    }
}