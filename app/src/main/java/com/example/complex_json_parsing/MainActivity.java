package com.example.complex_json_parsing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.map_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Map_Activity.class);
                startActivity(intent);
            }
        });

        gettingData();

    }

    public void gettingData()
    {
        try {
            //Loading JSON From Assets
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONObject s1 = obj.getJSONObject("responseData");
            JSONObject f2 = s1.getJSONObject("feed");

            String s01 = f2.getString("feedUrl");
            String s02 = f2.getString("title");
            String s03 = f2.getString("link");
            String s04 = f2.getString("author");
            String s05 = f2.getString("description");
            String s06 = f2.getString("type");
            //Getting Json Array
            JSONArray a1 = f2.getJSONArray("entries");
            for(int i=0; i<a1.length();i++)
            {
                //Converting JSON Array To Object
                JSONObject j1 = a1.getJSONObject(i);
                {
                    //Getting Single Object
                    String s001 = j1.getString("title");
                    String s002 = j1.getString("link");
                    String s003 = j1.getString("author");
                    String s004 = j1.getString("publishedDate");
                    String s005 = j1.getString("contentSnippet");
                    String s006 = j1.getString("content");
                    String s007 = j1.getString("categories");

                    Log.e("String",s001+"");
                    Log.e("String",s002+"");
                    Log.e("String",s003+"");
                    Log.e("String",s004+"");
                    Log.e("String",s005+"");
                    Log.e("String",s006+"");
                    Log.e("String",s007+"");
                }
            }

            //Getting Json Objects
            String  s2 = obj.getString("responseDetails");
            String  s3 = obj.getString("responseStatus");



            //Log.e("JSON ARRAY",array+"");
            Log.e("feedUrl",s01+"");
            Log.e("title",s02+"");
            Log.e("link",s03+"");
            Log.e("author",s04+"");
            Log.e("description",s05+"");
            Log.e("type",s06+"");

            Log.e("responseDetails",s2+"");
            Log.e("responseStatus",s3+"");

            Log.e("Json_LOG",obj+"");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("Json_Parsing.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}