package mysql;
public class DeleteHelper extends DBConnector {
    private String from;
    private String where;

    public static mysql.DeleteHelper delete() {
        return new mysql.DeleteHelper();
    }

    public mysql.DeleteHelper from(String from) {
        this.from = from;
        return this;
    }
    public DeleteHelper where(String where) {
        this.where = where;
        return this;
    }

    public void execute() {
        try {
            getStatement().executeUpdate("delete " + " from " + from + (where == null ? "" : " where " + where));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
