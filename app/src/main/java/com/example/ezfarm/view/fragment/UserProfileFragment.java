package com.example.ezfarm.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.poe_life.R;
import com.example.poe_life.adapter.PoemAdaptor;
import com.example.poe_life.data.api.ApiClient;
import com.example.poe_life.data.interfaces.PoemInterface;
import com.example.poe_life.data.model.PoemListData;
import com.example.poe_life.view.activity.SettingsActivity;
import com.example.poe_life.view.additional.CircleTransform;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserProfileFragment extends Fragment {
    private ImageView onClick = null;
    private RelativeLayout photobackground;
    public ImageView imageClicked;
    List<PoemListData.Popularpoem> popularpoemList;
    PoemAdaptor poemAdaptor;
    View view;
    TextView nameUser;
    RecyclerView recycleruser;
    public TextView followersCount, followingCount;
    PoemInterface apiClientDetails;
    PoemListData poemData;
    ImageView photoProfile;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_userprofile,container,false);
        onClick = view.findViewById(R.id.userprofileIVsetting);
        recycleruser = view.findViewById(R.id.userprofileRecycler);


//        photoProfile.setImageResource(R.drawable.profiledumy);
//
        photobackground = view.findViewById(R.id.userprofileRLbackground);
//        photobackground.setBackgroundResource(R.drawable.banner);
        nameUser = view.findViewById(R.id.userProfileTVusername);
        followersCount = view.findViewById(R.id.userprofileTVfollwers);
        followingCount = view.findViewById(R.id.userprofileTVfollowing);
        photoProfile = view.findViewById(R.id.userProfileIVphotoProfile);


        onClick.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), SettingsActivity.class);
                startActivity(intent);
            }
        });

        loadData();

        return view;

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }

    public void loadData(){
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyUserData", Context.MODE_PRIVATE);
        SharedPreferences sharedFollowPreferences = getActivity().getSharedPreferences("MyFollowData",Context.MODE_PRIVATE);
        String uid = sharedPreferences.getString("userId","");
        String userName = sharedPreferences.getString("userName","Guest");
        String userProfile = sharedPreferences.getString("userImage", "");
        String followersCountTV = sharedFollowPreferences.getString("0","0");
        String followingCountTV = sharedFollowPreferences.getString("0","0");
        int userBackground = sharedPreferences.getInt("profileImage", R.drawable.banner);
        nameUser.setText(userName);
        followersCount.setText(followersCountTV);
        followingCount.setText(followingCountTV);
        Picasso.get().load(userProfile).transform(new CircleTransform()).into(photoProfile);
        photobackground.setBackgroundResource(userBackground);
        fetch(uid);
    }
    public void fetch(String uid){
        apiClientDetails = ApiClient.getRetrofitInstance().create(PoemInterface.class);
        Call<PoemListData> call = apiClientDetails.Allpoemcall(uid,"published");
        call.enqueue(new Callback<PoemListData>() {
            @Override
            public void onResponse(Call<PoemListData> call, Response<PoemListData> response) {
                poemData = response.body();
                if (poemData.getCode() == 0){
                    popularpoemList = poemData.getData();
                    poemAdaptor = new PoemAdaptor(view.getContext(), popularpoemList);
                    recycleruser.setLayoutManager(new LinearLayoutManager(view.getContext()));
                    recycleruser.setAdapter(poemAdaptor);
                }
            }

            @Override
            public void onFailure(Call<PoemListData> call, Throwable t) {

            }
        });
    }
}