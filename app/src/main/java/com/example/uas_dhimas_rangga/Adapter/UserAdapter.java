package com.example.uas_dhimas_rangga.Adapter;

import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uas_dhimas_rangga.EditActivity;
import com.example.uas_dhimas_rangga.Model.User;
import com.example.uas_dhimas_rangga.R;

import java.util.List;

import javax.xml.namespace.QName;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {
    List<User>  mUserList;

    public UserAdapter(List <User> userList){
        mUserList=userList; }

    @NonNull
    @Override
    public UserAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate (R.layout.users_list,false);
         MyViewHolder myViewHolder =new MyViewHolder(mView);
        return myViewHolder;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull UserAdapter.MyViewHolder holder, int position) {
        holder.mTextViewId.setText("Id = "+ mUserList.get(position).getId());
        holder.mTextViewId.setText("Name = "+ mUserList.get(position).getNama());
        holder.mTextViewId.setText("Email= "+ mUserList.get(position).getEmail());
        holder.mTextViewId.setText("Telepon = "+ mUserList.get(position).getTelepon());
        holder.itemView.setOnContextClickListener( new View.OnContextClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), EditActivity.class);
                mIntent.putExtra("Id", mUserList.get(position).getId());
                mIntent.putExtra("Name", mUserList.get(position).getNama());
                mIntent.putExtra("Email", mUserList.get(position).getEmail());
                mIntent.putExtra("Telepon", mUserList.get(position).getTelepon());
                view.getContext().startActivity(mIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewId, mTextViewNama, mTextViewEmail, mTextViewTelepon;
        public myViewHolder(View itemView){
            super(itemView);
            mTextViewId     = (TextView) itemView.findViewById(R.id.tvId);
            mTextViewNama   = (TextView) itemView.findViewById(R.id.tvName);
            mTextViewEmail  = (TextView) itemView.findViewById(R.id.tvEmail);
            mTextViewTelepon= (TextView) itemView.findViewById(R.id.tvTelepon);

        }
    }
}
