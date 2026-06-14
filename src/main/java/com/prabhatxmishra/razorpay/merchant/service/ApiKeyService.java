package com.prabhatxmishra.razorpay.merchant.service;

import com.prabhatxmishra.razorpay.merchant.dto.request.CreateApiKeyRequest;
import com.prabhatxmishra.razorpay.merchant.dto.response.ApiKeyCreateResponse;
import org.jspecify.annotations.Nullable;

import java.util.UUID;

public interface ApiKeyService {
     ApiKeyCreateResponse create(UUID merchantId, CreateApiKeyRequest request);
}
