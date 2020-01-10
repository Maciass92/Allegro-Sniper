package com.maciejkomorowski.allegro.sniper.services.impl;

import com.maciejkomorowski.allegro.sniper.utils.builders.RequestBuilder;
import com.maciejkomorowski.allegro.sniper.utils.builders.UrlBuilder;
import com.maciejkomorowski.allegro.sniper.services.AuctionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static com.maciejkomorowski.allegro.sniper.services.enums.AllegroUrl.OFFERS_LISTING;
import static com.maciejkomorowski.allegro.sniper.services.enums.AllegroUrl.SALE_CATEGORIES;

@Service
@RequiredArgsConstructor
public class AllegroAuctionServiceImpl implements AuctionService {

    private final RequestBuilder requestBuilder;
    private final UrlBuilder urlBuilder;

    @Override
    public String getAuctions(String accessToken, Map<String, String> queryParams) {
        String endpoint = urlBuilder.buildApiUrl(OFFERS_LISTING.getName(), queryParams);
        HttpEntity<String> request = requestBuilder.buildRequest(accessToken);
        ResponseEntity<String> result = new RestTemplate().exchange(endpoint, HttpMethod.GET, request, String.class);

        return result.getBody();
    }

    @Override
    public String getCategories(String accessToken) {
        String endpoint = urlBuilder.buildApiUrl(SALE_CATEGORIES.getName(), null);
        HttpEntity<String> request = requestBuilder.buildRequest(accessToken);
        ResponseEntity<String> result = new RestTemplate().exchange(endpoint, HttpMethod.GET, request, String.class);

        return result.getBody();
    }
}