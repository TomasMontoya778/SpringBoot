package com.riwi.productApi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.productApi.Entities.Product;
import com.riwi.productApi.Service.Abstract_services.IProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/products")
@AllArgsConstructor
public class ProductController {
    @Autowired
    private final IProductService objProductService;

    @GetMapping("/get")
    /* ResponseEntity lo utilizamos para responder con los status http */
    public ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.ok(this.objProductService.getAll());
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        return ResponseEntity.ok(this.objProductService.findById(id));
    }
    @PostMapping("/post")
    public ResponseEntity<Product> save(@RequestBody Product objProduct){
        return ResponseEntity.ok(this.objProductService.save(objProduct));
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<Product> update(@RequestBody Product objProduct, @PathVariable Long id){
        objProduct.setId(id);
        return ResponseEntity.ok(this.objProductService.update(objProduct));
    }
    @DeleteMapping(path ="/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.objProductService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
