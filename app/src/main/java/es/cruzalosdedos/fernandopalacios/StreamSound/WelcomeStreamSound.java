package es.cruzalosdedos.fernandopalacios.StreamSound;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Outline;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageButton;
import android.widget.Toast;


public class WelcomeStreamSound extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         // toolbar Material compatibility support
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        // crear sombras que simulen perspectivas sobre el eje z
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() {

                @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void getOutline(View view, Outline outline) {
                    int tabSize = getResources().getDimensionPixelSize(R.dimen.fab_size);
                    outline = new Outline();
                    outline.setOval(0, 0, tabSize, tabSize);
                }
            };

            ImageButton welcomeBtn = (ImageButton) findViewById(R.id.image_button_welcome);
            welcomeBtn.setOutlineProvider(viewOutlineProvider);
            welcomeBtn.setClipToOutline(true);
        }*/

    }

    public void loadMyMusic( View buttonWelcome ){
       Toast welcomeToast = Toast.makeText(getBaseContext(), "Acceso a la aplicación", Toast.LENGTH_SHORT );
       welcomeToast.show();
       
       Intent startMyMusic = new Intent(this, MyMusic.class);
       startActivity(startMyMusic);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
