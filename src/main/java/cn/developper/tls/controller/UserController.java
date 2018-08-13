package cn.developper.tls.controller;

import cn.developper.tls.entity.Authority;
import cn.developper.tls.entity.User;
import cn.developper.tls.service.AuthorityServicce;
import cn.developper.tls.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private static final Long ROLE_USER_AUTHORITY_ID = 2L;

    @Autowired
    private AuthorityServicce authorityServicce;

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public ModelAndView register(Model model) {
        model.addAttribute("user", new User(null, null, null, null));
        return new ModelAndView("register", "userModel", model);
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        model.addAttribute("errorMsg", "Login error, username or password not correct");
        return "login";
    }

    @PostMapping("/register")
    public String registerUser(User user) {
        List<Authority> authorityList = new ArrayList<>();
        authorityList.add(authorityServicce.getAuthorityById(ROLE_USER_AUTHORITY_ID));
        user.setAuthorities(authorityList);
        userService.saveUser(user);
        return "redirect:/hello";
    }
}
