package com.riwi.productApi.Service.Abstract_services;

import java.util.List;

import com.riwi.productApi.Entities.Product;

/**
 * Utilizamos una interfaz para ser utilizada como inyección
 * de dependencias en controlador, mantiene integridad, desacoplamiento
 * y principios SOLID
 */
public interface IProductService {
    public Product save(Product objProduct);
    public List<Product> getAll();
    public Product findById(Long id);
    public void delete(Long id);
    public Product update(Product objProduct);
    /* SpringbootApp.bind(IProductService,ProductService) */
}
