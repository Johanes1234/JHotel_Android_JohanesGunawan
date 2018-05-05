package com.example.hasegawa.jhotel_android_johanesgunawan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.android.volley.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Hotel> listHotel = new ArrayList<>();
    private ArrayList<Room> listRoom = new ArrayList<>();
    private HashMap<Hotel, ArrayList<Room>> childMapping = new HashMap<>();
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    HashMap<String, Hotel> hotelHashMap = new HashMap<>();
    HashMap<String, ArrayList<Room>> roomsMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expListView = (ExpandableListView) findViewById(R.id.expanded_menu);
        final ArrayList<Hotel> listHotel = new ArrayList<>();
        final ArrayList<Room> listRoom = new ArrayList<>();
        final HashMap<Hotel, ArrayList<Room>> childMapping = new HashMap<>();
        Response.Listener<String> responseListener = new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response) {
                refreshList(response);
            }
        };
    }
    public void refreshList(String response)
    {
        try
        {
            JSONArray jsonResponse = new JSONArray(response);
            for (int i = 0; i < jsonResponse.length(); i++) {
                JSONObject e = jsonResponse.getJSONObject(i).getJSONObject("hotel");
                JSONObject lokasi = e.getJSONObject("lokasi");
                JSONObject room = jsonResponse.getJSONObject(i);
                Hotel h = new Hotel(e.getInt("id"), e.getString("nama"), new Lokasi(lokasi.getInt("x"), lokasi.getInt("y"), lokasi.getString("deskripsi")),
                        e.getInt("bintang"));
                hotelHashMap.put(h.getNama(), h);
                Room room1 = new Room(room.getString("nomorKamar"), room.getString("statusKamar"), room.getDouble("dailyTariff"), room.getString("tipeKamar"));

                if (!roomsMap.containsKey(h.getNama())) {
                    ArrayList<Room> rooms = new ArrayList<>();
                    rooms.add(room1);
                    roomsMap.put(h.getNama(), rooms);
                } else {
                    ArrayList<Room> rooms = roomsMap.get(h.getNama());
                    rooms.add(room1);
                    roomsMap.put(h.getNama(), rooms);
                }
            }

            for (String key : hotelHashMap.keySet()) {
                listHotel.add(hotelHashMap.get(key));

                childMapping.put(hotelHashMap.get(key), roomsMap.get(key));
            }
            MenuListAdapter listAdapter = new MenuListAdapter( MainActivity.this, listHotel, childMapping );
            expListView.setAdapter(listAdapter);

        } catch (JSONException e1) {
            e1.printStackTrace();
        }
    }
}
