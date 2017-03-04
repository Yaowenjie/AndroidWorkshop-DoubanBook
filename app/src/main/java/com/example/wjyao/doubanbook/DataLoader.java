package com.example.wjyao.doubanbook;

import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by wjyao on 3/4/17.
 */
public class DataLoader {

    private static final String TAG = "DataLoader";

    public static JSONObject loadData(final String urlString) {
        StringBuilder contentBuilder = new StringBuilder();
        String line = null;

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(15000);
            connection.setConnectTimeout(15000);
            connection.connect();

            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );

            while((line = rd.readLine()) != null) {
                contentBuilder.append(line);
            }

            rd.close();
            connection.disconnect();
            return new JSONObject(contentBuilder.toString());
        } catch (Exception e) {
            Log.e(TAG, e.getLocalizedMessage());
        }

        return null;
    }
}
