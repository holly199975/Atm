package com.holly.atm;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class AgeActivity extends BaseActivity {
    int []numbers = {19,20,21,22,23,24,25};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //TODO:set adapter
        recyclerView.setAdapter(new AgeAdapter());
    }

    public void next(View view) {
        int age = Integer.parseInt(((EditText)findViewById(R.id.ed_age)).getText().toString());
        user.setAge(age);
        Intent gender = new Intent(this, GenderActivity.class);
        startActivity(gender);
    }

    public void back(View view) {
        finish();
    }
    class AgeAdapter extends RecyclerView.Adapter<AgeAdapter.AgeHoder>{


        @NonNull
        @Override
        public AgeHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.age_row,parent,false);
            return new AgeHoder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull AgeHoder holder, int position) {
            holder.ageText.setText(numbers[position]);
        }

        @Override
        public int getItemCount() {
            return numbers.length;
        }

        class AgeHoder extends RecyclerView.ViewHolder{
            TextView ageText;
            public AgeHoder(View itemView) {
                super(itemView);
                ageText = itemView.findViewById(R.id.tv_age);
            }
        }
    }

}
