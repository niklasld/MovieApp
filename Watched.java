public class Watched{

   private int userID;
   private int movieID;
   //private String[] actor;
   private int month, day, year;
   public Watched(int userID, int movieID, int day, int month, int year){
   
      this.userID = userID;
      this.movieID = movieID;
      this.day = day;
      this.month = month;
      this.year = year;
   }
   
   public String getDate(){
      
      return day+"/"+month+"/"+year;
   
   }
   public int getDay(){
      
      return day;
   }
   public int getMonth(){
      
      return month;
   }
   public int getYear(){
      
   return year;
   
   }
   public void setDate(int day, int month, int year){
      this.day = day;
      this.month = month;
      this.year = year;
      
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