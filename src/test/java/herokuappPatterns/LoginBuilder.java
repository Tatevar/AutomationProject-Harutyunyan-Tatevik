package herokuappPatterns;

public class LoginBuilder {
    public String username;
    public String password;

    public static  class Builder {

        private LoginBuilder loginBuilder;

        public Builder() {
            loginBuilder = new LoginBuilder();
        }

        public LoginBuilder.Builder withUsername(String username) {
            loginBuilder.username = username;
            return this;
        }

        public LoginBuilder.Builder withPassword(String password) {
            loginBuilder.password = password;
            return this;
        }

        public LoginBuilder build() {
            return loginBuilder;
        }

    }


}
