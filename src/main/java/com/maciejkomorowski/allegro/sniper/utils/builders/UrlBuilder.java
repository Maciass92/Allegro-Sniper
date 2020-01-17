package com.maciejkomorowski.allegro.sniper.utils.builders;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import static org.springframework.util.CollectionUtils.isEmpty;

@Component
public class UrlBuilder {

    @Value("${allegro.url.api}")
    private String apiUrl;
    @Value("${allegro.url.auth}")
    private String authUrl;

    public String buildApiUrl(String urlAppendix, MultiValueMap<String, String> queryParams){
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(apiUrl + urlAppendix);
        if (!isEmpty(queryParams)){
            builder.queryParams(queryParams);
        }

        return builder.toUriString();
    }

    public String getAuthUrl() {
        return authUrl;
    }
}