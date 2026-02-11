package top.orosirian.oromart.common.model.vo;

import lombok.Builder;
import lombok.Data;
import top.orosirian.oromart.common.model.entity.Product;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Data
@Builder
public class ProductVO {

    private Long productId;

    private String productName;

    private String price;

    private Integer stock;

    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;

    public static ProductVO of(Product product) {
        return ProductVO.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .price(product.getPrice().toString())
                .stock(product.getStock())
                .createdTime(LocalDateTime.ofInstant(product.getCreatedTime(), ZoneId.systemDefault()))
                .updatedTime(LocalDateTime.ofInstant(product.getUpdatedTime(), ZoneId.systemDefault()))
                .build();
    }

}
