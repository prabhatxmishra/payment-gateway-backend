package com.prabhatxmishra.razorpay.merchant.service.impl;

import com.prabhatxmishra.razorpay.common.exception.ResourceNotFoundException;
import com.prabhatxmishra.razorpay.merchant.dto.request.CreateApiKeyRequest;
import com.prabhatxmishra.razorpay.merchant.dto.response.ApiKeyCreateResponse;
import com.prabhatxmishra.razorpay.merchant.entity.ApiKey;
import com.prabhatxmishra.razorpay.merchant.entity.Merchant;
import com.prabhatxmishra.razorpay.merchant.repository.ApiKeyRepository;
import com.prabhatxmishra.razorpay.merchant.repository.MerchantRepository;
import com.prabhatxmishra.razorpay.merchant.service.ApiKeyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class ApiKeyServiceImpl implements ApiKeyService {

    private final MerchantRepository merchantRepository;
    private final ApiKeyRepository apiKeyRepository;

    @Override
    public ApiKeyCreateResponse create(UUID merchantId, CreateApiKeyRequest request) {

        Merchant merchant= merchantRepository.findById(merchantId).orElseThrow(
                ()-> new ResourceNotFoundException("Merchant not found","Merchant",merchantId)
        );

        String keyId= "rzp_"+request.environment().name().toLowerCase()+"BG_RANDOM_STRING";
        String rawSecret="BIG_RANDOM_SECRET"; //TODO:Replace with cryptographic random hex

        ApiKey apiKey=
                 ApiKey.builder()
                .merchant(merchant)
                .keyId(keyId)
                .keySecretHash(rawSecret) //TODO: To encrypt with BCryptPasswordEncoder
                .environment(request.environment())
                .build();

        apiKey=apiKeyRepository.save(apiKey);

        return new ApiKeyCreateResponse(apiKey.getId(), keyId, rawSecret,request.environment());
    }
}
