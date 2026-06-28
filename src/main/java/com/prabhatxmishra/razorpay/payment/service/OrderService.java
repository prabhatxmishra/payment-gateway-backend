package com.prabhatxmishra.razorpay.payment.service;

import com.prabhatxmishra.razorpay.payment.dto.request.CreateOrderRequest;
import com.prabhatxmishra.razorpay.payment.dto.response.OrderResponse;
import org.jspecify.annotations.Nullable;

import java.util.UUID;

public interface OrderService {
    OrderResponse create(UUID merchantId, CreateOrderRequest request);
}
