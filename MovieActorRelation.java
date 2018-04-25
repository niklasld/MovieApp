public class MovieActorRelation{

   private int movieID;
   private int actorID;
   
   public MovieActorRelation(int movieID, int actorID){
   
      this.movieID = movieID;
      this.actorID = actorID;
   
   }
   
   public void setMovieID(int movieID){
   
      this.movieID = movieID;
   
   }
   
   public void setActorID(int actorID){
   
      this.actorID = actorID;
   
   }
   
   public int getMovieID(){
   
      return movieID;
   
   }
   
   public int getActorID(){
   
      return actorID;
   
   }

}