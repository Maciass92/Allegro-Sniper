package com.maciejkomorowski.allegro.sniper.utils.transformers;

import com.maciejkomorowski.allegro.sniper.repositories.models.AuctionImageModel;
import com.maciejkomorowski.allegro.sniper.repositories.models.AuctionModel;
import com.maciejkomorowski.allegro.sniper.services.dto.Auction;
import com.maciejkomorowski.allegro.sniper.services.dto.AuctionImage;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.EMPTY_LIST;
import static org.springframework.util.CollectionUtils.isEmpty;

@Component
public class AuctionEntityTransformer {
    public static List<AuctionModel> transformToAuctionModelList(List<Auction> auctions) {
        return auctions.stream()
                .map(auction -> {
                    return AuctionModel.builder()
                            .id(auction.getId())
                            .sellerId(auction.getSellerId())
                            .name(auction.getName())
                            .price(auction.getPrice())
                            .sellingMode(auction.getSellingMode())
                            .isCompanySeller(auction.isCompanySeller())
                            .stock(auction.getStock())
                            .categoryId(auction.getCategoryId())
                            .images(transformToAuctionImageModelList(auction.getImages()))
                            .build();
                })
                .collect(Collectors.toList());
    }

    public static List<AuctionImageModel> transformToAuctionImageModelList(List<AuctionImage> images){
        if (isEmpty(images)){
            return EMPTY_LIST;
        }

        return images.stream()
                .map(auctionImage -> {
                    return AuctionImageModel.builder()
                            .imageUrl(auctionImage.getImageUrl())
                            .build();
                })
                .collect(Collectors.toList());
    }
}