package com.BalajiIT.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BalajiIT.model.Contact;
import com.BalajiIT.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactServiceI{

	@Autowired
	private ContactRepository contactRepository;
	
	@Override
	public boolean saveContact(Contact contact) {
		
	Contact save = contactRepository.save(contact);
		
		if(save != null) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public List<Contact> getAllContact() {
		List<Contact> findAll = contactRepository.findAll();
		return findAll;
	}

	@Override
	public Contact getContactById(Integer cid) {
		  Contact contact = contactRepository.findById(cid).get();
		return contact;
	}

	@Override
	public boolean updateContact(Contact contact) {
		Contact save = contactRepository.save(contact);
		if(save == null) {
		return false;
	}else {
		return true;
	}

	}


	@Override
	public boolean deleteById(Integer cid) {
		boolean byId = contactRepository.existsById(cid);
		if(byId) {
			contactRepository.deleteById(cid);
			return true;
		}else
		return false;
	}

//
//  Optional<Contact> findById = contactRepository.findById(cid);
//
//   if(findById.isPresent()) {
//	contactRepository.deleteById(cid);
//	return true;
//	}else 
//		return false;
	}

