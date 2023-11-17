package com.all.projpj07_fs.Repository;

import com.all.projpj07_fs.Entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepo extends JpaRepository<Document, Integer> {
    @Query("SELECT p FROM Document p WHERE p.Name LIKE %?1%" + " OR p.File LIKE %?1%")
    List<Document> search(String keyword);
}
