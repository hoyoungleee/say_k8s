package com.playdata.orderingservice.ordering.entity;

import com.playdata.orderingservice.ordering.entity.Order;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@ToString(exclude = {"order"})
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Long orderItemId; // 주문 상세아이디

    @Column(nullable = false)
    private int quantity; // 주문 수량

    @Column(name = "unit_price", precision = 20, scale = 2)
    private BigDecimal unitPrice; // 주문당시상품가격

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order; // 주문아이디

    @Column(name = "product_id", nullable = false)
    private Long productId; // 상품아이디

    @Setter
    @Column(name = "order_item_status")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus = OrderStatus.ORDERED;

}
