package com.example.uas_dhimas_rangga;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.uas_dhimas_rangga.Model.PostPutDelUser;
import com.example.uas_dhimas_rangga.Rest.ApiClient;
import com.example.uas_dhimas_rangga.Rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertActivity extends AppCompatActivity {
    EditText editName, editEmail, editTelepon;
    Button btnInsert, btnKembali;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        editName = (EditText) findViewById(R.id.editNama);
        editEmail = (EditText) findViewById(R.id.editEmail);
        editTelepon = (EditText) findViewById(R.id.editEmail);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btnInsert = (Button)findViewById(R.id.btnInsert);
        btnInsert.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Call<PostPutDelUser> postPutDelUsercall = mApiInterface.postUser(editName.getText().toString(),editEmail.getText().toString(),editTelepon.getText().toString());
                postPutDelUsercall.enqueue(new Callback<PostPutDelUser>() {
                    @Override
                    public void onResponse(Call<PostPutDelUser> call, Response<PostPutDelUser> response) {
                        MainActivity.ma.refresh();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostPutDelUser> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"error Boss",Toast.LENGTH_LONG).show();

                    }
                });

            }
        });
        btnInsert = (Button)findViewById(R.id.btnKembali);
        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.ma.refresh();
                finish();
            }
        });
    }
}