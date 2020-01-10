package com.maciejkomorowski.allegro.sniper.services.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AllegroUrl{
    OFFERS_LISTING ("/offers/listing"),
    SALE_CATEGORIES ("/sale/categories");

    private final String name;
}