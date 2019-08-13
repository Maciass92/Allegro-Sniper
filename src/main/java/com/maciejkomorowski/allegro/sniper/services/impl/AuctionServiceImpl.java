package com.maciejkomorowski.allegro.sniper.services.impl;

import com.maciejkomorowski.allegro.sniper.services.AuctionService;
import com.maciejkomorowski.allegro.sniper.utils.schedulers.AuctionScanJob;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuctionServiceImpl implements AuctionService {

    private final AuctionScanJob auctionScanJob;

    public void runSingleScan(){
        auctionScanJob.scanForAuctions();
    }
}