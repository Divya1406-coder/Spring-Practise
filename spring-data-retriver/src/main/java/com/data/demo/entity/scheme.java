package com.data.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class scheme {
	@Id
	private Integer schemeCode;
	
	private String schemeName;
	public scheme(){}
}
