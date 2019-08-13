package com.maciejkomorowski.allegro.sniper.utils.schedulers;

import com.maciejkomorowski.allegro.sniper.services.AuctionService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuctionScanJob {

    private final AuctionService auctionService;

    @Scheduled(fixedRate = 5000)
    public void scanForAuctions(){
        auctionService.runSingleScan();
    }
}
