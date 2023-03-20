package com.mis.repository;

import com.mis.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Long> {

    public Optional<Contact> findById(Long id);
    @Query(value = "select u from Contact u where u.name like ?1%")
    public List<Contact> findByName(String name);
}
