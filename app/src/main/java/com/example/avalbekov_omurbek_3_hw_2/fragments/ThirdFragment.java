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

public class ThirdFragment extends Fragment {

    Bundle bundle;
    Button buttonThird;
    EditText editTextStudyPlace;
    EditText editTextWorkPlace;
    String studyPlace, workPlace, name, surname, age, gender;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findView();
        setClick();
    }

    private void findView() {
        buttonThird = requireActivity().findViewById(R.id.button_save_third_fragment);
        editTextStudyPlace = requireActivity().findViewById(R.id.edit_text_study_place);
        editTextWorkPlace = requireActivity().findViewById(R.id.edit_text_work_place);
    }

    private void setClick() {
        buttonThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = getArguments().getString("name");
                surname = getArguments().getString("surname");
                age = getArguments().getString("age");
                gender = getArguments().getString("gender");
                studyPlace = editTextStudyPlace.getText().toString();
                workPlace = editTextWorkPlace.getText().toString();
                if (studyPlace.length() > 5 && workPlace.length() > 4) {
                    navigateToFourth();
                } else {
                    Toast.makeText(getActivity(),
                            "Некорректное название места учебы или работы",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void navigateToFourth() {
        bundle = new Bundle();
        bundle.putString("name", name);
        bundle.putString("surname", surname);
        bundle.putString("age", age);
        bundle.putString("gender", gender);
        bundle.putString("study", studyPlace);
        bundle.putString("work", workPlace);

        FourthFragment fourthFragment = new FourthFragment();
        fourthFragment.setArguments(bundle);
        requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_view, fourthFragment)
                .addToBackStack(null)
                .commit();
    }

}
