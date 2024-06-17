package com.example.spotgridfds.repository.implement;

import com.example.spotgridfds.domain.App;
import com.example.spotgridfds.repository.AppRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppRepositoryImpl implements AppRepository {
    private final JdbcTemplate jdbcTemplate;

    public AppRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<App> appRowMapper = (rs, rowNum) -> {
        App app = new App();
        app.setCodigoApp(rs.getLong("codigo"));
        app.setNomeApp(rs.getString("nome"));
        app.setPrecoApp(rs.getDouble("custoMensal"));
        return app;
    };

    @Override
    public List<App> findAll() {
        String sql = "SELECT * FROM App";
        return jdbcTemplate.query(sql, appRowMapper);
    }

    @Override
    public App findById(Long id) {
        String sql = "SELECT * FROM App WHERE codigo = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, appRowMapper);
    }

    @Override
    public void save(App app) {
        String sql = "INSERT INTO App (nome, custoMensal) VALUES (?, ?)";
        jdbcTemplate.update(sql, app.getNomeApp(), app.getPrecoApp());
    }

    @Override
    public void update(App app) {
        String sql = "UPDATE App SET nome = ?, custoMensal = ? WHERE codigo = ?";
        jdbcTemplate.update(sql, app.getNomeApp(), app.getPrecoApp(), app.getCodigoApp());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM App WHERE codigo = ?";
        jdbcTemplate.update(sql, id);
    }
}
