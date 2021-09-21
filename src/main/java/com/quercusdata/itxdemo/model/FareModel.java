package com.quercusdata.itxdemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class FareModel {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("productId")
    private Integer productId;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonProperty("startDate")
    private LocalDateTime startDate;

    @JsonProperty("endDate")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime endDate;

    @JsonProperty("brandId")
    private Integer brandId;

    @JsonProperty("price")
    private Double price;

    public FareModel() {
    }

    public FareModel(Long id, Integer productId, LocalDateTime startDate, LocalDateTime endDate, Integer brandId, Double price) {
        this.id = id;
        this.productId = productId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.brandId = brandId;
        this.price = price;
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

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String toString() {
        return "FareModel{productId=" + this.productId + ", startDate=" + this.startDate + ", endDate=" + this.endDate + ", brandId=" + this.brandId + ", price=" + this.price + ", id=" + this.id + '}';
    }
}
