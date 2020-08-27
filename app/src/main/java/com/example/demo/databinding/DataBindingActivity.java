package com.example.demo.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.TextView;

import com.example.demo.BR;
import com.example.demo.R;

public class DataBindingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityDataBindingBinding activityDataBindingBinding = DataBindingUtil.
                setContentView(this, R.layout.activity_data_binding);
//        setContentView(R.layout.activity_data_binding);

        /*TextView tvTitle = findViewById(R.id.tvTitle);
        TextView tvAuthor = findViewById(R.id.tvAuthor);
        TextView tvRating = findViewById(R.id.tvRating);*/



        Book book = new Book("Android 高性能编程", "叶坤");
        book.rating = 5;
        activityDataBindingBinding.setVariable(BR.book, book);

        activityDataBindingBinding.setEventHandler(new EventHandlerListener(this));
//        tvTitle.setText(book.title);
//        tvAuthor.setText(book.author);
//        tvRating.setText(book.rating + "");


    }
}