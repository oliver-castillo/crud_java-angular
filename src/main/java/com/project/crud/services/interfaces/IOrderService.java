package com.project.crud.services.interfaces;

import com.project.crud.models.Order;

import java.util.List;
import java.util.Optional;

public interface IOrderService {
  Order saveOrder(Order order);
  List<Order> getOrders();
  Optional<Order> getOrderById(String id);
  void deleteOrderById(String id);

}
