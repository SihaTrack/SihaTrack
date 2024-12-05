package com.eniad.sihatrack_v_1.ui.userAuth;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.eniad.sihatrack_v_1.R;
import com.eniad.sihatrack_v_1.database.MyDataBaseHelper;
import com.eniad.sihatrack_v_1.models.User;
import com.eniad.sihatrack_v_1.ui.userBoard.DashBoard;

public class LoginFragment extends Fragment {

    EditText loginEmailInp;
    EditText loginPasswordInp;
    Button loginButton;
    String email;
    String password;
    TextView registerText;
    MyDataBaseHelper dbHelper;


    public LoginFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootV =  inflater.inflate(R.layout.fragment_login, container, false);

        loginEmailInp = rootV.findViewById(R.id.loginEmailInp);
        loginPasswordInp = rootV.findViewById(R.id.loginPasswordInp);
        loginButton = rootV.findViewById(R.id.loginButton);
        registerText = rootV.findViewById(R.id.registerText);

        dbHelper = new MyDataBaseHelper(requireContext());

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = loginEmailInp.getText().toString();
                password = loginPasswordInp.getText().toString();
                if (email.isEmpty() || password.isEmpty()) {

                    Toast.makeText(getContext(), "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                User user = dbHelper.getUserByEmailAndPassword(email,password);
                if (user != null) {
                    Toast.makeText(getContext(), "Welcome " + user.getFirstname(), Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(requireContext(), DashBoard.class);
                    intent.putExtra("userId",user.getUserId());
                    startActivity(intent);
                } else {
                    Toast.makeText(getContext(), "Invalid email or password", Toast.LENGTH_SHORT).show();
                }
                loginEmailInp.setText("");
                loginPasswordInp.setText("");
            }
        });

        registerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new RegisterFragment());
            }
        });

        return  rootV;
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