package com.capstone.smartinventorymanagement.controller;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.smartinventorymanagement.dto.AuthUserDto;
import com.capstone.smartinventorymanagement.exception.UserEmailNotFoundException;
import com.capstone.smartinventorymanagement.model.AuthUser;
import com.capstone.smartinventorymanagement.repository.AuthUserRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/sims")
public class AuthUserController {
	@Autowired
	AuthUserRepository authUserRepo;
	@GetMapping("/getuser/{useremail}")
	public AuthUser getUser(@PathVariable("useremail")String userEmail) {
		return authUserRepo.findByUserEmail(userEmail).orElseThrow(()-> new RuntimeException("can't get user"+ userEmail));
	}
	@PostMapping("/loginrequest")
	public ResponseEntity<String> login(@RequestBody AuthUserDto authUserDto){
		AuthUser authUser = authUserRepo.findByUserEmail(authUserDto.getUserEmail()).get();
		if(authUserRepo.findByUserEmail(authUser.getUserEmail()).isPresent()) {
				
				if(authUserRepo.findByUserEmail(authUser.getUserEmail()).get().getUserPassword() == authUser.getUserPassword()) {

			return ResponseEntity.ok(authUser.getRole().toString()); 
			}else {
			return ResponseEntity.status(401).body("Invalid Credentials");
		
		}} else {
			return ResponseEntity.status(401).body("Invalid Credentials ");
		}
	}
	
	@PostMapping("/signup")
	public ResponseEntity<String> signup(@RequestBody AuthUser signUp){
		AuthUser user = authUserRepo.save(signUp);
		System.out.println(signUp.getUserEmail());
		if(user!=null) {
			String message = "Signup succesful" + signUp.getUserEmail();
			ResponseEntity<String> re = new ResponseEntity<String>(message,HttpStatus.CREATED);
			return re;
		}
		else {
			String message = "Failed";
			ResponseEntity<String> re = new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);
			return re;
		}
		
		
	}
	@PutMapping("/updateuser/{useremail}")
	public String updateUser(@PathVariable("useremail")String useremail,@RequestBody AuthUser authUser) {
		if(authUserRepo.existsByUserEmail(useremail)) {
			authUserRepo.findByUserEmail(useremail).get().setUserPassword(authUser.getUserPassword());
			return "updated successfully";
		}
		else 
			throw new UserEmailNotFoundException("useremail not found with"+useremail);
	}

//	private boolean isValidUser(String userEmail,String userPassword) {
//			return (authUserRepo.findByUserEmail(userEmail).get().getUserEmail()==userEmail && authUserRepo.findByUserEmail(userPassword).get().getUserPassword() == userPassword);
//		
//	}
	

}
