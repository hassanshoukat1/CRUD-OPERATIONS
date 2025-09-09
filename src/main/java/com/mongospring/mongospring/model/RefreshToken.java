package com.mongospring.mongospring.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@Document(collection = "refresh_tokens")
public class RefreshToken {
    @Id
    private String id;
    private String token;
    private String username;
    private Instant expiryDate;
    private Instant createdDate;
}
