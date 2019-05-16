package pl.kittenpaws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.kittenpaws.exception.ResourceNotFoundException;
import pl.kittenpaws.model.Login;
import pl.kittenpaws.model.User;
import pl.kittenpaws.model.UserPrincipal;
import pl.kittenpaws.repository.UserRepository;
import pl.kittenpaws.security.LoggedInAccount;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@LoggedInAccount UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("make-admin")
    public String makeAdmin(@RequestBody Login login) {

        User user = userRepository.findByEmail(login.getEmail()).get();
        user.setAdmin(true);
        userRepository.save(user);

        return "We've a new admin!";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/users")
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

}
