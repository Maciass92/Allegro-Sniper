package com.maciejkomorowski.allegro.sniper.repositories;

import com.maciejkomorowski.allegro.sniper.repositories.models.SearchCriteriaModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchCriteriaRepository extends CrudRepository<SearchCriteriaModel, Long> {
}
