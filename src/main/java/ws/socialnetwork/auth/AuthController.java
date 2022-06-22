package ws.socialnetwork.auth;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import ws.socialnetwork.error.ApiError;
import ws.socialnetwork.user.UserRepository;
import ws.socialnetwork.user.Users;

import java.util.Base64;
import java.util.logging.Logger;

@RestController
public class AuthController {

    @Autowired
    UserRepository userRepository;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @PostMapping("/api/1.0/auth/")
    ResponseEntity<?> handleAuthentication(@RequestHeader(name = "Authorization",required = false) String authorization) {
    if (authorization == null) {
      ApiError error = new ApiError(401, "Unauthorized request", "/api/1.0/auth");
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
    }
    String base64Credentials = authorization.split("Basic ")[1];
    String decoded = new String(Base64.getDecoder().decode(base64Credentials));
    String[] parts = decoded.split(":");
    String username = parts[0];
    String password = parts[1];
    Users inDB = userRepository.findByUsername(username);
    if (inDB == null) {
      ApiError error = new ApiError(401, "Username or Password is not valid", "/api/1.0/auth");
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
    }
    String hashedPassword = inDB.getPassword();

    if(!passwordEncoder.matches(password, hashedPassword)) {
        ApiError error = new ApiError(401, "Username or Password is not valid", "/api/1.0/auth");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
    }

    return ResponseEntity.ok().build();
    }
}