package ws.socialnetwork.auth;

import com.fasterxml.jackson.annotation.JsonView;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ws.socialnetwork.shared.CurrentUser;
import ws.socialnetwork.shared.Views;
import ws.socialnetwork.user.UserRepository;
import ws.socialnetwork.user.Users;

@RestController
public class AuthController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/api/1.0/auth")
    @JsonView(Views.BaseView.class)
    ResponseEntity<?> handleAuthentication(@CurrentUser Users user) {
    return ResponseEntity.ok(user);
    }
}