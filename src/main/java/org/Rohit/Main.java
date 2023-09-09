package org.Rohit;



import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {
        URL url=null;
        HttpURLConnection connection=null;
        int responseCode=0;

        String httpUrl=" https://api.zippopotam.us/us/33162";
        try{
            url=new URL(httpUrl);
        }
        catch (Exception e){
            System.out.println("Problem With the Url.. ");
        }
        try{
//            assert url != null;
            connection= (HttpURLConnection) url.openConnection();
            responseCode=connection.getResponseCode();
        } catch (Exception e) {
            System.out.println("Problem With Connection");
        }
        if(responseCode==200){
            BufferedReader in=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder apiData=new StringBuilder();
            String read=null;
            while((read= in.readLine())!=null) {
                apiData.append(read);
            }
            try {
                in.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

//            System.out.println(apiData.toString());
            JSONObject jsonAPIResponse = new JSONObject(apiData.toString());
            System.out.println(jsonAPIResponse);
//            System.out.println(jsonAPIResponse.toString());
        }
//        System.out.println(ap);
        else{
            System.out.println("problem Occured");
        }



    }
}