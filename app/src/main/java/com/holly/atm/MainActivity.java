package com.holly.atm;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final int RC_LOGIN=1;
    boolean logon = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!logon){ //如沒登入開啟LoginActivity
            Intent intent = new Intent(this,LoginActivity.class);
            startActivityForResult(intent,RC_LOGIN);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_LOGIN){
            if (resultCode == RESULT_OK){
                String uid = data.getStringExtra("LOGIN_USERID");
                String pw = data.getStringExtra("LOGIN_PASSWD");
                Log.d("RESULT",uid + "/" + pw);
                finish();
            }else{
                String nickname = getSharedPreferences("user",MODE_PRIVATE)
                        .getString("NICKNAME",null);
                String age = getSharedPreferences("user",MODE_PRIVATE)
                        .getString("AGE",null);
                String gender = getSharedPreferences("user",MODE_PRIVATE)
                        .getString("GENDER",null);
                if (nickname == null || age == null || gender == null) {
                    Intent nick = new Intent(this, NicknameActivity.class);
                    startActivity(nick);
                }
            }
        }
    }




}
