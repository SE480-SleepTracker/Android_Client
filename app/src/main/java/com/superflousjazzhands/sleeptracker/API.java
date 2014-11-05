package com.superflousjazzhands.sleeptracker;


import com.superflousjazzhands.sleeptracker.objects.SleepLog;

import java.util.List;

import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.Callback;

public class API {

    public static final String ACCEPT_JSON = "Accept: application/json";
    public static final String CONTENT_TYPE_JSON = "Content-Type: application/json";
    public static final String CONTENT_TYPE_MULTIPART_FORM_DATA = "Content-Type: multipart/form-data";
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String INSTANCE_URL = "InstanceUrl";

    public static SleepLogService sleepLogService;
    /*
        As Mifos is a multi-tenant platform, all requests require you to specify a tenant
        as a header in each request.
     */

    public static String mInstanceUrl = "https://demo.openmf.org/mifosng-provider/api/v1";

    static {
        init();
    }

    static RestAdapter sRestAdapter;

    private static synchronized void init() {
        sRestAdapter = createRestAdapter(mInstanceUrl);
        sleepLogService = sRestAdapter.create(SleepLogService.class);
    }

    public static <T> Callback<T> getCallback(T t){
        Callback<T> cb = new Callback<T>() {
            @Override
            public void success(T o, Response response) {
                System.out.println("Object " + o);
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                System.out.println("Error: " + retrofitError);
            }
        };

        return cb;
    }

    public static <T> Callback<List<T>> getCallbackList(List<T> t){
        Callback<List<T>> cb = new Callback<List<T>>() {
            @Override
            public void success(List<T> o, Response response) {
                System.out.println("Object " + o);
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                System.out.println("Error: " + retrofitError);
            }
        };

        return cb;
    }

    private static RestAdapter createRestAdapter(final String url) {
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(url).build();
        // TODO: This logging is sometimes excessive, e.g. for client image requests.
        restAdapter.setLogLevel(RestAdapter.LogLevel.FULL);
        return restAdapter;
    }

    public interface SleepLogService {
        @Headers({ACCEPT_JSON, CONTENT_TYPE_JSON})
        @GET("/") // api endpoint goes here
        public void getAllSleepLogs(Callback<List<SleepLog>> callback);

        @Headers({ACCEPT_JSON, CONTENT_TYPE_JSON})
        @POST("/") // api endpoint goes here
        public void saveSleepLog(
                // add parameters here
        );
    }
}
