package com.prabhatxmishra.razorpay.merchant.service;

import com.prabhatxmishra.razorpay.merchant.dto.request.MerchantSignUpRequest;
import com.prabhatxmishra.razorpay.merchant.dto.response.MerchantResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

public interface AuthService {
    MerchantResponse signup(@Valid MerchantSignUpRequest request);
}
