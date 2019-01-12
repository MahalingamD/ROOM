package mt.com.myroomdb.app;


import android.app.Application;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.migration.Migration;

import mt.com.myroomdb.data.AppDatabase;


public class AppController extends Application {

   public static final String TAG = AppController.class.getSimpleName();
   private static AppController myInstance;
   private AppDatabase db;


   public static synchronized AppController getInstance() {
      return myInstance;
   }

   @Override
   public void onCreate() {
      super.onCreate();
      myInstance = this;
     /* db = Room.databaseBuilder( this, AppDatabase.class, "rotogro_db" )
              .addMigrations( FROM_1_TO_2 ).build();*/

      Room.databaseBuilder( this, AppDatabase.class, "room_db" )
              .fallbackToDestructiveMigration()
              .build();
   }

   static final Migration FROM_1_TO_2 = new Migration( 1, 2 ) {
      @Override
      public void migrate( final SupportSQLiteDatabase database ) {
         //database.execSQL( "ALTER TABLE Repo ADD COLUMN createdAt TEXT" );
      }
   };
}