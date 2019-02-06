package com.gsanthosh.app.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.gsanthosh.app.MVVMApplication;
import com.gsanthosh.app.adapter.PlacesAdapter;
import com.gsanthosh.app.R;
import com.gsanthosh.app.base.BaseActivity;
import com.gsanthosh.app.databinding.ActivityMainBinding;
import com.gsanthosh.app.interfaces.MainActivityView;
import com.gsanthosh.app.model.Post;
import com.gsanthosh.app.viewmodel.MainViewModel;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> implements MainActivityView {
    @Inject
    MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MVVMApplication.getComponent().inject(this);
        super.onCreate(savedInstanceState);
        viewModel.attach(this);
        bindView(R.layout.activity_main);
        setTitle("Welcome");
        binding.rcyResult.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        viewModel.fetchPosts();

    }

    @Override
    public void setPlacesList(List<Post> posts) {
        binding.rcyResult.setAdapter(new PlacesAdapter(this, posts));
        hideLoading();
    }

    @Override
    public void showLoading() {
        binding.pbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        binding.pbLoading.setVisibility(View.GONE);
    }
}
