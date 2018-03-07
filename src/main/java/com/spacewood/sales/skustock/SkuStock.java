/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spacewood.sales.skustock;

import java.util.Objects;

/**
 *
 * @author user
 */
public class SkuStock {
    private Integer id;
    private String sku;
    private String productName;
    private String productDescription;
    private String color;
    private Integer t48Stock;
    private Integer nimjiStock;
    private Integer totalStock;
    private Double price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getT48Stock() {
        return t48Stock;
    }

    public void setT48Stock(Integer t48Stock) {
        this.t48Stock = t48Stock;
    }

    public Integer getNimjiStock() {
        return nimjiStock;
    }

    public void setNimjiStock(Integer nimjiStock) {
        this.nimjiStock = nimjiStock;
    }

    public Integer getTotalStock() {
        return totalStock;
    }

    public void setTotalStock(Integer totalStock) {
        this.totalStock = totalStock;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.sku);
        hash = 59 * hash + Objects.hashCode(this.productName);
        hash = 59 * hash + Objects.hashCode(this.productDescription);
        hash = 59 * hash + Objects.hashCode(this.color);
        hash = 59 * hash + Objects.hashCode(this.t48Stock);
        hash = 59 * hash + Objects.hashCode(this.nimjiStock);
        hash = 59 * hash + Objects.hashCode(this.totalStock);
        hash = 59 * hash + Objects.hashCode(this.price);
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
        final SkuStock other = (SkuStock) obj;
        if (!Objects.equals(this.sku, other.sku)) {
            return false;
        }
        if (!Objects.equals(this.productName, other.productName)) {
            return false;
        }
        if (!Objects.equals(this.productDescription, other.productDescription)) {
            return false;
        }
        if (!Objects.equals(this.color, other.color)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.t48Stock, other.t48Stock)) {
            return false;
        }
        if (!Objects.equals(this.nimjiStock, other.nimjiStock)) {
            return false;
        }
        if (!Objects.equals(this.totalStock, other.totalStock)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SkuStock{" + "id=" + id + ", sku=" + sku + ", productName=" + productName + ", productDescription=" + productDescription + ", color=" + color + ", t48Stock=" + t48Stock + ", nimjiStock=" + nimjiStock + ", totalStock=" + totalStock + ", price=" + price + '}';
    }
            
}
