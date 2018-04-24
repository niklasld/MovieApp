import java.util.*;
import java.io.*;

public class Menu{

   Scanner scan;
   private int run = 1;
   private boolean loginMatch = false;
   private boolean admin = false;
   
   public void startMenu(User[] users, Movies[] movies, Actor[] actors){
      
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
                  mainMenu(users, movies, actors);
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

   public void mainMenu(User[] users, Movies[] movies, Actor[] actors){
      if(loginMatch == true) {
         while(run == 1) {
            System.out.println("\n::::::::::::::::::::::::::::Welcome to::::::::::::::::::::::::::::");
            System.out.println(":::::::::::::::::::::::Leek movie database::::::::::::::::::::::::\n");
            System.out.println("Please select one of the followings options.");
            System.out.println("\t1. Search Movies/Actors \n\t2. Show Favorites\n\t3. Show Movies Watched\n\t4. Quit");
            if(admin == true) {
               System.out.println("\tAdmin functions\n\t5. Add Movie\n\t6. Add Actor");
            }
            
            scan = new Scanner(System.in);
            
            if(scan.hasNext()){
            
               switch(scan.next()){
               
                  case "1":
                     //Search Movie/Actors
                     break;
                  case "2":
                     //Show Favorites
                     break;
                  case "3":
                     //Show movies watched
                     break;
                  case "4":
                     //quit
                     break;
                  case "5":
                     if(admin == true) {
                        addMovie(movies);
                     }
                     
                     break;
                  case "6":
                     if(admin == true) {
                        addToActors(actors);
                     }
                     //Add Actors
                     break;
                  default:
                     System.out.println("Invalid option, please try agian... and again... and again.");
                     break;
               
               }
            
            }   
         }
      }
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
      
      int idFind = 0;
      while(users[idFind]!=null) {
         idFind++;
      }
      
      int ID = idFind+1;
      users[idFind] = new User(ID, username, password, false);
      
      
      userFile.clearFile("Users.txt");
      
      idFind=0;
      while(users[idFind]!=null) {
         userFile.addToUser(users[idFind].getID(),users[idFind].getUsername(),users[idFind].getPassword(), users[idFind].getAdmin());
         idFind++;
      }
      
   }
   
   public void addMovie(Movies[] movies){
      Files moviesFile = new Files();
      System.out.println("\n:::::::::::::::::::::::Leek movie database::::::::::::::::::::::::\n");
      System.out.println("Add Movie:");  
      
      System.out.print("Movie name: ");
      scan = new Scanner(System.in);
      String movieName = scan.nextLine();
      
      System.out.print("realeaseYear: ");
      scan = new Scanner(System.in);
      int releaseYear = scan.nextInt();
      
      int idFind = 0;
      while(movies[idFind]!=null) {
         idFind++;
      }
      //int ID, String title, int releaseYear
      int ID = idFind+1;
      movies[idFind] = new Movies(ID, movieName, releaseYear);
      
      moviesFile.clearFile("Movies.txt");
      idFind=0;
      while(movies[idFind]!=null){
         
         moviesFile.addToMovies(movies[idFind].getID(),movies[idFind].getTitle().replace(" ", "_") ,movies[idFind].getYear());
         idFind++;
      }  
   }
   public void addToActors(Actor[] actors){
      Files actorsfile = new Files();
      
      System.out.println("\n:::::::::::::::::::::::Leek movie database::::::::::::::::::::::::\n");
      System.out.println("Add Movie:");
      
      System.out.print("Actor firstname:");
      scan = new Scanner(System.in);
      String firstName = scan.next();
      
      System.out.print("Actor lastname:");
      scan = new Scanner(System.in);
      String lastName = scan.next();
      
      int idFind = 0;
      while(actors[idFind]!=null) {
         idFind++;
      }
      int ID = idFind+1;
      actors[idFind]= new Actor(ID, firstName, lastName);
      actorsfile.clearFile("Actors.txt");
      idFind = 0;
      while(actors[idFind]!=null){
      
         actorsfile.addToActors(actors[idFind].getID(),actors[idFind].getFirstName(),actors[idFind].getLastName());
         idFind++;
      }
   }
}