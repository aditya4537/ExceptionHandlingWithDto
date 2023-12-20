package com.example.intern.service;

import java.util.List;

import com.example.intern.dto.ResponseDto;
import com.example.intern.model.Intern;

public interface InternService {
	public List<Intern> getInternDetails();
	
	public Intern saveIntern(Intern intern);
	
	public ResponseDto deleteIntern(long id);
	
	public Intern editIntern(Intern intern);
	
	public ResponseDto addBuddyOfIntern(long iId, long bId);
	
}
