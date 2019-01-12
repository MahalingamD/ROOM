package mt.com.myroomdb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

   LinearLayout myAddUserLAY, myDeleteLAY, myViewLay;

   @Override
   protected void onCreate( Bundle savedInstanceState ) {
      super.onCreate( savedInstanceState );
      setContentView( R.layout.activity_main );

      init();
   }

   private void init() {
      myAddUserLAY = findViewById( R.id.add_layout );
      myDeleteLAY = findViewById( R.id.delete_layout );
      myViewLay = findViewById( R.id.view_layout );

      myAddUserLAY.setOnClickListener( this );
      myDeleteLAY.setOnClickListener( this );
      myViewLay.setOnClickListener( this );
   }

   @Override
   public void onClick( View view ) {

      switch( view.getId() ) {

         case R.id.add_layout: {
            startActivity( new Intent( MainActivity.this, AddUserActivity.class ) );

            break;
         }
         case R.id.delete_layout: {
            break;
         }
         case R.id.view_layout: {
            break;
         }
         default: {
            break;
         }
      }


   }
}
