package com.prabhatxmishra.razorpay.merchant.service;

import com.prabhatxmishra.razorpay.merchant.dto.request.CreateApiKeyRequest;
import com.prabhatxmishra.razorpay.merchant.dto.response.ApiKeyCreateResponse;
import com.prabhatxmishra.razorpay.merchant.dto.response.ApiKeyResponse;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public interface ApiKeyService {
     ApiKeyCreateResponse create(UUID merchantId, CreateApiKeyRequest request);

     List<ApiKeyResponse> list(UUID merchantId);

     void revoke(UUID merchantId, UUID keyId);

     ApiKeyCreateResponse rotateKey(UUID merchantId, UUID keyId);
}
