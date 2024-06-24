package com.example.spotgridfds.repository.implement;

import com.example.spotgridfds.domain.Aplicativo;
import com.example.spotgridfds.repository.AplicativoRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AplicativoRepositoryImpl implements AplicativoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_SQL = "INSERT INTO aplicativo (codigo, nome, custo_mensal) VALUES (?, ?, ?)";
    private static final String SELECT_ALL_SQL = "SELECT * FROM aplicativo";
    private static final String SELECT_BY_ID_SQL = "SELECT * FROM aplicativo WHERE codigo = ?";
    private static final String UPDATE_SQL = "UPDATE aplicativo SET nome = ?, custo_mensal = ? WHERE codigo = ?";
    private static final String DELETE_SQL = "DELETE FROM aplicativo WHERE codigo = ?";

    @Override
    public void save(Aplicativo aplicativo) {
        jdbcTemplate.update(INSERT_SQL, aplicativo.getCodigoApp(), aplicativo.getNomeApp(), aplicativo.getCustoAppMensal());
    }

    @Override
    public List<Aplicativo> findAll() {
        return jdbcTemplate.query(SELECT_ALL_SQL, new AplicativoRowMapper());
    }

    @Override
    public Aplicativo findById(Long id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID_SQL, new AplicativoRowMapper(), id);
    }

    @Override
    public void update(Aplicativo aplicativo) {
        jdbcTemplate.update(UPDATE_SQL, aplicativo.getNomeApp(), aplicativo.getCustoAppMensal(), aplicativo.getCodigoApp());
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update(DELETE_SQL, id);
    }

    private static final class AplicativoRowMapper implements RowMapper<Aplicativo> {
        @Override
        public Aplicativo mapRow(ResultSet rs, int rowNum) throws SQLException {
            Aplicativo aplicativo = new Aplicativo();
            aplicativo.set(rs.getLong("id"));
            aplicativo.setNome(rs.getString("nome"));
            aplicativo.setDescricao(rs.getString("descricao"));
            return aplicativo;
        }
    }

}
