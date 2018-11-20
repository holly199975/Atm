package com.holly.atm;

import android.content.Context;
import android.content.SharedPreferences;

public class User {
    private  Context context;
    String id;
    String nickname;
    String age;
    String gender;
    boolean valid = false;

    SharedPreferences settings;

    public User(Context context){
        this.context = context;
        settings = context.getSharedPreferences("user",Context.MODE_PRIVATE);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        if (nickname == null){
            nickname = settings.getString("NICKNAME",null);
        }

        return nickname;
    }

    public void setNickname(String nickname) {
        settings.edit()
                .putString("NICKNAME",nickname)
                .apply();
        this.nickname = nickname;
    }

    public String getAge() {
        if (age == null){
            age = settings.getString("AGE",null);
        }
        return age;
    }

    public void setAge(String age) {
        settings.edit()
                .putString("AGE",age)
                .apply();
        this.age = age;
    }

    public String getGender() {
        if (gender == null){
            gender = settings.getString("GENDER",null);
        }
        return gender;
    }

    public void setGender(String gender) {
        settings.edit()
                .putString("GENDER",gender)
                .apply();
        this.gender = gender;
    }

    public boolean isValid() {
        valid = getNickname() != null && age != null && gender != null;
        return valid;
    }
}
