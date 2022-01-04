package com.example.sharepreferance;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextOne,editTextTwo;
    private Button buttonONe,buttonTwo;

    private TextView textViewONe, textViewTwo;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextOne = findViewById(R.id.editone);
        editTextTwo = findViewById(R.id.editTwo);

        buttonONe = findViewById(R.id.btnONe); //save
        buttonTwo = findViewById(R.id.btntwo);//show

        textViewONe = findViewById(R.id.Shoemailid);
        textViewTwo = findViewById(R.id.showpasswordid);


        buttonONe.setOnClickListener(this);
        buttonTwo.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.btnONe){

            String email = editTextOne.getText().toString();
            String password = editTextTwo.getText().toString();

            if(email.equals("") || password.equals("")){
                Toast.makeText(MainActivity.this,"please enter some data",Toast.LENGTH_LONG).show();
            }else{
                //writing data in sharepreferance

                SharedPreferences sharedPreferences = getSharedPreferences("Userdetails", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("User_email",email);
                editor.putString("User_pass",password);
                editor.commit();
                editTextOne.setText("");
                editTextTwo.setText("");

                Toast.makeText(MainActivity.this,"Successfully data save",Toast.LENGTH_LONG).show();
            }

        }else if(view.getId() == R.id.btntwo){
            SharedPreferences sharedPreferences = getSharedPreferences("Userdetails", Context.MODE_PRIVATE);
            if(sharedPreferences.contains("User_email") && sharedPreferences.contains("User_pass")){

                String email = sharedPreferences.getString("User_email","no");
                String pass = sharedPreferences.getString("User_pass","no");

                textViewONe.setText("Email: " +email);
                textViewTwo.setText("Password: "+pass);

                Toast.makeText(MainActivity.this,"Successfully data showing",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(MainActivity.this,"No data found",Toast.LENGTH_LONG).show();
            }
        }

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}