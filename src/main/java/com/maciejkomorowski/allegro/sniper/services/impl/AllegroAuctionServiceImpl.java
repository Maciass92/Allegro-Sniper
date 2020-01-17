package com.maciejkomorowski.allegro.sniper.services.impl;

import com.maciejkomorowski.allegro.sniper.repositories.AuctionRepository;
import com.maciejkomorowski.allegro.sniper.repositories.models.AuctionModel;
import com.maciejkomorowski.allegro.sniper.services.AuctionService;
import com.maciejkomorowski.allegro.sniper.services.dto.GetAuctionsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.util.List;

import static com.maciejkomorowski.allegro.sniper.services.enums.AllegroUrl.SALE_CATEGORIES;
import static com.maciejkomorowski.allegro.sniper.utils.transformers.AuctionEntityTransformer.transformToAuctionModelList;
import static java.util.Objects.nonNull;
import static org.springframework.util.CollectionUtils.isEmpty;

@Service
@RequiredArgsConstructor
public class AllegroAuctionServiceImpl implements AuctionService {

    private final AllegroApiService allegroApiService;
    private final AuctionRepository auctionRepository;

    @Override
    public GetAuctionsResponse getAuctions(String accessToken, MultiValueMap<String, String> queryParams, boolean shouldSaveItems) {
        GetAuctionsResponse response = allegroApiService.getAuctions(accessToken, queryParams);

        if (shouldSaveItems && nonNull(response) && !isEmpty(response.getAuctions())){
            List<AuctionModel> auctionModels = transformToAuctionModelList(response.getAuctions());
            //todo auction filtering
            auctionRepository.saveAll(auctionModels);
        }

        return response;
    }

    @Override
    public String getCategories(String accessToken) {
        return allegroApiService.getRawResponse(accessToken, SALE_CATEGORIES.getAppendix());
    }
}