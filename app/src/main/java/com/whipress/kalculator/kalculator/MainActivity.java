package com.whipress.kalculator.kalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import bsh.EvalError;
import bsh.Interpreter;
//This class belongs to BeanShell .jar package


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

TextView CalculationValues;
Button btn9, btn8, btn7, btn6, btn5, btn4, btn3, btn2, btn1, btn0, btnSum, btnClear, btnMinus, btnDivision, btnMulti, btnPoint , btnResult;


String operartionValue;
int counterOp = 0;

int triggerOne = 0;


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




    @Override
    public void onClick(View v) {

        TextView txt1 = (TextView) findViewById(v.getId());


       if (txt1.getText().equals("+") && triggerOne == 0 || txt1.getText().equals("-") && triggerOne == 0 || txt1.getText().equals("X") && triggerOne == 0 || txt1.getText().equals("÷") && triggerOne == 0)
                {

                    operartionValue = "";
                    Log.w("Valor", "Clique do +");
             }





        if (txt1.getText().equals("+") || txt1.getText().equals("-") || txt1.getText().equals("X") || txt1.getText().equals("÷"))
        {

            counterOp = counterOp + 1;
        }
        else
        {
            counterOp = 1;
            triggerOne = 1;
        }




            if (txt1.getText().equals("="))
            {

                //This object was created used BeanShell
                Interpreter interpreter = new Interpreter();



                try {

                    String equation = CalculationValues.getText().toString();
                    equation = equation.replace("X", "*");
                    equation = equation.replace("÷", "/");
                    interpreter.eval("result =" + equation);
                    CalculationValues.setText(interpreter.get("result").toString());
                    }

                    catch (EvalError evalError)
                    {
                         evalError.printStackTrace();
                    }
            }

            else
                {

                operartionValue = txt1.getText().toString();


                    if (counterOp > 2)
                {
                    operartionValue = "";
                }


                if (triggerOne > 0 ) {
                    CalculationValues.setText(CalculationValues.getText().toString() + operartionValue);

                }
                }


        // This condition clears the textview
        if (txt1.getText().equals("C"))
        {
            CalculationValues.setText("");
            triggerOne = 0;

        }

        }
    }


