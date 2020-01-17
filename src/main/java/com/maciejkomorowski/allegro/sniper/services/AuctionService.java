package com.maciejkomorowski.allegro.sniper.services;

import com.maciejkomorowski.allegro.sniper.services.dto.GetAuctionsResponse;
import org.springframework.util.MultiValueMap;

public interface AuctionService {
    GetAuctionsResponse getAuctions(String accessToken, MultiValueMap<String, String> queryParams, boolean shouldSaveItems);
    String getCategories(String accessToken);
}
