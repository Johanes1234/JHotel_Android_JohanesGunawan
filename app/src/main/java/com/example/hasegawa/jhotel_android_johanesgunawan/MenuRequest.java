package com.example.hasegawa.jhotel_android_johanesgunawan;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class MenuRequest extends StringRequest{
    private static final String Regis_URL = "insert your New Customer API URL here" ;
    private Map<String, String> params;
    public MenuRequest(String roomNumber, String statusKamar, Double dailyTariff, String tipeKamar, Response.Listener<String> listener) {
        super(Method.GET, Regis_URL, listener, null);
        params = new HashMap<>();
        params.put("Nomor", roomNumber);
        params.put("Status", statusKamar);
        params.put("Daily Tariff", String.valueOf(dailyTariff));
        params.put("Tipe ", tipeKamar);
    }
    @Override public Map<String, String> getParams() {
        return params;
    }
}

