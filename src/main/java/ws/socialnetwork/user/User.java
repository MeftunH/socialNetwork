package ws.socialnetwork.user;

import lombok.Data;

@Data
public class User {
    private String username;
    private String password;
    private String email;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
