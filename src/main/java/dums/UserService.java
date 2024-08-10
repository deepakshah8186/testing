package dums;


import java.util.ArrayList;
import java.util.List;

import dumm.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

//    @Autowired
//    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return new ArrayList<User>();
    }

    public User getUserById(Long id) {
        return new User();
    }

    public User saveUser(User user) {
        return new User();
    }

    public void deleteUser(Long id) {
        System.out.println("do nothing");
    }
}