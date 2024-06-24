package com.example.spotgridfds.repository;

import com.example.spotgridfds.domain.Aplicativo;
import java.util.List;

public interface AplicativoRepository {
    void save(Aplicativo aplicativo);
    List<Aplicativo> findAll();
    Aplicativo findById(Long id);
    void update(Aplicativo aplicativo);
    void deleteById(Long id);
}
