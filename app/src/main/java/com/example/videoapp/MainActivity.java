package com.example.videoapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.customview.widget.Openable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.videoapp.home.Home;
import com.example.videoapp.message.Message;
import com.example.videoapp.video.Video;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    BottomNavigationView bottomNavigationView;

    NavController navController;
    private void init(){
        navController = Navigation.findNavController(this, R.id.fragment_container);

        NavigationUI.setupWithNavController(bottomNavigationView, navController);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_nav);

        init();

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                if(destination.getId() == R.id.navigation_home){
                    bottomNavigationView.getMenu().getItem(0).setChecked(true);
                }
                else if(destination.getId() == R.id.navigation_search){
                    bottomNavigationView.getMenu().getItem(1).setChecked(true);
                }
                else if(destination.getId() == R.id.navigation_message){
                    bottomNavigationView.getMenu().getItem(3).setChecked(true);
                }
                else if(destination.getId() == R.id.navigation_profile){
                    bottomNavigationView.getMenu().getItem(4).setChecked(true);
                }
            }
        });

    }

    private boolean isValidDesitnation(int dest){
        return dest != Navigation.findNavController(this, R.id.fragment_container).getCurrentDestination().getId();
    }

    NavBackStackEntry mycheck(int dest){
        try{
            return Navigation.findNavController(this, R.id.fragment_container).getBackStackEntry(dest);
        }
        catch (Exception e){
            return null;
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch( item.getItemId()){
            case R.id.nav_home:
                if(isValidDesitnation(R.id.navigation_home)){
                    Navigation.findNavController(this, R.id.fragment_container).navigate(R.id.navigation_home);
                }
                break;
            case R.id.nav_search:
                if(isValidDesitnation(R.id.navigation_search)){
                    Navigation.findNavController(this, R.id.fragment_container).navigate(R.id.navigation_search);
                }
                break;
            case R.id.nav_message:
                if(isValidDesitnation(R.id.navigation_message)){
                    Navigation.findNavController(this, R.id.fragment_container).navigate(R.id.navigation_message);
                }
                break;
            case R.id.nav_profile:
                NavOptions navOptions = new NavOptions.Builder()
                        .setPopUpTo(R.id.mobile_navigation, true)
                        .build();

                Navigation.findNavController(this, R.id.fragment_container).navigate(R.id.navigation_profile, null, navOptions);
                break;
        }

        item.setChecked(true);

        return true;
    }
}