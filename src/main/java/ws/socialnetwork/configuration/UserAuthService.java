package ws.socialnetwork.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ws.socialnetwork.user.UserRepository;
import ws.socialnetwork.user.Users;

@Service
public class UserAuthService implements UserDetailsService{
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Users inDB = userRepository.findByUsername(username);
       if (inDB == null) {
          throw new UsernameNotFoundException("User not found");
       }
       return inDB;
    }
}
