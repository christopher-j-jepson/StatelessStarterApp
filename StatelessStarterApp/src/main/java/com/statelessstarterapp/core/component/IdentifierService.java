package com.statelessstarterapp.core.component;

import org.springframework.stereotype.Component;

import com.statelessstarterapp.core.model.Identifier;

@Component
public class IdentifierService implements IIdentifierService{

	Identifier identifier = new Identifier();
	
	IdentifierService(){

	}
	
	@Override
	public Identifier getIdentifier(){
		
		return identifier;
		
	}
	
	@Override
	public void setIdentifier(final Identifier identifier) {
		
		this.identifier = identifier;
		
	}
	
}
