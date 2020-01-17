package com.maciejkomorowski.allegro.sniper.repositories.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Builder
@Table(name = "AUCTION")
@NoArgsConstructor
@AllArgsConstructor
public class AuctionModel {

    @Id
    @GeneratedValue
    private Long id;
    private Long sellerId;
    private Long categoryId;

    @NotNull private int stock;

    @NotNull private String name;
    @NotNull private String price;
    private String sellingMode;

    private boolean isCompanySeller;

    @JoinColumn(name = "auctionId")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AuctionImageModel> images;
}