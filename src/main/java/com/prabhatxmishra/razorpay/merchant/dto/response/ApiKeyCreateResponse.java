package com.prabhatxmishra.razorpay.merchant.dto.response;

import java.util.UUID;

public record ApiKeyCreateResponse(
        UUID id,
        String keyId,
        String keySecret,
        com.prabhatxmishra.razorpay.common.enums.Environment environment
) {
}
