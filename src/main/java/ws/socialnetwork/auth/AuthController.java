package ws.socialnetwork.auth;

import com.fasterxml.jackson.annotation.JsonView;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ws.socialnetwork.error.ApiError;
import ws.socialnetwork.shared.Views;
import ws.socialnetwork.user.UserRepository;
import ws.socialnetwork.user.Users;

import java.util.Base64;
import java.util.logging.Logger;

@RestController
public class AuthController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/api/1.0/auth")
    @JsonView(Views.BaseView.class)
    ResponseEntity<?> handleAuthentication(@RequestHeader(name = "Authorization") String authorization) {
    String base64Credentials = authorization.split("Basic ")[1];
    String decoded = new String(Base64.getDecoder().decode(base64Credentials));
    String[] parts = decoded.split(":");
    String username = parts[0];
    Users inDB = userRepository.findByUsername(username);
    return ResponseEntity.ok().build();
    }
}