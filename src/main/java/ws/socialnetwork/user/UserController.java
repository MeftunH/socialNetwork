package ws.socialnetwork.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
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
 public GenericResponse create(@Valid @RequestBody Users user) {
     userService.save(user);
    return new GenericResponse("User created successfully");
 }

}
