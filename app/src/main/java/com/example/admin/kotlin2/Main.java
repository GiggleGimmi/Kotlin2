package com.example.admin.kotlin2;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends AppCompatActivity {

    Button button;
    EditText et;
    TextView txtView;
    String modifyText;

    public void onClick(View v) {
        Button button = (Button) findViewById(R.id.mButton);
        switch (v.getId()) {
            case R.id.mButton: {
                    Toast.makeText(getBaseContext(), et.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.mButton);
        et = (EditText) findViewById(R.id.mInput);

        button.setEnabled(false);

        et.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

                if (s.toString().equals("")) {
                    button.setEnabled(false);
                } else {
                    button.setEnabled(true);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        txtView=(TextView) findViewById(R.id.mOutput);
        button=(Button) findViewById(R.id.mButton);
        et = (EditText) findViewById(R.id.mInput);

        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                txtView.setText("Last input: " + et.getText());
                Toast.makeText(getApplicationContext(), et.getText(), Toast.LENGTH_LONG).show();
            }

        });

    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("TextView","Last input: " + et.getText());
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        String TextView = savedInstanceState.getString("TextView");
        super.onRestoreInstanceState(savedInstanceState);
        txtView.setText(TextView);

    }

}
