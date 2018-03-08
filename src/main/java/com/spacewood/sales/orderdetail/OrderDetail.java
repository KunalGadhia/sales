/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spacewood.sales.orderdetail;

import java.util.Objects;

/**
 *
 * @author user
 */
public class OrderDetail {
    private Integer id;
    private Integer productId;
    private String productCode;
    private String productName;
    private String productColor;
    private String productLocation;
    private Integer quantity;
    private Double price;
    private Integer orderHeadId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public String getProductLocation() {
        return productLocation;
    }

    public void setProductLocation(String productLocation) {
        this.productLocation = productLocation;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getOrderHeadId() {
        return orderHeadId;
    }

    public void setOrderHeadId(Integer orderHeadId) {
        this.orderHeadId = orderHeadId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.productId);
        hash = 17 * hash + Objects.hashCode(this.productCode);
        hash = 17 * hash + Objects.hashCode(this.productName);
        hash = 17 * hash + Objects.hashCode(this.productColor);
        hash = 17 * hash + Objects.hashCode(this.productLocation);
        hash = 17 * hash + Objects.hashCode(this.quantity);
        hash = 17 * hash + Objects.hashCode(this.price);
        hash = 17 * hash + Objects.hashCode(this.orderHeadId);
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
        final OrderDetail other = (OrderDetail) obj;
        if (!Objects.equals(this.productCode, other.productCode)) {
            return false;
        }
        if (!Objects.equals(this.productName, other.productName)) {
            return false;
        }
        if (!Objects.equals(this.productColor, other.productColor)) {
            return false;
        }
        if (!Objects.equals(this.productLocation, other.productLocation)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.productId, other.productId)) {
            return false;
        }
        if (!Objects.equals(this.quantity, other.quantity)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        if (!Objects.equals(this.orderHeadId, other.orderHeadId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OrderDetail{" + "id=" + id + ", productId=" + productId + ", productCode=" + productCode + ", productName=" + productName + ", productColor=" + productColor + ", productLocation=" + productLocation + ", quantity=" + quantity + ", price=" + price + ", orderHeadId=" + orderHeadId + '}';
    }
        
}
