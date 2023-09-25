package com.example.ezfarm.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.poe_life.R;

public class NotificationsFragment extends Fragment {
    RecyclerView Notifrecycle;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_notifications,container,false);
//        DataListNotif[] listDatanotif = new DataListNotif[]{
//                new DataListNotif("lalala","lllilii","3 hour ago", R.drawable.ic_heart)
//        };

        Notifrecycle = view.findViewById(R.id.Notifrecycle);
//        Adaptornotif adapter = new Adaptornotif(listDatanotif);
        Notifrecycle.setLayoutManager(new LinearLayoutManager(view.getContext()));
//        Notifrecycle.setAdapter(adapter);
        return view;

    }
}