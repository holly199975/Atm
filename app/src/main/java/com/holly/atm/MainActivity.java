package com.holly.atm;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends BaseActivity {
    private static final int RC_LOGIN = 90;
    boolean login = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(!login){
            Intent intent = new Intent(this,LoginActivity.class);
            startActivityForResult(intent,RC_LOGIN);
        }
        //data
        List<String> fruit = Arrays.asList("草莓","芭樂","蘋果");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,fruit);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RC_LOGIN){
            if(resultCode!=RESULT_OK){
                finish();
            }else{
                login=true;

                if(!user.isValid()){
                    Intent nickName = new Intent(this,NicknameActivity.class);
                    startActivity(nickName);
                }

            }
        }
    }
}
