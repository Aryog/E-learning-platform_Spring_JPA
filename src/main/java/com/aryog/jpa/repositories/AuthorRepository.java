package com.aryog.jpa.repositories;

import com.aryog.jpa.models.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,Integer> {


    // update Author a set a.age = 32 where a.id = 1
    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age where a.id = :id")
    void updateAuthor(int age,int id);


    List<Author> findByNamedQuery(@Param("age") int age);
    // select * from author where first_name = 'ali'
    List<Author> findAllByFirstName(String fn);

    // select * from author where first_name = 'al'
    List<Author> findAllByFirstNameIgnoreCase(String fn);

    // select * from author where first_name like '%al%'
    List<Author> findAllByFirstNameContainingIgnoreCase(String fn);
}
