package ws.socialnetwork.auth;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import ws.socialnetwork.error.ApiError;

import java.util.logging.Logger;

@RestController
public class AuthController {

    private static final Logger log = (Logger) LoggerFactory.getLogger(AuthController.class);
    @PostMapping("/api/1.0/auth/")
    ResponseEntity<?> handleAuthentication(@RequestHeader(name = "Authorization",required = false) String authorization) {
    if (authorization == null) {
      ApiError error = new ApiError(401, "Unauthorized request", "/api/1.0/auth");
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
    }
    String base64Credentials = authorization.split("Basic ")[1];
    return ResponseEntity.ok().build();
    }
}