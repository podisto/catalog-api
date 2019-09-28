package com.simba.catalog.web.rest;

import com.simba.catalog.domain.Product;
import com.simba.catalog.service.ProductService;
import com.simba.catalog.web.rest.errors.ProductNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author <a href="mailto:ElHadjiOmar.DIONE@orange-sonatel.com">podisto</a>
 * @since 2019-09-27
 */
@RestController
@RequestMapping(value = "/api/products", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class ProductResource {
    private final ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        log.debug("--- get all products ---");
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{code}")
    public ResponseEntity<Product> findByCode(@PathVariable String code) {
        log.debug("--- find product with code = {} --- ", code);
        return productService.findByCode(code)
            .map(ResponseEntity::ok)
            .orElseThrow(() -> new ProductNotFoundException("Product with code ["+ code +"] does not exist"));
    }
}
