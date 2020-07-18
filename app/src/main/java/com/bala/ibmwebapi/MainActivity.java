package com.bala.ibmwebapi;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.bala.ibmwebapi.data.PostTemperatureResponse;
import com.bala.ibmwebapi.data.UserData;
import java.util.List;
import java.util.TreeMap;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private GetDataService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<UserData>> call = service.getUserData("","G1234567P","",
                                "06-09-2020","06-09-2020","",
                                "1","1","","false");

        call.enqueue(new Callback<List<UserData>>() {
            @Override
            public void onResponse(Call<List<UserData>> call, Response<List<UserData>> response) {
                Log.d(TAG, "onResponse: " +response.body().get(0).getMobileNo());
            }

            @Override
            public void onFailure(Call<List<UserData>> call, Throwable t) {
                Log.e(TAG, "onFailure: "+ t.toString());
            }
        });
    }

    public void post(View view)
    {
        TreeMap<String,String> postData = new TreeMap<>();
        Call<PostTemperatureResponse> postTemperatureResponseCall = service.postTemperature(postData);
        postTemperatureResponseCall.enqueue(new Callback<PostTemperatureResponse>() {
            @Override
            public void onResponse(Call<PostTemperatureResponse> call, Response<PostTemperatureResponse> response) {
                Log.d(TAG, "onResponse: " +response.body());
            }

            @Override
            public void onFailure(Call<PostTemperatureResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: "+ t.toString());
            }
        });

    }

}