package com.prabhatxmishra.razorpay.merchant.dto.request;

import com.prabhatxmishra.razorpay.common.enums.Environment;

public record CreateApiKeyRequest(
        Environment environment
) {
}
