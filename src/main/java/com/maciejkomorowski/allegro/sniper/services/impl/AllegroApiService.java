package com.maciejkomorowski.allegro.sniper.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maciejkomorowski.allegro.sniper.services.dto.GetAuctionsResponse;
import com.maciejkomorowski.allegro.sniper.utils.builders.RequestBuilder;
import com.maciejkomorowski.allegro.sniper.utils.builders.UrlBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import static com.maciejkomorowski.allegro.sniper.services.enums.AllegroUrl.OFFERS_LISTING;

@Slf4j
@Service
@RequiredArgsConstructor
public class AllegroApiService {

    private final static ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private RestTemplate restTemplate;

    private final RequestBuilder requestBuilder;
    private final UrlBuilder urlBuilder;

    public GetAuctionsResponse getAuctions(String accessToken, MultiValueMap<String, String> queryParams) {
        String endpoint = urlBuilder.buildApiUrl(OFFERS_LISTING.getAppendix(), queryParams);
        HttpEntity<String> request = requestBuilder.buildRequest(accessToken);

        GetAuctionsResponse content = null;
        try {
            ResponseEntity<String> result = restTemplate.exchange(endpoint, HttpMethod.GET, request, String.class);
            content = mapper.readValue(result.getBody(), GetAuctionsResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            //exception handling
        }

        return content;
    }

    public String getRawResponse(String accessToken, String urlAppendix) {
        String endpoint = urlBuilder.buildApiUrl(urlAppendix, null);
        HttpEntity<String> request = requestBuilder.buildRequest(accessToken);
        ResponseEntity<String> result = restTemplate.exchange(endpoint, HttpMethod.GET, request, String.class);

        return result.getBody();
    }
}
