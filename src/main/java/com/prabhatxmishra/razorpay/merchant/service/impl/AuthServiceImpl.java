package com.prabhatxmishra.razorpay.merchant.service.impl;

import com.prabhatxmishra.razorpay.common.enums.MerchantStatus;
import com.prabhatxmishra.razorpay.common.enums.UserRole;
import com.prabhatxmishra.razorpay.common.exception.DuplicateException;
import com.prabhatxmishra.razorpay.merchant.dto.request.MerchantSignUpRequest;
import com.prabhatxmishra.razorpay.merchant.dto.response.MerchantResponse;
import com.prabhatxmishra.razorpay.merchant.entity.AppUser;
import com.prabhatxmishra.razorpay.merchant.entity.Merchant;
import com.prabhatxmishra.razorpay.merchant.repository.AppUserRepository;
import com.prabhatxmishra.razorpay.merchant.repository.MerchantRepository;
import com.prabhatxmishra.razorpay.merchant.service.AuthService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class AuthServiceImpl implements AuthService {

    private final AppUserRepository appUserRepository;
    private final MerchantRepository merchantRepository;

    @Override
    public MerchantResponse signup(MerchantSignUpRequest request) {
        if(merchantRepository.existsByEmail(request.email())) {
            throw new DuplicateException("DUPLICATE_MERCHANT_EMAIL","Merchant with email already exists" + request.email());
        }

        Merchant merchant= Merchant.builder()
                .businessName(request.businessName())
                .businessType(request.businessType())
                .name(request.name())
                .email(request.email())
                .status(MerchantStatus.PENDING_KYC)
                .build();

        merchant= merchantRepository.save(merchant);

        AppUser appUser= AppUser.builder()
                .email(request.email())
                .merchant(merchant)
                .passwordHash(request.password()) //TODO: Encrypt using BCrypt
                .role(UserRole.OWNER)
                .build();
        appUser= appUserRepository.save(appUser);

        return new MerchantResponse(merchant.getId(), merchant.getName(),
                merchant.getEmail(), merchant.getBusinessName(),
                merchant.getBusinessType());
    }
}
