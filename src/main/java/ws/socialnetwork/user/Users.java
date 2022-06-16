package ws.socialnetwork.user;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Users {
    @Id
    @GeneratedValue
    private long id;
    @Column(name="`USERNAME`")
    private String username;
    @Column(name="`PASSWORD`")
    private String password;
    @Column(name="`EMAIL`")
    private String email;
}
