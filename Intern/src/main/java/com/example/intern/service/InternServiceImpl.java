package com.example.intern.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.intern.dto.ResponseDto;
import com.example.intern.model.Buddy;
import com.example.intern.model.Intern;
import com.example.intern.reppository.BuddyRepository;
import com.example.intern.reppository.InternRepository;

@Service
public class InternServiceImpl implements InternService {

	@Autowired
	private InternRepository internRepository;
	
	@Autowired
	private BuddyRepository buddyRepository;
	
	@Override
	public List<Intern> getInternDetails() {
		
		return internRepository.findAll();
	}

	@Override
	public Intern saveIntern(Intern intern) {
		return internRepository.save(intern);
	}

	@Override
	public ResponseDto deleteIntern(long id) {
		Intern intern = internRepository.findById(id).orElse(null);
		if(intern != null) {
			internRepository.deleteById(id);
			
			ResponseDto responseDto = new ResponseDto();
			responseDto.setData("Intern data deleted");
			responseDto.setMessage("ok");
			responseDto.setStatus(200);
			return responseDto;
		}
		else {
			ResponseDto responseDto = new ResponseDto();
			responseDto.setData("Intern data not found");
			responseDto.setMessage("Not found");
			responseDto.setStatus(404);
			return responseDto;
		}
	}

	@Override
	public ResponseDto addBuddyOfIntern(long iId, long bId) {
		Intern intern = internRepository.findById(iId).orElse(null);
		Buddy buddy1 = buddyRepository.findById(bId).orElse(null);
		
		if(intern != null && buddy1 != null) {
			Buddy buddy = new Buddy();
			
			buddy.setBuddyId(bId);
			intern.setBuddyOfIntern(buddy);
			
			ResponseDto responseDto = new ResponseDto();
			responseDto.setData(internRepository.save(intern));
			responseDto.setMessage("ok");
			responseDto.setStatus(200);
			return responseDto;
		}
		else {
			ResponseDto responseDto = new ResponseDto();
			if(intern == null)
				responseDto.setData("Intern data not found");
			else
				responseDto.setData("Buddy data not found");
			responseDto.setMessage("Not found");
			responseDto.setStatus(404);
			return responseDto;
		}
		
	}

	@Override
	public Intern editIntern(Intern intern) {
		Intern updateIntern = internRepository.findById(intern.getInternId()).orElse(null);
		if(updateIntern != null) {
			updateIntern.setInternId(intern.getInternId());
			updateIntern.setinternName(intern.getinternName());
			updateIntern.setInternRole(intern.getInternRole());
			updateIntern.setInternStippend(intern.getInternStippend());
			updateIntern.setBuddyOfIntern(intern.getBuddyOfIntern());
			internRepository.save(updateIntern);
			return updateIntern;
		}
		return null;
	}
	
	

}
