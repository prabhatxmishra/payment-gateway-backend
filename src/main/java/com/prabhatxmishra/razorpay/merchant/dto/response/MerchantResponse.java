package com.prabhatxmishra.razorpay.merchant.dto.response;

import com.prabhatxmishra.razorpay.common.enums.BusinessType;

public record MerchantResponse<UUID>(
        UUID id,
        String name,
        String email,
        String BusinessName,
        BusinessType businessType
) {
}
