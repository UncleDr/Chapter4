package com.bytedance.android.lesson.restapi.restapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.bytedance.android.lesson.restapi.restapi.bean.OSList;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    public static String RAW =
            "{\"os\":[{\"name\":\"Pie\",\"code\":28}," +
                    "{\"name\":\"Oreo\",\"code\":27}]}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = findViewById(R.id.tv);
        tv.setText(parseFirstNameWithGson());
    }

    private static String parseFirstNameWithGson() {
        OSList list = new Gson()
                .fromJson(RAW, OSList.class);
        return list.getOs()[0].getName();
    }

    private static String parseFirstNameWithJSON() {
        String result = null;
        try {
            JSONObject root = new JSONObject(RAW);
            JSONArray os = root.optJSONArray("os");
            result = os.optJSONObject(0).
                    optString("name");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }
}
