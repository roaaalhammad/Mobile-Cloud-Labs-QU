package com.example.lab3calculatorapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FirstActivity extends AppCompatActivity {
    // تعريف الاوبجكت للربط
    private EditText fisrtNum, secNum;
    private Button bA, bS, bM, bD, bC;
    private TextView res;
    private float op1, op2, op3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_first);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // خطوة الربط
        fisrtNum = (EditText) findViewById(R.id.num1);
        secNum = (EditText) findViewById(R.id.num2);

        bA = (Button) findViewById(R.id.addButton);
        bS = (Button) findViewById(R.id.subButton);
        bM = (Button) findViewById(R.id.mulButton);
        bD = (Button) findViewById(R.id.divButton);
        bC = (Button) findViewById(R.id.clearButton);

        res = (TextView) findViewById(R.id.result);

        // Add op

        bA.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 op1 = Float.parseFloat(fisrtNum.getText().toString());
                 op2 = Float.parseFloat(secNum.getText().toString());
                 op3 = op1 + op2;
                 res.setText(Float.toString(op3));

             }
         });
         //Subtract op
        bS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op1 = Float.parseFloat(fisrtNum.getText().toString());
                op2 = Float.parseFloat(secNum.getText().toString());
                op3 = op1 - op2;
                res.setText(Float.toString(op3));

            }
        });

        //  Multuplay op
        bM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op1 = Float.parseFloat(fisrtNum.getText().toString());
                op2 = Float.parseFloat(secNum.getText().toString());
                op3 = op1 * op2;
                res.setText(Float.toString(op3));

            }
        });

        //Divide op
        bD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op1 = Float.parseFloat(fisrtNum.getText().toString());
                op2 = Float.parseFloat(secNum.getText().toString());
                op3 = op1 / op2;
                res.setText(Float.toString(op3));

            }
        });


        //Clear op
        bC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fisrtNum.setText("");
                secNum.setText("");
                res.setText("");

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

