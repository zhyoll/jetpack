package com.example.demo.databinding;

import android.graphics.Color;
import android.text.TextUtils;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.example.demo.R;
import com.squareup.picasso.Picasso;

public class RecyclerViewImageBindingAdapter {

    @BindingAdapter("itemImage")
    public static void setImg(ImageView img, String imgUrl) {
        if (!TextUtils.isEmpty(imgUrl)) {
            Picasso.get().load(imgUrl)
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(img);
        } else {
            img.setBackgroundColor(Color.DKGRAY);
        }
    }
}
