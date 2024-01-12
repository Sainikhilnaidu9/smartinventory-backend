package com.capstone.smartinventorymanagement.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.smartinventorymanagement.dto.GodownDto;
import com.capstone.smartinventorymanagement.exception.GodownIdNotFoundException;
import com.capstone.smartinventorymanagement.mapper.GodownMapper;
import com.capstone.smartinventorymanagement.model.Godown;
import com.capstone.smartinventorymanagement.repository.GodownRepository;

@Service
public class GodownServices {

   @Autowired
    private GodownRepository godownRepository;

    
    // to get details of all godown
    public List<GodownDto> getAllGodowns() {
        List<Godown> godowns = godownRepository.findAll();
        List<GodownDto> godownDtos = new ArrayList<>();

        for (Godown godown : godowns) {
            godownDtos.add(GodownMapper.convertToDto(godown));
        }

        return godownDtos;
    }
    
    
// to get details of Godown with particular id
    
    //here id will be like GDW101, so String is used.
    public GodownDto getGodownById(String id) {
        Optional<Godown> op = godownRepository.findById(id);
        
        if(op.isPresent()) {
            System.out.println("Godown Details found");
            return GodownMapper.convertToDto(op.get());
        } else {
            
            throw new GodownIdNotFoundException("No Record is found for Godown with id: " + id);
        }
    }

    
    
    //to create new godown 
    //manager is not added here yet
    public String createGodown(GodownDto godownDto) {
        Godown godown = new Godown();
        godown.setGodownId(godownDto.getGodownId());
        godown.setLocation(godownDto.getLocation());
        godown.setName(godownDto.getName());
        godown.setStartDate(godownDto.getStartDate());

        GodownDto godownDB= GodownMapper.convertToDto(godownRepository.save(godown));
        
        if(godownDB!=null) {
        	return "New Godown Created";
        }
        else {
        	return null;
        }
    }

    
    //to update godown details.
    public String updateGodown(String id, GodownDto godownDto) {
        Optional<Godown> optionalGodown = godownRepository.findById(id);
        if (optionalGodown.isPresent()) {
            Godown godown = optionalGodown.get();
            godown.setGodownId(godownDto.getGodownId());
            godown.setLocation(godownDto.getLocation());
            godown.setName(godownDto.getName());
            godown.setStartDate(godownDto.getStartDate());

            GodownDto godownDB=GodownMapper.convertToDto(godownRepository.save(godown));
            if(godownDB!=null) {
            	return "Updated";
            }
            else {
            	return null;
            }
        }else {
        	throw new GodownIdNotFoundException("No Record found for Godown with id: " + id);
        }
    }

    
    //to delete a godown by id
    public String deleteGodown(String id) {
    	if(godownRepository.existsById(id)) {
    		godownRepository.deleteById(id);
    		return "Deleted";
    	}
    	else {
    		throw new GodownIdNotFoundException("No Record found for Godown with id: " + id);
    	}
        
    }
}