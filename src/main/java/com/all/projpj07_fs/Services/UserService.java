package com.all.projpj07_fs.Services;

import com.all.projpj07_fs.Entity.User;
import com.all.projpj07_fs.Exception.GenericNotFoundException;

import java.util.List;

public interface UserService {
    List<User> listAll();

    User get(Integer id) throws GenericNotFoundException;

    void delete(Integer id) throws GenericNotFoundException;

    User save(User user);

    User findByEmail(String email);
}
