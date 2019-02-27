package com.statelessstarterapp.core.component;

import com.statelessstarterapp.core.model.Person;

public interface IPersonService {
	
  public Person getPersonDetail(Integer id);
  
  public void setPersonDetail(Person person);
  
} 
