package com.web.order.repository;

import com.web.member.domain.Member;
import com.web.order.domain.Order;
import com.web.order.domain.OrderStatus;
import com.web.order.form.OrderResponse;
import com.web.order.form.OrderSearchRequest;
import java.util.List;

public interface OrderRepositoryCustom {
    List<OrderResponse> orderSearch(OrderSearchRequest request);
}
