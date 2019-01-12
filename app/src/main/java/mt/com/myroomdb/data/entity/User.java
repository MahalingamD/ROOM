package mt.com.myroomdb.data.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "user")
public class User {

   @PrimaryKey(autoGenerate = true)
   public long id;
   public String UserName;
   public String UserPassword;
   public String UserPlace;

   public String getUserPlace() {
      return UserPlace;
   }


   public long getId() {
      return id;
   }

   public String getUserName() {
      return UserName;
   }

   public String getUserPassword() {
      return UserPassword;
   }

   public User( String aName, String aMobile, String aPlace ) {
      UserName = aName;
      UserPassword = aMobile;
      UserPlace = aPlace;
   }


   public User() {
      this.UserName = "";
      this.UserPassword = "";
      this.UserPlace = "";
   }
}
