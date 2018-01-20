package com.exercises.javid.myHomework.net;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * gets the data from site
 * @author Javid
 */

public class JSONDownloader {


    /**
     * gets data from database in site
     * @param urlString: url of site to get data
     * @return String JSON (data)
     */
    public String download(String urlString) {

        String data = "";

        try {
            URL url = new URL(urlString);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //connecting methods are required:
            connection.setConnectTimeout(10000);
            connection.setReadTimeout(15000);
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.connect();

            InputStream stream = connection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(stream));

            StringBuilder sb = new StringBuilder();

            for (String line; (line = br.readLine()) != null; sb.append(line)) {}

            data = sb.toString();

            br.close();

            stream.close();

            connection.disconnect();

        } catch (Exception e) {
            Log.e("My Cod:", "Class: JSONDownloader Method: download " + e.toString());
        }
        return data;
    }
}
