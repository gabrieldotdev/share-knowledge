package com.all.projpj07_fs.Services.Impls;

import com.all.projpj07_fs.Entity.Comment;
import com.all.projpj07_fs.Entity.Document;
import com.all.projpj07_fs.Exception.GenericNotFoundException;
import com.all.projpj07_fs.Repository.CommentRepo;
import com.all.projpj07_fs.Services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepo repo;

    @Override
    public List<Comment> listAll() {
        return (List<Comment>) repo.findAll();
    }

    @Override
    public Comment get(Integer id) throws GenericNotFoundException {
        Optional<Comment> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new GenericNotFoundException("Could not find any comments with ID " + id);
    }

    @Override
    public void delete(Integer id) throws GenericNotFoundException {
        Long count = repo.findById(id).stream().count();
        if (count == null || count == 0) {
            throw new GenericNotFoundException("Could not find any comments with ID " + id);
        }
        repo.deleteById(id);
    }

    @Override
    public Comment save(Comment document) {
        return repo.save(document);
    }
}
