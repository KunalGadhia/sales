/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spacewood.sales.orderdetail;

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
public class OrderDetailDAL {
    public static final class Columns {

        public static final String ID = "id";        
        public static final String PRODUCT_ID = "product_id";
        public static final String PRODUCT_CODE = "product_code";
        public static final String PRODUCT_NAME = "product_name";
        public static final String PRODUCT_COLOR = "product_color";
        public static final String PRODUCT_LOCATION = "product_location";
        public static final String QUANTITY = "quantity";
        public static final String PRICE = "price";
        public static final String ORDER_HEAD_ID = "order_head_id";        

    }

    public static final String TABLE_NAME = "order_detail";

    private final SimpleJdbcInsert insertOrderDetail;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderDetailDAL(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        insertOrderDetail = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName(TABLE_NAME)
                .usingColumns(                        
                        Columns.PRODUCT_ID,
                        Columns.PRODUCT_CODE,
                        Columns.PRODUCT_NAME,
                        Columns.PRODUCT_COLOR,
                        Columns.PRODUCT_LOCATION,
                        Columns.QUANTITY,
                        Columns.PRICE,
                        Columns.ORDER_HEAD_ID
                )
                .usingGeneratedKeyColumns(Columns.ID);
    }

    public List<OrderDetail> findAll(Integer offset) {
        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE deleted = FALSE ORDER BY " + Columns.ID + " DESC LIMIT 10 OFFSET ?";
        return jdbcTemplate.query(sqlQuery, new Object[]{offset}, new BeanPropertyRowMapper<>(OrderDetail.class));
    }

    public OrderDetail findById(Integer id) {
        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE deleted = FALSE AND " + Columns.ID + " = ?";
        return jdbcTemplate.queryForObject(sqlQuery, new Object[]{id}, new BeanPropertyRowMapper<>(OrderDetail.class));
    }

//    public Party findByName(String name) {       
//        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE deleted = FALSE AND " + Columns.DEALER_NAME + " = ?";        
//        return jdbcTemplate.queryForObject(sqlQuery, new Object[]{name}, new BeanPropertyRowMapper<>(Party.class));
//    }
//
    public List<OrderDetail> findByOrderHeadId(Integer orderHeadId) {
        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE deleted = FALSE AND " + Columns.ORDER_HEAD_ID + " = ?";
        return jdbcTemplate.query(sqlQuery, new Object[]{orderHeadId}, new BeanPropertyRowMapper<>(OrderDetail.class));
    }

    public OrderDetail insert(OrderDetail orderDetail) {
        System.out.println("Insert Order Detail :" + orderDetail);
        Map<String, Object> parameters = new HashMap<>();
        
        parameters.put(Columns.PRODUCT_ID, orderDetail.getProductId());
        parameters.put(Columns.PRODUCT_CODE, orderDetail.getProductCode());
        parameters.put(Columns.PRODUCT_NAME, orderDetail.getProductName());
        parameters.put(Columns.PRODUCT_COLOR, orderDetail.getProductColor());
        parameters.put(Columns.PRODUCT_LOCATION, orderDetail.getProductLocation());
        parameters.put(Columns.QUANTITY, orderDetail.getQuantity());
        parameters.put(Columns.PRICE, orderDetail.getPrice());
        parameters.put(Columns.ORDER_HEAD_ID, orderDetail.getOrderHeadId());

        Number newId = insertOrderDetail.executeAndReturnKey(parameters);
        orderDetail = findById(newId.intValue());
        return orderDetail;
    }

    public void delete(Integer id) {
        String sqlQuery = "UPDATE " + TABLE_NAME + " SET deleted=? WHERE " + Columns.ID + "=?";
        jdbcTemplate.update(sqlQuery, new Object[]{true, id});
    }

    public OrderDetail update(OrderDetail orderDetail) {
        String sqlQuery = "UPDATE " + TABLE_NAME + " SET "
                + Columns.PRODUCT_ID + " = ?,"
                + Columns.PRODUCT_CODE + " = ?,"
                + Columns.PRODUCT_NAME + " = ?, "
                + Columns.PRODUCT_COLOR + " = ?,"
                + Columns.PRODUCT_LOCATION + " = ?,"
                + Columns.QUANTITY + " = ?,"
                + Columns.PRICE + " = ?,"                
                + Columns.ORDER_HEAD_ID + " = ? WHERE " + Columns.ID + " = ?";
        Number updatedCount = jdbcTemplate.update(sqlQuery,
                new Object[]{
                    orderDetail.getProductId(),
                    orderDetail.getProductCode(),
                    orderDetail.getProductName(),
                    orderDetail.getProductColor(),
                    orderDetail.getProductLocation(),
                    orderDetail.getQuantity(),
                    orderDetail.getPrice(),
                    orderDetail.getOrderHeadId(),                    
                    orderDetail.getId()
                });
        orderDetail = findById(orderDetail.getId());
        return orderDetail;
    }
}
