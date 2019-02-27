package com.statelessstarterapp.core.component;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.statelessstarterapp.core.model.Person;

@Component
public class PersonService implements IPersonService {
	
	private final Map<Integer, Person> personMap = new LinkedHashMap<>();
	private final Person person0 = new Person(0, "", "");
	private final Person person1 = new Person(1, "New York", "John");
	private final Person person2 = new Person(2, "Florida", "Doe");
	private final Person person3 = new Person(3, "Chicago", "Smith");
	
	PersonService(){
		
		personMap.put(person0.getId(), person0);
		personMap.put(person1.getId(), person1);
		personMap.put(person2.getId(), person2);
		personMap.put(person3.getId(), person3);
		
	}
	
	@Override
	public Person getPersonDetail(Integer id){
		
		return personMap.get(id);
		
	}
	
	@Override
	public void setPersonDetail(final Person person) {
		
		personMap.put(person.getId(), person);
		
	}
	
} 