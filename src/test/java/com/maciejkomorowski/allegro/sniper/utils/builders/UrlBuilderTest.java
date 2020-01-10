package com.maciejkomorowski.allegro.sniper.utils.builders;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static com.maciejkomorowski.allegro.sniper.services.enums.AllegroQueryParams.PHRASE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {UrlBuilder.class})
@TestPropertySource(properties = {"allegro.url.api=http://test.api"})
public class UrlBuilderTest {

    @Autowired
    private UrlBuilder urlBuilder;

    @Value("${allegro.url.api}")
    private String apiUrl;

    @Test
    public void properUrlWithoutParams(){
        //given
        String appendUrl = "/isWorking";

        //when
        String url = urlBuilder.buildApiUrl(appendUrl, null);

        //then
        assertEquals(url, apiUrl + appendUrl);
        assertFalse(url.contains("?"));
    }

    @Test
    public void properUrlWithParams(){
        //given
        String appendUrl = "/isWorking";
        Map<String, String> params = new HashMap<>();
        params.put(PHRASE.getName(), "test");

        //when
        String url = urlBuilder.buildApiUrl(appendUrl, params);

        //then
        assertTrue(url.contains(apiUrl + appendUrl));
        assertTrue(url.contains("?phrase=test"));
    }
}
