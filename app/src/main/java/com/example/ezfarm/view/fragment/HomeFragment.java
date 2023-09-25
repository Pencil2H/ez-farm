package com.example.ezfarm.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.poe_life.R;
import com.example.poe_life.adapter.CardViewRecyclerAdaptor;
import com.example.poe_life.adapter.PoemAdaptor;
import com.example.poe_life.data.api.ApiClient;
import com.example.poe_life.data.interfaces.MiscInterface;
import com.example.poe_life.data.interfaces.PoemInterface;
import com.example.poe_life.data.model.CategoriesData;
import com.example.poe_life.data.model.PoemListData;
import com.example.poe_life.view.activity.AllPoemListActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    RecyclerView viewPager;
    List<CategoriesData.categories> modelcardviews;
    RecyclerView recycleHome;
    View view;
    PoemInterface apiClientDetails;
    MiscInterface apiClientCat;
    PoemAdaptor poemAdaptor;
    CategoriesData categoriesData;
    PoemListData poemData;
    List<PoemListData.Popularpoem> popularpoemList;
    TextView namehome,seeall;
    String userName,uid;
    CardViewRecyclerAdaptor cardAdapter;




    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home,container,false);
        seeall = view.findViewById(R.id.SeeAll);
        recycleHome = view.findViewById(R.id.recycleDraft);
        viewPager = view.findViewById(R.id.viewpagerHome);
        namehome = view.findViewById(R.id.nameHome);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyUserData", Context.MODE_PRIVATE);
        userName = sharedPreferences.getString("userName","Guest");

        namehome.setText(userName);
        uid = sharedPreferences.getString("userId", "0");


        seeall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AllPoemListActivity.class);
                intent.putExtra("type","all");
                startActivity(intent);
            }
        });
        fetch();

        apiClientCat = ApiClient.getRetrofitInstance().create(MiscInterface.class);
        Call<CategoriesData> callCategories = apiClientCat.getcategories(uid);
        callCategories.enqueue(new Callback<CategoriesData>() {
            @Override
            public void onResponse(Call<CategoriesData> call, Response<CategoriesData> response) {
                categoriesData = response.body();
                if (categoriesData.getCode() == 0) {
                    modelcardviews = categoriesData.getData();
                    LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false);
                    cardAdapter = new CardViewRecyclerAdaptor(view.getContext(), modelcardviews);
                    viewPager.setLayoutManager(layoutManager);
                    viewPager.setAdapter(cardAdapter);
                }
            }

            @Override
            public void onFailure(Call<CategoriesData> call, Throwable t) {

            }
        });

        return view;
    }

    public void fetch(){
        apiClientDetails = ApiClient.getRetrofitInstance().create(PoemInterface.class);
        Call<PoemListData> call = apiClientDetails.getPopularPoem(uid);
        call.enqueue(new Callback<PoemListData>() {
            @Override
            public void onResponse(Call<PoemListData> call, Response<PoemListData> response) {
                poemData = response.body();
                if (poemData.getCode() == 0){
                    popularpoemList = poemData.getData();
                    poemAdaptor = new PoemAdaptor(view.getContext(), popularpoemList);
                    recycleHome.setLayoutManager(new LinearLayoutManager(view.getContext()));
                    recycleHome.setAdapter(poemAdaptor);

                }
            }

            @Override
            public void onFailure(Call<PoemListData> call, Throwable t) {

            }
        });
    }
    @Override
    public void onResume() {
        super.onResume();
        fetch();
    }
}