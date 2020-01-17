package com.maciejkomorowski.allegro.sniper.services.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class Auction {
    private Long id;
    private Long sellerId;
    private Long categoryId;

    private int stock;

    private String name;
    private String price;
    private String sellingMode;

    private boolean isCompanySeller;

    private List<AuctionImage> images;
}
