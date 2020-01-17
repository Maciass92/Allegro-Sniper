package com.maciejkomorowski.allegro.sniper.services.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.maciejkomorowski.allegro.sniper.utils.deserializers.AuctionDeserializer;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@JsonDeserialize(using = AuctionDeserializer.class)
public class GetAuctionsResponse implements ApiResponse{
    private List<Auction> auctions;
    private int totalCount;
}