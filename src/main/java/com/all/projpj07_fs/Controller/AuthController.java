package com.all.projpj07_fs.Controller;

import com.all.projpj07_fs.Entity.User;
import com.all.projpj07_fs.Services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService servs;

    @RequestMapping(value = {"/signin", "/login"}, method = RequestMethod.GET)
    public String showSignInPage(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            return "redirect:/";
        }
        model.addAttribute("title", "Đăng nhập");
        return "pages/auth/signIn";
    }

    @PostMapping("/login")
    public String SignIn(@RequestParam String email,
                         @RequestParam String password,
                         RedirectAttributes ra,
                         HttpSession session) {
        User user = servs.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
//            save user to session
            session.setAttribute("user", user);

            return user.getRole().getId() == 1 ? "redirect:/admin/dashboard" : "redirect:/";
        } else {
            ra.addFlashAttribute("message", "Email hoặc mật khẩu không đúng");
            return "redirect:/auth/signin";
        }
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
