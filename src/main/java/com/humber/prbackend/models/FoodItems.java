package com.humber.prbackend.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "FoodItems")
public class FoodItems {
    @Id
    private String id;
    private String image;
    private String name;
    private String category;
    private String price;
    private String description;

}
