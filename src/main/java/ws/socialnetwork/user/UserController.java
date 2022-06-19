package ws.socialnetwork.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ws.socialnetwork.error.ApiError;
import ws.socialnetwork.shared.GenericResponse;

@RestController
public class UserController {
 private static final Logger log= LoggerFactory.getLogger(UserController.class);

 @Autowired
 UserService userService;

 @PostMapping("/api/1.0/users")
 @ResponseStatus(HttpStatus.CREATED)
 public ResponseEntity<?> create(@RequestBody Users user) {

     String username = user.getUsername();
     if(username == null || username.isEmpty()) {
         ApiError error = new ApiError(HttpStatus.BAD_REQUEST.value(), "Validation Error.Username is required", "/api/1.0/users");
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
     }

    userService.save(user);
    return ResponseEntity.ok(new GenericResponse("User created successfully"));
 }
}
