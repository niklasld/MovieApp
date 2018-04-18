import java.util.*;
import java.io.*;

public class MovieApp{

   public static void main(String[] args)throws IOException{
      
      User users[] = new User[5000000];
      Actor actors[] = new Actor[1000000];
      History historys[] = new History[100000000];
      Movies movies[] = new Movies[200000];
      //MovieActorRelation mar[] = new MovieActorRelation[9000000]
      
      Files movieFile = new Files();
      
      movieFile.createFile("MovieHistory.txt");
      movieFile.createFile("Users.txt");
      movieFile.createFile("Movies.txt");
      movieFile.createFile("Actors.txt");
      movieFile.createFile("MovieActorRelation.txt");
      
      movieFile.openFile("Users.txt");
      movieFile.readUser(users);
      System.out.println(users[0].getID()+" "+users[0].getUsername()+" " +users[0].getPassword());
      
      movieFile.closeFile();
    
   }
}

