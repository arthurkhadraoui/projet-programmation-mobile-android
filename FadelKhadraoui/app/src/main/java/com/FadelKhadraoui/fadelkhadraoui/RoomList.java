package com.fadelkhadraoui.fadelkhadraoui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RoomList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent i = getIntent();
        String userToken = i.getStringExtra("tokenID");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_list);
        getPics("room");
        getRooms(userToken);
    }

    public void getPics(String type){
        ArrayList pictures = new ArrayList();
        AndroidNetworking.get("https://myhouse.lesmoulinsdudev.com/pictures")
                .addQueryParameter("type",type)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray pictures = response.getJSONArray("pictures");

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });

    }

    public void getRooms(String tokenId){

        AndroidNetworking.get("https://myhouse.lesmoulinsdudev.com/rooms")
                .addHeaders("Authorization","Bearer "+tokenId)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray rooms = response.getJSONArray("rooms");

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        Toast toastError = Toast.makeText(RoomList.this,"eMail ou mot de passe inconnus",Toast.LENGTH_SHORT);
                        toastError.show();
                    }
                });
    }
}