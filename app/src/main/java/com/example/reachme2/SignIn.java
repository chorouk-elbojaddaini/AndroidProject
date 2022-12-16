package com.example.reachme2;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class SignIn extends AppCompatActivity implements View.OnClickListener{
    private EditText Email, password;
    private TextView forget,register;
    private Button btnSignIn;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        Email = (EditText) findViewById(R.id.emailText);
        password = (EditText) findViewById(R.id.passwordText);

        btnSignIn = (Button) findViewById(R.id.signIn);
        btnSignIn.setOnClickListener(this);



        register = (TextView) findViewById(R.id.register);
        register.setOnClickListener(this);

        DB  = new DBHelper(this);

    }

    @Override

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.signIn:
                String userEmail = Email.getText().toString();
                String pass = password.getText().toString();

                if(userEmail.equals("") || pass.equals("")){
                    Toast.makeText(SignIn.this,"please enter all fields",Toast.LENGTH_SHORT).show();
                }else {
                    Boolean Checkpass = DB.checkPassword(userEmail,pass);
                    if(Checkpass == true){
                        Toast.makeText(SignIn.this,"Sign in successfully",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),ProfileActivity.class);
                        intent.putExtra("email",userEmail);
                        startActivity(intent);
                    }else {
                        Toast.makeText(SignIn.this,"Invalid email or password !",Toast.LENGTH_SHORT).show();

                    }

                }
                break;
            case R.id.register:
                startActivity(new Intent(this,SignUp.class));
                break;

  }

}
}