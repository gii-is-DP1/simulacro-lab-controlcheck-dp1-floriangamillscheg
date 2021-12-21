package org.springframework.samples.petclinic.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {

    @Autowired ProductRepository productRepository;


    @Autowired
    public ProductService(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){return this.productRepository.findAll();}


    public List<Product> getProductsCheaperThan(double price) {
        return this.productRepository.findByPriceLessThan(price);
    }

    public ProductType getProductType(String typeName) {return this.productRepository.getProductTypeByName(typeName);}


    public Product save(Product p){
        return null;       
    }

    
}
