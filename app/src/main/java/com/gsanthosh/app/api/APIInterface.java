package com.gsanthosh.app.api;

import com.gsanthosh.app.model.Post;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by gsanthosh91 on 06-02-2019.
 */

public interface APIInterface {
    @GET("posts")
    Observable<List<Post>> posts();
}
