import java.util.*;
import java.io.*;

public class Menu{

   Scanner scan;
   private int run = 1;
   private boolean movieInfo = false;
   private boolean actorInfo = false;
   private boolean searchInfo = false;
   private boolean loginMatch = false;
   private boolean admin = false;
   private int loginID;
   
   public void startMenu(User[] users, Movies[] movies, Actor[] actors, Favorits[] favorits, MovieActorRelation[] maRelation, Watched[] watched){
      
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
                  mainMenu(users, movies, actors, favorits, maRelation, watched);
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

   public void mainMenu(User[] users, Movies[] movies, Actor[] actors, Favorits[] favorits, MovieActorRelation[] maRelation, Watched[] watched){
      while(run == 1 && loginMatch == true) {
         System.out.println("\n::::::::::::::::::::::::::::Welcome to::::::::::::::::::::::::::::");
         System.out.println(":::::::::::::::::::::::Leek movie database::::::::::::::::::::::::\n");
         System.out.println("Please select one of the followings options.");
         System.out.println("\t1. Search Movies/Actors \n\t2. Show Favorites\n\t3. Show Movies Watched\n\t4. Quit");
         if(admin == true) {
            System.out.println("\tAdmin functions\n\t5. Add Movie\n\t6. Add Actor\n\t7.Remove Movie\n\t8.Remove Actor");
         }
         
         scan = new Scanner(System.in);
         
         if(scan.hasNext()){
         
            switch(scan.next()){
            
               case "1":
                  //Search Movie/Actors
                  searchMenu(users, movies, actors, favorits, maRelation, watched);
                  break;
               case "2":
                  //Show Favorites
                  readFavorits(favorits, movies);
                  break;
               case "3":
                  //Show movies watched
                  readWatched(watched, movies);
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
               case "7":
                  //remove movie
                  if(admin == true) {
                     searchMovie(true, users, movies, actors, favorits, maRelation, watched);
                  }
                  break;
               case "8":
                  //remove actor
                  if(admin == true) {
                     searchActor(true, users, movies, actors, favorits, maRelation, watched);
                  }
                  break;
               default:
                  System.out.println("Invalid option. (Main menu)");
                  break;
            
            }
         
         }   
      }
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
      users[idFind] = new User(ID, username, password, false, true);
      
      
      userFile.clearFile("Users.txt");
      
      idFind=0;
      while(users[idFind]!=null) {
         userFile.addToUser(users[idFind].getID(),users[idFind].getUsername(),users[idFind].getPassword(), users[idFind].getAdmin(), users[idFind].getVisible());
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
      movies[idFind] = new Movies(ID, movieName, releaseYear, true);
      
      moviesFile.clearFile("Movies.txt");
      idFind=0;
      while(movies[idFind]!=null){
         
         moviesFile.addToMovies(movies[idFind].getID(),movies[idFind].getTitle().replace(" ", "_") ,movies[idFind].getYear(),movies[idFind].getVisible());
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
      actors[idFind]= new Actor(ID, firstName, lastName, true);
      actorsfile.clearFile("Actors.txt");
      idFind = 0;
      while(actors[idFind]!=null){
      
         actorsfile.addToActors(actors[idFind].getID(),actors[idFind].getFirstName(),actors[idFind].getLastName(),actors[idFind].getVisible());
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
   
   public void readWatched(Watched[] watched, Movies[] movies){
   
      Files watchedfile = new Files();
      
      System.out.println("\n:::::::::::::::::::::::Leek movie database::::::::::::::::::::::::\n");
      System.out.println("Your watched list:");
      
      int count = 0;
      int movieNumber = 0;
      while(watched[count]!=null){
         
         if(watched[count].getUserID() == loginID){
            
            movieNumber = watched[count].getMovieID() - 1;
            System.out.println(movies[movieNumber].getTitle().replace("_", " "));
            //System.out.println(favorits[count].getMovieID());
              
         }
         count++;   
      }
   
   }
   
   public void searchMenu(User[] users, Movies[] movies, Actor[] actors, Favorits[] favorits, MovieActorRelation[] maRelation, Watched[] watched) {
      Files actorFile = new Files();
      
      System.out.println("\n:::::::::::::::::::::::Leek movie database::::::::::::::::::::::::\n");
      System.out.println("Select a search option:"); 
      System.out.println("\n1. Search by moviename\n2. Search by actorname");
      
      scan = new Scanner(System.in);
      String search = "";
      //String search = scan.nextLine();
      //if(movieInfo ==) {
      searchInfo = true;
      while(searchInfo == true){
         search = scan.nextLine();
         if(search.equals("1")) {
            //search movie
            searchMovie(false, users, movies, actors, favorits, maRelation, watched);
            searchInfo = false;
         }
         else if(search.equals("2")) {
            //search actor
            searchActor(false, users, movies, actors, favorits, maRelation, watched);
            searchInfo = false;
         }
         else {
            System.out.println("Try again");
         }
      }
      
   }
   
   public void searchActor(boolean remove, User[] users, Movies[] movies, Actor[] actors, Favorits[] favorits, MovieActorRelation[] maRelation, Watched[] watched) {
      
      Files moviesFile = new Files();
      System.out.println("\n:::::::::::::::::::::::Leek movie database::::::::::::::::::::::::\n");
      System.out.println("Search:");  
      
      System.out.print("Enter actor name: ");
      scan = new Scanner(System.in);
      String search = scan.nextLine();
      search = search.toLowerCase();
      
      int count = 0;
      boolean result = false;
      
      while(actors[count]!=null){
         
         if(actors[count].getFirstName().toLowerCase().contains(search) || actors[count].getLastName().toLowerCase().contains(search)){
            if(actors[count].getVisible() == true) {
               result = true;
               System.out.println(actors[count].getID() + ". " + actors[count].getFirstName() + " " + actors[count].getLastName());
            }  
         }
         count++;   
      }
      
      if(result == false){
      
         System.out.println("No actors mached: " + search);
      
      } else {
         if(remove==false) {
            System.out.print("Enter actor number: ");
         }
         else if(remove==true) {
            System.out.print("Enter actor number to remove: ");
         }
         
         scan = new Scanner(System.in);
         
         if(scan.hasNextInt() && remove == false){
            int actorID = scan.nextInt();
            
            actorInfo = true;
            selectActor(actorID, users, movies, actors, favorits, maRelation, watched);
         } 
         
         else if(scan.hasNextInt() && remove == true) {
            int actorID = scan.nextInt();
            actors[actorID-1].setVisible(false);
            System.out.println(actors[actorID].getVisible());
            System.out.println("Actor removed...");
            moviesFile.clearFile("Actors.txt");
            int idFind = 0;
            
            while(actors[idFind]!=null){
            
               moviesFile.addToActors(actors[idFind].getID(),actors[idFind].getFirstName(),actors[idFind].getLastName(),actors[idFind].getVisible());
               idFind++;
            }
         }
         else {
            System.out.println("Go home Jarl(Search actor function error)");
         }
      
      }
   
   }
   
   public void selectActor(int actorID, User[] users, Movies[] movies, Actor[] actors, Favorits[] favorits, MovieActorRelation[] maRelation, Watched[] watched) {
      Files actorFile = new Files();
      System.out.println("\n:::::::::::::::::::::::Leek movie database::::::::::::::::::::::::\n");
      System.out.println("Search result:");
      
      int arrayID = actorID-1;
      System.out.println(actors[arrayID].getFirstName() + " " + actors[arrayID].getLastName() + " is in the following movies: "); 
      
      int count = 0;
      int movieNumber = 0;
      while(maRelation[count]!=null){
         
         if(maRelation[count].getActorID() == actorID){
            movieNumber = maRelation[count].getMovieID() - 1;
            System.out.println(movies[movieNumber].getID()+" "+movies[movieNumber].getTitle().replace("_", " "));
              
         }
         count++;
            
      }
      scan = new Scanner(System.in);
      
      
      if(scan.hasNextInt()) {
         movieNumber = scan.nextInt(); 
         movieInfo = true;
         selectMovie(movieNumber, users, movies, actors, favorits, maRelation, watched);
      }  
   }
   
   public void searchMovie(boolean remove,User[] users, Movies[] movies, Actor[] actors, Favorits[] favorits, MovieActorRelation[] maRelation, Watched[] watched){
   
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
         
         if(movies[count].getTitle().toLowerCase().contains(search) && movies[count].getVisible() == true){
            
            result = true;
            System.out.println(movies[count].getID() + ". " + movies[count].getTitle().replace("_", " "));
              
         }
         count++;   
      }
      
      if(result == false){
      
         System.out.println("No movie mached: " + search.replace("_", " "));
      
      } 
      
      else if(result == true) {
      
         System.out.print("Enter movie number: ");
         scan = new Scanner(System.in);
         
         if(scan.hasNextInt() && remove == false){
            int movieID = scan.nextInt();
            //movieID--;
            movieInfo = true;
            selectMovie(movieID, users, movies, actors, favorits, maRelation, watched);
         } 
         else if(scan.hasNextInt() && remove == true) {
            int moviesID = scan.nextInt();
            movies[moviesID-1].setVisible(false);
            //System.out.println(movies[moviesID].getVisible());
            System.out.println("Movie removed...");
            moviesFile.clearFile("Movies.txt");
            int idFind = 0;
            
            while(movies[idFind]!=null){
            
               moviesFile.addToMovies(movies[idFind].getID(),movies[idFind].getTitle(),movies[idFind].getYear(),movies[idFind].getVisible());
               idFind++;
            }
         }
         
         else {
            System.out.println("Go home Jarl (search movie method)");
         }
      
      }
   
   }
   
   public void addActorToMovie(int movieID, User[] users, Movies[] movies, Actor[] actors, Favorits[] favorits, MovieActorRelation[] maRelation, Watched[] watched) {
      scan = new Scanner(System.in);
      Files multiFile = new Files();
      int count= 0;
      int actorNumber = -1;
      
      System.out.println("Actors list:");
      while(actors[count]!=null) {
         System.out.println(actors[count].getID()+" "+actors[count].getFirstName()+" "+actors[count].getLastName());
         count++;
      }
      System.out.println("\nPlease type in an actor number you wish to add to the movie:");
      if(scan.hasNextInt()) {
         actorNumber = scan.nextInt();
      }
      count = 0;
      while(maRelation[count]!=null) {
         count++;
      }
      maRelation[count] = new MovieActorRelation(movieID, actorNumber);
      multiFile.clearFile("MovieActorRelation.txt");
      count = 0;
      while(favorits[count]!=null) {
         multiFile.addToMovieActorRelation(maRelation[count].getMovieID(), maRelation[count].getActorID());
         count++;
      }
      
   }
   
   public void selectMovie(int ID ,User[] users, Movies[] movies, Actor[] actors, Favorits[] favorits, MovieActorRelation[] maRelation, Watched[] watched){
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
         System.out.print("Actors: ");
         
         count = 0;
         int actorNumber = 0;
         boolean first = true;
         while(maRelation[count]!=null){
            
            if(maRelation[count].getMovieID() == ID && actors[maRelation[count].getActorID()-1].getVisible() == true){
               
               actorNumber = maRelation[count].getActorID() - 1;
               if (first == false){
                  System.out.print(", ");
               }
               System.out.print(actors[actorNumber].getFirstName() + " " + actors[actorNumber].getLastName());
               //System.out.println(favorits[count].getMovieID());
               first = false;
                 
            }
            count++;   
         }
         
         System.out.println();
         System.out.println();
         System.out.println("Options:");
         System.out.println("1. Go to main menu");
         System.out.println("2. add to favorite");
         System.out.println("3. add to watched movies");
         if(admin==true){
            System.out.println("Admin functions");
            System.out.println("4. add actor");
            System.out.println("5. remove actor");
            System.out.println("6. edit movie");
         }
         scan = new Scanner(System.in);
         
         if(scan.hasNext()){
         
            switch(scan.next()){
            
               case "1":
                  movieInfo = false;
                  //mainMenu(users, movies, actors, favorits, maRelation);
                  break;
               case "2":
                  //add to favorite
                  count = 0;
                  while(favorits[count]!=null) {
                     count++;
                  }
                  favorits[count] = new Favorits(loginID, ID);
                  multiFile.clearFile("Favorits.txt");
                  count = 0;
                  while(favorits[count]!=null) {
                     multiFile.addToFavorits(favorits[count].getUserID(), favorits[count].getMovieID());
                     count++;
                  }
                  
                  break;
               case "3":
                  //add to watched movies
                  count = 0;
                  while(watched[count]!=null) {
                     count++;
                  }
                  watched[count] = new Watched(loginID, ID);
                  multiFile.clearFile("Watched.txt");
                  count = 0;
                  while(watched[count]!=null) {
                     multiFile.addToWatched(watched[count].getUserID(), watched[count].getMovieID());
                     count++;
                  }
                  
                  break;
               case "4":
                  //add actor
                  if(admin==true){
                     addActorToMovie(ID, users, movies, actors, favorits, maRelation, watched);
                  }
                  break;
               case "5":
                  //remove actor
                  if(admin==true){
                     
                  }
                  break;
               case "6":
                  //edit movie
                  if(admin==true){
                     scan = new Scanner(System.in);
                     int input2 = -1;
                     System.out.println("Please type in a new Title for the movie");
                     String input = scan.nextLine().replace(" ", "_");
                     movies[ID-1].setTitle(input);
                     System.out.println("Please type in release year of the movie");
                     if(scan.hasNextInt()) {
                        input2 = scan.nextInt();
                     }
                     movies[ID-1].setYear(input2);
                     
                     multiFile.clearFile("Movies.txt");
                     count = 0;
                     while(movies[count]!=null) {
                        multiFile.addToMovies(movies[count].getID(),movies[count].getTitle(), movies[count].getYear(),movies[count].getVisible());
                        count++;
                     }
                     
                  }
                  break;
               default:
                  System.out.println("Invalid option, please try agian... and again... and again.");
                  break;
            
            }
         
         }
      }
   
   }
}