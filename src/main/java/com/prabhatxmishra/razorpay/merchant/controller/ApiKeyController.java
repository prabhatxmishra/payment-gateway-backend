package com.prabhatxmishra.razorpay.merchant.controller;

import com.prabhatxmishra.razorpay.merchant.dto.request.CreateApiKeyRequest;
import com.prabhatxmishra.razorpay.merchant.dto.response.ApiKeyCreateResponse;
import com.prabhatxmishra.razorpay.merchant.service.ApiKeyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/merchants/{merchantId}/api-key")
@RequiredArgsConstructor
public class ApiKeyController {

    private final ApiKeyService apiKeyService;

    @PostMapping
    public ResponseEntity<ApiKeyCreateResponse> create(@PathVariable UUID merchantId, @RequestBody CreateApiKeyRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(apiKeyService.create(merchantId, request));
    }
}
