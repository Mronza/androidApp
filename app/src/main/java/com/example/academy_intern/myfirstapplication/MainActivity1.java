package com.example.academy_intern.myfirstapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity1 extends AppCompatActivity  {

    private EditText username;
    private EditText password;
    private Button login;
    private TextView registerLink;
    private TextView log;
    private int count= 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);


    }

    public void Butt(View v)
    {
        username = (EditText) findViewById(R.id.uName);
        password = (EditText) findViewById(R.id.pword);
        registerLink = (TextView) findViewById(R.id.register);


        String username1 = username.getText().toString();
        String pas = password.getText().toString();

       // DataSource da = new DataSource();



        if((username1.isEmpty()) && (pas.isEmpty())) {
            Toast.makeText(this,"Enter username & \n password to Login",Toast.LENGTH_LONG).show();
        }else
        {
            if(!(username1.isEmpty()))
            {
                if(!(pas.isEmpty()))
                {
                    if(DataSource.check(username1, pas) )
                    {


                        Intent intent = new Intent(MainActivity1.this, display.class);



                        for(User user : DataSource.listuser)
                        {



                            if(username1.equals(user.getUsername()) && pas.equals(user.getPassword()) )
                            {
                               String display = String.format("Name      : " + user.getName() + " \n" +
                                        "Surname : " + user.getSurname() + "\n" +
                                        "Age        : " + user.getAge() + "\n" +
                                        "============== \n");

                                intent.putExtra("userData",display);
                            }
                        }




                        startActivity(intent);


                    }else
                    {
                        Toast.makeText(this,"User not found,please Register/Login",Toast.LENGTH_LONG).show();
                        ++count;
                        if(count == 3){
                            android.os.Process.killProcess(android.os.Process.myPid());
                        }
                    }
                }else
                {
                    Toast.makeText(this,"Please enter password",Toast.LENGTH_LONG).show();
                }
            }else
            {
                Toast.makeText(this,"Please enter username",Toast.LENGTH_LONG).show();
            }
        }


    }

    public void regis(View v)
    {
        Intent intent = new Intent(MainActivity1.this, RegistrationActivity.class);
        startActivity(intent);
    }



}
