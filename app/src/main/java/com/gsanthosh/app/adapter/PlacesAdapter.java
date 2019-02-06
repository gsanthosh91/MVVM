package com.gsanthosh.app.adapter;

import android.app.Activity;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.gsanthosh.app.BR;
import com.gsanthosh.app.R;
import com.gsanthosh.app.model.Post;

import java.util.List;

/**
 * Created by gsanthosh91 on 10-03-2018.
 */


public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.MyViewHolder> {
    private List<Post> list;

    public PlacesAdapter(Activity activity, List<Post> post) {
        this.list = post;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding layoutPlacesBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.list_item_post,
                        parent, false);
        return new MyViewHolder(layoutPlacesBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(list.get(position));
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    @BindingAdapter({"android:src"})
    public static void setImageViewResource(ImageView imageView, String resource) {
        Glide.with(imageView.getContext()).load(resource).into(imageView);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private final ViewDataBinding binding;

        MyViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Object obj) {
            binding.setVariable(BR.obj, obj);
            binding.executePendingBindings();

        }
    }
}