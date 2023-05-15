package com.example.avalbekov_omurbek_3_hw_2.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.avalbekov_omurbek_3_hw_2.R;

public class SecondFragment extends Fragment {
    Bundle bundle;
    Button buttonSecond;
    EditText editTextAge;
    EditText editTextGender;
    Integer age;
    String gender;
    String name, surname;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findView();
        setClick();
    }

    private void findView() {
        buttonSecond = requireActivity().findViewById(R.id.button_save_second_fragment);
        editTextAge = requireActivity().findViewById(R.id.edit_text_age);
        editTextGender = requireActivity().findViewById(R.id.edit_text_gender);
    }

    private void setClick() {
        buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = getArguments().getString("name");
                surname = getArguments().getString("surname");
                try {
                    age = Integer.valueOf(editTextAge.getText().toString());
                    gender = editTextGender.getText().toString();

                    if (age > 1 && age <= 90) {
                        if (gender.equals("m") || gender.equals("j")) {
                            navigateToThird();
                        } else {
                            Toast.makeText(getActivity(),
                                    "Некорректный тип: введите 'm' или 'j'",
                                    Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(getActivity(),
                                "Некорректный возраст",
                                Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(getActivity(),
                            "Допустимо вводить только целые числа",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void navigateToThird() {
        bundle = new Bundle();
        bundle.putString("name", name);
        bundle.putString("surname", surname);
        bundle.putString("age", String.valueOf(age));
        bundle.putString("gender", gender);

        ThirdFragment thirdFragment = new ThirdFragment();
        thirdFragment.setArguments(bundle);
        requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_view, thirdFragment)
                .addToBackStack(null)
                .commit();
    }

}
