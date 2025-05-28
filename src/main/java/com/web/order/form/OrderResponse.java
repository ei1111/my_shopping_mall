package com.web.order.form;

import com.querydsl.core.annotations.QueryProjection;
import com.web.delivery.domain.Delivery;
import com.web.member.domain.Address;
import com.web.member.domain.Member;
import com.web.order.domain.Order;
import com.web.order.domain.OrderStatus;
import com.web.orderItem.domain.OrderItem;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Schema(description = "주문 항목 response")
public class OrderResponse {

    @Schema(description = "주문 번호", example = "1")
    private Long id;

    @Schema(description = "주문한 아이템")
    private List<OrderItemResponse> orderItems;

    @Schema(description = "회원 이름", example = "홍길동")
    private String memberName;

    @Schema(description = "주문 상태", example = "ORDER")
    private OrderStatus status;

    @Schema(description = "주문 날짜", example = "2025-05-28")
    private LocalDate orderDate;

    public static OrderResponse from(Order order) {
        return new OrderResponse(order);
    }

    private OrderResponse(Order order) {
        this.id = order.getId();
        this.orderItems = OrderItemResponse.from(order.getOrderItems());
        this.memberName = order.getMember().getName();
        this.status = order.getStatus();
        this.orderDate = order.getOrderDate();
    }
}
