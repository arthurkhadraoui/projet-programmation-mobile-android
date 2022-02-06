package com.fadelkhadraoui.fadelkhadraoui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.json.JSONArray;
import org.json.JSONException;

public class RoomAdapter extends BaseAdapter implements ListAdapter {

    //activity context
    Context context;

    //the layout resource file for the list items
    int resource;

    JSONArray rooms;

    String imageRoom;
    String name;

    public RoomAdapter(@NonNull Context context, int resource, JSONArray rooms) {
        this.context=context;
        this.resource=resource;
        this.rooms=rooms;
    }

    @Override
    public int getCount() {
        if(null==rooms)
            return 0;
        else
            return rooms.length();
    }

    @Override
    public Object getItem(int i) {
        if(null==rooms) return null;
        else
            return rooms.optJSONObject(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //we need to get the view of the xml for our list item
        //And for this we need a layoutinflater
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        //getting the view
        View view = layoutInflater.inflate(resource, null, false);



        //getting the view elements of the list from the view
        ImageView thumbnail = view.findViewById(R.id.thumbnail);
        TextView roomname = view.findViewById(R.id.roomname);

        //adding values to the list item
        try {
            name =  rooms.getJSONObject(position).getString("name");
        } catch (JSONException e) {
            e.printStackTrace();
        }


        roomname.setText(name);


        //finally returning the view
        return view;
    }
}
