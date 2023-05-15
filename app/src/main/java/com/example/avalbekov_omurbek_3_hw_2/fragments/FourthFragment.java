package com.example.avalbekov_omurbek_3_hw_2.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.avalbekov_omurbek_3_hw_2.R;

public class FourthFragment extends Fragment {

    TextView name;
    TextView surname;
    TextView age;
    TextView gender;
    TextView studyPlace;
    TextView workPlace;
    String savedName;
    String savedSurname;
    String savedAge;
    String savedGender;
    String savedStudyPlace;
    String savedWorkPlace;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fourth, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findView();
        showInfo();
        setText();
    }

    private void findView() {
        name = requireView().findViewById(R.id.text_view_fourth_fragment_name);
        surname = requireView().findViewById(R.id.text_view_fourth_fragment_surname);
        age = requireView().findViewById(R.id.text_view_fourth_fragment_age);
        gender = requireView().findViewById(R.id.text_view_fourth_fragment_gender);
        studyPlace = requireView().findViewById(R.id.text_view_fourth_fragment_study_place);
        workPlace = requireView().findViewById(R.id.text_view_fourth_fragment_work_place);
    }

    private void showInfo() {
        assert getArguments() != null;
        savedName = getArguments().getString("name");
        savedSurname = getArguments().getString("surname");
        savedAge = getArguments().getString("age");
        savedGender = getArguments().getString("gender");
        savedStudyPlace = getArguments().getString("study");
        savedWorkPlace = getArguments().getString("work");
    }

    @SuppressLint("SetTextI18n")
    private void setText() {
        name.setText("Имя: " + savedName);
        surname.setText("Фамилия: " + savedSurname);
        age.setText("Возраст: " + savedAge);
        gender.setText("Пол: " + savedGender);
        studyPlace.setText("Место учебы: " + savedStudyPlace);
        workPlace.setText("Место работы: " + savedWorkPlace);
    }
}
