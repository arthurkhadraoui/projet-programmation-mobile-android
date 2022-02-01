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

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    public void login(){
        Intent login = new Intent(this, RoomList.class);
        EditText email = findViewById(R.id.email);
        EditText pwd = findViewById(R.id.password);
        AndroidNetworking.post("https://myhouse.lesmoulinsdudev.com/auth")
                .addBodyParameter("login",email.getText().toString())
                .addBodyParameter("password",pwd.getText().toString())
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        String token = null;
                        try {
                            token = response.getString("token");
                            login.putExtra("tokenID", token);
                            startActivity(login);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

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

    public void onLoginClicked(View view){
        login();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AndroidNetworking.initialize(this);
    }
}