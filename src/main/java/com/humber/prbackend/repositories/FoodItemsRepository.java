package com.humber.prbackend.repositories;

import com.humber.prbackend.models.FoodItems;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FoodItemsRepository extends MongoRepository<FoodItems, String> {
}
