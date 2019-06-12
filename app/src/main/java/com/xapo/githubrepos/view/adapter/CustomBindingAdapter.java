package com.xapo.githubrepos.view.adapter;

import android.databinding.BindingAdapter;
import android.view.View;

public class CustomBindingAdapter {
    @BindingAdapter("visibleGone")
    public static void showHide(View view, boolean show) {
        view.setVisibility(show ? View.VISIBLE : View.GONE);
    }

//    @BindingAdapter("imageUrl")
//    public static void setImageUrl(ImageView imageView, String url){
//        if(url == null)
//        {
//            imageView.setImageDrawable(null);
//        }else {
//            Glide.with(imageView.getContext()).load(url);
//        }
//    }

}
