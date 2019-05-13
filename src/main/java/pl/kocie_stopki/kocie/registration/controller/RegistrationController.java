package pl.kocie_stopki.kocie.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;
import pl.kocie_stopki.kocie.entity.User;
import pl.kocie_stopki.kocie.registration.service.UserService;
import pl.kocie_stopki.kocie.repository.UserRepository;


@Controller
public class RegistrationController {


    private UserService userService;

    @Autowired
    private RegistrationController (UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public void register(@RequestBody User user) throws Exception {
        userService.register(user);
    }

}
