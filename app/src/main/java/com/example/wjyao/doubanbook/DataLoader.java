package com.example.wjyao.doubanbook;

import android.content.Context;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

import static android.util.Xml.Encoding.UTF_8;

/**
 * Created by wjyao on 3/4/17.
 */
public class DataLoader {

    private static final String TAG = "DataLoader";

    public static JSONObject loadData(Context context) {
        JSONObject jsonObject = null;

        InputStream inputStream = context.getResources().openRawResource(R.raw.book_list);

        try {
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            jsonObject = new JSONObject(new String(buffer, UTF_8.toString()));
        } catch (IOException | JSONException e) {
            Log.e(TAG, e.getLocalizedMessage());
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return jsonObject;
    }
}
