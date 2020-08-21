package com.example.demo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.demo.lifecycle.LocationObserver;
import com.example.demo.lifecycle.MyLifecycleService;
import com.example.demo.livadata.LiveDataActivity;
import com.example.demo.viewmodel.ViewModelActivity;

public class MainActivity extends AppCompatActivity implements LifecycleOwner, LocationObserver.OnLocationChangeListener {

    LocationObserver observer;

    private AppBarConfiguration appBarConfiguration;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        observer = new LocationObserver(this, this);
        getLifecycle().addObserver(observer);

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        /*findViewById(R.id.start).setOnClickListener(v -> {
            Intent intent = new Intent(this, MyLifecycleService.class);
            startService(intent);
        });

        findViewById(R.id.stop).setOnClickListener(v -> {
            Intent intent = new Intent(this, MyLifecycleService.class);
            stopService(intent);
        });*/


        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            //界面切换时，回调方法
            Log.e("TAG", "界面发生了切换");
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return NavigationUI.onNavDestinationSelected(item, navController) ||
                super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp();
    }

    @Override
    public void onLocationChange() {
        Log.e("TAG", "onLocationChange");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    public void toViewModel(View view) {
        startActivity(new Intent(MainActivity.this, ViewModelActivity.class));
    }

    public void toLiveData(View view) {
        startActivity(new Intent(MainActivity.this, LiveDataActivity.class));
    }
}