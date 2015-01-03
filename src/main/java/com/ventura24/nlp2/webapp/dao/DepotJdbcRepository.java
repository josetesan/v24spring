package com.ventura24.nlp2.webapp.dao;

import com.ventura24.nlp2.webapp.model.Depot;
import com.ventura24.nlp2.webapp.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by josete on 3/1/15.
 */
@Repository
public class DepotJdbcRepository implements DepotRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<Depot> findAllByUserid(Long userId) {
        return this.jdbcTemplate.query("Select * from DEPOT where user_id = ?",
                new DepotMapper(),
                userId);
    }


    private final static class DepotMapper implements RowMapper<Depot>
    {

        @Override
        public Depot mapRow(ResultSet rs, int rowNum) throws SQLException {
            Depot depot = new Depot();

            depot.setDrawDate(rs.getDate("DRAW_DATE"));
            depot.setProduct(rs.getString("PRODUCT"));
            depot.setStatus(Status.valueOf(rs.getString("STATUS")));
            depot.setAmount(rs.getBigDecimal("AMOUNT"));
            depot.setUserId(rs.getLong("USER_ID"));

            return depot;
        }
    }
}
