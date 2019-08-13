package com.maciejkomorowski.allegro.sniper.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AuctionModel {

    @Id
    @GeneratedValue()
    Long id;
}
