package com.maciejkomorowski.allegro.sniper.repositories.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "AUCTION_IMAGE")
public class AuctionImageModel {

    @Id
    @GeneratedValue
    private Long id;
    @NotNull private Long auctionId;

    @NotNull private String imageUrl;
}
