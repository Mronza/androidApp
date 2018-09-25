package com.example.academy_intern.myfirstapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class display extends AppCompatActivity {
    private Button logoutt;

    EditText ed;
    TextView di;

    DataSource da = new DataSource();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);


        ed = findViewById(R.id.txtSearch);
        di = findViewById(R.id.txtDisplay);

        TextView search = findViewById(R.id.txtSearch);
        Button btn = findViewById(R.id.btnSearch);

         Intent intent = getIntent();
         String data = intent.getStringExtra("userData");

         di.setText(data);

         String src = btn.getText().toString();



    }



    public void btnSear(View v)
    {
        String se = ed.getText().toString();



        if(da.search(se))
        {
           di.setText(da.dis(se));
        }else{

            Toast.makeText(this,"User not found,Search again",Toast.LENGTH_LONG).show();
            di.setText("");
        }
    }

    public void logout(View v)
    {
        logoutt = (Button) findViewById(R.id.btnExit);

        Intent intent = new Intent(display.this, MainActivity1.class);
        startActivity(intent);
    }

//    public void listBT(View v)
//    {
//        logoutt = (Button) findViewById(R.id.btnExit);
//
//        Intent intent = new Intent(display.this, MainActivity1.class);
//        startActivity(intent);
//    }

    protected void onRestart()
    {
        super.onRestart();
    }



}
