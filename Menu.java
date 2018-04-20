import java.util.*;
import java.io.*;

public class Menu{

   Scanner scan;
   private int run = 1;
   private boolean loginMatch = false;
   private boolean admin = false;
   
   public void startMenu(User[] users){
      
      while(run == 1){
   
         System.out.println("\n::::::::::::::::::::::::::::Welcome to::::::::::::::::::::::::::::");
         System.out.println(":::::::::::::::::::::::Leek movie database::::::::::::::::::::::::\n");
         System.out.println("Please select one of the followings options.");
         System.out.println("\t1. Log in \n\t2. Create new user \n\t3. Quit");
         
         scan = new Scanner(System.in);
         
         if(scan.hasNext()){
         
            switch(scan.next()){
            
               case "1":
                  login(users);
                  break;
               case "2":
                  createUser(users);
                  break;
               case "3":
                  //quit
                  run = 0;
                  break;
               default:
                  System.out.println("Invalid option, please try agian... and again... and again.");
                  break;
            
            }
         
         }
         
      }
   
   }

   public void mainMenu(){
   }

   public void getMovie(){
   //return Movie; 
   }
   
   public void login(User[] users) {
      
      System.out.println("\n:::::::::::::::::::::::Leek movie database::::::::::::::::::::::::\n");
      
      System.out.println("Log in:");
      
      System.out.print("Username: ");
      scan = new Scanner(System.in);
      String username = scan.next();
      //System.out.println(username);
      
      System.out.print("Password: ");
      scan = new Scanner(System.in);
      String password = scan.next();
      //System.out.println(password);
       
      int count = 0;
      while(users[count]!=null){
         
         if(users[count].getUsername().equals(username) && users[count].getPassword().equals(password)){
            
            loginMatch = true;
            System.out.println("Login success!!!");
            if(users[count].getAdmin() == true){
            
               admin = true;
            
            }
            
         }
         
         count++;   
      }
      
   }
   
   public void createUser(User[] users){
   
      Files userFile = new Files();
      
      System.out.println("\n:::::::::::::::::::::::Leek movie database::::::::::::::::::::::::\n");
      
      System.out.println("Create new user:");
      
      System.out.print("Username: ");
      scan = new Scanner(System.in);
      String username = scan.next();
      
      System.out.print("Password: ");
      scan = new Scanner(System.in);
      String password = scan.next();
      
      //Finder det første tomme element i array
      int idFind = 0;
      while(users[idFind]!=null) {
         idFind++;
      }
      //Sætter ID for brugeren som skal oprettes
      int ID = idFind+1;
      users[idFind] = new User(ID, username, password, false);
      
      //cleare textfilen users.txt
      userFile.clearFile("Users.txt");
      
      //tilføjer hele arrayet til txt filen.
      idFind=0;
      while(users[idFind]!=null) {
         userFile.addToUser(users[idFind].getID()," "+users[idFind].getUsername()," "+users[idFind].getPassword(), users[idFind].getAdmin());
         idFind++;
      }
      
   }
   /*
   //old shit
   public void createUser(User[] users){
   
      Files userFile = new Files();
      
      System.out.println("\n:::::::::::::::::::::::Leek movie database::::::::::::::::::::::::\n");
      
      System.out.println("Create new user:");
      
      System.out.print("Username: ");
      scan = new Scanner(System.in);
      String username = scan.next();
      //System.out.println(username);
      
      System.out.print("Password: ");
      scan = new Scanner(System.in);
      String password = scan.next();
      //System.out.println(password);
      int count = 0;
      int id = 0;
      
      for(int i = 0; users[i]!=null; i++){
      
         id = i;
      
      }
      id+=2;
      int count = 0;
      while(users[count]!=null) {
         count++;
      }
      System.out.println(count);
      id = count+1;
      users[count] = new User(count, username, password);
      
      count = 0;
      while(count != null){
         userFile.addToUser("Users.txt", id, username, password);
      }
   }*/
   
}