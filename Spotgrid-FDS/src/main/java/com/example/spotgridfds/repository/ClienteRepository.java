package com.example.spotgridfds.repository;

import com.example.spotgridfds.domain.Cliente;
import java.util.List;

public interface ClienteRepository {
    List<Cliente> findAll();
    Cliente findById(Long id);
    void save(Cliente cliente);
    void update(Cliente cliente);
    void delete(Long id);
}
