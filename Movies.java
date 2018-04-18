public class Movies{

   private int ID;
   private String title;
   private int releaseYear;
   //private String[] actor;
   
   public Movies(int ID, String title, int releaseYear){
   
      this.ID = ID;
      this.title = title;
      this.releaseYear = releaseYear;
   
   }
   
   public void setTitle(String title){
   
      this.title = title;
   
   }
   
   public void setYear(int releaseYear){
   
      this.releaseYear = releaseYear;
   
   }
   
   public int getID(){
   
      return ID;
   
   }
   
   public String getTitle(){
   
      return title;
   
   }
   
   public int getYear(){
   
      return releaseYear;
   
   }

}