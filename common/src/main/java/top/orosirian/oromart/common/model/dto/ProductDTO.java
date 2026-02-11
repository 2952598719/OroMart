package top.orosirian.oromart.common.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDTO {

    private String productName;

    private String price;

    private Integer stock;

}
