package com.mulei.financetracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.mulei.financetracker.databinding.ActivityMainBinding;
import com.mulei.financetracker.databinding.ActivitySignUpBinding;

public class SignUp extends AppCompatActivity {
    ActivitySignUpBinding binding;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        binding= ActivitySignUpBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
   //     email_signup"
     //   password_signup"
firebaseAuth=FirebaseAuth.getInstance();

binding.gotologin.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent= new Intent(SignUp.this, MainActivity.class);
        try{
            startActivity(intent);
        }catch (Exception e){

        }
    }
});


         binding.btnsignup.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                String email = binding.emailSignup.getText().toString();
                String password = binding.passwordSignup.getText().toString();
                if(email.trim().length()<=0 || password.trim().length()<=0){
                    return;
                }
                 firebaseAuth.createUserWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                     @Override
                     public void onSuccess(AuthResult authResult) {
                         Toast.makeText(SignUp.this,"Successful Registration", Toast.LENGTH_SHORT).show();
                         Intent intent1= new Intent(SignUp.this, homepage.class);
                         startActivity(intent1);
                     }
                 }).addOnFailureListener(new OnFailureListener() {
                     @Override
                     public void onFailure(@NonNull Exception e) {
                         Toast.makeText(SignUp.this," Registration Failed" + e.getMessage(), Toast.LENGTH_SHORT).show();

                     }
                 });
             }
         });
    }
}