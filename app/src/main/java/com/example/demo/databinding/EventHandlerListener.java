package com.example.demo.databinding;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

public class EventHandlerListener {

    private Context context;

    public EventHandlerListener(Context context) {
        this.context = context;
    }

    public void onButtonClicked(View view) {
        Toast.makeText(context, "i am clicked", Toast.LENGTH_SHORT).show();
    }
}
