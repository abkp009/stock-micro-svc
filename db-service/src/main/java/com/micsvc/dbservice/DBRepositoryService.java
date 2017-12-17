package com.micsvc.dbservice;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/db")
public class DBRepositoryService {

	@Autowired
	private QuoteRepo repo;

	@GetMapping("/{userName}")
	@ResponseBody
	public List<String> listQuotes(@PathVariable("userName") final String userName) {
		System.out.println("userName: "+userName);
		return repo.findByUserName(userName)
				.stream()
				.map(q -> q.getQuote())
				.collect(Collectors.toList());
	}
	
	@PostMapping("/add")
	@ResponseBody
	public Quotes addQuotes(@RequestBody final Quotes quote ) {
		return repo.save(quote);
	}
	
	@PostMapping("/delete")
	public boolean deleteQuotes(@RequestBody final Quotes quote ) {
		 repo.delete(quote);
		 return true;
	}

}
