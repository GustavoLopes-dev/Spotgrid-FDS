package com.example.spotgridfds.repository.implement;

import com.example.spotgridfds.domain.Pagamento;
import com.example.spotgridfds.repository.PagamentoRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class PagamentoRepositoryImpl implements PagamentoRepository {
    private final JdbcTemplate jdbcTemplate;

    public PagamentoRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Pagamento> pagamentoRowMapper = (rs, rowNum) -> {
        Pagamento pagamento = new Pagamento();
        pagamento.setCodigoPagamento(rs.getLong("codigo"));
        pagamento.setAssinaturaPaga(rs.getLong("codigoAssinatura"));
        pagamento.setValorPago(rs.getDouble("valorPago"));
        pagamento.setDataPagamento(rs.getDate("dataPagamento").toLocalDate());
        return pagamento;
    };

    @Override
    public List<Pagamento> findAll() {
        String sql = "SELECT * FROM Pagamento";
        return jdbcTemplate.query(sql, pagamentoRowMapper);
    }

    @Override
    public Pagamento findById(Long id) {
        String sql = "SELECT * FROM Pagamento WHERE codigo = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, pagamentoRowMapper);
    }

    @Override
    public void save(Pagamento pagamento) {
        String sql = "INSERT INTO Pagamento (codigoAssinatura, valorPago, dataPagamento) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, pagamento.getAssinaturaId(), pagamento.getValorPago(), pagamento.getDataPagamento());
    }

    @Override
    public void update(Pagamento pagamento) {
        String sql = "UPDATE Pagamento SET codigoAssinatura = ?, valorPago = ?, dataPagamento = ? WHERE codigo = ?";
        jdbcTemplate.update(sql, pagamento.getAssinaturaId(), pagamento.getValorPago(), pagamento.getDataPagamento(), pagamento.getCodigo());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM Pagamento WHERE codigo = ?";
        jdbcTemplate.update(sql, id);
    }
}
