/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spacewood.sales.skustock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository
public class SkuStockDAL {
    
    public static final class Columns {

        public static final String ID = "id";
        public static final String SKU = "sku";
        public static final String PRODUCT_NAME = "product_name";
        public static final String PRODUCT_DESCRIPTION = "product_description";
        public static final String COLOR = "color";
        public static final String T48_STOCK = "t48_stock";
        public static final String NIMJI_STOCK = "nimji_stock";
        public static final String TOTAL_STOCK = "total_stock";
        public static final String PRICE = "price";
    }

    public static final String TABLE_NAME = "sku_stock_master";

    private final SimpleJdbcInsert insertSkuStockMaster;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SkuStockDAL(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        insertSkuStockMaster = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName(TABLE_NAME)
                .usingColumns(
                        Columns.SKU,
                        Columns.PRODUCT_NAME,
                        Columns.PRODUCT_DESCRIPTION,
                        Columns.COLOR,
                        Columns.T48_STOCK,
                        Columns.NIMJI_STOCK,
                        Columns.TOTAL_STOCK,
                        Columns.PRICE
                )
                .usingGeneratedKeyColumns(Columns.ID);
    }

    public List<SkuStock> findAll(Integer offset) {
        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE deleted = FALSE ORDER BY " + Columns.ID + " DESC LIMIT 10 OFFSET ?";
        return jdbcTemplate.query(sqlQuery, new Object[]{offset}, new BeanPropertyRowMapper<>(SkuStock.class));
    }    

    public List<SkuStock> findAllList() {
        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE deleted = FALSE";
        return jdbcTemplate.query(sqlQuery, new Object[]{}, new BeanPropertyRowMapper<>(SkuStock.class));
    }

    public SkuStock findById(Integer id) {
        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE deleted = FALSE AND " + Columns.ID + " = ?";
        return jdbcTemplate.queryForObject(sqlQuery, new Object[]{id}, new BeanPropertyRowMapper<>(SkuStock.class));
    }

    public SkuStock findByName(String name) {
        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE deleted = FALSE AND " + Columns.PRODUCT_NAME + " = ?";
        return jdbcTemplate.queryForObject(sqlQuery, new Object[]{name}, new BeanPropertyRowMapper<>(SkuStock.class));
    }

    public List<SkuStock> findByNameLike(String name) {
        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE deleted = FALSE AND lower(product_name) LIKE?";
        String nameLike = "%" + name.toLowerCase() + "%";
        return jdbcTemplate.query(sqlQuery, new Object[]{nameLike}, new BeanPropertyRowMapper<>(SkuStock.class));
    }    

    public SkuStock insert(SkuStock skuStock) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put(Columns.SKU, skuStock.getSku());
        parameters.put(Columns.PRODUCT_NAME, skuStock.getProductName());
        parameters.put(Columns.PRODUCT_DESCRIPTION, skuStock.getProductDescription());
        parameters.put(Columns.COLOR, skuStock.getColor());
        parameters.put(Columns.T48_STOCK, skuStock.getT48Stock());
        parameters.put(Columns.NIMJI_STOCK, skuStock.getNimjiStock());
        parameters.put(Columns.TOTAL_STOCK, skuStock.getTotalStock());
        parameters.put(Columns.PRICE, skuStock.getPrice());
        
        Number newId = insertSkuStockMaster.executeAndReturnKey(parameters);
        skuStock = findById(newId.intValue());
        return skuStock;
    }

    public void delete(Integer id) {
        String sqlQuery = "UPDATE " + TABLE_NAME + " SET deleted=? WHERE " + Columns.ID + "=?";
        jdbcTemplate.update(sqlQuery, new Object[]{true, id});
    }

    public SkuStock update(SkuStock skuStock) {
        
        String sqlQuery = "UPDATE " + TABLE_NAME + " SET "
                + Columns.SKU + " = ?,"
                + Columns.PRODUCT_NAME + " = ?,"
                + Columns.PRODUCT_DESCRIPTION + " = ?, "
                + Columns.COLOR + " = ?,"
                + Columns.T48_STOCK + " = ?,"
                + Columns.NIMJI_STOCK + " = ?,"
                + Columns.TOTAL_STOCK + " = ?,"
                + Columns.PRICE + " = ? WHERE " + Columns.ID + " = ?";
        Number updatedCount = jdbcTemplate.update(sqlQuery,
                new Object[]{
                    skuStock.getSku(),
                    skuStock.getProductName(),
                    skuStock.getProductDescription(),
                    skuStock.getColor(),
                    skuStock.getT48Stock(),
                    skuStock.getNimjiStock(),
                    skuStock.getTotalStock(),
                    skuStock.getPrice(),                    
                    skuStock.getId()
                });
        skuStock = findById(skuStock.getId());
        return skuStock;
    }
}
