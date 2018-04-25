public class Favorits{

   private int userID;
   private int movieID;
   //private String[] actor;
   
   public Favorits(int userID, int movieID){
   
      this.userID = userID;
      this.movieID = movieID;
   
   }
   
   public int getUserID(){
   
      return userID;
   
   }
   
   public int getMovieID(){
   
      return movieID;
   
   }
   
   public void setUserID(int userID){
   
      this.userID = userID;
   
   }
   
   public void setMovieID(int movieID){
   
      this.movieID = movieID;
   
   }
   
}