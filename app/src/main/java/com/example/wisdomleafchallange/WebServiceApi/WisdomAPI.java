package com.example.wisdomleafchallange.WebServiceApi;

import com.example.wisdomleafchallange.Util.Constants;
import com.jakewharton.retrofit.Ok3Client;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit.RestAdapter;

public class WisdomAPI {

    public static OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build();

    public static WisdomApiInterface getWisdomClient() {
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(Constants.WEBSERVICES_DOMAIN)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setClient(new Ok3Client(client))
                .build();
        WisdomApiInterface api = adapter.create(WisdomApiInterface.class);
        return api;
    }

}
