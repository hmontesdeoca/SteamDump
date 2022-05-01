package com.HTTP;
import java.io.IOException;

import okhttp3.*;

public class Requester {
  
    private final OkHttpClient client = new OkHttpClient();
    public String getSync(String url) {
        // build the URL
        Request request = new Request.Builder()
            .url(url)
            .build();
    
        // try the response and execute it
        try (Response response = client.newCall(request).execute()) {
        	client.connectionPool().evictAll();
          return response.body().string();
          
        }
        catch(IOException e){e.printStackTrace();}
        client.connectionPool().evictAll();
        return null;
      }

        //asynchronous implementation awaits next request
  /*public void getAsync(String url)  {
    // build the URL
    Request request = new Request.Builder()
        .url(url)
        .build();

    // enqueue the call back to make it async
    client.newCall(request).enqueue(new Callback() {
      // override on failure of the call & throw an exception
      @Override
      public void onFailure(Call call, IOException e) {
        e.printStackTrace();
      }

      // override the onresponse and throw an exception if failed
      @Override
      public void onResponse(Call call, Response response) throws IOException {
        try (ResponseBody responseBody = response.body()) {
          if (!response.isSuccessful())
            throw new IOException("Unexpected code " + response);

          // if successful print the headers
          Headers responseHeaders = response.headers();
          for (int i = 0, size = responseHeaders.size(); i < size; i++) {
            // System.out.println(responseHeaders.name(i) + ": " +
            // responseHeaders.value(i));
          }
          // return the body
          System.out.println(responseBody.string());
        }
      }
    });
  }*/
    
}
