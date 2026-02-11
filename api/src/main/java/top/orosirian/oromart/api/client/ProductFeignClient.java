package top.orosirian.oromart.api.client;

import com.github.pagehelper.PageInfo;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import top.orosirian.oromart.common.model.dto.ProductDTO;
import top.orosirian.oromart.common.model.vo.ProductVO;
import top.orosirian.oromart.common.model.vo.ResponseVO;

@FeignClient("product")
public interface ProductFeignClient {

    @PostMapping("/product")
    ResponseVO<String> createProduct(@Valid @RequestBody ProductDTO dto);

    @GetMapping("/product/list")
    ResponseVO<PageInfo<ProductVO>> getProductList(@RequestParam Integer currentPage, @RequestParam Integer pageSize);

    @GetMapping("/product/{productId}")
    ResponseVO<ProductVO> getProduct(@PathVariable Long productId);

    @PutMapping("/product/{productId}")
    ResponseVO<String> updateProduct(@PathVariable Long productId, @RequestBody ProductDTO dto);

    @DeleteMapping("/product/{productId}")
    ResponseVO<String> removeProduct(@PathVariable Long productId);

}
