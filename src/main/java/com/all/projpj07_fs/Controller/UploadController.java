package com.all.projpj07_fs.Controller;

import com.all.projpj07_fs.Entity.Document;
import com.all.projpj07_fs.Services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/upload")
public class UploadController {
    @Autowired
    private DocumentService servs;

    @RequestMapping(value = {"/uploadFile/new", "tai-len"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String showUploadFile(Model model) {
        model.addAttribute("documents", new Document());
        model.addAttribute("title", "Upload file");
        return "pages/upload/uploadFile";
    }

    @RequestMapping(value = {"/save", "luu"}, method = RequestMethod.POST)
    public String saveUploadFile(Document document) {
//        System.out.println(document);
        servs.save(document);
        return "redirect:/";
    }
}
