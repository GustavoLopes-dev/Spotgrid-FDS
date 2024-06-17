package com.example.spotgridfds.repository;

import com.example.spotgridfds.domain.App;

import java.util.List;

public interface AppRepository {
    List<App> findAll();
    App findById(Long id);
    void save(App app);
    void update(App app);
    void delete(Long id);
}
