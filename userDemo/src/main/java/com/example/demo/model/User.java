package com.example.demo.model;

import java.util.Optional;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.domain.EntityScan;



@Data
@Entity
@Table(name="users")
public class User {
	
	// instance variables 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	@Column
    private String userName; 
	@Column
    private String birthdate;
	@Column
    private String residenceCountry;
	@Column
    private String phone;
	@Column
    private String genre;
    
    
    
	public Optional<String> getPhone(){
	    return Optional.ofNullable(phone);
	  }
	
	public Optional<String> getGenre(){
	    return Optional.ofNullable(genre);
	  }


}
