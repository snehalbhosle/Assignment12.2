package com.project.my.sharedpref;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SharedPrefActivity extends AppCompatActivity {
    private Button save;
    private Button show;
    private EditText txt_name;
    private EditText txt_age;
    private EditText txt_phone;
    private EditText txt_city;
    private SharedPreferences sp;
    private SharedPreferences.Editor edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref);

        save = (Button) findViewById(R.id.btn_save);
        show = (Button) findViewById(R.id.btn_show);

        txt_name = (EditText) findViewById(R.id.txt_name);
        txt_age = (EditText) findViewById(R.id.txt_age);
        txt_phone = (EditText) findViewById(R.id.txt_phone);
        txt_city = (EditText) findViewById(R.id.txt_city);
        sp = getApplicationContext().getSharedPreferences("pref",0);
        edit = sp.edit();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                edit.putString("key_name", txt_name.getText().toString());
                edit.putString("key_age", txt_age.getText().toString());
                edit.putString("key_phone", txt_phone.getText().toString());
                edit.putString("key_city", txt_city.getText().toString());
                edit.commit();
                }
            });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = sp.getString("key_name",null) + "\n" +sp.getString("key_age",null) + "\n" +
                        sp.getString("key_phone",null) + "\n" + sp.getString("key_city",null);
                Toast showMsg = Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT);
                showMsg.show();
            }
        });
    }
}

