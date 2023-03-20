package com.mis.repository;

import com.mis.entity.PhoneNumbers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneNumbersRepository extends JpaRepository<PhoneNumbers,Long> {
    @Query(value = "select u from PhoneNumbers  u where u.phoneNumber = ?1")
    public List<PhoneNumbers> findByPhoneNumber(String number);
}
