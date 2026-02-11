package top.orosirian.oromart.api.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import com.github.pagehelper.PageInfo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.orosirian.oromart.api.client.ProductFeignClient;
import top.orosirian.oromart.common.model.dto.ProductDTO;
import top.orosirian.oromart.common.model.vo.ProductVO;
import top.orosirian.oromart.common.model.vo.ResponseVO;

@RestController
public class ProductController {

    @Autowired
    private ProductFeignClient client;

    @SaCheckLogin
    @SaCheckRole("admin")
    @PostMapping("/api/product")
    public ResponseVO<String> createProduct(@Valid @RequestBody ProductDTO dto) {
        return client.createProduct(dto);
    }

    @SaCheckLogin
    @GetMapping("/api/product/list")
    public ResponseVO<PageInfo<ProductVO>> getProductList(@RequestParam Integer currentPage, @RequestParam Integer pageSize) {
        return client.getProductList(currentPage, pageSize);
    }

    @SaCheckLogin
    @GetMapping("/api/product/{productId}")
    public ResponseVO<ProductVO> getProduct(@PathVariable Long productId) {
        return client.getProduct(productId);
    }

    @SaCheckLogin
    @SaCheckRole("admin")
    @PutMapping("/api/product/{productId}")
    public ResponseVO<String> updateProduct(@PathVariable Long productId, @RequestBody ProductDTO dto) {
        return client.updateProduct(productId, dto);
    }

    @SaCheckLogin
    @SaCheckRole("admin")
    @DeleteMapping("/api/product/{productId}")
    public ResponseVO<String> removeProduct(@PathVariable Long productId) {
        return client.removeProduct(productId);
    }

}
