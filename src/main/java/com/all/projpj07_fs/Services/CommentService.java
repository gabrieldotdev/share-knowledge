package com.all.projpj07_fs.Services;

import com.all.projpj07_fs.Entity.Comment;
import com.all.projpj07_fs.Exception.GenericNotFoundException;

import java.util.List;

public interface CommentService {
    List<Comment> listAll();

    Comment get(Integer id) throws GenericNotFoundException;

    void delete(Integer id) throws GenericNotFoundException;

    Comment save(Comment document);
}
