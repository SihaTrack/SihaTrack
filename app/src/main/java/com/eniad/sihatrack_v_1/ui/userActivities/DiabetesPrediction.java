package com.eniad.sihatrack_v_1.ui.userActivities;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.eniad.sihatrack_v_1.R;




import org.tensorflow.lite.DataType;
import org.tensorflow.lite.Interpreter;


import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;


public class DiabetesPrediction extends AppCompatActivity {

    private Button predictButton;
    private TextView resultText;
    private EditText ageInput, bmiInput, smokingHistoryInput, hba1cInput, bloodGlucoseInput;
    private RadioGroup genderGroup;
    private CheckBox hypertensionCheck, heartDiseaseCheck;

    private Interpreter tflite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diabetes_prediction);

        ageInput = findViewById(R.id.ageInput);
        bmiInput = findViewById(R.id.bmiInput);
        smokingHistoryInput = findViewById(R.id.smokingHistoryInput);
        hba1cInput = findViewById(R.id.hba1cInput);
        bloodGlucoseInput = findViewById(R.id.bloodGlucoseInput);
        genderGroup = findViewById(R.id.genderGroup);
        hypertensionCheck = findViewById(R.id.hypertensionCheck);
        heartDiseaseCheck = findViewById(R.id.heartDiseaseCheck);
        resultText = findViewById(R.id.resultText);
        predictButton = findViewById(R.id.submitButton);

        try {
            tflite = new Interpreter(loadModelFile());
        } catch (IOException e) {
            Toast.makeText(this, "Error loading model", Toast.LENGTH_SHORT).show();
        }

        predictButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

    }

    private MappedByteBuffer loadModelFile() throws IOException {
        FileInputStream inputStream = new FileInputStream(getAssets().openFd("model.tflite").getFileDescriptor());
        FileChannel fileChannel = inputStream.getChannel();
        long startOffset = getAssets().openFd("model.tflite").getStartOffset();
        long declaredLength = getAssets().openFd("model.tflite").getDeclaredLength();
        return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength);
    }

    private void makePrediction() {
        // Parse input values
        try {
            float age = Float.parseFloat(ageInput.getText().toString());
            float bmi = Float.parseFloat(bmiInput.getText().toString());
            float smokingHistory = Float.parseFloat(smokingHistoryInput.getText().toString());
            float hba1c = Float.parseFloat(hba1cInput.getText().toString());
            float bloodGlucose = Float.parseFloat(bloodGlucoseInput.getText().toString());

            int gender = (genderGroup.getCheckedRadioButtonId() == R.id.maleRadio) ? 1 : 0;
            int hypertension = hypertensionCheck.isChecked() ? 1 : 0;
            int heartDisease = heartDiseaseCheck.isChecked() ? 1 : 0;

            // Create input array
            float[] input = {age, bmi, smokingHistory, hba1c, bloodGlucose, gender, hypertension, heartDisease};


        } catch (Exception e) {
            Toast.makeText(this, "Invalid input!", Toast.LENGTH_SHORT).show();
        }
    }

}
