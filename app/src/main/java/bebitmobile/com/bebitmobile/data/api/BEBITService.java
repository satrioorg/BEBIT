package bebitmobile.com.bebitmobile.data.api;

import android.content.Context;
import android.util.Base64;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tunggul.jati on 18/10/2016.
 */

public class BEBITService {

    private BEBITAPI api;

    public BEBITService(String serviceBaseUrl) {
        Retrofit retrofitSvc = new Retrofit.Builder()
                .baseUrl(serviceBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getCustomClient())
                .build();
        this.api = retrofitSvc.create(BEBITAPI.class);
    }

    private OkHttpClient getCustomClient(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient httpClient = new OkHttpClient.Builder().addInterceptor(
                new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request.Builder requestBuilder = chain.request().newBuilder();
                        requestBuilder.header("Content-Type", "application/json");
                        requestBuilder.header("applicationId","WA");
                        return chain.proceed(requestBuilder.build());
                    }
                }
        ).addInterceptor(logging).build();

        return httpClient;
    }

    public BEBITAPI getApi(){
        return this.api;
    }


}