package mt.com.myroomdb;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import mt.com.myroomdb.data.AppDatabase;
import mt.com.myroomdb.data.dao.UserDao;
import mt.com.myroomdb.data.entity.User;

public class AddUserActivity extends AppCompatActivity implements View.OnClickListener {


   AppCompatActivity myContext;
   TextInputLayout myUsernameTXT, myPasswordTXT, myPlaceTXT;
   TextInputEditText myUserNameEDT, myPasswordEDT, myPlaceEDT;
   Button myAddBUT;

   AppDatabase myDatabase;
   UserDao myUserDao;


   @Override
   protected void onCreate( Bundle savedInstanceState ) {
      super.onCreate( savedInstanceState );
      setContentView( R.layout.activity_add_user );

      init();

   }

   private void init() {

      myContext = this;
      myDatabase = AppDatabase.getDatabase( myContext );

      myUserNameEDT = findViewById( R.id.add_text_user_EDT );
      myPasswordEDT = findViewById( R.id.add_text_password_EDT );
      myPlaceEDT = findViewById( R.id.add_text_place_EDT );

      myUsernameTXT = findViewById( R.id.add_text_user_txt );
      myPasswordTXT = findViewById( R.id.add_text_password_txt );
      myPlaceTXT = findViewById( R.id.add_text_place_txt );


      myAddBUT = findViewById( R.id.add_button );

      myAddBUT.setOnClickListener( this );

      myUserDao = myDatabase.personModel();

   }


   @Override
   public void onClick( View view ) {

      if( view.getId() == R.id.add_button ) {
         validation();
      }
   }

   private void validation() {
      if( myUserNameEDT.getText() == null || myUserNameEDT.getText().toString().equals( "" ) ) {
         myUsernameTXT.setErrorEnabled( true );
         myUsernameTXT.setError( getString( R.string.label_error_user_name ) );
      } else if( myPasswordEDT.getText() == null || myPasswordEDT.getText().toString().equals( "" ) ) {
         myPasswordTXT.setErrorEnabled( true );
         myPasswordTXT.setError( getString( R.string.label_error_password ) );
      } else if( myPlaceEDT.getText() == null || myPlaceEDT.getText().toString().equals( "" ) ) {
         myPlaceTXT.setErrorEnabled( true );
         myPlaceTXT.setError( getString( R.string.label_erroe_place ) );
      } else {
         myUsernameTXT.setErrorEnabled( false );
         myPasswordTXT.setErrorEnabled( false );
         myPlaceTXT.setErrorEnabled( false );

         User aUser = new User( myUserNameEDT.getText().toString(), myPasswordEDT.getText().toString(), myPlaceEDT.getText().toString() );
         myUserDao.insert( aUser );

         myUserNameEDT.setText( "" );
         myPasswordEDT.setText( "" );
         myPlaceEDT.setText( "" );
      }

   }
}
