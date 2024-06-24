package com.example.spotgridfds.repository;

import com.example.spotgridfds.domain.Usuario;
import java.util.List;

public interface UsuarioRepository {
    void save(Usuario usuario);
    List<Usuario> findAll();
    Usuario findById(Long id);
    void update(Usuario usuario);
    void deleteById(Long id);
}