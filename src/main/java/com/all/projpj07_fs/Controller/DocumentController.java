package com.all.projpj07_fs.Controller;

import com.all.projpj07_fs.Entity.Comment;
import com.all.projpj07_fs.Entity.Document;
import com.all.projpj07_fs.Entity.User;
import com.all.projpj07_fs.Services.CommentService;
import com.all.projpj07_fs.Services.DocumentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/document")
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @Autowired
    private CommentService commentService;

    @GetMapping(value = {"", "tai-lieu"})
    public String showDocumentPage(Model model) {
        List<Document> documents = documentService.listAll();
        model.addAttribute("documents", documents);
        model.addAttribute("title", "Tài liệu");
        return "pages/documentation/document";
    }

    @RequestMapping(value = {"/document-detail/{id}", "/tai-lieu-chi-tiet{id}"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String showDocumentDetailPage(@PathVariable Integer id, Model model, HttpSession session) {
        List<Comment> comments = commentService.listAll();
        Document document = documentService.get(id);
        Comment comment = commentService.get(id);
        model.addAttribute("comment", comment);
        model.addAttribute("comments", comments);
        model.addAttribute("document", document);
        model.addAttribute("title", "Tài liệu chi tiết");
        // Khởi tạo đối tượng (comment, reply) để truyền vào form
        model.addAttribute("comment", new Comment());
        // Lấy thông tin user từ session
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/auth/login";
        } else {
            model.addAttribute("user", user);
            return "pages/documentation/documentDetail";
        }
    }

    @PostMapping("/save-comment")
    public String saveComment(@RequestParam(name = "commentId", required = false) Integer commentId,
                              @RequestParam(name = "documentId") Integer documentId,
                              @RequestParam(name = "userId") Integer userId,
                              @RequestParam(name = "content") String content) {

        if (commentId != null) {
            // Cập nhật comment đã tồn tại
            Comment existingComment = commentService.get(commentId);
            if (existingComment != null) {
                existingComment.setContent(content);
                commentService.save(existingComment);
            }
        } else {
            // Tạo comment mới
            Comment newComment = new Comment();
            newComment.setDocumentId(documentId);
            newComment.setUserId(userId);
            newComment.setContent(content);
            commentService.save(newComment);
        }
        return "redirect:/document/document-detail/" + documentId;
    }


    @RequestMapping(value = {"/delete-comment/{id}", "/xoa-binh-luan/{id}"}, method = {RequestMethod.POST})
    public String deleteComment(@PathVariable Integer id, Integer documentId) {
        commentService.delete(id);
        return "redirect:/document/document-detail/" + documentId;
    }


}
