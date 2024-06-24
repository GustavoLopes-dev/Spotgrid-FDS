package com.example.spotgridfds.repository;

import com.example.spotgridfds.domain.Cliente;
import java.util.List;

public interface ClienteRepository {
    void save(Cliente cliente);
    List<Cliente> findAll();
    Cliente findById(Long id);
    void update(Cliente cliente);
    void deleteById(Long id);
}
