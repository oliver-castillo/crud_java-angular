package com.project.crud.services.impl;

import com.project.crud.models.Order;
import com.project.crud.repositories.IOrderRepository;
import com.project.crud.services.interfaces.IOrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService implements IOrderService {

  private final IOrderRepository orderRepository;

  protected OrderService(IOrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  @Override
  public Order saveOrder(Order order) {
    try {
      order.setOrderNumber(orderRepository.count() + 1);
      order.setNumberOfProducts((order.getProducts().size()));
      return orderRepository.save(order);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return null;
  }

  @Override
  public List<Order> getOrders() {
    return orderRepository.findAll();
  }

  @Override
  public Optional<Order> getOrderById(String id) {
    return orderRepository.findById(id);
  }

  @Override
  public void deleteOrderById(String id) {
    orderRepository.deleteById(id);
  }
}
