package mt.com.myroomdb;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

   Button mySubButton;

   TextInputEditText myUserNmaeEDT, myPasswordEDT;
   TextInputLayout myUsernameTXTLayout, myPasswordTXTLayout;

   @Override
   protected void onCreate( Bundle savedInstanceState ) {
      super.onCreate( savedInstanceState );
      setContentView( R.layout.activity_login );

      init();
   }

   private void init() {
      mySubButton = findViewById( R.id.login_submit_but );

      myUserNmaeEDT = findViewById( R.id.login_user_name_EDT );
      myPasswordEDT = findViewById( R.id.login_password_EDT );

      myUsernameTXTLayout = findViewById( R.id.login_user_name_TILayout );
      myPasswordTXTLayout = findViewById( R.id.login_password_TILayout );

      clickListener();
   }

   private void clickListener() {

      myUserNmaeEDT.addTextChangedListener( new TextWatcher() {
         @Override
         public void beforeTextChanged( CharSequence charSequence, int i, int i1, int i2 ) {

         }

         @Override
         public void onTextChanged( CharSequence charSequence, int i, int i1, int i2 ) {

            if( charSequence.length() == 0 ) {
               myUsernameTXTLayout.setErrorEnabled( true );
               myUsernameTXTLayout.setError( getString( R.string.label_error_user_name ) );
            } else {
               myUsernameTXTLayout.setErrorEnabled( false );
            }
         }

         @Override
         public void afterTextChanged( Editable editable ) {

         }
      } );


      myPasswordEDT.addTextChangedListener( new TextWatcher() {
         @Override
         public void beforeTextChanged( CharSequence charSequence, int i, int i1, int i2 ) {

         }

         @Override
         public void onTextChanged( CharSequence charSequence, int i, int i1, int i2 ) {
            if( charSequence.length() == 0 ) {
               myPasswordTXTLayout.setErrorEnabled( true );
               myPasswordTXTLayout.setError( getString( R.string.label_error_password ) );
            } else {
               myPasswordTXTLayout.setErrorEnabled( false );
            }
         }

         @Override
         public void afterTextChanged( Editable editable ) {

         }
      } );


      myUserNmaeEDT.setOnEditorActionListener( ( textView, i, keyEvent ) -> {
         if( myUserNmaeEDT.getText() == null || myUserNmaeEDT.getText().toString().equals( "" ) ) {
            myUsernameTXTLayout.setErrorEnabled( true );
            myUsernameTXTLayout.setError( getString( R.string.label_error_user_name ) );
         }
         return false;
      } );

      myPasswordEDT.setOnEditorActionListener( ( textView, i, keyEvent ) -> {
         validation();
         return false;
      } );


      mySubButton.setOnClickListener( view -> {
         validation();
      } );
   }

   private void validation() {
      if( myUserNmaeEDT.getText() == null || myUserNmaeEDT.getText().toString().equals( "" ) ) {
         myUsernameTXTLayout.setErrorEnabled( true );
         myUsernameTXTLayout.setError( getString( R.string.label_error_user_name ) );
      } else if( myPasswordEDT.getText() == null || myPasswordEDT.getText().toString().equals( "" ) ) {
         myPasswordTXTLayout.setErrorEnabled( true );
         myPasswordTXTLayout.setError( getString( R.string.label_error_password ) );
      } else if( myUserNmaeEDT.getText().toString().equalsIgnoreCase( getString( R.string.label_admin ) ) &&
              myPasswordEDT.getText().toString().equalsIgnoreCase( getString( R.string.label_admin ) ) ) {
         startActivity( new Intent( LoginActivity.this, MainActivity.class ) );
         LoginActivity.this.finish();
      } else {
         myUsernameTXTLayout.setErrorEnabled( false );
         myPasswordTXTLayout.setErrorEnabled( false );
         Toast.makeText( LoginActivity.this, R.string.label_valid_username_password, Toast.LENGTH_SHORT ).show();
      }
   }

}
