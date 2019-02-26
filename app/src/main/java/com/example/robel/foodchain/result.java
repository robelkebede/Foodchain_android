package com.example.robel.foodchain;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;





public class result extends AppCompatActivity  {

    public static String TAG="com.example.robel";


    public static final String BASE_URL = "http://192.168.43.18:8000";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        String value = intent.getStringExtra("id");
        final TextView results = (TextView) findViewById(R.id.status);
        //final TextView error= (TextView) findViewById(R.id.result_error);
        final TextView pack = (TextView) findViewById(R.id.pack);
        final TextView company = (TextView) findViewById(R.id.company);
        final TextView date = (TextView) findViewById(R.id.date);
        final TextView grower = (TextView) findViewById(R.id.grower);
        final TextView type = (TextView) findViewById(R.id.type);
        final TextView owner = (TextView) findViewById(R.id.owner);
        final TextView message = (TextView) findViewById(R.id.mess);
        final ProgressBar progress = (ProgressBar) findViewById(R.id.progressBar);
       // textView.setText(value);



        //API STUFF

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Json json = retrofit.create(Json.class);
        progress.setVisibility(View.VISIBLE);





        // triming the double quotes
        value = value.replaceAll("^\"|\"$", "");

        Call<Post> call = json.getData(value);


        call.enqueue(new Callback<Post>() {





            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                try {


                    progress.setVisibility(View.INVISIBLE);
                    Log.d(TAG, "POST" + new Gson().toJson(response.body()));
                    if (!response.isSuccessful()) {
                        Log.d(TAG, "res message" + response.message());

                    }
                    Post post = response.body();
                    Log.d(TAG, "response " + response.body());

                    if (post.getRes() != null) {
                        date.setText("This Product is not registered");
                    } else {

                        date.setText("Date: " + post.getDate().toString());
                        pack.setText("Package: " + post.getPackageItem().toString());
                        company.setText("Company: " + post.getCompany().toString());
                        grower.setText("Grower: " + post.getGrower().toString());
                        type.setText("Type: " + post.getType().toString());
                       // owner.setText("Owner: "+post.getOwner().toString());
                        Log.d(TAG,"this is the owners id");


                        // results.setText(post.getDate().toString());
                    }
                }catch(Exception e){
                    Log.d(TAG,"ERROR");
                }


            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

                progress.setVisibility(View.INVISIBLE);
                Log.d(TAG,"onFailure "+t.getMessage());

                if(t.getMessage()=="timeout") {
                    message.setText("The Product is not registered :(");
                }else{
                    message.setText("No Internet Connection :(");
                }
            }

        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });

    }


}
