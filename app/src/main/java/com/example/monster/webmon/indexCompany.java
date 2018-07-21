package com.example.monster.webmon;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

public class indexCompany extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout mdraw;
    private ActionBarDrawerToggle mtoggle;
    private Toolbar mtool;
    //public TextView tx;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index_company);
      //  tx = (TextView)findViewById(R.id.tag);
        mdraw = (DrawerLayout) findViewById(R.id.main);
        mtoggle = new ActionBarDrawerToggle(this, mdraw, R.string.open, R.string.close);
        mtool = (Toolbar)findViewById(R.id.nav_action);
        setSupportActionBar(mtool);
        //registerForContextMenu(tx);
        mdraw.addDrawerListener(mtoggle);
        mtoggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        NavigationView nav_view = (NavigationView)findViewById(R.id.navigation_view);
        nav_view.setNavigationItemSelectedListener(this);
        Fragment fragment = new menu1();

        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flContent, fragment);
            ft.commit();
        }



    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        //Class fragmentClass;
        switch (item.getItemId()) {

            case R.id.home:
                fragment = new menu1();
                //fragmentClass = MainActivity.class;
                break;

            case R.id.about:
                fragment = new menu2();
                //fragmentClass = info.class;
                break;
            case R.id.contact:
                fragment = new menu3();
                //fragmentClass = register.class;
                break;
            default:
                fragment = new menu2();
                //fragmentClass = info.class
                break;
        }
//        try {
//            fragment = (Fragment) fragmentClass.newInstance();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flContent, fragment);
            ft.commit();
        }

        // Insert the fragment by replacing any existing fragment
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
//
//        item.setChecked(true);
//        setTitle(item.getTitle());

        //close navigation drawer
        mdraw.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
        menu.setHeaderTitle("Select The Action");
    }
    @Override
    public boolean onContextItemSelected(MenuItem item){
        if(item.getItemId()==R.id.copy){
            Toast.makeText(getApplicationContext(),"Copied",Toast.LENGTH_LONG).show();
        }
        else if(item.getItemId()==R.id.search){
            Toast.makeText(getApplicationContext(),"Search",Toast.LENGTH_LONG).show();
        }else{
            return false;
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mtoggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showInfo(View v){
        NavigationView nav_view = (NavigationView)findViewById(R.id.navigation_view);
        nav_view.setNavigationItemSelectedListener(this);
        Fragment fragment = new menu2();

        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flContent, fragment);
            ft.commit();
        }
    }


    public void call(View v){
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            String phone = "+918347844601";
            Intent i = new Intent(Intent.ACTION_CALL, Uri.fromParts("tel", phone, null));
            startActivity(i);
        }else{
            Toast.makeText(this,"Please give the permission", Toast.LENGTH_LONG).show();
        }
    }

    public void map(View v){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.co.in/maps?q=Christ+University+Bangalore,Hosur+Road") );
        startActivity(i);
    }

    public void emailMe(View v){
        Intent i = new Intent(Intent.ACTION_SENDTO);
        i.setData(Uri.parse("mailto:"));
        i.putExtra(Intent.EXTRA_EMAIL  , new String[] { "me@somewhere.com" });
        i.putExtra(Intent.EXTRA_SUBJECT, "My subject");

        startActivity(Intent.createChooser(i, "Email via..."));

    }
    public void web(View v){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ronli.xyz"));
        startActivity(i);
    }
}
