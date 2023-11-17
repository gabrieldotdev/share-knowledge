package com.all.projpj07_fs.Controller;

import com.all.projpj07_fs.Entity.Document;
import com.all.projpj07_fs.Services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/document")
public class DocumentController {
    @Autowired
    private DocumentService servs;

    @GetMapping(value = {"", "tai-lieu"})
    public String showDocumentPage(Model model){
        List<Document> documents = servs.listAll();
        model.addAttribute("documents", documents);
        model.addAttribute("title", "Tài liệu");
        return "pages/documentation/document";
    }

    @GetMapping(value = {"/document-detail", "tai-lieu-chi-tiet"})
    public String showDocumentDetailPage(Model model){
        model.addAttribute("title", "Tài liệu chi tiết");
        return "pages/documentation/documentDetail";
    }

}
