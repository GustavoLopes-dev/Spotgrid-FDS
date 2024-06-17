package com.example.spotgridfds.repository;

import com.example.spotgridfds.domain.Usuario;

import java.util.List;

public interface UsuarioRepository {
    List<Usuario> findAll();
    Usuario findById(Long id);
    Usuario findByUsername(String username);
    void save(Usuario usuario);
    void update(Usuario usuario);
    void delete(Long id);
}
