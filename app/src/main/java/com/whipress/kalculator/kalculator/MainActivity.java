package com.whipress.kalculator.kalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

TextView CalculationValues;
Button btn9, btn8, btn7, btn6, btn5, btn4, btn3, btn2, btn1, btn0, btnSum, btnClear, btnMinus, btnDivision, btnMulti, btnPoint , btnResult;
String operationSignal;

Double v1 = 0.0, v2 = 0.0, v3 = 0.0, v4 = 0.0;
Integer s1 = 0 , s2 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CalculationValues = (TextView)findViewById(R.id.CalculationValues);

        createCalculatorButtons();


    }

    public void createCalculatorButtons()
    {

        btn9 = (Button)findViewById(R.id.btn9);
        btn9.setOnClickListener(this);

        btn8 = (Button)findViewById(R.id.btn8);
        btn8.setOnClickListener(this);

        btn7 = (Button)findViewById(R.id.btn7);
        btn7.setOnClickListener(this);

        btn6 = (Button)findViewById(R.id.btn6);
        btn6.setOnClickListener(this);

        btn5 = (Button)findViewById(R.id.btn5);
        btn5.setOnClickListener(this);

        btn4 = (Button)findViewById(R.id.btn4);
        btn4.setOnClickListener(this);

        btn3 = (Button)findViewById(R.id.btn3);
        btn3.setOnClickListener(this);

        btn2 = (Button)findViewById(R.id.btn2);
        btn2.setOnClickListener(this);

        btn1 = (Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(this);

        btn0 = (Button)findViewById(R.id.btn0);
        btn0.setOnClickListener(this);


        btnDivision = (Button)findViewById(R.id.btnDivision);
        btnDivision.setOnClickListener(this);

        btnMulti = (Button)findViewById(R.id.btnMulti);
        btnMulti.setOnClickListener(this);

        btnMinus = (Button)findViewById(R.id.btnMinus);
        btnMinus.setOnClickListener(this);

        btnSum = (Button)findViewById(R.id.btnSum);
        btnSum.setOnClickListener(this);

        btnPoint = (Button)findViewById(R.id.btnPoint);
        btnPoint.setOnClickListener(this);

        btnClear = (Button)findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);


        btnResult = (Button)findViewById(R.id.btnResult);
        btnResult.setOnClickListener(this);

    }

    public void insertCalculationValues(View z)
    {
        TextView txtView = (TextView)findViewById(z.getId());

        if (txtView.getText().toString().equals("-") && s1 == 0)
        {

            operationSignal = "-";

                s1 = 1;
                Log.w("S1", "é um" + operationSignal);
          }


        if (txtView.getText().toString().equals("X") && s1 == 0)
        {

            operationSignal = "X";

            s1 = 1;
            Log.w("S1", "é um" + operationSignal);
        }



        if (txtView.getText().toString().equals("="))
        {
            doCalculation();
        }
        else
        {
            CalculationValues.setText(CalculationValues.getText().toString() + txtView.getText());
        }

    }

    public void doCalculation()
    {

        String CurrentString = CalculationValues.getText().toString();

        String[] separated = CurrentString.split(operationSignal);


        Double v1 = Double.parseDouble(separated[0]);
        Double v2 = Double.parseDouble(separated[1]);


        if (operationSignal.equals("-")) {
            Double v3 = v1 - v2;
            Log.w("valores", CurrentString + " > " + operationSignal + v1);
            CalculationValues.setText(v3.toString());
        }

        if (operationSignal.equals("X")) {
            Double v3 = v1 * v2;
            Log.w("valores", CurrentString + " > " + operationSignal + separated[1]);
            CalculationValues.setText(v3.toString());
        }



    }



    @Override
    public void onClick(View v) {

        insertCalculationValues(v);

    }
}
