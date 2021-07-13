package com.example.uas_dhimas_rangga;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.uas_dhimas_rangga.Adapter.UserAdapter;
import com.example.uas_dhimas_rangga.Model.GetUser;
import com.example.uas_dhimas_rangga.Model.User;
import com.example.uas_dhimas_rangga.Rest.ApiInterface;

import java.util.List;
import java.util.logging.LoggingPermission;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button btnInsert;
    ApiInterface mApiInterface;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutmanager;
    public  static MainActivity ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = (Button)findViewById(R.id.btnInsert);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,InsertActivity));
            }
        });
        mRe
    }

    public void  refresh(){
        Call<GetUser> userCall = mApiInterface.getuser();
        userCall.enqueue(new Callback<GetUser>() {
            @Override
            public void onResponse(Call<GetUser> call, Response<GetUser> response) {
                List<User> UserList = response.body().getData();
                Log.d("Retrofit Get", "Jumlah data User"+ String.valueOf(UserList.size()));
                mAdapter = new UserAdapter(UserList);

            }

            @Override
            public void onFailure(Call<GetUser> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}