package ws.socialnetwork.user;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
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
    private String username;
    @Column(name="`PASSWORD`")
    private String password;
    @NotNull
    @Size(min = 3, max = 20)
    @Column(name="`DISPLAY_NAME`")
    private String displayName;
}
