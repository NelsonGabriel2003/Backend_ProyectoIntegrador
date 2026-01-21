package com.puce.luluncotoapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puce.luluncotoapp.dto.LoginRequest;
import com.puce.luluncotoapp.dto.LoginResponse;
import com.puce.luluncotoapp.dto.RegisterRequest;
import com.puce.luluncotoapp.dto.RegisterResponse;
import com.puce.luluncotoapp.dto.UserResponse;
import com.puce.luluncotoapp.model.UserModel;
import com.puce.luluncotoapp.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private JwtService jwtService;

    public LoginResponse login(LoginRequest request) {
        
        Optional<UserModel> optionalUser = userRepository.findByEmail(request.getEmail());

        if (optionalUser.isEmpty()) {
            throw new RuntimeException("Usuario no encontrado");
        }

        UserModel user = optionalUser.get();

        if (!user.getContrasena().equals(request.getContrasena())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        UserResponse userResponse = new UserResponse(
            user.getId(),
        	user.getNombre(),
            user.getEmail(),
            user.getCedula(),
            user.getCelular(),
            user.getFotoPerfil(),
            user.getFechadeNacimiento()
        );

        String token = jwtService.generateToken(user.getEmail()) ;

        return new LoginResponse(token, userResponse);
    }
    
    public RegisterResponse registrar(RegisterRequest request) {
    	
    	if(userRepository.findByEmail(request.getEmail()).isPresent()){
    		throw new RuntimeException("El email ya esta registrado en la Base de Datos");
    	}
    	
    	if(userRepository.findByCedula(request.getCedula()).isPresent()) {
    		throw new RuntimeException("La cedula ha sido registrada en otra cuenta");
    	}
    	
    	UserModel user = new UserModel();
        user.setNombre(request.getNombre());
        user.setEmail(request.getEmail());
        user.setContrasena(request.getContrasena());
        user.setCedula(request.getCedula());
        user.setCelular(request.getCelular());
        user.setFechadeNacimiento(request.getFechaDeNacimiento());
        
        UserModel savedUser = userRepository.save(user);
        
        return new RegisterResponse(
                savedUser.getNombre(),
                savedUser.getEmail(),
                savedUser.getCedula(),
                savedUser.getCelular(),
                savedUser.getFechadeNacimiento()
            );
    	}
    }