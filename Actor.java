public class Actor{

   private int ID;
   private String firstName;
   private String lastName;
   //private String[] movie;

   public Actor(int ID, String firstName, String lastName){
   
      this.ID = ID;
      this.firstName = firstName;
      this.lastName = lastName;
   
   }
   
   public void setFirstName(String firstName){
   
      this.firstName = firstName;
   
   }
   
   public void setLastName(String lastName){
   
      this.lastName = lastName;
   
   }
   
   public int getID(){
   
      return ID;
   
   }
   
   public String getFirstName(){
   
      return firstName;
   
   }
   
   public String getLastName(){
   
      return lastName;
   
   }

}