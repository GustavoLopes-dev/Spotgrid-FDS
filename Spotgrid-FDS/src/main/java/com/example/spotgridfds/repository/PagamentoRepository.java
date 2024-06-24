package com.example.spotgridfds.repository;

import com.example.spotgridfds.domain.Pagamento;

import java.util.List;

public interface PagamentoRepository {
    void save(Pagamento pagamento);
    List<Pagamento> findAll();
    Pagamento findById(Long id);
    void update(Pagamento pagamento);
    void deleteById(Long id);
}