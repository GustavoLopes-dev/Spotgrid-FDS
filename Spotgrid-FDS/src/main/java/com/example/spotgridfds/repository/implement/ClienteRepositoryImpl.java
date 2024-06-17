package com.example.spotgridfds.repository.implement;

import com.example.spotgridfds.domain.Cliente;
import com.example.spotgridfds.repository.ClienteRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class ClienteRepositoryImpl implements ClienteRepository {
    private final JdbcTemplate jdbcTemplate;

    public ClienteRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Cliente> clienteRowMapper = (rs, rowNum) -> {
        Cliente cliente = new Cliente();
        cliente.setCodigoCliente(rs.getLong("codigo"));
        cliente.setNomeCliente(rs.getString("nome"));
        cliente.setEmailCliente(rs.getString("email"));
        return cliente;
    };

    @Override
    public List<Cliente> findAll() {
        String sql = "SELECT * FROM Cliente";
        return jdbcTemplate.query(sql, clienteRowMapper);
    }

    @Override
    public Cliente findById(Long id) {
        String sql = "SELECT * FROM Cliente WHERE codigo = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, clienteRowMapper);
    }

    @Override
    public void save(Cliente cliente) {
        String sql = "INSERT INTO Cliente (nome, email) VALUES (?, ?)";
        jdbcTemplate.update(sql, cliente.getNomeCliente(), cliente.getEmailCliente());
    }

    @Override
    public void update(Cliente cliente) {
        String sql = "UPDATE Cliente SET nome = ?, email = ? WHERE codigo = ?";
        jdbcTemplate.update(sql, cliente.getNomeCliente(), cliente.getEmailCliente(), cliente.getCodigoCliente());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM Cliente WHERE codigo = ?";
        jdbcTemplate.update(sql, id);
    }
}
