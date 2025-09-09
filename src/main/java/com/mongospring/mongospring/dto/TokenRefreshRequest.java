package com.mongospring.mongospring.dto;

import lombok.Data;

@Data
public class TokenRefreshRequest {
    private String refreshToken;
}
