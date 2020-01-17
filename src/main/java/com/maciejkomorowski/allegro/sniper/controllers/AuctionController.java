package com.maciejkomorowski.allegro.sniper.controllers;

import com.maciejkomorowski.allegro.sniper.services.AuctionService;
import com.maciejkomorowski.allegro.sniper.services.dto.GetAuctionsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static com.maciejkomorowski.allegro.sniper.services.enums.AllegroQueryParams.PHRASE;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RestController
@RequiredArgsConstructor
@RequestMapping("/allegro/auctions")
public class AuctionController {

    private final AuctionService auctionService;

    @GetMapping("")
    @ResponseBody
    public GetAuctionsResponse getAuctions(@RequestParam String phrase, @RequestHeader(name=AUTHORIZATION) String accessToken){
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add(PHRASE.getName(), phrase);

        return auctionService.getAuctions(accessToken, queryParams, false);
    }

    @GetMapping("/category/all")
    @ResponseBody
    public String getCategories(@RequestHeader(name=AUTHORIZATION) String accessToken){
        return auctionService.getCategories(accessToken);
    }
}
