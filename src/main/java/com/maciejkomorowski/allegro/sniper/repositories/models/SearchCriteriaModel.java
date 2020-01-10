package com.maciejkomorowski.allegro.sniper.repositories.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SearchCriteriaModel {

    @Id
    @GeneratedValue()
    Long id;
}
