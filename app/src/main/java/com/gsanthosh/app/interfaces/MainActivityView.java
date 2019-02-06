package com.gsanthosh.app.interfaces;

import com.gsanthosh.app.base.IView;
import com.gsanthosh.app.model.Post;

import java.util.List;

/**
 * Created by gsanthosh91 on 06-02-2019.
 */

public interface MainActivityView extends IView {
    void setPlacesList(List<Post> posts);
}
