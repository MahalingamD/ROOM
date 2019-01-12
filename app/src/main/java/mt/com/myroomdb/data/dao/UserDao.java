package mt.com.myroomdb.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;


import java.util.List;

import mt.com.myroomdb.data.entity.User;

@Dao
public interface UserDao {

   @Insert
   void insert( User... user );

   @Update
   void update( User... user );

   @Delete
   void delete( User... user );

   @Query("SELECT * FROM user")
   List<User> getAllUser();
}
