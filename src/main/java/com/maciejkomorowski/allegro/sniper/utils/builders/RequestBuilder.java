package com.maciejkomorowski.allegro.sniper.utils.builders;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class RequestBuilder {

    @Value("${allegro.request.header.accept}")
    private String allegroHeaderAccept;

    public static final String HEADER_ACCEPT = "Accept";
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String HEADER_AUTHORIZATION_BEARER = "Bearer ";

    public HttpEntity<String> buildRequest(String accessToken){
        HttpHeaders header = new HttpHeaders();
        header.add(HEADER_AUTHORIZATION, HEADER_AUTHORIZATION_BEARER + accessToken);
        header.add(HEADER_ACCEPT, allegroHeaderAccept);

        return new HttpEntity<>(header);
    }

    public HttpEntity<String> buildAuthRequest(String username, String password){
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(username, password);

        return new HttpEntity<>(header);
    }
}
