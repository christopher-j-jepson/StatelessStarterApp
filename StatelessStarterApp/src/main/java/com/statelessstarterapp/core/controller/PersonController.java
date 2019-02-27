package com.statelessstarterapp.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.statelessstarterapp.core.component.IPersonService;
import com.statelessstarterapp.core.model.Identifier;
import com.statelessstarterapp.core.model.Person;

@RestController
@RequestMapping("/person/")
public class PersonController {

	@Autowired
	private IPersonService personService;
	
	/**
	 * Use URL format http://localhost:8080/StatelessStarterApp/person/[VALUE]
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Person> getPersonDetail(@PathVariable("id") int id) {


		Person person = personService.getPersonDetail(id);
		
		if (person == null) {
			return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Person>(person, HttpStatus.OK);
	}
	
	/**
	 * Use URL format http://localhost:8080/StatelessStarterApp/person/request/
	 * <br/>
	 * content-type: application/json; charset=UTF-8
	 * <br/>
	 * {
	 * 		"identifier" : "[VALUE]"
	 * }
	 * 
	 * @param identifier
	 * @param ucBuilder
	 * @return
	 */
	@RequestMapping(value = "/request/", method = RequestMethod.POST)
	public ResponseEntity<Person> getPersonDetail(@RequestBody Identifier identifier, UriComponentsBuilder ucBuilder) {
			
		Person person = personService.getPersonDetail(identifier.getIdentifier());
		
		return new ResponseEntity<Person>(person, HttpStatus.OK);

	}
	
	/**
	 * Use URL format http://localhost:8080/StatelessStarterApp/person/create/
	 * <br/>
	 * content-type: application/json; charset=UTF-8
	 * <br/>
	 * {
	 * 		"id" : "[VALUE]",
	 * 		"location" : "[VALUE]",
	 * 		"name" : "[VALUE]"
	 * }
	 * 
	 * @param person
	 * @param ucBuilder
	 * @return
	 */
	@RequestMapping(value = "/create/", method = RequestMethod.POST)
	public ResponseEntity<Void> createPerson(@RequestBody Person person, UriComponentsBuilder ucBuilder) {
		
		personService.setPersonDetail(person);
				
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/person/create/{id}").buildAndExpand(person.getId()).toUri());
		
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

	}

}
