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

public class FirstFragment extends Fragment {

    Bundle bundle;
    Button buttonFirst;
    EditText editTextName;
    EditText editTextSurname;
    String name;
    String surname;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findView();
        setClick();
    }

    private void navigateToSecond() {
        bundle = new Bundle();
        bundle.putString("name", name);
        bundle.putString("surname", surname);

        SecondFragment secondFragment = new SecondFragment();
        secondFragment.setArguments(bundle);

        requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_view, secondFragment)
                .addToBackStack(null)
                .commit();
    }

    private void setClick() {
        buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = editTextName.getText().toString();
                surname = editTextSurname.getText().toString();
                if (name.length() > 2 && surname.length() > 3) {
                    navigateToSecond();
                } else {
                    Toast.makeText(getActivity(),
                            "Некорректное имя или фамилия",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void findView() {
        buttonFirst = requireActivity().findViewById(R.id.button_save_first_fragment);
        editTextName = requireActivity().findViewById(R.id.edit_text_name);
        editTextSurname = requireActivity().findViewById(R.id.edit_text_surname);
    }

}
