package com.eazybytes.eazyschool.repository;

import com.eazybytes.eazyschool.model.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

    List<Contact> findByStatus(String status);

    @Query("SELECT c FROM Contact c WHERE c.status = :status")
    //@Query(value = "SELECT * FROM contact_msg c WHERE c.status = :status",nativeQuery = true)
    Page<Contact> findByStatusWithQuery(String status, Pageable pageable);

    @Transactional
    @Modifying
    @Query("UPDATE Contact c SET c.status = ?1 WHERE c.contactId = ?2")
    int updateStatusById(String status, int id);

    Page<Contact> findOpenMsgs(@Param("status") String status, Pageable pageable);

    @Transactional
    @Modifying
    int updateMsgStatus(String status, int id);

    Optional<Contact> findById(Integer contactId);
}
