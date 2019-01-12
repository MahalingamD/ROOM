package mt.com.myroomdb.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import mt.com.myroomdb.data.dao.UserDao;
import mt.com.myroomdb.data.entity.User;


@Database(entities = { User.class }, version = 1)
public abstract class AppDatabase extends RoomDatabase {

   private static AppDatabase INSTANCE;

   public abstract UserDao personModel();


   public static AppDatabase getDatabase( Context context ) {
      if( INSTANCE == null ) {
         INSTANCE = Room.databaseBuilder( context.getApplicationContext(), AppDatabase.class, "room_db" )
                 .allowMainThreadQueries()
                 .build();
      }
      return INSTANCE;
   }

   public static AppDatabase getMemoryDatabase( Context context ) {
      if( INSTANCE == null ) {
         INSTANCE = Room.inMemoryDatabaseBuilder( context.getApplicationContext(), AppDatabase.class )
                 .allowMainThreadQueries()
                 .build();
      }
      return INSTANCE;
   }

   public static void destroyInstance() {
      INSTANCE = null;
   }

}
