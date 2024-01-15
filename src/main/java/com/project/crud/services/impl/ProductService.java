package com.project.crud.services.impl;

import com.project.crud.models.Product;
import com.project.crud.repositories.IProductRepository;
import com.project.crud.services.interfaces.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

  IProductRepository productRepository;

  protected ProductService(IProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public Product saveProduct(Product product) {
    return productRepository.save(product);
  }

  @Override
  public List<Product> getProducts() {
    return productRepository.findAll();
  }

  @Override
  public Optional<Product> getProductById(Long id) {
    return productRepository.findById(id);
  }

  @Override
  public void deleteProductById(Long id) {
    productRepository.deleteById(id);
  }
}
