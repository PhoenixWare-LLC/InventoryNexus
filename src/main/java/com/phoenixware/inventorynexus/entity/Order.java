package com.phoenixware.inventorynexus.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderid")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "street_1")
    private String street1;

    @Column(name = "street_2")
    private String street2;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "total")
    private BigDecimal total;

    @Column(name = "creation_timestamp", nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP = DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime creationTimestamp;

    @Column(name = "shipped")
    private boolean shipped;

    @Column(name = "fulfilled")
    private boolean fulfilled;

    @Column(name = "tracking_number")
    private String trackingNumber;

    @Column(name= "marketplace")
    private String marketplace;

    @Column(name = "status")
    private String status;

    public Order() {
    }

    public Order(String name, String street1, String street2, String city, String state, String postalCode, BigDecimal total, String marketplace) {
        this.name = name;
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.total = total;
        this.marketplace = marketplace;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setShipped(boolean shipped) {
        this.shipped = shipped;
    }

    public void setFulfilled(boolean fulfilled) {
        this.fulfilled = fulfilled;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public void setMarketplace(String marketplace) {
        this.marketplace = marketplace;
    }

    public LocalDateTime getCreationTimestamp() {
        return creationTimestamp;
    }

    public boolean isShipped() {
        return shipped;
    }

    public boolean isFulfilled() {
        return fulfilled;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public String getMarketplace() {
        return marketplace;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postal_code) {
        this.postalCode = postalCode;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", name=" + name + ", street1=" + street1 + ", street2=" + street2 +
                ", city=" + city + ", state=" + state + ", postalCode=" + postalCode + ", total=" + total +
                ", creation_timestamp=" + creationTimestamp + ", marketplace=" + marketplace +  "]";
    }
}
