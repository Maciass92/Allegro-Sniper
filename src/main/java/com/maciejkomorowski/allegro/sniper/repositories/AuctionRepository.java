package com.maciejkomorowski.allegro.sniper.repositories;

import com.maciejkomorowski.allegro.sniper.repositories.models.AuctionModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionRepository extends CrudRepository<AuctionModel, Long> {

}
