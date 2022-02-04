package com.fadelkhadraoui.fadelkhadraoui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.OkHttpResponseListener;

import okhttp3.Response;

public class CreerPiece extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_piece);
    }





    public void createRoom(){
        Spinner pic = findViewById(R.id.spinner);
        EditText name = findViewById(R.id.roomName);
        Intent roomList = new Intent(this, RoomList.class);
        AndroidNetworking.post("https://myhouse.lesmoulinsdudev.com/room-create")
                .addBodyParameter("name",name.getText().toString())
                .addBodyParameter("idPicture",null)
                .build()
                .getAsOkHttpResponse(new OkHttpResponseListener() {
                    @Override
                    public void onResponse(Response response) {
                        switch (response.code()){
                            case 200:
                                Toast toastSuccess = Toast.makeText(CreerPiece.this,"Pièce créée",Toast.LENGTH_SHORT);
                                toastSuccess.show();

                                startActivity(roomList);
                                break;
                            default:
                                Toast toastError = Toast.makeText(CreerPiece.this,"Erreur "+response.code(),Toast.LENGTH_SHORT);
                                toastError.show();

                        }
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });
    }

        public void onAddClicked(View view){
            createRoom();
        }
}