package com.puce.luluncotoapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.puce.luluncotoapp.dto.LoginRequest;
import com.puce.luluncotoapp.dto.LoginResponse;
import com.puce.luluncotoapp.dto.RegisterRequest;
import com.puce.luluncotoapp.dto.RegisterResponse;
import com.puce.luluncotoapp.dto.UserResponse;
import com.puce.luluncotoapp.exception.ContrasenaIncorrectaException;
import com.puce.luluncotoapp.exception.RegistroDuplicadoException;
import com.puce.luluncotoapp.exception.UsuarioNoEncontradoException;
import com.puce.luluncotoapp.model.RolModel;
import com.puce.luluncotoapp.model.UserModel;
import com.puce.luluncotoapp.repository.RolRepository;
import com.puce.luluncotoapp.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder codificadorContrasena;

    @Autowired
    private HistorialActividadService historialService;

    public LoginResponse login(LoginRequest request) {

        Optional<UserModel> optionalUser = userRepository.findByEmail(request.getEmail());

        if (optionalUser.isEmpty()) {
            throw new UsuarioNoEncontradoException("Usuario no encontrado");
        }

        UserModel user = optionalUser.get();

        if (!codificadorContrasena.matches(request.getContrasena(), user.getContrasena())) {
            throw new ContrasenaIncorrectaException("Contraseña incorrecta");
        }

        UserResponse userResponse = new UserResponse(
            user.getId(),
            user.getNombre(),
            user.getEmail(),
            user.getCedula(),
            user.getCelular(),
            user.getFotoPerfil(),
            user.getFechadeNacimiento(),
            user.getRol().getNombre(),
            user.getCreadoEn()
        );

        String token = jwtService.generateToken(user.getEmail());

        historialService.registrarActividad(user, "LOGIN", "USUARIO", user.getId(), "Inicio de sesión exitoso");

        return new LoginResponse(token, userResponse);
    }

    public RegisterResponse registrar(RegisterRequest request) {

    	if(userRepository.findByEmail(request.getEmail()).isPresent()){
    		throw new RegistroDuplicadoException("El email ya esta registrado en la Base de Datos");
    	}

    	if(userRepository.findByCedula(request.getCedula()).isPresent()) {
    		throw new RegistroDuplicadoException("La cedula ha sido registrada en otra cuenta");
    	}

    	UserModel user = new UserModel();
        user.setNombre(request.getNombre());
        user.setEmail(request.getEmail());
        user.setContrasena(codificadorContrasena.encode(request.getContrasena()));
        user.setCedula(request.getCedula());
        user.setCelular(request.getCelular());
        user.setFechadeNacimiento(request.getFechaDeNacimiento());

        RolModel rolUsuario = rolRepository.findByNombre("USUARIO")
                .orElseThrow(() -> new RuntimeException("Rol USUARIO no encontrado en la base de datos"));
        user.setRol(rolUsuario);

        UserModel savedUser = userRepository.save(user);

        historialService.registrarActividad(savedUser, "REGISTRO", "USUARIO", savedUser.getId(), "Nuevo usuario registrado: " + savedUser.getEmail());

        return new RegisterResponse(
                savedUser.getNombre(),
                savedUser.getEmail(),
                savedUser.getCedula(),
                savedUser.getCelular(),
                savedUser.getFechadeNacimiento(),
                savedUser.getRol().getNombre(),
                savedUser.getCreadoEn()
            );
    }
}
