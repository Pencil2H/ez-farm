package com.example.ezfarm.view.fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.poe_life.R;
import com.example.poe_life.adapter.BookmarkAdaptor;
import com.example.poe_life.data.api.ApiClient;
import com.example.poe_life.data.interfaces.BookmarkInterface;
import com.example.poe_life.data.model.BookmarkGetData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookmarkFragment extends Fragment {
    RecyclerView bookmarkrecycle;
    LinearLayout bookmarkEmpty;
    BookmarkAdaptor bookmarkAdaptor;
    BookmarkInterface apiClient;
    BookmarkGetData BookmarkData;
    List<BookmarkGetData.GetBookmark> bookmarkList;

    View view;

    public void loadbookmark(){
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyUserData", Context.MODE_PRIVATE);
        String uid = sharedPreferences.getString("userId", "0");
        apiClient = ApiClient.getRetrofitInstance().create(BookmarkInterface.class);
        Call<BookmarkGetData> call = apiClient.getMyBookmark(uid);

        call.enqueue(new Callback<BookmarkGetData>() {
            @Override
            public void onResponse(Call<BookmarkGetData> call, Response<BookmarkGetData> response) {
                BookmarkData = response.body();
                if (BookmarkData.getCode() == 0){
                    bookmarkList = BookmarkData.getData();
                    bookmarkAdaptor = new BookmarkAdaptor(view.getContext(),bookmarkList);
                    bookmarkrecycle.setLayoutManager(new LinearLayoutManager(view.getContext()));
                    bookmarkrecycle.setAdapter(bookmarkAdaptor);
                }else{
                    bookmarkEmpty.setVisibility(View.VISIBLE);
                    bookmarkrecycle.setVisibility(View.GONE);
                }

            }

            @Override
            public void onFailure(Call<BookmarkGetData> call, Throwable t) {

            }
        });

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.fragment_bookmark,container,false);
        bookmarkrecycle= view.findViewById(R.id.userprofileRecycler);
        bookmarkEmpty = view.findViewById(R.id.emptyBookmarkLayout);
        loadbookmark();

        return view;
    }

}