package com.BalajiIT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BalajiIT.model.Contact;
import com.BalajiIT.service.ContactServiceI;

@RestController
public class ContactController {

	@Autowired
	private ContactServiceI contactServiceI;
	
	@PostMapping(value="/saveContact", consumes="APPLICATION/JSON")
	public ResponseEntity<String> saveContact(@RequestBody Contact contact){
	  boolean saveContact = contactServiceI.saveContact(contact);
	  
	  if(saveContact==true) {
		  String msg="Contact saved successfully";
	  
	   return new ResponseEntity<String>(msg,HttpStatus.OK);
}    
	  else {
		  String msg="Contact not saved";
	  
		  return new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST);
	  }
}
	 @GetMapping(value="getAllContact" ,produces="application/json")
	public ResponseEntity<List<Contact>> getAllContact() {
		List<Contact> contact1 = contactServiceI.getAllContact();
		
		if(contact1 != null) {
		return new ResponseEntity<List<Contact>>(contact1,HttpStatus.OK);
	}else {
		String msg="Data not found";
		return new ResponseEntity(msg,HttpStatus.BAD_REQUEST);
	}
	 } 
		@GetMapping(value ="/getContactById/{cid}",produces = "application/json")
		public ResponseEntity<Contact> getContactById(@PathVariable Integer cid) {
			Contact contactById = contactServiceI.getContactById(cid);
			return new ResponseEntity<Contact>(contactById,HttpStatus.OK);

		}

		
		@PutMapping(value = "/UpdateContact", consumes = "application/json")
		public ResponseEntity<String> UpdateContact(@RequestBody Contact contact) {

			boolean updateContact = contactServiceI.updateContact(contact);

			if (updateContact == true) {
				String msg = "Contact Updated Successfully";
				return new ResponseEntity<String>(msg, HttpStatus.OK);
			} else {
				String msg = "Contact  not updated Successfully";
				return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
			}
		}
		@DeleteMapping(value="/deleteContactById/{cid}")
		public ResponseEntity<String> deleteContactById(@PathVariable Integer cid){
			
			boolean deleteById = contactServiceI.deleteById(cid);
			
			if(deleteById) {
				return new ResponseEntity<String>("Record deleted Successfully",HttpStatus.OK);
			}else {
		 return new ResponseEntity<String>("Record not  deleted Successfully",HttpStatus.BAD_REQUEST);
			
		}
}
}
