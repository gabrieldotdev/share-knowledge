package com.all.projpj07_fs.Controller;

import com.all.projpj07_fs.Entity.Document;
import com.all.projpj07_fs.Services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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
    public String saveUploadFile(@RequestParam("file") MultipartFile file,
                                 @RequestParam("name") String name,
                                 @RequestParam("description") String description,
                                 @RequestParam("userId") Integer userId,
                                 RedirectAttributes redirectAttributes
    ) throws IOException {
        String fileType = file.getContentType();
        List<String> acceptType = Arrays.asList("application/pdf", "application/msword", "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        if(!acceptType.contains(fileType)){
            redirectAttributes.addFlashAttribute("message", "Chỉ chấp nhận file pdf, doc, docx");
            return "redirect:/upload/uploadFile/new";
        }
        byte[] fileBytes = file.getBytes();
        Document document = new Document();
        document.setName(name);
        document.setDescription(description);
        document.setUserId(userId);
        document.setFileName(file.getName());
        document.setFileType(file.getContentType());
        document.setFileData(fileBytes);
        System.out.println(document);
        servs.save(document);
        return "redirect:/";
    }
}
