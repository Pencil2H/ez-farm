package com.example.ezfarm.view.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.poe_life.R;
import com.example.poe_life.view.additional.CircleTransform;
import com.squareup.picasso.Picasso;

public class CommentFragment extends Fragment {
    View view;
    ImageView commentProfile;
    EditText commentEdittext;
    String userName;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_comment_full, container, false);
        commentEdittext = view.findViewById(R.id.commentEditText);
        commentProfile = view.findViewById(R.id.commentPicture);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyUserData", Context.MODE_PRIVATE);
        userName = sharedPreferences.getString("userName","Guest");

        String photo = sharedPreferences.getString("userimage","");
        Picasso.get().load(photo).transform(new CircleTransform()).into(commentProfile);


        return view;
        }
    }
