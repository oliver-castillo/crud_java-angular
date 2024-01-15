package com.project.crud.controllers;

import com.project.crud.models.Product;
import com.project.crud.services.interfaces.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/products")
@CrossOrigin(origins = "*")
public class ProductController {
  private final IProductService productService;

  private ProductController(IProductService productService) {
    this.productService = productService;
  }

  @PostMapping(value = "")
  public ResponseEntity<Object> saveProduct(@RequestBody Product product) {
    return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<Object> updateProduct(@RequestBody Product product) {
    return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.OK);
  }

  @GetMapping(value = "")
  public ResponseEntity<Object> getProducts() {
    return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Object> getProductById(@PathVariable Long id) {
    return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Object> deleteProduct(@PathVariable Long id) {
    productService.deleteProductById(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
