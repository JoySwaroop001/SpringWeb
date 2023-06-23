package com.example.springweb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productoffers")
public class Productoffer {
    @Id
    @Column(name = "id", nullable = false, length = 10)
    private String id;

    @Column(name = "username", length = 50)
    private String username;

    @Column(name = "hscode", length = 30)
    private String hscode;

    @Column(name = "offersname", length = 16)
    private String offersname;

    @Column(name = "qty")
    private Integer qty;

    @Column(name = "unit", length = 40)
    private String unit;

    @Column(name = "unitprice")
    private Integer unitprice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHscode() {
        return hscode;
    }

    public void setHscode(String hscode) {
        this.hscode = hscode;
    }

    public String getOffersname() {
        return offersname;
    }

    public void setOffersname(String offersname) {
        this.offersname = offersname;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(Integer unitprice) {
        this.unitprice = unitprice;
    }

}