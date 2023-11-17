package com.all.projpj07_fs.Services;

import com.all.projpj07_fs.Entity.Document;
import com.all.projpj07_fs.Exception.GenericNotFoundException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

//@Service
//public class DocumentService {
//    @Autowired
//    private DocumentRepo repo;
//
//    public List<Document> listAll() {
//        return (List<Document>) repo.findAll();
//    }
//
//    public void save(Document document) {
//        repo.save(document);
//    }
//
//    public Document get(Integer id) throws GenericNotFoundException {
//        Optional<Document> result = repo.findById(id);
//        if (result.isPresent()) {
//            return result.get();
//        }
//        throw new GenericNotFoundException("Could not find any documents with ID " + id);
//    }
//
//    public void delete(Integer id) throws GenericNotFoundException {
//        Long count = repo.findById(id).stream().count();
//        if (count == null || count == 0) {
//            throw new GenericNotFoundException("Could not find any documents with ID " + id);
//        }
//        repo.deleteById(id);
//    }
//}

public interface DocumentService {
    List<Document> listAll();

    Document get(Integer id) throws GenericNotFoundException;

    void delete(Integer id) throws GenericNotFoundException;

    Document save(Document document);

    List<Document> search(String keyword);
}
