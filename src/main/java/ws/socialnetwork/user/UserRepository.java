package ws.socialnetwork.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<Users, Long> {

}