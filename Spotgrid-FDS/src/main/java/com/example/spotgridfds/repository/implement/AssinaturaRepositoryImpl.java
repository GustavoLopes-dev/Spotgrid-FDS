package com.example.spotgridfds.repository.implement;

import com.example.spotgridfds.domain.Assinatura;
import com.example.spotgridfds.repository.AssinaturaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class AssinaturaRepositoryImpl implements AssinaturaRepository {
    private final JdbcTemplate jdbcTemplate;

    public AssinaturaRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Assinatura> assinaturaRowMapper = (rs, rowNum) -> {
        Assinatura assinatura = new Assinatura();
        assinatura.setCodigoAssinatura(rs.getLong("codigo"));
        // Supondo que os métodos get/set para App e Cliente estão definidos na classe Assinatura
        // Aqui você precisaria ajustar conforme a estrutura real das suas entidades
        assinatura.setAppAssinatura(null); // Ajustar conforme necessário
        assinatura.setClienteAssinatura(null); // Ajustar conforme necessário
        assinatura.setInicioVigencia(rs.getDate("inicioVigencia"));
        assinatura.setFimVigencia(rs.getDate("fimVigencia"));
        return assinatura;
    };

    @Override
    public List<Assinatura> findAll() {
        String sql = "SELECT * FROM Assinatura";
        return jdbcTemplate.query(sql, assinaturaRowMapper);
    }

    @Override
    public List<Assinatura> findActive() {
        String sql = "SELECT * FROM Assinatura WHERE fimVigencia > CURDATE()";
        return jdbcTemplate.query(sql, assinaturaRowMapper);
    }

    @Override
    public List<Assinatura> findCancelled() {
        String sql = "SELECT * FROM Assinatura WHERE fimVigencia <= CURDATE()";
        return jdbcTemplate.query(sql, assinaturaRowMapper);
    }

    @Override
    public List<Assinatura> findByClienteId(Long clienteId) {
        String sql = "SELECT * FROM Assinatura WHERE codigoCliente = ?";
        return jdbcTemplate.query(sql, new Object[]{clienteId}, assinaturaRowMapper);
    }

    @Override
    public List<Assinatura> findByAplicativoId(Long aplicativoId) {
        String sql = "SELECT * FROM Assinatura WHERE codigoAplicativo = ?";
        return jdbcTemplate.query(sql, new Object[]{aplicativoId}, assinaturaRowMapper);
    }

    @Override
    public Assinatura findById(Long id) {
        String sql = "SELECT * FROM Assinatura WHERE codigo = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, assinaturaRowMapper);
    }

    @Override
    public void save(Assinatura assinatura) {
        String sql = "INSERT INTO Assinatura (codigoCliente, codigoAplicativo, inicioVigencia, fimVigencia) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, assinatura.getClienteAssinatura().getCodigoCliente(), assinatura.getAppAssinatura().getCodigoApp(), assinatura.getInicioVigencia(), assinatura.getFimVigencia());
    }

    @Override
    public void update(Assinatura assinatura) {
        String sql = "UPDATE Assinatura SET codigoCliente = ?, codigoAplicativo = ?, inicioVigencia = ?, fimVigencia = ? WHERE codigo = ?";
        jdbcTemplate.update(sql, assinatura.getClienteAssinatura().getCodigoCliente(), assinatura.getAppAssinatura().getCodigoApp(), assinatura.getInicioVigencia(), assinatura.getFimVigencia(), assinatura.getCodigoAssinatura());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM Assinatura WHERE codigo = ?";
        jdbcTemplate.update(sql, id);
    }
}
