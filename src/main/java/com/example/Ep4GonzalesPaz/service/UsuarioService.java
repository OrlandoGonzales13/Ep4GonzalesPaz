package com.example.Ep4GonzalesPaz.service;

import com.example.Ep4GonzalesPaz.entity.Usuario;
import com.example.Ep4GonzalesPaz.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    // Otros métodos de servicio
}