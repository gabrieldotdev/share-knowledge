package com.all.projpj07_fs.Controller;

import com.all.projpj07_fs.Entity.Comment;
import com.all.projpj07_fs.Entity.Document;
import com.all.projpj07_fs.Services.CommentService;
import com.all.projpj07_fs.Services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/document")
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @Autowired
    private CommentService commentService;

    @GetMapping(value = {"", "tai-lieu"})
    public String showDocumentPage(Model model){
        List<Document> documents = documentService.listAll();
        model.addAttribute("documents", documents);
        model.addAttribute("title", "Tài liệu");
        return "pages/documentation/document";
    }

    @GetMapping(value = {"/document-detail/{id}", "/tai-lieu-chi-tiet{id}"})
    public String showDocumentDetailPage(@PathVariable Integer id, Model model){
        List<Comment> comments = commentService.listAll();
        Comment comment = new Comment();
        Document document = documentService.get(id);
        model.addAttribute("comments", comments);
        model.addAttribute("document", document);
        model.addAttribute("title", "Tài liệu chi tiết");
        return "pages/documentation/documentDetail";
    }

}
