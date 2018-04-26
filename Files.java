import java.util.*;
import java.io.*;
import java.lang.*;
import java.nio.*;
import static java.nio.file.StandardOpenOption.*;

public class Files{
   Scanner fileScan;
   // hvilke filer? 
   //movieHistory.txt / Users.txt 
   // Movies.txt / Actors.txt /  MovieActorRelations.txt
   
   /*
   
   File dir = new File("tmp/test");
   dir.mkdirs();
   File tmp = new File(dir, "tmp.txt");
   tmp.createNewFile();
   
   a*/
   
   public void createFile(String input){
         final Formatter fileCreate; 
         File fileName = new File(input);
         
         if(!fileName.exists()) {
            try {
               
               fileCreate = new Formatter(input);
            }
            catch(Exception e) {
               System.out.println("Error creating file " + fileName);
            }
         }
   }   
   
   public void openFile(String fileName) {
      try {
         File name = new File(fileName);
         fileScan = new Scanner(name);
      }
      catch (Exception e) {
         System.out.println("Blaaah");
      }
   
   }
   
   public void readUser(User[] users){
      int counter = 0;
      while(fileScan.hasNext()) {
         int ID = fileScan.nextInt();
         String username = fileScan.next();
         String password= fileScan.next();
         boolean admin = fileScan.nextBoolean();
         users[counter] = new User(ID, username, password, admin);
         counter++;
      }
        
   }
   public void readActor(Actor[] actors){
      int counter = 0;
      while(fileScan.hasNext()) {
         int ID = fileScan.nextInt();
         String firstname = fileScan.next();
         String lastname = fileScan.next();
         actors[counter] = new Actor(ID, firstname, lastname);
         counter++;
      }
        
   }
  
   public void readHistory(History[] historys){
      int counter = 0;
      while(fileScan.hasNext()) {
         int ID = fileScan.nextInt();
         int date = fileScan.nextInt();
         int movieID = fileScan.nextInt();
         int userID = fileScan.nextInt();
         historys[counter] = new History(ID, date, movieID, userID);
         counter++;
      }
        
   } 
   public void readMovies(Movies[] movies){
      int counter = 0;
      while(fileScan.hasNext()) {
         int ID = fileScan.nextInt();
         String title = fileScan.next();
         int realeaseYear = fileScan.nextInt();
         movies[counter] = new Movies(ID, title, realeaseYear);
         counter++;
      }
        
   }
   
   public void readFavorits(Favorits[] favorits){
   
      int counter = 0;
      while(fileScan.hasNext()){
      
         int userID = fileScan.nextInt();
         int movieID = fileScan.nextInt();
         favorits[counter] = new Favorits(userID, movieID);
         counter++;
      
      }
   
   }
   
   public void readWatched(Watched[] watched){
   
      int counter = 0;
      while(fileScan.hasNext()){
      
         int userID = fileScan.nextInt();
         int movieID = fileScan.nextInt();
         watched[counter] = new Watched(userID, movieID);
         counter++;
      
      }
   
   }
   
   public void readMovieActorRelations(MovieActorRelation[] maRelation){
      int counter = 0;
      while(fileScan.hasNext()) {
         
         int movieID = fileScan.nextInt();
         int actorID = fileScan.nextInt();
         maRelation[counter] = new MovieActorRelation(movieID, actorID);
         counter++;
      }
        
   }
    
   public void closeFile(){
   
      fileScan.close();
   
   }

   public void addToHistory(String fileName,int ID, int date, int movieID, int userID){
      try{
         FileWriter fileW = new FileWriter(fileName, true);
         BufferedWriter buffW = new BufferedWriter(fileW);
         buffW.write(ID + " " + date + " "  + movieID + " " + userID);
         buffW.close();
      }
      catch(Exception e){
         System.out.println("Error writing to" + fileName);
      }  
   }
   public void addToActors(int ID, String firstname, String lastname){
      try{
         FileWriter fileW = new FileWriter("Actors.txt", true);
         BufferedWriter buffW = new BufferedWriter(fileW);
         buffW.write(ID + " " + firstname + " "  + lastname+ "\n");
         buffW.close();
      }
      catch(Exception e){
         System.out.println("Error writing to" + "Actors.txt");
      }

   }
   public void addToMovies(int ID, String title, int releaseYear){
      try{
         FileWriter fileW = new FileWriter("Movies.txt", true);
         BufferedWriter buffW = new BufferedWriter(fileW);
         buffW.write(ID + " " + title.replace(" ","_") + " " + releaseYear+"\n");
         buffW.close();
      }
      catch(Exception e){
         System.out.println("Error writing to Movies.txt");
      }
   }

  public void addToUser(int ID, String username, String password, boolean admin){
      try{
         FileWriter fileW = new FileWriter("Users.txt", true);
         BufferedWriter buffW = new BufferedWriter(fileW);
         buffW.write(ID + " " + username + " "  + password + " "+admin+"\n");
         buffW.close();
      }
      catch(Exception e){
         System.out.println("Error writing to Users.txt");
      }
   }
   
   public void addToFavorits(int userID, int movieID){
   
      try{
      
         FileWriter fileW = new FileWriter("Favorits.txt", true);
         BufferedWriter buffW = new BufferedWriter(fileW);
         buffW.write(userID+" "+movieID+"\n");
         buffW.close();
      
      }catch(Exception e){
      
         System.out.println("Error writing to Favorits.txt");
      
      }
   
   }
   
   public void addToWatched(int userID, int movieID){
   
      try{
      
         FileWriter fileW = new FileWriter("Watched.txt", true);
         BufferedWriter buffW = new BufferedWriter(fileW);
         buffW.write(userID+" "+movieID+"\n");
         buffW.close();
      
      }catch(Exception e){
      
         System.out.println("Error writing to Watched.txt");
      
      }
   
   }
   
   public void addToMovieActorRelation(int movieID, int actorID){
      try{
         FileWriter fileW = new FileWriter("MovieActorRelation.txt", true);
         BufferedWriter buffW = new BufferedWriter(fileW);
         buffW.write(movieID+" "+actorID+"\n");
         buffW.close();
      }
      catch(Exception e){
         System.out.println("Error writing to MovieActorRelation.txt");
      }
   }
   
   public void clearFile(String fileName){
      try{
         FileWriter fileW = new FileWriter(fileName);
         BufferedWriter buffW = new BufferedWriter(fileW);
         buffW.write("");
         buffW.close();
         //System.out.println("Wrote to file "+type+".txt");
      }
      catch (Exception e) {
         e.printStackTrace();
      }
   }
}