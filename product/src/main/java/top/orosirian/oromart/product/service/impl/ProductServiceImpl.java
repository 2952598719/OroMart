package top.orosirian.oromart.product.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.orosirian.oromart.common.BusinessException;
import top.orosirian.oromart.common.enums.ResultCode;
import top.orosirian.oromart.common.model.dto.ProductDTO;
import top.orosirian.oromart.common.model.entity.Product;
import top.orosirian.oromart.common.model.vo.ProductVO;
import top.orosirian.oromart.product.mappers.ProductMapper;
import top.orosirian.oromart.product.service.ProductService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public void createProduct(ProductDTO dto) {
        BigDecimal price = new BigDecimal(dto.getPrice());
        productMapper.insertProduct(dto.getProductName(), price, dto.getStock());
    }

    @Override
    public PageInfo<ProductVO> getProductList(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Product> products = productMapper.selectProductList();
        List<ProductVO> productVOs = new ArrayList<>();
        for (Product product : products) {
            productVOs.add(ProductVO.of(product));
        }
        return new PageInfo<>(productVOs);
    }

    @Override
    public ProductVO getProduct(Long productId) {
        Product product = productMapper.selectProduct(productId);
        if (product == null) {
            throw new BusinessException(ResultCode.PRODUCT_NOT_EXIST);
        }
        return ProductVO.of(product);
    }

    @Override
    public void updateProduct(Long productId, ProductDTO dto) {
        Product product = productMapper.selectProduct(productId);
        if (product == null) {
            throw new BusinessException(ResultCode.PRODUCT_NOT_EXIST);
        }
        BigDecimal price = new BigDecimal(dto.getPrice());
        productMapper.updateProduct(productId, dto.getProductName(), price, dto.getStock());
    }

    @Override
    public void removeProduct(Long productId) {
        Product product = productMapper.selectProduct(productId);
        if (product == null) {
            throw new BusinessException(ResultCode.PRODUCT_NOT_EXIST);
        }
        productMapper.removeProduct(productId);
    }

}
