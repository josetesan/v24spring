package com.ventura24.nlp2.webapp.dao;

import com.ventura24.nlp2.webapp.model.GProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by jsanc on 5/01/15.
 */
@Repository
public class GProductsJdbcRepository implements GProductsDao
{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<GProduct> findGProductsByUser(final Long userId)
    {
        return jdbcTemplate.query(SQL_QUERY, new GProductRowMapper(),userId, userId,userId);
    }

    private static final class GProductRowMapper implements RowMapper<GProduct>{

        @Override
        public GProduct mapRow(ResultSet rs, int rownumber) throws SQLException
        {
            GProduct product = new GProduct();

            product.setProductId(rs.getLong("G_PRODUCT_ID"));
            product.setProductTypeId(rs.getLong("G_PRODUCT_TYPE_ID"));
            product.setBettorId(rs.getLong("G_BETTOR_ID"));
            product.setBettorTypeId(rs.getLong("G_BETTOR_TYPE_ID"));
            product.setSubscriptionId(rs.getLong("G_SUBSCRIPTION_ID"));
            product.setPaymentStateId(rs.getLong("G_PAYMENT_STATE_ID"));
            product.setFirstDrawId(rs.getLong("G_FIRST_DRAW_ID"));
            product.setLastDrawId(rs.getLong("G_LAST_DRAW_ID"));
            product.setExternalId(rs.getLong("EXTERNAL_ID"));
            product.setAmount(rs.getBigDecimal("AMOUNT"));
            product.setDuration(rs.getLong("DURATION"));
            product.setLastModified(rs.getTimestamp("LAST_MODIFIED"));
            product.setCreationDate(rs.getTimestamp("CREATION_DATE"));

            return product;
        }
    }



    private static final String SQL_QUERY = "SELECT pp.*\n" +
            "FROM g_products pp,\n" +
            "  g_draws d\n" +
            "WHERE pp.g_last_draw_id = d.g_draw_id\n" +
            "AND pp.g_product_id    IN (\n" +
            "  (SELECT g_product_id\n" +
            "  FROM g_products p\n" +
            "  WHERE p.g_bettor_id      = ?\n" +
            "  AND p.g_subscription_id IS NULL\n" +
            "  )\n" +
            "UNION\n" +
            "  (SELECT MAX(p.g_product_id)\n" +
            "  FROM g_products p\n" +
            "  WHERE p.g_bettor_id      = ?\n" +
            "  AND p.g_subscription_id IS NOT NULL\n" +
            "  GROUP BY g_subscription_id\n" +
            "  ) )\n" +
            "AND d.drawing_date + 30 > sysdate\n" +
            "UNION\n" +
            "SELECT p.*\n" +
            "FROM g_products p,\n" +
            "  g_subscription_md m,\n" +
            "  g_draws d\n" +
            "WHERE p.g_bettor_id            = ?\n" +
            "AND p.g_last_draw_id           = d.g_draw_id\n" +
            "AND p.g_subscription_id        =m.g_subscription_id\n" +
            "AND m.g_subscription_md_type_id=2\n" +
            "AND m.value                    ='false'\n" +
            "AND d.drawing_date + 30        > sysdate ;".intern();
}
