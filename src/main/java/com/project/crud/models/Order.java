package com.project.crud.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  private Long orderNumber;

  @Column(name = "date", updatable = false, columnDefinition = "TIMESTAMP")
  @CreationTimestamp
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
  private LocalDateTime date;

  @ManyToMany
  private List<Product> products;

  private int numberOfProducts;

}
