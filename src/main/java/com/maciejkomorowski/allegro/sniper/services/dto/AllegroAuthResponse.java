package com.maciejkomorowski.allegro.sniper.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class AllegroAuthResponse implements AuthResponse{

    @JsonProperty("access_token")
    String accessToken;

    @JsonProperty("expires_in")
    String expirationTime;
}