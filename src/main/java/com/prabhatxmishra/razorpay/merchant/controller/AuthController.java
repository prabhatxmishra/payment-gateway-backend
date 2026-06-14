package com.prabhatxmishra.razorpay.merchant.controller;

import com.prabhatxmishra.razorpay.merchant.dto.request.MerchantSignUpRequest;
import com.prabhatxmishra.razorpay.merchant.dto.response.MerchantResponse;
import com.prabhatxmishra.razorpay.merchant.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    ResponseEntity<MerchantResponse> signup(@RequestBody @Valid MerchantSignUpRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                authService.signup(request)
        );
    }
}
