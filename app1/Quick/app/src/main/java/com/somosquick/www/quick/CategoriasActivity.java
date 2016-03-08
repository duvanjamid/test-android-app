package com.somosquick.www.quick;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.somosquick.www.utiles.HttpClient;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;

public class CategoriasActivity extends AppCompatActivity {
    private static final String TAG = "CategoriasActivity";
    private static final String URL = "http://192.168.1.33:8084/quick/request.jsp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
// JSON object to hold the information, which is sent to the server
        JSONObject jsonObjSend = new JSONObject();

        try {
            // Add key/value pairs
            jsonObjSend.put("key_1", "value_1");
            jsonObjSend.put("key_2", "value_2");

            // Add a nested JSONObject (e.g. for header information)
            JSONObject header = new JSONObject();
            header.put("deviceType","Android"); // Device type
            header.put("deviceVersion","2.0"); // Device OS version
            header.put("language", "es-es");	// Language of the Android client
            jsonObjSend.put("header", header);

            // Output the JSON object we're sending to Logcat:
            Log.i(TAG, jsonObjSend.toString(2));

        JSONObject jsonObjRecv = HttpClient.SendHttpPost(URL, jsonObjSend);
            TextView textView = (TextView)findViewById(R.id.categorias_text);
            //textView.setText(jsonObjRecv.toString(2));
     //   Log.i(TAG, jsonObjRecv.toString() );
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Send the HttpPostRequest and receive a JSONObject in return
		/* Log.i(TAG, jsonObjSend.toString(2));
		 *  From here on do whatever you want with your JSONObject, e.g.
		 *  1) Get the value for a key: jsonObjRecv.get("key");
		 *  2) Get a nested JSONObject: jsonObjRecv.getJSONObject("key")
		 *  3) Get a nested JSONArray: jsonObjRecv.getJSONArray("key")
		 */

    }
}
