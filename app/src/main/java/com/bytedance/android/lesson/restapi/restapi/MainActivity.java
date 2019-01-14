package com.bytedance.android.lesson.restapi.restapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = findViewById(R.id.tv);
        tv.setText(parseFirstName());
    }

    private static String parseFirstName() {
        String result = null;
        try {
            String raw = "{\"os\":[{\"name\":\"Pie\",\"code\":28},{\"name\":\"Oreo\",\"code\":27}]}";
            JSONObject root = new JSONObject(raw);
            JSONArray os = root.optJSONArray("os");
            result = os.optJSONObject(0).optString("name");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;

    }
}
