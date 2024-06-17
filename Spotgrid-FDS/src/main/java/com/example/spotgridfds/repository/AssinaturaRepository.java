package com.example.spotgridfds.repository;

import com.example.spotgridfds.domain.Assinatura;

import java.util.List;

public interface AssinaturaRepository {
    List<Assinatura> findAll();
    List<Assinatura> findActive();
    List<Assinatura> findCancelled();
    List<Assinatura> findByClienteId(Long clienteId);
    List<Assinatura> findByAplicativoId(Long aplicativoId);
    Assinatura findById(Long id);
    void save(Assinatura assinatura);
    void update(Assinatura assinatura);
    void delete(Long id);
}
