package com.software.engineering.alcohollife.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.gson.JsonObject;
import com.software.engineering.alcohollife.R;
import com.software.engineering.alcohollife.model.network.DrinkRetrofit;
import com.software.engineering.alcohollife.model.network.base.RestClient;
import com.software.engineering.alcohollife.ui.review.ItemPage;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainFragment extends Fragment {
    DrinkRetrofit model = RestClient.INSTANCE.getDrinkService();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getView().findViewById(R.id.soju).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).goToCategory("소주");
            }
        });
        getView().findViewById(R.id.beer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).goToCategory("맥주");
            }
        });
        getView().findViewById(R.id.wine).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).goToCategory("막걸리");
            }
        });


        //서치함수 연결
        SearchView searchView = (SearchView) view.findViewById(R.id.searchView2);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                search(s);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return true;
            }
        });
    }

    private void search(final String keyword) {
        model.getAlcohol(keyword).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, final Response<JsonObject> response) {
                new Handler().post(new Runnable() {
                    @Override
                    public void run() {
                        if(response.code() == 200){
                            Intent intent = ItemPage.Companion.getStartIntent(getContext(), keyword);
                            startActivity(intent);
                        }else {
                            Toast.makeText(getContext(), "검색 결과가 없습니다.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }
}