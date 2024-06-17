package com.example.spotgridfds.repository.implement;

import com.example.spotgridfds.domain.Assinatura;
import com.example.spotgridfds.domain.Pagamento;
import com.example.spotgridfds.repository.PagamentoRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class PagamentoRepositoryImpl implements PagamentoRepository {
    private final JdbcTemplate jdbcTemplate;

    public PagamentoRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    @Override
//    public List<Pagamento> findAll() {
//        String sql = "SELECT * FROM Pagamento";
//        return jdbcTemplate.query(sql, (rs, rowNum) -> {
//            Pagamento pagamento = new Pagamento();
//            pagamento.setCodigoPagamento(rs.getLong("codigo"));
//            pagamento.setAssinaturaPaga(new Assinatura(rs.getLong("codigoAssinatura"))); // Ajuste necessário para vincular a assinatura
//            pagamento.setValorPago(rs.getDouble("valorPago"));
//            pagamento.setDataPagamento(rs.getDate("dataPagamento").toLocalDate());
//            return pagamento;
//        });
//    }

//    @Override
//    public Pagamento findById(Long id) {
//        String sql = "SELECT * FROM Pagamento WHERE codigo = ?";
//        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
//            Pagamento pagamento = new Pagamento();
//            pagamento.setCodigoPagamento(rs.getLong("codigo"));
//            pagamento.setAssinaturaPaga(new Assinatura(rs.getLong("codigoAssinatura"))); // Ajuste necessário
//            pagamento.setValorPago(rs.getDouble("valorPago"));
//            pagamento.setDataPagamento(rs.getDate("dataPagamento").toLocalDate());
//            return pagamento;
//        });
//    }

    @Override
    public void save(Pagamento pagamento) {
        String sql = "INSERT INTO Pagamento (codigoAssinatura, valorPago, dataPagamento) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, pagamento.getAssinaturaPaga().getCodigoAssinatura(), pagamento.getValorPago(), pagamento.getDataPagamento());
    }

    @Override
    public void update(Pagamento pagamento) {
        String sql = "UPDATE Pagamento SET codigoAssinatura = ?, valorPago = ?, dataPagamento = ? WHERE codigo = ?";
        jdbcTemplate.update(sql, pagamento.getAssinaturaPaga().getCodigoAssinatura(), pagamento.getValorPago(), pagamento.getDataPagamento(), pagamento.getCodigoPagamento());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM Pagamento WHERE codigo = ?";
        jdbcTemplate.update(sql, id);
    }
}
