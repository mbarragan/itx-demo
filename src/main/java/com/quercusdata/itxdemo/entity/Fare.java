package com.quercusdata.itxdemo.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
    name = "T_FARE"
)
public class Fare {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    private Long id;
    private Integer productId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer brandId;
    private Double price;
    private Integer priority;
    private String currency;

    public Fare() {
    }

    public Fare(Long id, Integer productId, LocalDateTime startDate, LocalDateTime endDate, Integer brandId, Double price,
                Integer priority, String currency) {
        this.id = id;
        this.productId = productId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.brandId = brandId;
        this.price = price;
        this.priority = priority;
        this.currency = currency;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getProductId() {
        return this.productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public LocalDateTime getStartDate() {
        return this.startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return this.endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Integer getBrandId() {
        return this.brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getPriority() {
        return this.priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String toString() {
        return "Fare{id=" + this.id + ", productId=" + this.productId + ", startDate=" + this.startDate + ", endDate="
            + this.endDate + ", brandId=" + this.brandId + ", price=" + this.price + ", priority=" + this.priority +
            ", currency='" + this.currency + '\'' + '}';
    }
}
