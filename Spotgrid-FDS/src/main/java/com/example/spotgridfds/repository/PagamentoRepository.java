package com.example.spotgridfds.repository;

import com.example.spotgridfds.domain.Pagamento;

import java.util.List;

public interface PagamentoRepository {
    List<Pagamento> findAll();
    Pagamento findById(Long id);
    void save(Pagamento pagamento);
    void update(Pagamento pagamento);
    void delete(Long id);
}
