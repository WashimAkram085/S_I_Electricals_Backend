package com.washim.S.I.Electricals.service.interf;

import com.washim.S.I.Electricals.dto.OrderRequest;
import com.washim.S.I.Electricals.dto.Response;
import com.washim.S.I.Electricals.enums.OrderStatus;

import org.springframework.data.domain.Pageable;
import java.time.LocalDateTime;

public interface OrderItemService {
    Response placeOrder(OrderRequest orderRequest);
    Response updateOrderItemStatus(Long orderItemId, String status);
    Response filterOrderItems(OrderStatus status, LocalDateTime startDate, LocalDateTime endDate, Long itemId, Pageable pageable);
}
