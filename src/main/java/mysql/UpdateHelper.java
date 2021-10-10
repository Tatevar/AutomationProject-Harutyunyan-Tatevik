package mysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UpdateHelper extends DBConnector {
    private String update;
    private String from;
    private String where;
    private String set;
    private static UpdateHelper updateHelper;

    public static UpdateHelper getUpdate() {
        if (updateHelper == null) {
            updateHelper = new UpdateHelper();
        }
        return updateHelper;
    }

    public static void reset() {
        updateHelper = new UpdateHelper();
    }

    public UpdateHelper update(String update) {
        this.update = update;
        return this;
    }

    public UpdateHelper from(String from) {
        this.from = from;
        return this;
    }
    public UpdateHelper set(String set) {
        this.set = set;
        return this;
    }

    public UpdateHelper where(String where) {
        this.where = where;
        return this;
    }

        public ResultSet resultSet() {
        try {
            return getStatement().executeQuery("update " + update + " from " + from + (where == null ? "" : " where " + where));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reset();
        }
        return null;
    }
    public Statement updateUSer() {
        try {
            return getStatement();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reset();
        }
        return null;
    }

    public Map<String, List<String>> getMapData() {
        Map<String, List<String>> data = new HashMap<>();
        List<List<String>> listData = getListData();
        try {
            ResultSet resultSet = resultSet();
            ResultSetMetaData metaData = resultSet.getMetaData();
            List<String> titles = new ArrayList<>();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                titles.add(metaData.getColumnLabel(i));
            }
            for (int i = 0; i < titles.size(); i++) {
                List<String> column = new ArrayList<>();
                for (List<String> listDatum : listData) {
                    column.add(listDatum.get(i));
                }
                data.put(titles.get(i), column);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public List<List<String>> getListData() {
        List<List<String>> data = new ArrayList<>();
        try {
            ResultSet resultSet = resultSet();
            while (resultSet.next()) {
                List<String> row = new ArrayList<>();
                for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                    row.add(resultSet.getString(i));
                }
                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
