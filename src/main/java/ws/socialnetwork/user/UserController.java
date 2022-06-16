package ws.socialnetwork.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ws.socialnetwork.shared.GenericResponse;

@RestController
public class UserController {
 private static final Logger log= LoggerFactory.getLogger(UserController.class);

 UserService userService;

 @PostMapping("/api/1.0/users")
 @ResponseStatus(HttpStatus.CREATED)
 public GenericResponse create(@RequestBody Users user) {
    userService.save(user);
    return new GenericResponse("User created successfully");
 }
}
