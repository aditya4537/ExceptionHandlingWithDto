package com.example.intern.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.intern.dto.ResponseDto;
import com.example.intern.model.Intern;
import com.example.intern.service.InternService;

@RestController
@RequestMapping("/intern")
public class InternController {

	@Autowired
	private InternService internService;
	
	@GetMapping("/get")
	public List<Intern> getInterns(){
		return internService.getInternDetails();
	}
	
	@PostMapping("/add")
	public Intern addIntern(@RequestBody Intern intern) {
		return internService.saveIntern(intern);
	}
	
	@DeleteMapping("/delete/{internId}")
	public ResponseEntity<ResponseDto> deleteIntern(@PathVariable() long internId) {
		ResponseDto rd = internService.deleteIntern(internId);
		
		return new ResponseEntity<>(rd ,HttpStatusCode.valueOf(rd.getStatus()));	
	}
	
	@PutMapping("/edit")
	public Intern editIntern(@RequestBody Intern intern) {
		return internService.editIntern(intern);
	}
	
	@PutMapping("/addBuddy")
	public ResponseEntity<ResponseDto> addBuddyOfIntern(@RequestParam("iId") long internId, @RequestParam("bId") long buddyId) {
		ResponseDto rd = internService.addBuddyOfIntern(internId, buddyId);
		return new ResponseEntity<>(rd ,HttpStatusCode.valueOf(rd.getStatus()));
	}
}
