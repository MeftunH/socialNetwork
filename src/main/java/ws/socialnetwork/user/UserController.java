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

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
 private static final Logger log= LoggerFactory.getLogger(UserController.class);

 @Autowired
 UserService userService;

 @PostMapping("/api/1.0/users")
 @ResponseStatus(HttpStatus.CREATED)
 public ResponseEntity<?> create(@Valid @RequestBody Users user) {
     ApiError error = new ApiError(HttpStatus.BAD_REQUEST.value(), "Validation Error", "/api/1.0/users");
     Map<String,String> validationErrors = new HashMap<>();


     String username = user.getUsername();
     String displayName = user.getDisplayName();

     if(username == null || username.isEmpty()) {
         validationErrors.put("username", "Username is required");
     }
     if(displayName == null || displayName.isEmpty()) {
         validationErrors.put("displayName", "Display Name is required");
     }

     if(!validationErrors.isEmpty()) {
         error.setValidationErrors(validationErrors);
         return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
     }

     userService.save(user);
    return ResponseEntity.ok(new GenericResponse("User created successfully"));
 }
}
