package ws.socialnetwork.user;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
public class Users {
    @Id
    @GeneratedValue
    private long id;

    @Column(name="`USERNAME`")
    @NotNull
    @Size(min = 3, max = 20)
    @UniqueUsername
    private String username;

    @NotNull
    @Column(name="`PASSWORD`")
    @Size(min = 6, max = 80)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}$", message = "Password must contain at least 6 characters, including UPPER/lowercase, numbers and special characters.")
    private String password;

    @NotNull
    @Size(min = 3, max = 20)
    @Column(name="`DISPLAY_NAME`")
    private String displayName;
}
