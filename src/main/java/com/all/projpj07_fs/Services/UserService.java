package com.all.projpj07_fs.Services;

import com.all.projpj07_fs.Entity.User;
import com.all.projpj07_fs.Exception.GenericNotFoundException;
import com.all.projpj07_fs.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;

    public List<User> listAll() {
        return (List<User>) repo.findAll();
    }

    public void save(User user) {
        repo.save(user);
    }

    public User get(Integer id) throws GenericNotFoundException {
        Optional<User> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new GenericNotFoundException("Could not find any users with ID " + id);
    }

    public void delete(Integer id) throws GenericNotFoundException {
        Long count = repo.findById(id).stream().count();
        if (count == null || count == 0) {
            throw new GenericNotFoundException("Could not find any patients with ID " + id);
        }
        repo.deleteById(id);
    }

}
