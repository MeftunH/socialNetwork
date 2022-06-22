package ws.socialnetwork.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import ws.socialnetwork.error.ApiError;

@RestController
public class AuthController {

    @PostMapping("/api/1.0/auth/")
    ResponseEntity<?> handleAuthentication(@RequestHeader(name = "Authorization",required = false) String authorization) {
    if (authorization == null) {
      ApiError error = new ApiError(401, "Unauthorized request", "/api/1.0/auth");
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
    }
    return ResponseEntity.ok().build();
    }
}