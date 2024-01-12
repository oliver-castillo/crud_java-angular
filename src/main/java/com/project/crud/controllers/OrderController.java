package com.project.crud.controllers;

import com.project.crud.models.Order;
import com.project.crud.services.interfaces.IOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value ="/orders")
@CrossOrigin(value = "http://localhost:4200/")
public class OrderController {

  private final IOrderService orderService;

  private OrderController(IOrderService orderService) {
    this.orderService = orderService;
  }

  @PostMapping(value = "/create")
  public ResponseEntity<Object> saveOrder(@RequestBody Order order){
    return new ResponseEntity<>(orderService.saveOrder(order), HttpStatus.CREATED);
  }

  @PutMapping(value = "/update")
  public ResponseEntity<Object> updateOrder(@RequestBody Order order){
    return new ResponseEntity<>(orderService.saveOrder(order), HttpStatus.OK);
  }

  @GetMapping(value = "")
  public ResponseEntity<Object> getOrders(){
    return new ResponseEntity<>(orderService.getOrders(), HttpStatus.OK);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Object> getOrderById(@PathVariable String id){
    return new ResponseEntity<>(orderService.getOrderById(id), HttpStatus.OK);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Object> deleteOrder(@PathVariable String id){
    orderService.deleteOrderById(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
