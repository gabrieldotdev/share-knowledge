package com.all.projpj07_fs.Repository;

import com.all.projpj07_fs.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {
//    @Query(value = "SELECT * FROM user WHERE username = ?1", nativeQuery = true)
//    Optional<User> findByUsername(String username);
}
