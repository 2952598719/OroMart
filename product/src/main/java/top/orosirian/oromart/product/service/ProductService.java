package top.orosirian.oromart.product.service;

import com.github.pagehelper.PageInfo;
import top.orosirian.oromart.common.model.dto.ProductDTO;
import top.orosirian.oromart.common.model.vo.ProductVO;

public interface ProductService {

    void createProduct(ProductDTO dto);

    PageInfo<ProductVO> getProductList(Integer currentPage, Integer pageSize);

    ProductVO getProduct(Long productId);

    void updateProduct(Long productId, ProductDTO dto);

    void removeProduct(Long productId);

}
