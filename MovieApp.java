import java.util.*;
import java.io.*;

public class MovieApp{

   public static void main(String[] args)throws IOException{
      
      User users[] = new User[5000000];
      Actor actors[] = new Actor[1000000];
      History historys[] = new History[100000000];
      Movies movies[] = new Movies[200000];
      //MovieActorRelation mar[] = new MovieActorRelation[9000000]
      
      Files file = new Files();
      Menu startMenu = new Menu();
      
      file.createFile("MovieHistory.txt");
      file.createFile("Users.txt");
      file.createFile("Movies.txt");
      file.createFile("Actors.txt");
      file.createFile("MovieActorRelation.txt");
      
      file.openFile("Users.txt");
      file.readUser(users);
      file.openFile("Movies.txt");
      file.readMovies(movies);
      file.openFile("Actors.txt");
      file.readActor(actors);
      System.out.println(users[0].getID()+" "+users[0].getUsername()+" " +users[0].getPassword());
      
      file.closeFile();
      
      startMenu.startMenu(users, movies, actors);
    
   }
}

