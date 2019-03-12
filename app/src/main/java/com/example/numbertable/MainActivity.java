package com.example.numbertable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Submit (View view) {
        EditText max = findViewById(R.id.max);
        EditText min = findViewById(R.id.min);

        String maxString = max.getText().toString();
        String minString = min.getText().toString();

        int maxInt = Integer.parseInt(maxString);
        int minInt = Integer.parseInt(minString);

        if (minInt >= maxInt){
            thingWentWrong();
        }
        TableLayout table = new findViewById(R.id.table);
    }

    private void thingWentWrong (){
        Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
    }

}
