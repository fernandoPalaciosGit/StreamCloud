package es.cruzalosdedos.fernandopalacios.StreamSound;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.Outline;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageButton;
import android.widget.Toast;

import es.cruzalosdedos.fernandopalacios.StreamSound.fragments.FragmentFriend;
import es.cruzalosdedos.fernandopalacios.StreamSound.fragments.FragmentSong;
import es.cruzalosdedos.fernandopalacios.StreamSound.fragments.FragmentProfile;

public class MyMusic extends Activity implements ActionBar.TabListener {
    private ActionBar actionBar;
    private Fragment[] toolbarFragment = new Fragment[]{
        new FragmentSong(), new FragmentFriend(), new FragmentProfile()
    };
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_music);

        setToolbarTabs();
        setToolbarFragments();
        setFABLoadMyMusic();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void imgBtnSahadowFAB( ImageButton imgBtn, final int resShadowSize){
        ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() {

            @Override
            public void getOutline(View view, Outline outline) {
                outline.setOval(0, 0, resShadowSize, resShadowSize);
            }
        };
        imgBtn.setOutlineProvider(viewOutlineProvider);
        imgBtn.setClipToOutline(true);
    }
    
    private void setFABLoadMyMusic() {
        ImageButton loadMyMusicFab = (ImageButton) findViewById(R.id.load_my_music_fab);
        
        // FAB to access Friend Prefference
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            int tabSize = getResources().getDimensionPixelSize(R.dimen.fab_size);
            imgBtnSahadowFAB(loadMyMusicFab, tabSize);
        }

        loadMyMusicFab.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText( v.getContext(), "¡ Go My Music !", Toast.LENGTH_SHORT).show();
            }
        } );

    }

    // populate all content fragments and load first tab
    private void setToolbarFragments() {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction managerTransaction = manager.beginTransaction();

        for ( Fragment fragment : toolbarFragment ){
            managerTransaction.add( R.id.activity_my_music, fragment).hide(fragment);
        }

        managerTransaction.show( toolbarFragment[0] ).commit();
    }

    // customize action bar by tabs
    private void setToolbarTabs(){
        actionBar = getActionBar();
        actionBar.setNavigationMode( ActionBar.NAVIGATION_MODE_TABS );
        actionBar.addTab( actionBar.newTab().setText("Music").setTabListener(this));
        actionBar.addTab( actionBar.newTab().setText("Friends").setTabListener(this));
        actionBar.addTab( actionBar.newTab().setText("Profile").setTabListener(this));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_music, menu);
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

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        // cerrar todos los fragments y mostrar el seleccionado
        for ( Fragment fragment : toolbarFragment ){
            ft.hide(fragment);
        }

        ft.show( toolbarFragment[tab.getPosition()] );
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}