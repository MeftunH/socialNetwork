package ws.socialnetwork.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class UserService{
    UserRepository userRepository;
    //if you have only one constructor and this constructor has values, it is not meaningful to use @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(Users user) {
        userRepository.save(user);
    }
}
