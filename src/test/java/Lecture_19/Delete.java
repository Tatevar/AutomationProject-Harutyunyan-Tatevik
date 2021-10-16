package Lecture_19;
import org.testng.annotations.Test;
import static mysql.DeleteHelper.delete;

public class Delete {

    @Test
    public void test1() {
        delete().table("user").condition("id=1").execute();
    }
}