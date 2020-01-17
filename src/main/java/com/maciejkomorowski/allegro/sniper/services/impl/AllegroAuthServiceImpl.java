package com.maciejkomorowski.allegro.sniper.services.impl;

import com.maciejkomorowski.allegro.sniper.services.AuthService;
import com.maciejkomorowski.allegro.sniper.services.dto.AllegroAuthResponse;
import com.maciejkomorowski.allegro.sniper.utils.builders.RequestBuilder;
import com.maciejkomorowski.allegro.sniper.utils.builders.UrlBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class AllegroAuthServiceImpl implements AuthService {

    @Autowired
    private RestTemplate restTemplate;

    private final RequestBuilder requestBuilder;
    private final UrlBuilder urlBuilder;

    @Override
    public AllegroAuthResponse authUser(String username, String password) {
        String authUrl = urlBuilder.getAuthUrl();
        HttpEntity<String> request = requestBuilder.buildAuthRequest(username, password);
        ResponseEntity<AllegroAuthResponse> response = restTemplate.exchange(authUrl, HttpMethod.POST, request, AllegroAuthResponse.class);

        return response.getBody();
    }
}
