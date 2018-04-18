public class History{

   private int ID, date, movieID, userID;
   
   public History(int ID, int date, int movieID, int userID){
   
      this.ID = ID;
      this.date = date;
      this.movieID = movieID;
      this.userID = userID;
   
   }
   
   public void setDate(int date){
   
      this.date = date;
   
   }
   
   public void setMovieID(int movieID){
   
      this.movieID = movieID;
   
   }
   
   public void setUserID(int userID){
   
      this.userID = userID;
   
   }
   
   public int getID(){
   
      return ID;
   
   }
   
   public int getDate(){
   
      return date;
   
   }
   
   public int getMovieID(){
   
      return movieID;
   
   }
   
   public int getUserID(){
   
      return userID;
    
   }


}