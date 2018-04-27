public class Actor{

   private int ID;
   private String firstName;
   private String lastName;
   private boolean visible;

   public Actor(int ID, String firstName, String lastName,boolean visible){
   
      this.ID = ID;
      this.firstName = firstName;
      this.lastName = lastName;
      this.visible = visible;
   
   }
   public void setVisible(boolean visible) {
      this.visible = visible;
   }
   
   public boolean getVisible() {
      return visible;
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