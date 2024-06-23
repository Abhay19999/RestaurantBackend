package com.humber.prbackend.Services;


import com.humber.prbackend.models.FoodItems;
import com.humber.prbackend.repositories.FoodItemsRepository;
import org.codehaus.plexus.resource.loader.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class FoodItemService {

    private FoodItemsRepository foodItemRepository;

    public FoodItemService(FoodItemsRepository foodItemRepository){
        this.foodItemRepository = foodItemRepository;
    }

    public List<FoodItems> getAllDishes(){
        return (List<FoodItems>) foodItemRepository.findAll();
    }
    public FoodItems addDish(FoodItems foodItem) {

        return foodItemRepository.save(foodItem);
    }
    public void deleteDish(String id) {
        foodItemRepository.deleteById(id);
    }
    public FoodItems editFoodItem(String id, FoodItems updatedFoodItem) throws ResourceNotFoundException {
        FoodItems existingFoodItem = foodItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Food item not found with id: " + id));
        existingFoodItem.setName(updatedFoodItem.getName());
        existingFoodItem.setCategory(updatedFoodItem.getCategory());
        existingFoodItem.setImage(updatedFoodItem.getImage());
        existingFoodItem.setDescription(updatedFoodItem.getDescription());
        return foodItemRepository.save(existingFoodItem);
    }




}
