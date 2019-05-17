package pl.kocie_stopki.kocie.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.kocie_stopki.kocie.entity.User;
import pl.kocie_stopki.kocie.registration.service.UserService;

/**
 * Class provides endpoints to register new user
 */
@Controller
public class RegistrationController {


    private UserService userService;

    @Autowired
    private RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) throws Exception {
        return userService.register(user);
    }

}
