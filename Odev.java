package odev;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.HashMap; // import the HashMap class
import odev.Food;
import odev.People;
import odev.Sport;
import java.math.BigDecimal;


public class Odev {
     

    public static void main(String[] args) throws IOException {
        
        
        File file=new File("C:\\Users\\ESİLA\\Desktop\\files\\people.txt");
        if(file.exists()){
            file.createNewFile();}
        //people.getName();
        HashMap<Integer, People> peopleList = new HashMap<Integer, People>();
 
        FileReader fileReader = new FileReader(file);
        String line;
 
         BufferedReader br = new BufferedReader(fileReader);
 
         while ((line = br.readLine()) != null) {
 
            String[] strArray;  
            //converting using String.split() method with whitespace as a delimiter  
            strArray = line.split("\t");   
            People person = new People();
            
            //printing the converted string array  
            person.setPersonID(Integer.parseInt(strArray[0]));
            person.setName(strArray[1]); 
            person.setGender(strArray[2]);
            person.setWeight(Integer.parseInt(strArray[3]));
            person.setHeight(Integer.parseInt(strArray[4]));
            person.setDateOfBirth(Integer.parseInt(strArray[5]));
              
            peopleList.put(person.getPersonID(), person);
            
         }
         br.close();
         
         
         
        file=new File("C:\\Users\\ESİLA\\Desktop\\files\\food.txt");
        if(file.exists()){
            file.createNewFile();}
 
        HashMap<Integer, Food> foodList = new HashMap<Integer, Food>();

        fileReader = new FileReader(file);
        br = new BufferedReader(fileReader);
 

        while ((line = br.readLine()) != null) {
            String[] strArray;  
            //converting using String.split() method with whitespace as a delimiter  
            strArray = line.split("\t");   
            //printing the converted string array  
            Food food= new Food();
            food.setFoodID(Integer.parseInt(strArray[0]));
            food.setNameOfFood(strArray[1]); 
            food.setCalorieCount(Integer.parseInt(strArray[2]));
            
            foodList.put(food.getFoodID(), food);
        }
 
        br.close();
        
        

        file=new File("C:\\Users\\ESİLA\\Desktop\\files\\sport.txt");
        if(file.exists()){
            file.createNewFile();}

        HashMap<Integer, Sport> sportList = new HashMap<Integer, Sport>();
        
        fileReader = new FileReader(file);
        br = new BufferedReader(fileReader);
 
        while ((line = br.readLine()) != null) {
            String[] strArray;  
            //converting using String.split() method with whitespace as a delimiter  
            strArray = line.split("\t");   
            
            //printing the converted string array  
            Sport spor= new Sport();
            spor.setSportID(Integer.parseInt(strArray[0]));
            spor.setNameOfSport(strArray[1]); 
            spor.setCalorieBurned(Integer.parseInt(strArray[2]));
             
            
            sportList.put(spor.getSportID(), spor);
        }

        br.close();
        

        
        file=new File("C:\\Users\\ESİLA\\Desktop\\IO\\IO1\\command.txt");
        if(file.exists()){
            file.createNewFile();}
        
        fileReader = new FileReader(file);
        br = new BufferedReader(fileReader);
        
        File fileOut=new File("C:\\Users\\ESİLA\\Desktop\\IO\\IO1\\kodMonitoring.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut));
        while ((line = br.readLine()) != null) {

            String text;
            String[] strArray;  
            //converting using String.split() method with whitespace as a delimiter  
            strArray = line.split("\t");
            
            text=strArray[0]+"\thas\t";
            
            if(Integer.parseInt(strArray[1])/1000==1){
                Food food = foodList.get(Integer.parseInt(strArray[1]));
                text+="taken\t"+Integer.parseInt(strArray[2])*food.getCalorieCount()+"kcal\tfrom\t"+food.getNameOfFood()+"\n***************\n";
            }else if(Integer.parseInt(strArray[1])/1000==2){
                Sport spor =sportList.get(Integer.parseInt(strArray[1]));
                text+="burned\t"+Integer.parseInt(strArray[2])/60*spor.getCalorieBurned()+"kcal\tthanks\tto\t"+spor.getNameOfSport()+"\n***************\n";
            }                      
            writer.write(text);
        }
        writer.close();
        
        file=new File("C:\\Users\\ESİLA\\Desktop\\IO\\IO1\\kodMonitoring.txt");
        if(file.exists()){
            file.createNewFile();}
        
        fileReader = new FileReader(file);
        br = new BufferedReader(fileReader);
        
        int calTaken=0, calGiven=0;
        while ((line = br.readLine()) != null) {

            String text;
            String[] strArray;  
            //converting using String.split() method with whitespace as a delimiter  
            strArray = line.split("\t");
            
            if(strArray[0].equals("11234")){
                    if(strArray[2].equals("taken"))
                        calTaken+=Integer.parseInt(strArray[3].substring(0,strArray[3].indexOf("k")-1));
                    else calGiven+=Integer.parseInt(strArray[3].substring(0,strArray[3].indexOf("k")-1));
            }
        }
        
        fileOut=new File("C:\\Users\\ESİLA\\Desktop\\IO\\IO1\\kodMonitoring2.txt");
        writer = new BufferedWriter(new FileWriter(fileOut));
        //murat	35	1776kcal	1225kcal	0kcal	-551kcal
        People person = peopleList.get(11234);
        writer.write(person.getName()+" "+(2022-person.getDateOfBirth())+"\t"+dailyCalorieNeeds(person)+"kcal\t"+calTaken+"kcal\t"+calGiven+"kcal\t"+(calTaken-calGiven-dailyCalorieNeeds(person)+"kcal\t"));
        
        writer.close();
            
        try {
            File myObj = new File("C:\\Users\\ESİLA\\Desktop\\IO\\IO1\\kodMonitoring2.txt");
            if (myObj.createNewFile()) {
              System.out.println("File created: " + myObj.getName());
            } else {
              System.out.println("File already exists.");
            }
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          } 
                    
            // if binle bas. 2 ise spor yapmış çıkarma(-)
            //else (+) toplama yemek yemiş
            




        /*for() {
            People person =  new People();

         int dailyCalorieNeeds;
         person.setGender(String gender) 
         */
    }

    private static int print(int personID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 
    private static int dailyCalorieNeeds (People person) {
       if(person.getGender().equals("female"))
            return (int) Math.round(665+9.6*person.getWeight()+1.7*person.getHeight()-4.7*(2022-person.getDateOfBirth()));
       else
            return (int) Math.round(66+13.75*person.getWeight()+5*person.getHeight()-6.8*(2022-person.getDateOfBirth()));
    }
}
    
    
    

