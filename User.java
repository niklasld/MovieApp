public class User{

   private int ID;
   private String username, password;
   private boolean admin;

   public User(int ID, String username, String password, boolean admin){
      this.ID = ID;
      this.username = username;
      this.password = password;
      this.admin = admin;
   
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

   public boolean getAdmin(){
      return admin;
   }
   
   public void setAdmin(boolean admin){
      this.admin = admin;
   }
}