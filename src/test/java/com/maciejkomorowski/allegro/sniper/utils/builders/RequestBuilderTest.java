package com.maciejkomorowski.allegro.sniper.utils.builders;

import com.maciejkomorowski.allegro.sniper.controllers.dto.AllegroCredentials;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {RequestBuilder.class})
@TestPropertySource(properties = {"allegro.request.header.accept=testValue"})
public class RequestBuilderTest {

    @Autowired
    private RequestBuilder requestBuilder;

    @Value("${allegro.request.header.accept}")
    private String allegroHeaderAccept;

    @Test
    public void requestContainsHeader(){
        //given
        String accessToken = "345";
        String bearer = "Bearer ";

        //when
        HttpEntity<String> request = requestBuilder.buildRequest(accessToken);

        //then
        assertEquals(request.getHeaders().get(HttpHeaders.ACCEPT).get(0), allegroHeaderAccept);
        assertEquals(request.getHeaders().get(HttpHeaders.AUTHORIZATION).get(0), bearer + accessToken);
    }

    @Test
    public void requestHeaderContainsBasicEncryption(){
        //given
        String bearer = "Basic ";

        //when
        HttpEntity<String> request = requestBuilder.buildAuthRequest("asd", "qwe");

        //then
        assertTrue(request.getHeaders().get(HttpHeaders.AUTHORIZATION).get(0).contains(bearer));
    }
}
