package com.maciejkomorowski.allegro.sniper.utils.builders;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

import static org.springframework.util.CollectionUtils.isEmpty;

@Getter
@Component
public class UrlBuilder {

    @Value("${allegro.url.api}")
    private String apiUrl;
    @Value("${allegro.url.auth}")
    private String authUrl;

    public String buildApiUrl(String appendUrl, Map<String, String> queryParams){
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(apiUrl + appendUrl);
        if (!isEmpty(queryParams)){
            for (String key : queryParams.keySet()){
                builder.queryParam(key, queryParams.get(key));
            }
        }

        return builder.toUriString();
    }
}