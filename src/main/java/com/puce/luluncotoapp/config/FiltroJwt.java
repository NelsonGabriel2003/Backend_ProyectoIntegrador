package com.puce.luluncotoapp.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.puce.luluncotoapp.service.JwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.ArrayList;

@Component
public class FiltroJwt extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest solicitud, HttpServletResponse respuesta, FilterChain cadenaFiltros)
            throws ServletException, IOException {

        String encabezadoAutorizacion = solicitud.getHeader("Authorization");
        String token = null;
        String email = null;

        // Extraer token del encabezado Authorization: Bearer <token>
        if (encabezadoAutorizacion != null && encabezadoAutorizacion.startsWith("Bearer ")) {
            token = encabezadoAutorizacion.substring(7);
            try {
                email = jwtService.extractEmail(token);
            } catch (Exception e) {
                // Token invalido, continuar sin autenticar
            }
        }

        // Si se extrajo el email y no hay autenticacion previa en el contexto
        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            if (jwtService.validateToken(token, email)) {
                UsernamePasswordAuthenticationToken autenticacion =
                    new UsernamePasswordAuthenticationToken(email, null, new ArrayList<>());
                autenticacion.setDetails(new WebAuthenticationDetailsSource().buildDetails(solicitud));
                SecurityContextHolder.getContext().setAuthentication(autenticacion);
            }
        }

        cadenaFiltros.doFilter(solicitud, respuesta);
    }
}
