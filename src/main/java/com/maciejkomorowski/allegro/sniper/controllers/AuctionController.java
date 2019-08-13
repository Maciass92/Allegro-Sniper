package com.maciejkomorowski.allegro.sniper.controllers;

import com.maciejkomorowski.allegro.sniper.services.AuctionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auctions")
public class AuctionController {

    private final AuctionService auctionService;

    @RequestMapping()
    public String getAuctions(){

        return "Hello world";
    }

    @RequestMapping("/scan")
    public String scan(){
        auctionService.runSingleScan();

        return "Scanned";
    }
}
