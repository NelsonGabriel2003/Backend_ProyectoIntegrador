package com.puce.luluncotoapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.puce.luluncotoapp.dto.ActualizarPerfilRequest;
import com.puce.luluncotoapp.dto.CambiarContrasenaRequest;
import com.puce.luluncotoapp.dto.UserResponse;
import com.puce.luluncotoapp.exception.ContrasenaIncorrectaException;
import com.puce.luluncotoapp.exception.UsuarioNoEncontradoException;
import com.puce.luluncotoapp.model.UserModel;
import com.puce.luluncotoapp.repository.UserRepository;

@Service
public class UsuarioService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder codificadorContrasena;

    @Autowired
    private HistorialActividadService historialService;

    private UserModel obtenerUsuarioAutenticado() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsuarioNoEncontradoException("Usuario no encontrado"));
    }

    public UserResponse obtenerPerfil() {
        UserModel usuario = obtenerUsuarioAutenticado();
        return new UserResponse(
            usuario.getId(),
            usuario.getNombre(),
            usuario.getEmail(),
            usuario.getCedula(),
            usuario.getCelular(),
            usuario.getFotoPerfil(),
            usuario.getFechadeNacimiento(),
            usuario.getRol().getNombre(),
            usuario.getCreadoEn()
        );
    }

    public UserResponse actualizarPerfil(ActualizarPerfilRequest request) {
        UserModel usuario = obtenerUsuarioAutenticado();

        if (request.getNombre() != null && !request.getNombre().isBlank()) {
            usuario.setNombre(request.getNombre());
        }
        if (request.getCelular() != null && !request.getCelular().isBlank()) {
            usuario.setCelular(request.getCelular());
        }
        if (request.getFotoPerfil() != null) {
            usuario.setFotoPerfil(request.getFotoPerfil());
        }

        UserModel usuarioActualizado = userRepository.save(usuario);

        historialService.registrarActividad(usuarioActualizado, "ACTUALIZAR_PERFIL", "USUARIO", usuarioActualizado.getId(), "Perfil actualizado");

        return new UserResponse(
            usuarioActualizado.getId(),
            usuarioActualizado.getNombre(),
            usuarioActualizado.getEmail(),
            usuarioActualizado.getCedula(),
            usuarioActualizado.getCelular(),
            usuarioActualizado.getFotoPerfil(),
            usuarioActualizado.getFechadeNacimiento(),
            usuarioActualizado.getRol().getNombre(),
            usuarioActualizado.getCreadoEn()
        );
    }

    public void cambiarContrasena(CambiarContrasenaRequest request) {
        UserModel usuario = obtenerUsuarioAutenticado();

        if (!codificadorContrasena.matches(request.getContrasenaActual(), usuario.getContrasena())) {
            throw new ContrasenaIncorrectaException("La contrasena actual es incorrecta");
        }

        usuario.setContrasena(codificadorContrasena.encode(request.getContrasenaNueva()));
        userRepository.save(usuario);

        historialService.registrarActividad(usuario, "CAMBIAR_CONTRASENA", "USUARIO", usuario.getId(), "Contraseña actualizada");
    }
}
