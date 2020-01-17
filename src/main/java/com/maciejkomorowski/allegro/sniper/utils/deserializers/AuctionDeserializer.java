package com.maciejkomorowski.allegro.sniper.utils.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.maciejkomorowski.allegro.sniper.services.dto.Auction;
import com.maciejkomorowski.allegro.sniper.services.dto.AuctionImage;
import com.maciejkomorowski.allegro.sniper.services.dto.GetAuctionsResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//todo refactor?
public class AuctionDeserializer extends JsonDeserializer<GetAuctionsResponse> {

    @Override
    public GetAuctionsResponse deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.readValueAsTree();
        JsonNode auctionList = node.get("items").get("regular");
        int auctionCount = node.get("searchMeta").get("availableCount").asInt();

        ArrayList<Auction> auctions = new ArrayList<>();
        for (JsonNode jsonNode : auctionList){
            JsonNode sellingMode = jsonNode.get("sellingMode");
            JsonNode seller = jsonNode.get("seller");
            JsonNode imagesNode = jsonNode.get("images");
            List<AuctionImage> images = new ArrayList<>();
            for (JsonNode jsonNode1 : imagesNode){
                images.add(new AuctionImage(jsonNode1.get("url").asText()));
            }

            auctions.add(Auction.builder()
                    .id(jsonNode.get("id").asLong())
                    .sellerId(seller.get("id").asLong())
                    .stock(jsonNode.get("stock").get("available").asInt())
                    .name(jsonNode.get("name").asText())
                    .price(sellingMode.get("price").get("amount").asText())
                    .sellingMode(sellingMode.get("format").asText())
                    .categoryId(jsonNode.get("category").get("id").asLong())
                    .isCompanySeller(seller.get("company").booleanValue())
                    .images(images)
                    .build());
        }

        return new GetAuctionsResponse(auctions, auctionCount);
    }
}
