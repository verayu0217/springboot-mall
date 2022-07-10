package com.vera.springbootmall.controller;

import com.vera.springbootmall.constant.ProductCategory;
import com.vera.springbootmall.dto.ProductRequest;
import com.vera.springbootmall.model.Product;
import com.vera.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("products")
    public ResponseEntity<List<Product>>getProduces(
            @RequestParam(required = false) ProductCategory category,
            @RequestParam(required = false) String search
    ){
        List<Product> productList = productService.getProducts(category,search);
        //實作列表型api時 不論有沒有查到數據 都要固定回傳200ok給前端
        return ResponseEntity.status(HttpStatus.OK).body(productList);
    }


    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId){
        Product product = productService.getProductById(productId);
        //如果是實作查詢單筆的api 有數據才回傳200ok
        //沒數據則回傳404 not found
        if(product != null){
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest productRequest){
      Integer productId = productService.createProduct(productRequest);
      Product product = productService.getProductById(productId);

      return ResponseEntity.status(HttpStatus.CREATED).body(product);

    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId,
                                                 @RequestBody @Valid ProductRequest productRequest){
        //先查詢這個商品是否存在
        Product product = productService.getProductById(productId);
        if(product == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        //商品若存在就更新 並將更新後數據回傳前端
        productService.updateProduct(productId,productRequest);
        Product updateProduct = productService.getProductById(productId);
        return ResponseEntity.status(HttpStatus.OK).body(updateProduct);

    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId) {
        //前端在意的是商品是否不存在了 只要確定商品不見即可 不需要去判斷商品是否存在再刪除
        //因為使用者就是希望沒有這筆 點擊刪除後就只要回應說204消失不見即可
        productService.deleteProductById(productId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

}
