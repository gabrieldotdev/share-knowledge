package com.all.projpj07_fs;

import com.all.projpj07_fs.Entity.User;
import com.all.projpj07_fs.Entity.Document;
import com.all.projpj07_fs.Services.DocumentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private DocumentService servs;

    @GetMapping("/")
    public String showHomePage(Model model, @Param("keyword") String keyword, HttpSession session) {
        User user = (User) session.getAttribute("user");
        System.out.println(user == null ? "null" : user);
        List<Document> searchDocument = servs.search(keyword);
//        model.addAttribute("user", user);
        model.addAttribute("searchDocument", searchDocument);
        model.addAttribute("documents", servs.listAll());
        model.addAttribute("title", "The Knowledge Bank | Trang web chia sẻ tài liệu");
        return "pages/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteTest(@PathVariable("id") Integer id) {
        servs.delete(id);
        return "redirect:/";
    }
}
