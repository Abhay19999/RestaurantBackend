package com.humber.prbackend.controller;


import com.humber.prbackend.Services.FoodItemService;
import com.humber.prbackend.models.FoodItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
public class FoodItemController {

    private FoodItemService foodItemService;

    @Autowired
    public FoodItemController(FoodItemService foodItemService){
        this.foodItemService=foodItemService;
    }

    @CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "Requestor-Type", exposedHeaders = "X-Get-Header")
    @GetMapping("/all-dishes")
    public ResponseEntity<List<FoodItems>> getAllFoodDishes() {
        List<FoodItems> dishes = foodItemService.getAllDishes();
        return new ResponseEntity<>(dishes, HttpStatus.OK);
    }
    @PostMapping("/add-dish")
    public ResponseEntity<FoodItems> addFoodDish(@RequestBody FoodItems foodItem) {
        FoodItems savedDish = foodItemService.addDish(foodItem);
        return new ResponseEntity<>(savedDish, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete-dish/{id}")
    public ResponseEntity<Void> deleteFoodDish(@PathVariable String id) {
        foodItemService.deleteDish(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/edit-dish/{id}")
    public ResponseEntity<FoodItems> editFoodItem(@PathVariable String id, @RequestBody FoodItems updatedFoodItem) {
        try {
            FoodItems editedFoodItem = foodItemService.editFoodItem(id, updatedFoodItem);
            return new ResponseEntity<>(editedFoodItem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
