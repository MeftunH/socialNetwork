package ws.socialnetwork;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import ws.socialnetwork.user.UserRepository;
import ws.socialnetwork.user.UserService;
import ws.socialnetwork.user.Users;

import java.security.Security;

@SpringBootApplication
public class SocialNetworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocialNetworkApplication.class, args);
    }
    @Bean
    CommandLineRunner createInitialUsers(UserService userService) {
        return (args) -> {
            Users user = new Users();
            user.setUsername("user1");
            user.setDisplayName("user1_dn");
            user.setPassword("P4ssword*");
            userService.save(user);
        };
    }
}
