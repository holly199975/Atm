package com.holly.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NicknameActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nickname);
    }

    public void next(View view) {
        EditText edNick = findViewById(R.id.ed_nickname);
        String nickName = edNick.getText().toString();
        user.setNickName(nickName);

        Intent age = new Intent(NicknameActivity.this,AgeActivity.class);
        startActivity(age);
    }
}
