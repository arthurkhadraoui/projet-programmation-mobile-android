package com.fadelkhadraoui.fadelkhadraoui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    public void login(){

        EditText email = findViewById(R.id.email);
        EditText pwd = findViewById(R.id.password);
        AndroidNetworking.post("https://fierce-cove-29863.herokuapp.com/getAllUsers/{pageNumber}")
                .addBodyParameter("email",email.getText().toString())
                .addBodyParameter("password",pwd.getText().toString())
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {

                    }

                    @Override
                    public void onError(ANError anError) {
                        Toast toastError = Toast.makeText(MainActivity.this,"eMail ou mot de passe inconnus",Toast.LENGTH_SHORT);
                        toastError.show();
                    }
                });
    }

    public void onRegisterClicked(View view){
        Intent register = new Intent(this, Register.class);
        startActivity(register);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AndroidNetworking.initialize(this);
    }
}