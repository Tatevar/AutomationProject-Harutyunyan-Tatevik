package Patterns;

public class UserBuilder {

     public String username;
     public String password;

    @Override
    public String toString() {
        return "UserBuilder{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static  class Builder {

        private UserBuilder userBuilder;

        public Builder() {
            userBuilder = new UserBuilder();
        }

        public Builder withUsername(String username) {
            userBuilder.username = username;
            return this;
        }

        public Builder withPassword(String password) {
            userBuilder.password = password;
            return this;
        }

        public UserBuilder build() {
            return userBuilder;
        }

    }

}