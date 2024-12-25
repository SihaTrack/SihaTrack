package com.eniad.sihatrack_v_1.ui.userBoard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eniad.sihatrack_v_1.R;
import com.eniad.sihatrack_v_1.database.MyDataBaseHelper;
import com.eniad.sihatrack_v_1.models.User;

public class ProfileFragment extends Fragment {

    int userId;
    MyDataBaseHelper dbHelper;
    TextView fullName,email,date_birth,gender,emailDisplay,passwordDisplay;

    public ProfileFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        fullName = v.findViewById(R.id.fullNamePrf);
        email = v.findViewById(R.id.emailPrf);
        date_birth = v.findViewById(R.id.dateOfBirthPrf);
        gender = v.findViewById(R.id.genderPrf);
        emailDisplay = v.findViewById(R.id.emailDisplayPrf);
        passwordDisplay = v.findViewById(R.id.passwordDisplayPrf);

        dbHelper = new MyDataBaseHelper(requireContext());

        Bundle args = getArguments();
        if (args != null) {
            userId = args.getInt("userId");

        }
        User user = dbHelper.getUserById(userId);
        fullName.setText(user.getFirstname()+" "+user.getLastname());
        email.setText(user.getEmail());
        date_birth.setText(user.getDate_birth());
        gender.setText(user.getGender());
        emailDisplay.setText(user.getEmail());
        passwordDisplay.setText(user.getPassword());

        return v;
    }
}