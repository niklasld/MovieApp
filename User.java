public class User{

   private int ID;
   private String username, password;
   private boolean admin = false;

   public User(int ID, String username, String password, boolean admin){
      this.ID = ID;
      this.username = username;
      this.password = password;
   
   }
   
   public int getID(){
   return ID;
   }

   public String getUsername(){
   return username;
   }

   public String getPassword(){
      return password;
   }
   public void setAdmin(boolean admin){
      this.admin = admin;
   }
}