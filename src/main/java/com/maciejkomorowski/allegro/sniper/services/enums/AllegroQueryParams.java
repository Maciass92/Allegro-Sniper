package com.maciejkomorowski.allegro.sniper.services.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AllegroQueryParams {
    PHRASE ("phrase");

    private final String name;
}