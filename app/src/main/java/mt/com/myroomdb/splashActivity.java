package mt.com.myroomdb;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import mt.com.myroomdb.data.AppDatabase;
import mt.com.myroomdb.data.dao.UserDao;
import mt.com.myroomdb.data.entity.User;

public class splashActivity extends AppCompatActivity {

   private FragmentActivity myContext;

   // instance of Handler
   private Handler myHandler = new Handler();
   private long DELAY_TIME_FOR_SPLASH_SCREEN = 3000;

   AppDatabase myDatabase;
   private UserDao myUserDao;

   @Override
   protected void onCreate( Bundle savedInstanceState ) {
      super.onCreate( savedInstanceState );
      setContentView( R.layout.activity_splash );


      myContext = this;
      myDatabase = AppDatabase.getDatabase( myContext );
      myUserDao = myDatabase.personModel();

      callLogin();

      List<User> aListUser = myUserDao.getAllUser();

      Log.e( "ERROR", "" + aListUser.size() );

   }

   private void callLogin() {
      Handler aHoldScreen = new Handler();
      aHoldScreen.postDelayed( () -> {
         try {
            Intent aIntent = new Intent( myContext, LoginActivity.class );
            aIntent.addFlags( Intent.FLAG_ACTIVITY_CLEAR_TOP );
            aIntent.addFlags( Intent.FLAG_ACTIVITY_NEW_TASK );
            startActivity( aIntent );
            myContext.finish();
         } catch( Exception e ) {
            e.printStackTrace();
         }
      }, DELAY_TIME_FOR_SPLASH_SCREEN );

   }
}
