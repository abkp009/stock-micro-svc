package com.micsvc.dbservice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepo extends JpaRepository<Quotes,Integer> {

	List<Quotes> findByUserName(String userName);
 
}
