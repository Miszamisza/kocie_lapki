package pl.kocie_stopki.kocie.services;

import org.springframework.web.servlet.ModelAndView;
import pl.kocie_stopki.kocie.entity.User;

public interface UserService {
    ModelAndView register();

    ModelAndView home();
}
