package com.data.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.data.demo.entity.scheme;

public interface Repo extends JpaRepository{
    
	@Query("Select * from table where schemeCode=?")
	public List<scheme> getAllBySchemeCode(String schemeCode);  // select * from table schemeCode= "123"
}
