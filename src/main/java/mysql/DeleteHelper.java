package mysql;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeleteHelper extends DBConnector {
    private String table;
    private String condition;
    private String from;
    private String where;

    /*DELETE FROM
    Customers
            WHERE
    Country = 'Norway';

     */
    public static mysql.DeleteHelper delete() {
        return new mysql.DeleteHelper();
    }

    public mysql.DeleteHelper condition(String condition) {
        this.condition = condition;
        return this;
    }
    public mysql.DeleteHelper table(String table) {
        this.table = table;
        return this;
    }
    public mysql.DeleteHelper from(String from) {
        this.from = from;
        return this;
    }
    public DeleteHelper where() {
        this.where = where;
        return this;
    }

    public void execute() {
        try {
            getStatement().executeUpdate("DELETE " + " from " + from + " WHERE "  + "CONDITION" + "( " + condition + ")");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
