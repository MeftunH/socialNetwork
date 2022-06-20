package ws.socialnetwork.user;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Users {
    @Id
    @GeneratedValue
    private long id;
    @Column(name="`USERNAME`")
    @NotNull
    private String username;
    @Column(name="`PASSWORD`")
    private String password;
    @NotNull
    @Column(name="`DISPLAY_NAME`")
    private String displayName;
}
