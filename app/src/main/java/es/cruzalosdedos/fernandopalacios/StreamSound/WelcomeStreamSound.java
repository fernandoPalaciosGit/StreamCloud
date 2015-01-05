package es.cruzalosdedos.fernandopalacios.StreamSound;

import android.annotation.TargetApi;
import android.view.ViewOutlineProvider;
import android.widget.ImageButton;
import android.graphics.Outline;
import android.os.Build;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.PushService;


public class WelcomeStreamSound extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize Parse Lib
        Parse.initialize(this, "Vt4gXqAOIYYMiGyczIjJuM91sdDu8i9NPmsVm0Gv", "Q6TwVf1xEOBRqCFZNEq3iNqcMhpwAcC5W8uPa6Bo");
        PushService.setDefaultPushCallback(this, WelcomeStreamSound.class);
        ParseInstallation.getCurrentInstallation().saveInBackground();

         // toolbar Material compatibility support
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
        
        // crear sombras que simulen perspectivas sobre el eje z
        ImageButton welcomeBtnFb = (ImageButton) findViewById(R.id.image_button_welcome_facebook);
        ImageButton welcomeBtnGo = (ImageButton) findViewById(R.id.image_button_welcome_google);
        setFabAccessApp(welcomeBtnFb);
        setFabAccessApp(welcomeBtnGo);
    }

    private void setFabAccessApp(ImageButton btnAccess) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() {

                @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void getOutline(View view, Outline outline) {
                    int fabSize = getResources().getDimensionPixelSize(R.dimen.fab_size_wellcome);
                    outline.setOval(0, 0, (fabSize+5), (fabSize+5));
                }
            };

            btnAccess.setOutlineProvider(viewOutlineProvider);
            btnAccess.setClipToOutline(true);
        }
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
