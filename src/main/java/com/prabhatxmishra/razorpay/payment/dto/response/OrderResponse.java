package com.prabhatxmishra.razorpay.payment.dto.response;

import com.prabhatxmishra.razorpay.common.entity.Money;
import com.prabhatxmishra.razorpay.common.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

public record OrderResponse(
        UUID id,
        UUID merchantId,
        String receipt, //MerchantReferenceNumber
        Money amount,
        OrderStatus status,
        Integer attempts,
        Map<String,Object> notes,
        LocalDateTime expiresAt,
        LocalDateTime createdAt
) {
}
