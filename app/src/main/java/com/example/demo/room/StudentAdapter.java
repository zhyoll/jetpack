package com.example.demo.room;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.demo.R;

import java.util.List;

public class StudentAdapter extends BaseAdapter {

    private List<Student> studentList;
    private LayoutInflater mInflater;

    public StudentAdapter(List<Student> studentList, Context context) {
        this.studentList = studentList;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return studentList == null ? 0 : studentList.size();
    }

    @Override
    public Object getItem(int i) {
        return studentList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = mInflater.inflate(R.layout.item_student, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.id = view.findViewById(R.id.tv_id);
            viewHolder.name = view.findViewById(R.id.tv_name);
            viewHolder.age = view.findViewById(R.id.tv_age);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Student student = studentList.get(i);
        viewHolder.id.setText(student.id + "");
        viewHolder.name.setText(student.name);
        viewHolder.age.setText(student.age);
        return view;
    }

    class ViewHolder {
        TextView id;
        TextView name;
        TextView age;
    }
}
