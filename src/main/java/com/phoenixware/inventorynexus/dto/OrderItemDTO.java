package com.phoenixware.inventorynexus.dto;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class OrderItemDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemid")
    private UUID id;

    @Column(name = "orderid")
    private UUID orderId;

    @Column(name = "sku")
    private String sku;

    @Column(name = "item_name")
    private String title;

    @Column(name = "base_price")
    private BigDecimal price;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "creation_timestamp", nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP = DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime creationTimestamp;

    public OrderItemDTO() {
    }

    public OrderItemDTO(UUID orderId, String sku, String title, BigDecimal price, int quantity) {
        this.orderId = orderId;
        this.sku = sku;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getOrder_id() {
        return orderId;
    }

    public void setOrder_id(UUID orderId) {
        this.orderId = orderId;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
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
        return "OrderItem [id=" + id + ", orderId=" + orderId + ", sku=" + sku + ", title=" + title + ", price=" + price + ", quantity=" + quantity + ", creation_timestamp=" + creationTimestamp + "]";
    }
}
