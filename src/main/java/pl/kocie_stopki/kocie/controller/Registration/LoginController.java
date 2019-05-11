package pl.kocie_stopki.kocie.controller.Registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.kocie_stopki.kocie.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController {
    @Autowired
    UserService usersService;

    @GetMapping(value = "/login")
    public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("login", new User());
        return mav;
    }

    @PostMapping(value = "/loginProcess")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response,
                              @ModelAttribute("login") User login) {
        ModelAndView modelAndView = null;
        User user = usersService.validateUser(login);
        if (user != null) {
            modelAndView = new ModelAndView("hello");
            modelAndView.addObject("login", user.getLogin());
        } else {
            modelAndView = new ModelAndView("login");
            modelAndView.addObject("message", "Something is wrong. Check login and password");
        }
        return modelAndView;
    }
}
