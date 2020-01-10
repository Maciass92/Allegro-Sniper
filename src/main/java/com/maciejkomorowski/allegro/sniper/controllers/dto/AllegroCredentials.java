package com.maciejkomorowski.allegro.sniper.controllers.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AllegroCredentials implements Credentials {

    java.lang.String clientId;
    java.lang.String clientSecret;

    @Override
    public java.lang.String getUsername() {
        return clientId;
    }

    @Override
    public java.lang.String getPassword() {
        return clientSecret;
    }
}