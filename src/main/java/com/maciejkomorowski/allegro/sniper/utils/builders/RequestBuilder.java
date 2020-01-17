package com.maciejkomorowski.allegro.sniper.utils.builders;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class RequestBuilder {

    @Value("${allegro.request.header.accept}")
    private String allegroHeaderAccept;

    public HttpEntity<String> buildRequest(String accessToken){
        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.ACCEPT, allegroHeaderAccept);
        header.setBearerAuth(accessToken);

        return new HttpEntity<>(header);
    }

    public HttpEntity<String> buildAuthRequest(String username, String password){
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(username, password);

        return new HttpEntity<>(header);
    }
}
