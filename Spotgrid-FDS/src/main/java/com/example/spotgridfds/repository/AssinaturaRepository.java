package com.example.spotgridfds.repository;

import com.example.spotgridfds.domain.Assinatura;
import java.util.List;


public interface AssinaturaRepository {
    void save(Assinatura assinatura);
    List<Assinatura> findAll();
    Assinatura findById(Long id);
    void update(Assinatura assinatura);
    void deleteById(Long id);
}
