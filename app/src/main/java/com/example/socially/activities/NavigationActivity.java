package com.example.socially.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.socially.R;
import com.example.socially.databinding.ActivityNavigationBinding;
import com.example.socially.fragments.ChatPageFragment;
import com.example.socially.fragments.FavPageFragment;
import com.example.socially.fragments.MainPageFragment;
import com.example.socially.fragments.ProfilePageFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NavigationActivity extends AppCompatActivity {

    private ActivityNavigationBinding binding;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNavigationBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        binding = DataBindingUtil.setContentView(this, R.layout.activity_navigation);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        binding.bottomAppBar.setVisibility(View.VISIBLE);
        binding.view.setVisibility(View.GONE);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentHold,new MainPageFragment()).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment=null;

                switch (item.getItemId())
                {
                    case R.id.mainPageFragment:
                        fragment=new MainPageFragment();
                        break;
                    case R.id.chatPageFragment:
                        fragment=new ChatPageFragment();
                        binding.bottomAppBar.setVisibility(View.GONE);
                        binding.view.setVisibility(View.VISIBLE);

                        break;
                    case R.id.favPageFragment:
                        fragment=new FavPageFragment();
                        break;
                    case R.id.profilePageFragment:
                        fragment=new ProfilePageFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentHold,fragment).commit();

                return true;
            }
        });

        hideSystemBars();




    }

    private void hideSystemBars() {
        WindowInsetsControllerCompat windowInsetsController =
                ViewCompat.getWindowInsetsController(getWindow().getDecorView());

        if (windowInsetsController == null)
        {
            return;
        }

        windowInsetsController.setSystemBarsBehavior(
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);
        windowInsetsController.hide(WindowInsetsCompat.Type.systemBars());
    }
}