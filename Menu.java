import java.util.*;
import java.io.*;

public class Menu{

   Scanner scan;
   private int run = 1;
   private boolean movieInfo = false;
   private boolean loginMatch = false;
   private boolean admin = false;
   private int loginID;
   
   public void startMenu(User[] users, Movies[] movies, Actor[] actors, Favorits[] favorits){
      
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
                  mainMenu(users, movies, actors, favorits);
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

   public void mainMenu(User[] users, Movies[] movies, Actor[] actors, Favorits[] favorits){
      while(run == 1 && loginMatch == true) {
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
                  search(users, movies, actors, favorits);
                  break;
               case "2":
                  //Show Favorites
                  readFavorits(favorits, movies);
                  break;
               case "3":
                  //Show movies watched
                  break;
               case "4":
                  //quit
                  loginMatch = false;
                  admin = false;
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
            this.loginID = users[count].getID();
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
   
   public void readFavorits(Favorits[] favorits, Movies[] movies){
   
      Files favoritsfile = new Files();
      
      System.out.println("\n:::::::::::::::::::::::Leek movie database::::::::::::::::::::::::\n");
      System.out.println("Your favorites list:");
      
      int count = 0;
      int movieNumber = 0;
      while(favorits[count]!=null){
         
         if(favorits[count].getUserID() == loginID){
            
            movieNumber = favorits[count].getMovieID() - 1;
            System.out.println(movies[movieNumber].getTitle().replace("_", " "));
            //System.out.println(favorits[count].getMovieID());
              
         }
         count++;   
      }
   
   }
   
   public void search(User[] users, Movies[] movies, Actor[] actors, Favorits[] favorits){
   
      Files moviesFile = new Files();
      System.out.println("\n:::::::::::::::::::::::Leek movie database::::::::::::::::::::::::\n");
      System.out.println("Search:");  
      
      System.out.print("Enter movie name: ");
      scan = new Scanner(System.in);
      String search = scan.nextLine();
      search = search.toLowerCase().replace(" ", "_");
      
      int count = 0;
      boolean result = false;
      while(movies[count]!=null){
         
         if(movies[count].getTitle().toLowerCase().contains(search)){
            
            result = true;
            System.out.println(movies[count].getID() + ". " + movies[count].getTitle().replace("_", " "));
              
         }
         count++;   
      }
      
      if(result == false){
      
         System.out.println("No movie mached: " + search.replace("_", " "));
      
      } else {
      
         System.out.print("Enter movie number: ");
         scan = new Scanner(System.in);
         
         if(scan.hasNextInt()){
            int movieID = scan.nextInt();
            movieID--;
            movieInfo = true;
            selectMovie(movieID, users, movies, actors, favorits);
         } else {
            System.out.println("Go home Jarl, you are drunk!");
         }
      
      }
   
   }
   
   public void selectMovie(int ID ,User[] users, Movies[] movies, Actor[] actors, Favorits[] favorits){
      while(movieInfo == true){
         Files multiFile = new Files();
         System.out.println("\n:::::::::::::::::::::::Leek movie database::::::::::::::::::::::::\n");
         System.out.println("Movie info:");
         
         int count = 0;
         while(movies[count]!=null){
            
            if(movies[count].getID() == ID){
               
               System.out.println("Movie title:" + movies[count].getTitle().replace("_", " "));
               System.out.println("releaseyear:" + movies[count].getYear());
                 
            }
            count++;  
         }
         
         System.out.println();
         System.out.println("Options:");
         System.out.println("1. Go to main menu");
         System.out.println("2. add to favorite");
         System.out.println("3. add to watched movies");
         System.out.println("4. add actor");
         System.out.println("5. remove actor");
         System.out.println("6. edit movie");
         scan = new Scanner(System.in);
         
         if(scan.hasNext()){
         
            switch(scan.next()){
            
               case "1":
                  movieInfo = false;
                  break;
               case "2":
                  //add to favorite
                  break;
               case "3":
                  //add to watched movies
                  break;
               case "4":
                  //add actor
                  break;
               case "5":
                  //remove actor
                  break;
               case "6":
                  //edit movie
                  break;
               default:
                  System.out.println("Invalid option, please try agian... and again... and again.");
                  break;
            
            }
         
         }
      }
   
   }
}