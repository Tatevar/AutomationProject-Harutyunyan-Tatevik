package Lecture_19;
import static mysql.UpdateHelper.getUpdate;
import org.testng.annotations.Test;


public class Update {


    @Test
    public void test1() {
        try {
            getUpdate().updateUSer().executeUpdate("update user set first_name='Michael Samii' where id=13");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        try {
            getUpdate().updateUSer().executeUpdate("update user set first_name='Ber aziz', age=35, last_name =07 where id=17");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3() {
        try {
            getUpdate().updateUSer().executeUpdate("update user set first_name='Michael Samiiik' , last_name ='Barev', age = 666 where id=18");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}