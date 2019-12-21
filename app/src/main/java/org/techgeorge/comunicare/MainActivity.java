package org.techgeorge.comunicare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.techgeorge.comunicare.fragments.CustomFragment;
import org.techgeorge.comunicare.fragments.HomeFragment;
import org.techgeorge.comunicare.fragments.SpeakFragment;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creating fragment transition
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //adding fragment to current activity
        Fragment fragment = new HomeFragment();
        fragmentTransaction.add(R.id.fragment_layout, fragment);
        fragmentTransaction.commit();

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navlistener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navlistener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment fragment = null;
            switch(menuItem.getItemId()) {
                case R.id.navigation_home:
                    fragment = new HomeFragment();
                    break;
                case R.id.navigation_custom:
                    fragment = new CustomFragment();
                    break;
                case R.id.navigation_dashboard:
                    fragment = new SpeakFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout,
                    fragment).commit();
            return true;
        }
    };
}
