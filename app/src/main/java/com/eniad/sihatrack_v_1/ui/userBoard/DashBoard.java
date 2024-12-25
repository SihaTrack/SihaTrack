package com.eniad.sihatrack_v_1.ui.userBoard;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.eniad.sihatrack_v_1.R;
import com.eniad.sihatrack_v_1.database.MyDataBaseHelper;
import com.eniad.sihatrack_v_1.models.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashBoard extends AppCompatActivity {

    int userId;
    Intent intent;
    MyDataBaseHelper dbHelper;
    User user;
    TextView textWelcome;
    BottomNavigationView nav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dash_board);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        userId = getIntent().getIntExtra("userId",-1);
        loadFragment(new HomeFragment(), userId);

        nav = findViewById(R.id.bottomNavigationView);
        nav.setSelectedItemId(R.id.home);
        nav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.home) {
                loadFragment(new HomeFragment(), userId);
                return true;
            } else if (id == R.id.profile) {
                loadFragment(new ProfileFragment(), userId);
                return true;
            } else if (id == R.id.settings) {
                loadFragment(new SettingsFragment(), -1);
                return true;
            }
            return false;
        });
    }

    private void loadFragment(Fragment fragment, int data) {
        Bundle bundle = new Bundle();
        bundle.putInt("userId", data);
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setReorderingAllowed(true);
        transaction.replace(R.id.dashBoard_fragment_container, fragment, null);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
