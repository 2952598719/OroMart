package top.orosirian.oromart.product.mappers;

import org.apache.ibatis.annotations.Mapper;
import top.orosirian.oromart.common.model.entity.Product;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface ProductMapper {

    void insertProduct(String productName, BigDecimal price, Integer stock);

    List<Product> selectProductList();

    Product selectProduct(Long productId);

    void updateProduct(Long productId, String productName, BigDecimal price, Integer stock);

    void removeProduct(Long productId);

}
