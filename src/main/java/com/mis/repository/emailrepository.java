package com.mis.repository;

import com.mis.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface emailrepository extends JpaRepository<Email,Long> {
    @Query(value = "select u from Email u where u.email = ?1")
    public List<Email> findbyemail(String email);

}
