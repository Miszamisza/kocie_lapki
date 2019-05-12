package pl.kocie_stopki.kocie.controller.Registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.kocie_stopki.kocie.entity.User;
import pl.kocie_stopki.kocie.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Controller
public class RegistrationController {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Autowired
    public UserService userService;

    @PostMapping(value = "/adduser")
    public void registerAction(User user) {
        String sql = "insert into users values(?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{user.getLogin(), user.getEMail(), user.getPassword(), user.isActive(), user.isAdmin()});

    }
//
//    @POST
//    @RequestMapping(){
//
//    }
}

