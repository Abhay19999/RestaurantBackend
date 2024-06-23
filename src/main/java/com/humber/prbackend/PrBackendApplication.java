package com.humber.prbackend;

import com.humber.prbackend.Services.FoodItemService;
import com.humber.prbackend.models.FoodItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootApplication
public class PrBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrBackendApplication.class, args);
    }



}
