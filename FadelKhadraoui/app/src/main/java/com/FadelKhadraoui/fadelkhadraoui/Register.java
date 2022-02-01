package com.fadelkhadraoui.fadelkhadraoui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.OkHttpResponseListener;

import okhttp3.Response;

public class Register extends AppCompatActivity {

    public void register(){
        EditText email = findViewById(R.id.emailregister);
        EditText pwd = findViewById(R.id.pwdregister);
        EditText name = findViewById(R.id.nameregister);
        Intent login = new Intent(this,MainActivity.class);
        AndroidNetworking.post("https://myhouse.lesmoulinsdudev.com/register")
                .addBodyParameter("name",name.getText().toString())
                .addBodyParameter("login",email.getText().toString())
                .addBodyParameter("password",pwd.getText().toString())
                .build()
                .getAsOkHttpResponse(new OkHttpResponseListener() {
                    @Override
                    public void onResponse(Response response) {
                        switch (response.code()){
                            case 200:
                                Toast toastSuccess = Toast.makeText(Register.this,"Inscription réussie",Toast.LENGTH_SHORT);
                                toastSuccess.show();

                                startActivity(login);
                                break;
                            default:
                                Toast toastError = Toast.makeText(Register.this,"Erreur "+response.code(),Toast.LENGTH_SHORT);
                                toastError.show();

                        }
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });
    }

    public void onRegisterclicked(View view){
        register();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
}