package com.maciejkomorowski.allegro.sniper.services;

import java.util.Map;

public interface AuctionService {
    String getAuctions(String accessToken, Map<String, String> queryParams);
    String getCategories(String accessToken);
}
