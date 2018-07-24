/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spacewood.sales.orderhead;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import jdk.nashorn.internal.objects.Global;
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
public class OrderHeadDAL {

    public static final class Columns {

        public static final String ID = "id";
        public static final String ORDER_NUM = "order_num";
        public static final String CUSTOMER_NAME = "customer_name";
        public static final String CONTACT_NUM = "contact_num";
        public static final String EMAIL_ID = "email_id";
        public static final String BOOKING_DATE = "booking_date";
        public static final String BILLING_FLOOR_NUM = "billing_floor_num";
        public static final String BILLING_LIFT = "billing_lift";
        public static final String BILLING_ADD1 = "billing_add1";
        public static final String BILLING_ADD2 = "billing_add2";
        public static final String BILLING_ADD3 = "billing_add3";
        public static final String BILLING_POSTAL_CODE = "billing_postal_code";
        public static final String BILLING_CITY = "billing_city";
        public static final String BILLING_STATE = "billing_state";
        public static final String DELIVERY_FLOOR_NUM = "delivery_floor_num";
        public static final String DELIVERY_LIFT = "delivery_lift";
        public static final String DELIVERY_ADD1 = "delivery_add1";
        public static final String DELIVERY_ADD2 = "delivery_add2";
        public static final String DELIVERY_ADD3 = "delivery_add3";
        public static final String DELIVERY_POSTAL_CODE = "delivery_postal_code";
        public static final String DELIVERY_CITY = "delivery_city";
        public static final String DELIVERY_STATE = "delivery_state";
        public static final String CREATED_BY = "created_by";
        public static final String TRANSPORTATION_CHARGES = "transportation_charges";
        public static final String INSTALLATION_CHARGES = "installation_charges";
        public static final String TOTAL_AMOUNT = "total_amount";
        public static final String PAYMENT_MODE = "payment_mode";
        public static final String TOTAL_AMOUNT_PAID = "total_amount_paid";
        public static final String TOTAL_AMOUNT_LEFT = "total_amount_left";
    }

    public static final String TABLE_NAME = "order_head";
    private static Integer srNumber = 0;
    private final SimpleJdbcInsert insertOrderHead;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderHeadDAL(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        insertOrderHead = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName(TABLE_NAME)
                .usingColumns(
                        Columns.ORDER_NUM,
                        Columns.CUSTOMER_NAME,
                        Columns.CONTACT_NUM,
                        Columns.EMAIL_ID,
                        Columns.BOOKING_DATE,
                        Columns.BILLING_FLOOR_NUM,
                        Columns.BILLING_LIFT,
                        Columns.BILLING_ADD1,
                        Columns.BILLING_ADD2,
                        Columns.BILLING_ADD3,
                        Columns.BILLING_POSTAL_CODE,
                        Columns.BILLING_CITY,
                        Columns.BILLING_STATE,
                        Columns.DELIVERY_FLOOR_NUM,
                        Columns.DELIVERY_LIFT,
                        Columns.DELIVERY_ADD1,
                        Columns.DELIVERY_ADD2,
                        Columns.DELIVERY_ADD3,
                        Columns.DELIVERY_POSTAL_CODE,
                        Columns.DELIVERY_CITY,
                        Columns.DELIVERY_STATE,
                        Columns.CREATED_BY,
                        Columns.TRANSPORTATION_CHARGES,
                        Columns.INSTALLATION_CHARGES,
                        Columns.TOTAL_AMOUNT,
                        Columns.PAYMENT_MODE,
                        Columns.TOTAL_AMOUNT_PAID,
                        Columns.TOTAL_AMOUNT_LEFT
                )
                .usingGeneratedKeyColumns(Columns.ID);
    }

    public List<OrderHead> findAll(Integer offset) {
        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE deleted = FALSE ORDER BY " + Columns.ID + " DESC LIMIT 10 OFFSET ?";
        return jdbcTemplate.query(sqlQuery, new Object[]{offset}, new BeanPropertyRowMapper<>(OrderHead.class));
    }

    public List<OrderHead> findAllList() {
        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE deleted = FALSE";
        return jdbcTemplate.query(sqlQuery, new Object[]{}, new BeanPropertyRowMapper<>(OrderHead.class));
    }

    public OrderHead findById(Integer id) {
        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE deleted = FALSE AND " + Columns.ID + " = ?";
        return jdbcTemplate.queryForObject(sqlQuery, new Object[]{id}, new BeanPropertyRowMapper<>(OrderHead.class));
    }

    public List findByOrderNumber(String orderNum) {
        String sqlQuery = "SELECT " + Columns.ORDER_NUM + " FROM " + TABLE_NAME + " WHERE " + Columns.ORDER_NUM + " LIKE ?";
        String stringEntry = orderNum + "%";
        return jdbcTemplate.query(sqlQuery, new Object[]{stringEntry}, new BeanPropertyRowMapper<>(OrderHead.class));
    }

//    public SkuStock findByName(String name) {
//        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE deleted = FALSE AND " + Columns.PRODUCT_NAME + " = ?";
//        return jdbcTemplate.queryForObject(sqlQuery, new Object[]{name}, new BeanPropertyRowMapper<>(SkuStock.class));
//    }
//    public List<SkuStock> findByNameLike(String name) {
//        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE deleted = FALSE AND lower(product_name) LIKE?";
//        String nameLike = "%" + name.toLowerCase() + "%";
//        return jdbcTemplate.query(sqlQuery, new Object[]{nameLike}, new BeanPropertyRowMapper<>(SkuStock.class));
//    }    
    public OrderHead insert(OrderHead orderHead) {
        Map<String, Object> parameters = new HashMap<>();
        String OrderNumber;

        List likeOrders = findByOrderNumber("SPSL");

        if (!likeOrders.isEmpty()) {
            srNumber = likeOrders.size() + 1;
        } else {
            srNumber = 1;
        }

        OrderNumber = "SPSL" + srNumber;
        parameters.put(Columns.ORDER_NUM, OrderNumber);
        parameters.put(Columns.CUSTOMER_NAME, orderHead.getCustomerName());
        parameters.put(Columns.CONTACT_NUM, orderHead.getContactNum());
        parameters.put(Columns.EMAIL_ID, orderHead.getEmailId());
        parameters.put(Columns.BOOKING_DATE, new Date());
        parameters.put(Columns.BILLING_FLOOR_NUM, orderHead.getBillingFloorNum());
        if (orderHead.getBillingLift() == null) {
            parameters.put(Columns.BILLING_LIFT, 0);
        } else {
            parameters.put(Columns.BILLING_LIFT, orderHead.getBillingLift());
        }

        parameters.put(Columns.BILLING_ADD1, orderHead.getBillingAdd1());
        parameters.put(Columns.BILLING_ADD2, orderHead.getBillingAdd2());
        parameters.put(Columns.BILLING_ADD3, orderHead.getBillingAdd3());
        parameters.put(Columns.BILLING_POSTAL_CODE, orderHead.getBillingPostalCode());
        parameters.put(Columns.BILLING_CITY, orderHead.getBillingCity());
        parameters.put(Columns.BILLING_STATE, orderHead.getBillingState());
        parameters.put(Columns.DELIVERY_FLOOR_NUM, orderHead.getDeliveryFloorNum());
        
        if (orderHead.getDeliveryLift() == null) {
            parameters.put(Columns.DELIVERY_LIFT, 0);
        } else {
            parameters.put(Columns.DELIVERY_LIFT, orderHead.getDeliveryLift());
        }
        parameters.put(Columns.DELIVERY_ADD1, orderHead.getDeliveryAdd1());
        parameters.put(Columns.DELIVERY_ADD2, orderHead.getDeliveryAdd2());
        parameters.put(Columns.DELIVERY_ADD3, orderHead.getDeliveryAdd3());
        parameters.put(Columns.DELIVERY_POSTAL_CODE, orderHead.getDeliveryPostalCode());
        parameters.put(Columns.DELIVERY_CITY, orderHead.getDeliveryCity());
        parameters.put(Columns.DELIVERY_STATE, orderHead.getDeliveryState());
        parameters.put(Columns.CREATED_BY, orderHead.getCreatedBy());
        parameters.put(Columns.TRANSPORTATION_CHARGES, orderHead.getTransportationCharges());
        parameters.put(Columns.INSTALLATION_CHARGES, orderHead.getInstallationCharges());
        parameters.put(Columns.TOTAL_AMOUNT, orderHead.getTotalAmount());
        parameters.put(Columns.PAYMENT_MODE, orderHead.getPaymentMode());
        parameters.put(Columns.TOTAL_AMOUNT_PAID, orderHead.getTotalAmountPaid());
        parameters.put(Columns.TOTAL_AMOUNT_LEFT, orderHead.getTotalAmountLeft());

        Number newId = insertOrderHead.executeAndReturnKey(parameters);
        orderHead = findById(newId.intValue());
        return orderHead;
    }

    public void delete(Integer id) {
        String sqlQuery = "UPDATE " + TABLE_NAME + " SET deleted=? WHERE " + Columns.ID + "=?";
        jdbcTemplate.update(sqlQuery, new Object[]{true, id});
    }

    public OrderHead update(OrderHead orderHead) {

        String sqlQuery = "UPDATE " + TABLE_NAME + " SET "
                + Columns.ORDER_NUM + " = ?,"
                + Columns.CUSTOMER_NAME + " = ?,"
                + Columns.CONTACT_NUM + " = ?, "
                + Columns.EMAIL_ID + " = ?,"
                + Columns.BOOKING_DATE + " = ?,"
                + Columns.BILLING_FLOOR_NUM + " = ?,"
                + Columns.BILLING_LIFT + " = ?,"
                + Columns.BILLING_ADD1 + " = ?,"
                + Columns.BILLING_ADD2 + " = ?,"
                + Columns.BILLING_ADD3 + " = ?,"
                + Columns.BILLING_POSTAL_CODE + " = ?,"
                + Columns.BILLING_CITY + " = ?,"
                + Columns.BILLING_STATE + " = ?,"
                + Columns.DELIVERY_FLOOR_NUM + " = ?,"
                + Columns.DELIVERY_LIFT + " = ?,"
                + Columns.DELIVERY_ADD1 + " = ?,"
                + Columns.DELIVERY_ADD2 + " = ?,"
                + Columns.DELIVERY_ADD3 + " = ?,"
                + Columns.DELIVERY_POSTAL_CODE + " = ?,"
                + Columns.DELIVERY_CITY + " = ?,"
                + Columns.DELIVERY_STATE + " = ?,"
                + Columns.CREATED_BY + " = ?,"
                + Columns.TRANSPORTATION_CHARGES + " = ?,"
                + Columns.INSTALLATION_CHARGES + " = ?,"
                + Columns.TOTAL_AMOUNT + " = ?,"
                + Columns.PAYMENT_MODE + " = ?,"
                + Columns.TOTAL_AMOUNT_PAID + " = ?,"
                + Columns.TOTAL_AMOUNT_LEFT + " = ? WHERE " + Columns.ID + " = ?";
        Number updatedCount = jdbcTemplate.update(sqlQuery,
                new Object[]{
                    orderHead.getOrderNum(),
                    orderHead.getCustomerName(),
                    orderHead.getContactNum(),
                    orderHead.getEmailId(),
                    orderHead.getBookingDate(),
                    orderHead.getBillingFloorNum(),
                    orderHead.getBillingLift(),
                    orderHead.getBillingAdd1(),
                    orderHead.getBillingAdd2(),
                    orderHead.getBillingAdd3(),
                    orderHead.getBillingPostalCode(),
                    orderHead.getBillingCity(),
                    orderHead.getBillingState(),
                    orderHead.getDeliveryFloorNum(),
                    orderHead.getDeliveryLift(),
                    orderHead.getDeliveryAdd1(),
                    orderHead.getDeliveryAdd2(),
                    orderHead.getDeliveryAdd3(),
                    orderHead.getDeliveryPostalCode(),
                    orderHead.getDeliveryCity(),
                    orderHead.getDeliveryState(),
                    orderHead.getCreatedBy(),
                    orderHead.getTransportationCharges(),
                    orderHead.getInstallationCharges(),
                    orderHead.getTotalAmount(),
                    orderHead.getPaymentMode(),
                    orderHead.getTotalAmountPaid(),
                    orderHead.getTotalAmountLeft(),
                    orderHead.getId()
                });
        orderHead = findById(orderHead.getId());
        return orderHead;
    }
}
