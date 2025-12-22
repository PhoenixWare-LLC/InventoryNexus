package com.phoenixware.shopify_integration.shopify_integration_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemid")
    private Long id;
    @Column(name = "orderid")
    private Long order_id;
    @Column(name = "sku")
    private String sku;
    @Column(name = "item_name")
    private String title;
    @Column(name = "base_price")
    private double price;
    @Column(name = "quantity")
    private int quantity;

    public OrderItem() {
    }

    public OrderItem(Long order_id, String sku, String title, double price, int quantity) {
        this.order_id = order_id;
        this.sku = sku;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderItem [id=" + id + ", order_id=" + order_id + ", sku=" + sku + ", title=" + title + ", price=" + price + ", quantity=" + quantity + "]";
    }
}
