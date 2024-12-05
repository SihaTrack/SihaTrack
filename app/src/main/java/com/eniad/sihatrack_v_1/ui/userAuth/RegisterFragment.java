package com.eniad.sihatrack_v_1.ui.userAuth;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.eniad.sihatrack_v_1.R;
import com.eniad.sihatrack_v_1.database.MyDataBaseHelper;
import com.eniad.sihatrack_v_1.models.User;

public class RegisterFragment extends Fragment {

    EditText dateBirthPicker,firstNameInp,lastNameInp,emailInp,passwordInp;
    String firstname, lastname,date_birth,gender,email,password;
    RadioGroup genderRadioGroup;
    Button btnRegister;
    TextView login;
    MyDataBaseHelper dbHelper;

    public RegisterFragment() {
        
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootv= inflater.inflate(R.layout.fragment_register, container, false);

        dateBirthPicker = rootv.findViewById(R.id.dateBirthPicker);
        login = rootv.findViewById(R.id.loginText);
        firstNameInp = rootv.findViewById(R.id.firstnameInp);
        lastNameInp = rootv.findViewById(R.id.lastnameInp);
        emailInp = rootv.findViewById(R.id.emailInp);
        passwordInp = rootv.findViewById(R.id.passwordInp);
        genderRadioGroup = rootv.findViewById(R.id.genderGroup);
        btnRegister = rootv.findViewById(R.id.registerButton);

        dbHelper = new MyDataBaseHelper(requireContext());

        dateBirthPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog dialog = new DatePickerDialog(requireContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {

                        dateBirthPicker.setText(String.valueOf(day)+"/"+String.valueOf(month)+"/"+String.valueOf(year));

                    }
                },2024,01,01);
                dialog.show();

            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                firstname = firstNameInp.getText().toString();
                lastname = lastNameInp.getText().toString();
                date_birth = dateBirthPicker.getText().toString();
                gender = genderRadioGroup.getCheckedRadioButtonId() == R.id.male ? "Male" : "Female";
                email = emailInp.getText().toString();
                password = passwordInp.getText().toString();
                if (firstname.isEmpty() || lastname.isEmpty() || date_birth.isEmpty() || email.isEmpty() || password.isEmpty()) {

                    Toast.makeText(getContext(), "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                User user = new User(firstname,lastname,date_birth,gender,email,password);
                dbHelper.addUser(user);
                firstNameInp.setText("");
                lastNameInp.setText("");
                dateBirthPicker.setText("");
                genderRadioGroup.clearCheck();
                emailInp.setText("");
                passwordInp.setText("");
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new LoginFragment());
            }
        });

        return rootv;
    }
    private void loadFragment(Fragment fragment){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setReorderingAllowed(true);
        transaction.replace(R.id.main_fragment_container,fragment,null);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}