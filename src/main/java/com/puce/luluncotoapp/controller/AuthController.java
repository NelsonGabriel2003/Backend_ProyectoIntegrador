package com.puce.luluncotoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.puce.luluncotoapp.dto.LoginRequest;
import com.puce.luluncotoapp.dto.LoginResponse;
import com.puce.luluncotoapp.dto.RegisterRequest;
import com.puce.luluncotoapp.dto.RegisterResponse;
import com.puce.luluncotoapp.service.AuthService;

@RestController
@RequestMapping("/luluncoto/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	
	@PostMapping("/login")
	public LoginResponse login(@RequestBody LoginRequest request) {
		return authService.login(request);
	}
	
	@PostMapping("/registro")
	public RegisterResponse registrar(@RequestBody RegisterRequest request){
		return authService.registrar(request);
	}
}
