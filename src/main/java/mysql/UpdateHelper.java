package mysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UpdateHelper extends DBConnector {
    private String table;
    private String value;
    private String update;
    private String where;

        public static mysql.UpdateHelper getUpdate() {
            return new mysql.UpdateHelper();
        }

        public mysql.UpdateHelper table(String table) {
            this.table = table;
            return this;
        }


        public mysql.UpdateHelper value(String value) {
            this.value = value;
            return this;
        }
    public UpdateHelper update(String select) {
        this.update = select;
        return this;
    }

    public UpdateHelper where(String where) {
        this.where = where;
        return this;
    }

        public void execute() {
            try {
                getStatement().executeUpdate("UPDATE " + table  + " SET "  + value + (where == null ? "" : " where " + where));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
