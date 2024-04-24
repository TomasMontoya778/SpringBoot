package com.riwi.productApi.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.productApi.Entities.Product;
import com.riwi.productApi.Repository.ProductRepository;
import com.riwi.productApi.Service.Abstract_services.IProductService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService implements IProductService{

    @Autowired
    private final ProductRepository objProductRepository;

    @Override
    public void delete(Long id) {
        Product objProduct = this.objProductRepository.findById(id).orElseThrow();
        this.objProductRepository.delete(objProduct);
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> objProduct = this.objProductRepository.findById(id);
        return objProduct.orElseThrow();
    }

    @Override
    public List<Product> getAll() {
        return this.objProductRepository.findAll();
    }

    @Override
    public Product save(Product objProduct) {
        return this.objProductRepository.save(objProduct);
    }

    @Override
    public Product update(Product objProduct) {
        return this.objProductRepository.save(objProduct);
    }

    
    
}
