package com.project.crud.services.interfaces;

import com.project.crud.models.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
  Product saveProduct(Product product);
  List<Product> getProducts();
  Optional<Product> getProductById(String id);
  void deleteProductById(String id);
}
