package com.multimedia_pj.was.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class BinanceKey {

    @NotBlank
    private final String apiKey;
    private final String secretKey;

    public BinanceKey(@JsonProperty("apiKey") String apiKey,
                      @JsonProperty("secretKey") String secretKey) {
        this.apiKey = apiKey;
        this.secretKey = secretKey;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getSecretKey() {
        return secretKey;
    }
}
