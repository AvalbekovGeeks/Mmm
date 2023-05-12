package com.example.masterclass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.masterclass.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.edPassword.getText().toString().equals("admin")){
                    binding.edPassword.setVisibility(View.GONE);
                    binding.edName.setVisibility(View.GONE);
                    binding.btRegistration.setVisibility(View.GONE);
                    binding.tvWelcome.setText("Hello " + binding.edName.getText().toString() + "!");
                    Toast.makeText(MainActivity.this, "Good!! :)", Toast.LENGTH_SHORT).show();

                    
                    
                    
                }else {
                    Toast.makeText(MainActivity.this, "Not Good!! :) ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}