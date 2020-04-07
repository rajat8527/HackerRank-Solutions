package com.hackerank.solutions;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LocationIP {

    public static int getExpenditure(int userId, int locationId, int netStart, int netEnd) {
        String urlString = "https://jsonmock.hackerrank.com/api/transactions/search?userId="+userId;
        int finalAmount = 0;
        System.out.println(userId + " " + locationId + " " + netStart + " " + netEnd);
        try {

            URL url = new URL(urlString);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();

            InputStream is = httpURLConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();

            String line = null;

            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }

            String responseBody = sb.toString();
            JSONParser parser = new JSONParser();
            JSONObject bodyObject = (JSONObject) parser.parse(responseBody);

            JSONArray dataArray = (JSONArray) bodyObject.get("data");

            for (Object o : dataArray) {
                JSONObject resultObject = (JSONObject) o;
                String ipString = (String) resultObject.get("ip");
                int ip = Integer.parseInt(ipString.split("\\.")[0]);
                Long id = (Long) resultObject.get("userId");
                double amount = Double.parseDouble(((String) resultObject.get("amount")).replaceAll("\\$", "").replaceAll("\\,",""));
                JSONObject locationObject = (JSONObject) resultObject.get("location");
                Long location = (Long) locationObject.get("id");
                if (ip >= netStart && ip <= netEnd && id == userId && locationId == location) {
                        finalAmount += amount;
                }
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }

        return finalAmount;

    }

    public static void main(String[] args) {
        System.out.println(getExpenditure(4,6,100,250));
    }
}
