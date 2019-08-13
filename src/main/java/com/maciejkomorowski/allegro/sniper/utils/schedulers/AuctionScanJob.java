package com.maciejkomorowski.allegro.sniper.utils.schedulers;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AuctionScanJob {

    @Scheduled(fixedRate = 5000)
    public void scanForAuctions(){
        System.out.println("Scanning for auctions");
    }
}
