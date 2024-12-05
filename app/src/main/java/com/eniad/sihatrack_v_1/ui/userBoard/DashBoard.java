package com.eniad.sihatrack_v_1.ui.userBoard;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.eniad.sihatrack_v_1.R;
import com.eniad.sihatrack_v_1.database.MyDataBaseHelper;
import com.eniad.sihatrack_v_1.models.User;

public class DashBoard extends AppCompatActivity {

    int userId;
    Intent intent;
    MyDataBaseHelper dbHelper;
    User user;
    TextView textWelcome;

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
        dbHelper = new MyDataBaseHelper(this);
        intent = getIntent();
        userId = intent.getIntExtra("userId",-1);
        user = dbHelper.getUserById(userId);
        textWelcome = findViewById(R.id.welcometext);
        textWelcome.setText("Welcome "+user.getFirstname()+" "+user.getLastname()+" to your account");

    }
}