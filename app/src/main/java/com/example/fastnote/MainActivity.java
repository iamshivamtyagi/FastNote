package com.example.fastnote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et_input;
    Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_input = findViewById(R.id.et_input);
        buttonSave = findViewById(R.id.buttonSave);

        final SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        String previousInput = sharedPreferences.getString("previousInput", "Error !!! \n Nothing found.");
        et_input.setText(previousInput);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("previousInput",et_input.getText().toString());
                editor.commit();
            }
        });
    }
}
