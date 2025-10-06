package com.example.lab3calculatorapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.graphics.Color;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActiviity extends AppCompatActivity {
    // تعريف الاوبجكت للربط
    private EditText WT, Ht;
    private Button bCal, bC;
    private TextView res;
    private float op1, op2,op3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second_activiity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // خطوة الربط
        WT = (EditText) findViewById(R.id.TheWeight);
        Ht = (EditText) findViewById(R.id.Height);

        bCal = (Button) findViewById(R.id.Calbutton);
        bC = (Button) findViewById(R.id.clearButton);

        res = (TextView) findViewById(R.id.tvResult);

        bCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op1 = Float.parseFloat(WT.getText().toString()); // الوزن بالكيلو
                op2 = Float.parseFloat(Ht.getText().toString()); // الطول بالـ cm

                op3 = (op1 / (op2 * op2)) * 10000;

                if (op3 < 18.5) {
                    res.setText("Underweight: " + op3);
                    res.setBackgroundColor(Color.parseColor("#F4A460"));
                } else if (op3 < 25) {
                    res.setText("Normal weight: " + op3);
                    res.setBackgroundColor(Color.parseColor("#228B22"));
                } else if (op3 < 30) {
                    res.setText("Overweight: " + op3);
                    res.setBackgroundColor(Color.parseColor("#FF8C00"));
                } else {
                    res.setText("Obese: " + op3);
                    res.setBackgroundColor(Color.parseColor("#B22222"));
                }
            }
        });
        //Clear op
        bC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WT.setText("");
                Ht.setText("");
                res.setText("");
                res.setBackgroundColor(Color.TRANSPARENT);


            }
        });

    }

    public void MovetoMain( View v ){
        // use explicit intent to move to another activity

        //From, to
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);

    }

}