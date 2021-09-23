package Patterns;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class User {
     private String username;
     private String password;

    }