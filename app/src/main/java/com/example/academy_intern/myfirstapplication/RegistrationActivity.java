package com.example.academy_intern.myfirstapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity{

    private EditText firstname;
    private EditText lastname;
    private EditText age;
    private EditText username;
    private EditText password;
    private Button register;
    private TextView logii;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

    }

 public void regButt(View v)
 {
     firstname = (EditText) findViewById(R.id.fName);
     lastname = (EditText) findViewById(R.id.lName);
     age = (EditText) findViewById(R.id.age);
     username = (EditText) findViewById(R.id.uName);
     password = (EditText) findViewById(R.id.ppWord);
     register = (Button) findViewById(R.id.regidter);

     String fn = firstname.getText().toString();
     String ln = lastname.getText().toString();
     String ag = age.getText().toString();
     String un = username.getText().toString();
     String pass = password.getText().toString();

     if(fn.isEmpty() && ln.isEmpty() && ln.isEmpty() && ag.isEmpty() && un.isEmpty() && pass.isEmpty())
     {

         Toast.makeText(this, "Please fill the form", Toast.LENGTH_LONG).show();
     }else
     {
        if(!(fn.isEmpty()))
        {
            if(!(ln.isEmpty()))
            {
                if(!(ag.isEmpty()))
                {
                    if(TextUtils.isDigitsOnly(ag) ) {

                        if (Integer.parseInt(ag) > 0 && Integer.parseInt(ag) <= 120) {
                            if (!(un.isEmpty())) {
                                if (!(pass.isEmpty())) {
                                    User user = new User(fn, ln, Integer.parseInt(ag), pass, un);
                                    DataSource data = new DataSource();
                                    data.addUser(user);
                                    Toast.makeText(this, "Successfully Registered", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(RegistrationActivity.this, MainActivity1.class);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(this, "please enter password", Toast.LENGTH_LONG).show();
                                }
                            } else {
                                Toast.makeText(this, "please enter username", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(this, "Age must be between 1 to 120", Toast.LENGTH_LONG).show();
                        }

                    }else{
                        Toast.makeText(this, "Age must be a number", Toast.LENGTH_LONG).show();
                    }

                }else
                {
                    Toast.makeText(this,"please enter age",Toast.LENGTH_LONG).show();
                }
            }else
            {
                Toast.makeText(this,"please enter lastname ",Toast.LENGTH_LONG).show();
            }
        }else
        {
            Toast.makeText(this,"please enter firstname",Toast.LENGTH_LONG).show();
        }

     }

 }

 public void log(View v)
 {
     logii = (TextView) findViewById(R.id.login);
     Intent intent = new Intent(RegistrationActivity.this, MainActivity1.class);
     startActivity(intent);
 }
}
