package com.example.seniortasse.storemanagementapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class WelcomeScreen extends Activity implements View.OnClickListener{

    // Declare an instance of FirebaeAuth
    private FirebaseAuth mAuth;

    /* Declare variables for the widgets */
    EditText editTextEmail, editTextPassword;
    /* Declare the Welcome Page buttons (button "Log Me In",
     button "Register New User" */
    Button buttonLogin,buttonRegister;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        // Initialize the FirebaseAuth instance
        mAuth = FirebaseAuth.getInstance();

        /*Get references to the widgets*/
        buttonRegister = findViewById(R.id.buttonRegister);
        buttonLogin = findViewById(R.id.buttonLogin);
        editTextEmail = findViewById(R.id.editTextEMail);
        editTextPassword = findViewById(R.id.editTextPassword);

        //Make buttons listening to clicks
        buttonLogin.setOnClickListener(this);
        buttonRegister.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        /* When user clicks on button "Register New User",
        then ...*/
        if(v == buttonRegister) {

            /*An account is created with User Email and Password as entered
            the edit texts in case the entries are valid.
            A Success message is returned on successful registration.
            A Fail message is returned on unsuccessful registration*/
            mAuth.createUserWithEmailAndPassword(editTextEmail.getText().toString(), editTextPassword.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(WelcomeScreen.this, "You are successfully registered. Let's go in the store.", Toast.LENGTH_SHORT).show();
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(WelcomeScreen.this, "The registration failed. Please, review your credentials.", Toast.LENGTH_SHORT).show();
                            }

                            // ...
                        }
                    });
        }
        /*When user clicks on button "Log Me In",
        then ...*/
        else if(v == buttonLogin) {

            /*User is signed in his account if his/her credentials are correctly
            entered. */
            mAuth.signInWithEmailAndPassword(editTextEmail.getText().toString(), editTextPassword.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information

                                FirebaseUser user = mAuth.getCurrentUser();
                                Toast.makeText(WelcomeScreen.this, "Login successful", Toast.LENGTH_SHORT).show();
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(WelcomeScreen.this, "Access denied. You may register first before signing in.", Toast.LENGTH_SHORT).show();
                            }

                            // ...
                        }
                    });


        }

    }
}
