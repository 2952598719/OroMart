package top.orosirian.oromart.product.controller;

import com.github.pagehelper.PageInfo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.orosirian.oromart.common.model.dto.ProductDTO;
import top.orosirian.oromart.common.model.vo.ProductVO;
import top.orosirian.oromart.common.model.vo.ResponseVO;
import top.orosirian.oromart.product.service.ProductService;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public ResponseVO<String> createProduct(@Valid @RequestBody ProductDTO dto) {
        productService.createProduct(dto);
        return ResponseVO.success("创建商品成功");
    }

    @GetMapping("/product/list")
    public ResponseVO<PageInfo<ProductVO>> getProductList(@RequestParam Integer currentPage, @RequestParam Integer pageSize) {
        PageInfo<ProductVO> pageInfo = productService.getProductList(currentPage, pageSize);
        return ResponseVO.success(pageInfo);
    }

    @GetMapping("/product/{productId}")
    public ResponseVO<ProductVO> getProduct(@PathVariable Long productId) {
        ProductVO product = productService.getProduct(productId);
        return ResponseVO.success(product);
    }

    @PutMapping("/product/{productId}")
    public ResponseVO<String> updateProduct(@PathVariable Long productId, @RequestBody ProductDTO dto) {
        productService.updateProduct(productId, dto);
        return ResponseVO.success("更新商品成功");
    }

    @DeleteMapping("/product/{productId}")
    public ResponseVO<String> removeProduct(@PathVariable Long productId) {
        productService.removeProduct(productId);
        return ResponseVO.success("下架商品成功");
    }

}
