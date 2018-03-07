/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spacewood.sales.orderhead;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author user
 */
public class OrderHead {
    private Integer id;
    private String orderNum;
    private String customerName;
    private String contactNum;
    private String emailId;
    private Date bookingDate;
    private Integer billingFloorNum;
    private Boolean billingLift;
    private String billingAdd1;
    private String billingAdd2;
    private String billingAdd3;
    private String billingPostalCode;
    private String billingCity;
    private String billingState;
    private Integer deliveryFloorNum;
    private Boolean deliveryLift;
    private String deliveryAdd1;
    private String deliveryAdd2;
    private String deliveryAdd3;
    private String deliveryPostalCode;
    private String deliveryCity;
    private String deliveryState;
    private Integer createdBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Integer getBillingFloorNum() {
        return billingFloorNum;
    }

    public void setBillingFloorNum(Integer billingFloorNum) {
        this.billingFloorNum = billingFloorNum;
    }

    public Boolean getBillingLift() {
        return billingLift;
    }

    public void setBillingLift(Boolean billingLift) {
        this.billingLift = billingLift;
    }

    public String getBillingAdd1() {
        return billingAdd1;
    }

    public void setBillingAdd1(String billingAdd1) {
        this.billingAdd1 = billingAdd1;
    }

    public String getBillingAdd2() {
        return billingAdd2;
    }

    public void setBillingAdd2(String billingAdd2) {
        this.billingAdd2 = billingAdd2;
    }

    public String getBillingAdd3() {
        return billingAdd3;
    }

    public void setBillingAdd3(String billingAdd3) {
        this.billingAdd3 = billingAdd3;
    }

    public String getBillingPostalCode() {
        return billingPostalCode;
    }

    public void setBillingPostalCode(String billingPostalCode) {
        this.billingPostalCode = billingPostalCode;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    public String getBillingState() {
        return billingState;
    }

    public void setBillingState(String billingState) {
        this.billingState = billingState;
    }

    public Integer getDeliveryFloorNum() {
        return deliveryFloorNum;
    }

    public void setDeliveryFloorNum(Integer deliveryFloorNum) {
        this.deliveryFloorNum = deliveryFloorNum;
    }

    public Boolean getDeliveryLift() {
        return deliveryLift;
    }

    public void setDeliveryLift(Boolean deliveryLift) {
        this.deliveryLift = deliveryLift;
    }

    public String getDeliveryAdd1() {
        return deliveryAdd1;
    }

    public void setDeliveryAdd1(String deliveryAdd1) {
        this.deliveryAdd1 = deliveryAdd1;
    }

    public String getDeliveryAdd2() {
        return deliveryAdd2;
    }

    public void setDeliveryAdd2(String deliveryAdd2) {
        this.deliveryAdd2 = deliveryAdd2;
    }

    public String getDeliveryAdd3() {
        return deliveryAdd3;
    }

    public void setDeliveryAdd3(String deliveryAdd3) {
        this.deliveryAdd3 = deliveryAdd3;
    }

    public String getDeliveryPostalCode() {
        return deliveryPostalCode;
    }

    public void setDeliveryPostalCode(String deliveryPostalCode) {
        this.deliveryPostalCode = deliveryPostalCode;
    }

    public String getDeliveryCity() {
        return deliveryCity;
    }

    public void setDeliveryCity(String deliveryCity) {
        this.deliveryCity = deliveryCity;
    }

    public String getDeliveryState() {
        return deliveryState;
    }

    public void setDeliveryState(String deliveryState) {
        this.deliveryState = deliveryState;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.orderNum);
        hash = 79 * hash + Objects.hashCode(this.customerName);
        hash = 79 * hash + Objects.hashCode(this.contactNum);
        hash = 79 * hash + Objects.hashCode(this.emailId);
        hash = 79 * hash + Objects.hashCode(this.bookingDate);
        hash = 79 * hash + Objects.hashCode(this.billingFloorNum);
        hash = 79 * hash + Objects.hashCode(this.billingLift);
        hash = 79 * hash + Objects.hashCode(this.billingAdd1);
        hash = 79 * hash + Objects.hashCode(this.billingAdd2);
        hash = 79 * hash + Objects.hashCode(this.billingAdd3);
        hash = 79 * hash + Objects.hashCode(this.billingPostalCode);
        hash = 79 * hash + Objects.hashCode(this.billingCity);
        hash = 79 * hash + Objects.hashCode(this.billingState);
        hash = 79 * hash + Objects.hashCode(this.deliveryFloorNum);
        hash = 79 * hash + Objects.hashCode(this.deliveryLift);
        hash = 79 * hash + Objects.hashCode(this.deliveryAdd1);
        hash = 79 * hash + Objects.hashCode(this.deliveryAdd2);
        hash = 79 * hash + Objects.hashCode(this.deliveryAdd3);
        hash = 79 * hash + Objects.hashCode(this.deliveryPostalCode);
        hash = 79 * hash + Objects.hashCode(this.deliveryCity);
        hash = 79 * hash + Objects.hashCode(this.deliveryState);
        hash = 79 * hash + Objects.hashCode(this.createdBy);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrderHead other = (OrderHead) obj;
        if (!Objects.equals(this.orderNum, other.orderNum)) {
            return false;
        }
        if (!Objects.equals(this.customerName, other.customerName)) {
            return false;
        }
        if (!Objects.equals(this.contactNum, other.contactNum)) {
            return false;
        }
        if (!Objects.equals(this.emailId, other.emailId)) {
            return false;
        }
        if (!Objects.equals(this.billingAdd1, other.billingAdd1)) {
            return false;
        }
        if (!Objects.equals(this.billingAdd2, other.billingAdd2)) {
            return false;
        }
        if (!Objects.equals(this.billingAdd3, other.billingAdd3)) {
            return false;
        }
        if (!Objects.equals(this.billingPostalCode, other.billingPostalCode)) {
            return false;
        }
        if (!Objects.equals(this.billingCity, other.billingCity)) {
            return false;
        }
        if (!Objects.equals(this.billingState, other.billingState)) {
            return false;
        }
        if (!Objects.equals(this.deliveryAdd1, other.deliveryAdd1)) {
            return false;
        }
        if (!Objects.equals(this.deliveryAdd2, other.deliveryAdd2)) {
            return false;
        }
        if (!Objects.equals(this.deliveryAdd3, other.deliveryAdd3)) {
            return false;
        }
        if (!Objects.equals(this.deliveryPostalCode, other.deliveryPostalCode)) {
            return false;
        }
        if (!Objects.equals(this.deliveryCity, other.deliveryCity)) {
            return false;
        }
        if (!Objects.equals(this.deliveryState, other.deliveryState)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.bookingDate, other.bookingDate)) {
            return false;
        }
        if (!Objects.equals(this.billingFloorNum, other.billingFloorNum)) {
            return false;
        }
        if (!Objects.equals(this.billingLift, other.billingLift)) {
            return false;
        }
        if (!Objects.equals(this.deliveryFloorNum, other.deliveryFloorNum)) {
            return false;
        }
        if (!Objects.equals(this.deliveryLift, other.deliveryLift)) {
            return false;
        }
        if (!Objects.equals(this.createdBy, other.createdBy)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OrderHead{" + "id=" + id + ", orderNum=" + orderNum + ", customerName=" + customerName + ", contactNum=" + contactNum + ", emailId=" + emailId + ", bookingDate=" + bookingDate + ", billingFloorNum=" + billingFloorNum + ", billingLift=" + billingLift + ", billingAdd1=" + billingAdd1 + ", billingAdd2=" + billingAdd2 + ", billingAdd3=" + billingAdd3 + ", billingPostalCode=" + billingPostalCode + ", billingCity=" + billingCity + ", billingState=" + billingState + ", deliveryFloorNum=" + deliveryFloorNum + ", deliveryLift=" + deliveryLift + ", deliveryAdd1=" + deliveryAdd1 + ", deliveryAdd2=" + deliveryAdd2 + ", deliveryAdd3=" + deliveryAdd3 + ", deliveryPostalCode=" + deliveryPostalCode + ", deliveryCity=" + deliveryCity + ", deliveryState=" + deliveryState + ", createdBy=" + createdBy + '}';
    }            
}
