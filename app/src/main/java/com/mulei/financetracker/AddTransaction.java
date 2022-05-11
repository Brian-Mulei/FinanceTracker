package com.mulei.financetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.mulei.financetracker.databinding.ActivityAddTransactionBinding;

public class AddTransaction extends AppCompatActivity {
ActivityAddTransactionBinding binding;
String type="";
FirebaseFirestore firestore;
FirebaseAuth firebaseAuth;
FirebaseUser firebaseUser;
//   ActivityA AddTransaction
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();

        binding= ActivityAddTransactionBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transaction);

        firestore=FirebaseFirestore.getInstance();
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseUser=firebaseAuth.getCurrentUser();
        binding.isExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                type="Expense";
                binding.isExpense.setChecked(true);
                binding.isIncome.setChecked(false);
            }
        });


        binding.isIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                type="Income";
                binding.isExpense.setChecked(false);
                binding.isIncome.setChecked(true);
            }
        });
        binding.addtrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String amount = binding.amount.getText().toString().trim();
                String note = binding.note.getText().toString().trim();

                if(amount.length() <=0){
                    return;
                }
             //   firestore.collection("Expenses").document(firebaseAuth.getUid())
            }
        });

    }
}