package com.example.numbertable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Submit (View view) {

        int padding = (int) (getResources().getDimension(R.dimen.padding));

        EditText max = findViewById(R.id.max);
        EditText min = findViewById(R.id.min);

        String maxString = max.getText().toString();
        String minString = min.getText().toString();

        int maxInt = Integer.parseInt(maxString);
        int minInt = Integer.parseInt(minString);

        if (minInt >= maxInt){
            thingWentWrong();
        }
        TableLayout table = findViewById(R.id.table);
        table.removeAllViews();
        for (int i = minInt; i <= maxInt; i++) {
            TableRow output = new TableRow(this);
            TextView number = new TextView(this);
            number.setText(Integer.toString(i));
            number.setPadding(0,0, padding, 0);
            TextView number2 = new TextView(this);
            number2.setText(Integer.toString(i * i));
            number2.setPadding(0,0, padding, 0);
            TextView number3 = new TextView(this);
            number3.setText(Integer.toString(i * i * i));
            number3.setPadding(0,0, padding, 0);
            TextView number4 = new TextView(this);
            double numberSquared = Math.sqrt(i);
            number4.setText(Double.toString(numberSquared));
            number4.setPadding(0,0, padding, 0);
            TextView number5 = new TextView(this);
            int placeholder = 1;
            for (int j  = 1; j <= i; j++) {
                placeholder = placeholder*j;
            }
            number5.setText(Integer.toString(placeholder));
            number5.setPadding(0,0, padding, 0);

            output.addView(number);

            CheckBox check =  findViewById(R.id.checkbox_nPowerOf2);
            if (check.isChecked()){
                output.addView(number2);
            }
            CheckBox check2 = findViewById(R.id.checkbox_nPowerOf3);
            if (check2.isChecked()){
                output.addView(number3);
            }
            CheckBox check3 = findViewById(R.id.checkbox_nSquared);
            if (check3.isChecked()){
                output.addView(number4);
            }
            CheckBox check4 = findViewById(R.id.checkbox_nFactorial);
            if (check4.isChecked()){
                output.addView(number5);
            }

            table.addView(output);
        }



    }

    private void thingWentWrong (){
        Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
    }

}
