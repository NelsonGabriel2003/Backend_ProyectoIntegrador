package com.puce.luluncotoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.puce.luluncotoapp.dto.ActualizarPerfilRequest;
import com.puce.luluncotoapp.dto.CambiarContrasenaRequest;
import com.puce.luluncotoapp.dto.MensajeResponse;
import com.puce.luluncotoapp.dto.UserResponse;
import com.puce.luluncotoapp.service.UsuarioService;

@RestController
@RequestMapping("/luluncoto/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/perfil")
    public ResponseEntity<UserResponse> obtenerPerfil() {
        return ResponseEntity.ok(usuarioService.obtenerPerfil());
    }

    @PutMapping("/perfil")
    public ResponseEntity<UserResponse> actualizarPerfil(@RequestBody ActualizarPerfilRequest request) {
        return ResponseEntity.ok(usuarioService.actualizarPerfil(request));
    }

    @PutMapping("/cambiar-contrasena")
    public ResponseEntity<MensajeResponse> cambiarContrasena(@RequestBody CambiarContrasenaRequest request) {
        usuarioService.cambiarContrasena(request);
        return ResponseEntity.ok(new MensajeResponse("Contrasena actualizada correctamente"));
    }
}
