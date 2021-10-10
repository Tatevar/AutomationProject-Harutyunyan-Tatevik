package Lecture_19;

import org.testng.annotations.Test;
import static mysql.DeleteHelper.getDelete;

public class Delete {

    @Test
    public void test1() {
        try {
            getDelete().deleteUSer().executeUpdate("delete from user where first_name='Michael Samiiik'where last_name='Michael Samiiik'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test2(){
        try {
        getDelete().deleteUSer().executeUpdate("delete from user where first_name='Michael Samiiik' where id=16");
    }catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test3() {
        try {
        getDelete().deleteUSer().executeUpdate("delete from user where id=20");
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}