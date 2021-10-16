package mysql;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectHelper extends DBConnector {
    private String select;
    private String from;
    private String where;

    public static SelectHelper getSelect() {
        return new SelectHelper();
    }

    public SelectHelper select(String select) {
        this.select = select;
        return this;
    }

    public SelectHelper from(String from) {
        this.from = from;
        return this;
    }

    public SelectHelper where(String where) {
        this.where = where;
        return this;
    }
    public ResultSet resultSet() {
        try {
            return getStatement().executeQuery("select " + select + " from " + from + (where == null ? "" : " where " + where));
        } catch (Exception e) {
            e.printStackTrace();
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
