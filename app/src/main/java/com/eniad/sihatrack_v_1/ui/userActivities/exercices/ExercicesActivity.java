package com.eniad.sihatrack_v_1.ui.userActivities.exercices;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.eniad.sihatrack_v_1.R;

public class ExercicesActivity extends AppCompatActivity {

    private TextView exerciceDescription;
    private Button btnShowExercice1, btnShowExercice2, btnShowExercice3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exercices);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Initialisation des éléments de l'interface
        exerciceDescription = findViewById(R.id.exerciceDescription);
        btnShowExercice1 = findViewById(R.id.btnShowExercice1);
        btnShowExercice2 = findViewById(R.id.btnShowExercice2);
        btnShowExercice3 = findViewById(R.id.btnShowExercice3);

        // Action pour le premier exercice
        btnShowExercice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exerciceDescription.setText("Exercice 1 : Marche rapide (10 minutes)\n\n" +
                        "But : Améliorer l'endurance cardiovasculaire et réduire le stress.\n" +
                        "Instructions : Trouvez un endroit pour marcher, marchez à un rythme rapide pendant 10 minutes.");
                Toast.makeText(ExercicesActivity.this, "Exercice 1 affiché", Toast.LENGTH_SHORT).show();
            }
        });

        // Action pour le deuxième exercice
        btnShowExercice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exerciceDescription.setText("Exercice 2 : Squats (3 séries de 10 répétitions)\n\n" +
                        "But : Renforcer les muscles des jambes et améliorer la circulation sanguine.\n" +
                        "Instructions : Faites 3 séries de 10 squats.");
                Toast.makeText(ExercicesActivity.this, "Exercice 2 affiché", Toast.LENGTH_SHORT).show();
            }
        });

        // Action pour le troisième exercice
        btnShowExercice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exerciceDescription.setText("Exercice 3 : Respiration profonde (5 minutes)\n\n" +
                        "But : Réduire le stress et favoriser la relaxation.\n" +
                        "Instructions : Faites des respirations profondes pendant 5 minutes.");
                Toast.makeText(ExercicesActivity.this, "Exercice 3 affiché", Toast.LENGTH_SHORT).show();
            }
        });
    }

}