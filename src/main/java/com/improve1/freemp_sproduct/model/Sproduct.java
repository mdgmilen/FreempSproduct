package com.improve1.freemp_sproduct.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.data.annotation.Id;


import java.math.BigDecimal;

@Entity
@Table(name = "sproduct")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Sproduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
    private BigDecimal price;
}
