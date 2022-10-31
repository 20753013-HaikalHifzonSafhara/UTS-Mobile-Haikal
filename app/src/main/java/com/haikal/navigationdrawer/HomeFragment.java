package com.haikal.navigationdrawer;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private RecyclerView rvKampus;
    private ArrayList<Kampus> list = new ArrayList<>();

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        rvKampus = view.findViewById(R.id.rv_Minuman);
        rvKampus.setHasFixedSize(true);

        list.addAll(getListKampus());
        showRecyclerList();

    }

    public ArrayList<Kampus> getListKampus() {
        String[] dataName = getResources().getStringArray(R.array.data_name);
        String[] dataDescription = getResources().getStringArray(R.array.data_description);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
        ArrayList<Kampus> listKampus = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Kampus Kampus = new Kampus();
            Kampus.setName(dataName[i]);
            Kampus.setDescription(dataDescription[i]);
            Kampus.setPhoto(dataPhoto.getResourceId(i, -1));
            listKampus.add(Kampus);
        }
        return listKampus;
    }

    private void showRecyclerList() {
        rvKampus.setLayoutManager(new LinearLayoutManager(getContext()));
        ListKampusAdapter listKampusAdapter = new ListKampusAdapter(list);
        rvKampus.setAdapter(listKampusAdapter);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

}