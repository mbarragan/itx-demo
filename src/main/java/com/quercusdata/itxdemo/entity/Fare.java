package com.quercusdata.itxdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_FARE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer productId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer brandId;
    private Double price;
    private Integer priority;
    private String currency;


    public String toString() {
        return "Fare{id=" + this.id + ", productId=" + this.productId + ", startDate=" + this.startDate + ", endDate="
            + this.endDate + ", brandId=" + this.brandId + ", price=" + this.price + ", priority=" + this.priority +
            ", currency='" + this.currency + '\'' + '}';
    }
}
