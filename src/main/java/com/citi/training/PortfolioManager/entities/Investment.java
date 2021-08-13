package com.citi.training.PortfolioManager.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="investments")
public class Investment implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;
    @Column(name="type")
    private String type;
    @Column(name="quantity")
    private int quantity;
    @Column(name="average_purchase_price")
    private double avgPurchasePrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAvgPurchasePrice() {
        return avgPurchasePrice;
    }

    public void setAvgPurchasePrice(double avgPurchasePrice) {
        this.avgPurchasePrice = avgPurchasePrice;
    }
}
