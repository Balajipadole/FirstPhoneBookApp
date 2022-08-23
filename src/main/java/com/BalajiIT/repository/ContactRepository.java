package com.BalajiIT.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BalajiIT.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Integer> {

}
