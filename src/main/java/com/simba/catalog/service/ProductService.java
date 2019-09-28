package com.simba.catalog.service;

import com.simba.catalog.domain.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author <a href="mailto:ElHadjiOmar.DIONE@orange-sonatel.com">podisto</a>
 * @since 2019-09-27
 */
@Service
@Slf4j
public class ProductService {

    public List<Product> findAll() {
        return ProductMockRepository.getProducts();
    }

    public Optional<Product> findByCode(String code) {
        return ProductMockRepository.getProducts()
            .stream()
            .filter(p -> code.equals(p.getCode()))
            .findFirst();

    }
}
