package com.maciejkomorowski.allegro.sniper.services.impl;

import com.maciejkomorowski.allegro.sniper.services.AuctionService;
import org.springframework.stereotype.Service;

@Service
public class AuctionServiceImpl implements AuctionService {

    public void runSingleScan(){
        System.out.println("Scanning for auctions");
    }
}