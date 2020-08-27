package com.example.demo.mvvm;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class User {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id", typeAffinity = ColumnInfo.TEXT)
    public int id;

    @ColumnInfo(name = "name", typeAffinity = ColumnInfo.TEXT)
    public String name;

    @ColumnInfo(name = "avatar", typeAffinity = ColumnInfo.TEXT)
    public String avatar;

    @ColumnInfo(name = "following", typeAffinity = ColumnInfo.INTEGER)
    public int following;

    @ColumnInfo(name = "blog", typeAffinity = ColumnInfo.TEXT)
    public String blog;

    @ColumnInfo(name = "company", typeAffinity = ColumnInfo.TEXT)
    public String company;

    @ColumnInfo(name = "bio", typeAffinity = ColumnInfo.TEXT)
    public String bio;

    @ColumnInfo(name = "location", typeAffinity = ColumnInfo.TEXT)
    public String location;

    @ColumnInfo(name = "htmlUrl", typeAffinity = ColumnInfo.TEXT)
    public String htmlUrl;

    public User(int id, String name, String avatar, int following, String blog, String company,
                String bio, String location, String htmlUrl) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.following = following;
        this.blog = blog;
        this.company = company;
        this.bio = bio;
        this.location = location;
        this.htmlUrl = htmlUrl;
    }
}
