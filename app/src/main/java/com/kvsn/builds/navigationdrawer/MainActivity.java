package com.kvsn.builds.navigationdrawer;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity
{
    DrawerLayout dl;
    NavigationView nv;
    android.support.v7.widget.Toolbar tb;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dl = findViewById(R.id.dl);
        nv = findViewById(R.id.nav_view);
        tb = findViewById(R.id.toolbar);

        setSupportActionBar(tb);
        ActionBar ab = getSupportActionBar();
        ab.setTitle("Welcome");
        ab.setLogo(R.mipmap.ic_launcher);
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setHomeAsUpIndicator(R.drawable.ic_menu_black_18dp);

        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                dl.closeDrawers();//used to close the navigaton drawer after an item is clicked..
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int k = item.getItemId();
        switch (k)
        {
            case android.R.id.home:
                dl.openDrawer(Gravity.START);
                break;
        }
        return true;
    }
}
