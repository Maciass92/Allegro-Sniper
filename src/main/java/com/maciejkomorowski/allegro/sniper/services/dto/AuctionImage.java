package com.maciejkomorowski.allegro.sniper.services.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class AuctionImage {
    private Long id;
    private final String imageUrl;
}