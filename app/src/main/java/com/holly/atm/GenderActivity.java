package com.holly.atm;

import  android.content.Intent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;
import static android.content.Intent.parseUri;

public class GenderActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
    }

    public void next4(View view) {
        EditText edGender = findViewById(R.id.ed_gender);
        int  gender = Integer.parseInt(edGender.getText().toString());
        user.setGender(gender);

        Intent main = new Intent(GenderActivity.this,MainActivity.class);
        setResult(RESULT_OK);
        main.setFlags(FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(main);
    }
    public void back2(View view) {
        finish();
    }
}
