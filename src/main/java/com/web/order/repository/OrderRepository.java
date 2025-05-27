package com.web.order.repository;

import com.web.item.domain.Item;
import com.web.member.domain.Member;
import com.web.order.domain.Order;
import com.web.order.domain.OrderStatus;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository  extends JpaRepository<Order, Long>, OrderRepositoryCustom  {
}
