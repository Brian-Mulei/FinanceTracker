package com.mulei.financetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mulei.financetracker.databinding.ActivityHomepageBinding;

public class homepage extends AppCompatActivity {
    ActivityHomepageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();

        super.onCreate(savedInstanceState);
        binding=ActivityHomepageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1= new Intent(homepage.this, AddTransaction.class);
                startActivity(intent1);
            }
        });

    }
}