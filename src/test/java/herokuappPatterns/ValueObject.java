package herokuappPatterns;

public class ValueObject {
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    String username;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    String password;

    public ValueObject() {

    }
}
