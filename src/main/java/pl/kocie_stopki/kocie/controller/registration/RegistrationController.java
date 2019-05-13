package pl.kocie_stopki.kocie.controller.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.kocie_stopki.kocie.services.UserService;


@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/register")
    public ModelAndView register() {
        return userService.register();
    }

    @GetMapping(value = "/index")
    public ModelAndView home() {
        return userService.home();
    }
}
