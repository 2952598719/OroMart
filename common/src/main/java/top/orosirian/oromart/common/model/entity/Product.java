package top.orosirian.oromart.common.model.entity;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
public class Product {

    private Long productId;

    private String productName;

    private BigDecimal price;

    private Integer stock;

    private Instant createdTime;

    private Instant updatedTime;

}
