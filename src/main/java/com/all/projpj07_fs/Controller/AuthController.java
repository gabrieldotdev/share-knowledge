package com.all.projpj07_fs.Controller;

import com.all.projpj07_fs.Entity.User;
import com.all.projpj07_fs.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService servs;

    @RequestMapping(value = {"/signin", "/login"}, method = RequestMethod.GET)
    public String showSignInPage(Model model) {
        model.addAttribute("title", "Đăng nhập");
        return "pages/auth/signIn";
    }

    @RequestMapping(value = {"/signup", "/register"}, method = RequestMethod.GET)
    public String showSignUpPage(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("title", "Đăng ký");
        return "pages/auth/signUp";
    }

    @PostMapping("/save")
    public String savePatient(User user, RedirectAttributes ra) {
        servs.save(user);
        ra.addFlashAttribute("message", "The patient has been saved successfully.");
        return "redirect:/auth/signin";
    }

}
