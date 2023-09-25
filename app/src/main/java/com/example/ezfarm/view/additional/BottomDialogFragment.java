package com.example.ezfarm.view.additional;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.poe_life.R;
import com.example.poe_life.view.activity.OtherPeopleProfileActivity;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomDialogFragment extends BottomSheetDialogFragment {
    public static BottomDialogFragment newInstance(String userId, String authorId){
        BottomDialogFragment fragment = new BottomDialogFragment();
        Bundle args = new Bundle();
        args.putString("userId",userId);
        args.putString("authorId",authorId);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.customdialog_detailmenuotheruser, container,false);

        String userId = getArguments().getString("userId");
        String authorId = getArguments().getString("authorId");
        LinearLayout otherProfile = v.findViewById(R.id.otherProfileLinearLayout);
        otherProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), OtherPeopleProfileActivity.class);
                intent.putExtra("authorId",authorId);
                intent.putExtra("userId",userId);
                startActivity(intent);
                dismiss();
            }
        });
        return v;
    }
}
