package odev;


import java.io.File;

import java.io.BufferedReader;
// Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner; // Impo
public class Food {
   
            
   int foodID;
   String nameOfFood;
   int calorieCount;

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public void setNameOfFood(String nameOfFood) {
        this.nameOfFood = nameOfFood;
    }

    public void setCalorieCount(int calorieCount) {
        this.calorieCount = calorieCount;
    }

    public int getFoodID() {
        return foodID;
    }

    public String getNameOfFood() {
        return nameOfFood;
    }

    public int getCalorieCount() {
        return calorieCount;
    }
   
    
}
