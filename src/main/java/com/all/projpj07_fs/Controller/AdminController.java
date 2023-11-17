package com.all.projpj07_fs.Controller;

//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @GetMapping(value = {"/dashboard", "/quan-tri"})
    public String showDashboardPage(Model model) {
        model.addAttribute("title", "Trang quản trị");
        return "pages/dashboard/dashboard";
    }
//    public String showDashboardPage(Model model) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//
//        if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"))) {
//            model.addAttribute("title", "Trang quản trị");
//            return "pages/dashboard/dashboard";
//        } else {
//            return "redirect:/";
//        }
//    }
}
