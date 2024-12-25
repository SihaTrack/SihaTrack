package com.eniad.sihatrack_v_1.ui.userBoard;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eniad.sihatrack_v_1.R;
import com.eniad.sihatrack_v_1.database.MyDataBaseHelper;
import com.eniad.sihatrack_v_1.models.User;
import com.eniad.sihatrack_v_1.ui.userActivities.articles.DiabetesArticlsActivity;
import com.eniad.sihatrack_v_1.ui.userActivities.DiabetesPrediction;
import com.eniad.sihatrack_v_1.ui.userActivities.HeartAttackPredictionActivity;
import com.eniad.sihatrack_v_1.ui.userActivities.exercices.ExercicesActivity;


public class HomeFragment extends Fragment {

    int userId;
    MyDataBaseHelper dbHelper;
    TextView welcome;
    CardView heartAttackCard,diabetesCard,diabetesArticlsCard,exerciceCard;


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, container, false);
        welcome = v.findViewById(R.id.welcomeText);
        dbHelper = new MyDataBaseHelper(getContext());
        heartAttackCard = v.findViewById(R.id.heartAttackCard);
        diabetesCard = v.findViewById(R.id.diabetesCard);
        diabetesArticlsCard = v.findViewById(R.id.articlCard);
        exerciceCard = v.findViewById(R.id.exerciceCard);

        Bundle args = getArguments();
        if (args != null) {
            userId = args.getInt("userId");

        }
        User user = dbHelper.getUserById(userId);

        welcome.setText("Welcome "+user.getFirstname()+" "+user.getLastname()+" to your dashboard");
        heartAttackCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(requireContext(), HeartAttackPredictionActivity.class);
                startActivity(intent);
            }
        });

        diabetesCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(requireContext(), DiabetesPrediction.class);
                startActivity(intent);
            }
        });
        diabetesArticlsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(requireContext(), DiabetesArticlsActivity.class);
                startActivity(intent);
            }
        });

        exerciceCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(requireContext(), ExercicesActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }
}