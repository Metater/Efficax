package com.github.metater.efficax.api;

import com.github.metater.efficax.Efficax;
import com.github.metater.efficax.api.events.APIEventPlayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIHandler {
    public void Init(Efficax efficax) {
        efficax.getServer().getPluginManager().registerEvents(new APIEventPlayer(efficax), efficax);
    }
    /*
    public class APIEventData()
    {
        
    }
     */

    public static String SendDataToAPI(String data)
    {
        String response;
        try {
            response = doHttpUrlConnectionAction("http://localhost:5000/mc?server=Gaemer%20Boius&data=" + data);
        }
        catch (Exception e) { response = "503"; }
        return response;
    }
    public static void SendDataToAPIVoid(String data)
    {
        String response;
        try {
            response = doHttpUrlConnectionAction("http://localhost:5000/mc?server=Gaemer%20Boius&data=" + data);
        }
        catch (Exception e) { }
    }
    private static String doHttpUrlConnectionAction(String desiredUrl)
            throws Exception {
        URL url = null;
        BufferedReader reader = null;
        StringBuilder stringBuilder;

        try {
            // create the HttpURLConnection
            url = new URL(desiredUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // just want to do an HTTP GET here
            connection.setRequestMethod("GET");

            // uncomment this if you want to write output to this url
            connection.setDoOutput(true);

            // give it 15 seconds to respond
            connection.setReadTimeout(15 * 1000);
            connection.connect();

            // read the output from the server
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            stringBuilder = new StringBuilder();

            String line = null;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            // close the reader; this can throw an exception too, so
            // wrap it in another try/catch block.
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }
}
