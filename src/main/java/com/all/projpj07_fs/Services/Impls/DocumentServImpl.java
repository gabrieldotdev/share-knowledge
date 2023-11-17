package com.all.projpj07_fs.Services.Impls;

import com.all.projpj07_fs.Entity.Document;
import com.all.projpj07_fs.Exception.GenericNotFoundException;
import com.all.projpj07_fs.Repository.DocumentRepo;
import com.all.projpj07_fs.Services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentServImpl implements DocumentService {
    @Autowired
    private DocumentRepo repo;

    @Override
    public List<Document> listAll() {
        return (List<Document>) repo.findAll();
    }

    @Override
    public Document get(Integer id) throws GenericNotFoundException {
        Optional<Document> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new GenericNotFoundException("Could not find any documents with ID " + id);
    }

    @Override
    public void delete(Integer id) throws GenericNotFoundException {
        Long count = repo.findById(id).stream().count();
        if (count == null || count == 0) {
            throw new GenericNotFoundException("Could not find any documents with ID " + id);
        }
        repo.deleteById(id);
    }

    @Override
    public Document save(Document document) {
        return repo.save(document);
    }
    
    @Override
    public List<Document> search(String keyword) {
        if (keyword != null && !keyword.isEmpty()) {
            return repo.search(keyword);
        } else {
            return (List<Document>) repo.findAll();
        }
    }
}
