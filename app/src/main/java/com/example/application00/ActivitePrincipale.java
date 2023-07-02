package com.example.application00;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Scanner;

public class ActivitePrincipale extends AppCompatActivity {

    private TextView screen;
    private int op1=0;
    private int op2=0;
    private Ops operator=null;
    private boolean isOp1=true;


    public enum Ops {
        PLUS,
        MOINS,
        FOIS,
        DIV
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screen = (TextView) findViewById(R.id.screen);


       /* //region Button 0
        Button button0 = (Button) findViewById(R.id.button0);
        button0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                text.setText(text.getText() + "0");

            }
        });
        //endregion

        //region Button 1
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                text.setText(text.getText() + "1");

            }
        });
        //endregion

        //region Button 2
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                text.setText(text.getText() + "2");

            }
        });
        //endregion

        //region Button 3
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                text.setText(text.getText() + "3");

            }
        });
        //endregion

        //region Button 4
        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                text.setText(text.getText() + "4");

            }
        });
        //endregion

        //region Button 5
        Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                text.setText(text.getText() + "5");

            }
        });
        //endregion

        //region Button 6
        Button button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                text.setText(text.getText() + "6");

            }
        });
        //endregion

        //region Button 7
        Button button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                text.setText(text.getText() + "7");

            }
        });
        //endregion

        //region Button 8
        Button button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                text.setText(text.getText() + "8");

            }
        });
        //endregion

        //region Button 9
        Button button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                text.setText(text.getText() + "9");

            }
        });
        //endregion

        //region Button Plus
        Button buttonPlus = (Button) findViewById(R.id.buttonPlus);
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                text.setText(text.getText() + "+");

            }
        });
        //endregion

        //region Button Minus
        Button buttonMinus = (Button) findViewById(R.id.buttonMinus);
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                text.setText(text.getText() + "-");

            }
        });
        //endregion

        //region Button Multiply
        Button buttonMultiply = (Button) findViewById(R.id.buttonMultiply);
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                text.setText(text.getText() + "*");

            }
        });
        //endregion

        //region Button Divide
        Button buttonDivide = (Button) findViewById(R.id.buttonDivide);
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                text.setText(text.getText() + "/");

            }
        });
        //endregion

        //region Button Erase
        Button buttonErase = (Button) findViewById(R.id.buttonErase);
        buttonErase.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                text.setText("");

            }
        });
        //endregion

        //region Button Equal
        Button buttonEqual = (Button) findViewById(R.id.buttonEqual);
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                compute();

            }
        });*/
        //endregion

        Button btnEgal = (Button)findViewById(R.id.buttonEqual);
        btnEgal.setOnClickListener(new View.OnClickListener()
        {public void onClick(View v)
        {
            compute();
        }
        });

    }

    public void compute() {
        if (!isOp1) {
            switch (operator) {
                case PLUS:
                    op1 = op1 + op2;
                    break;
                case MOINS:
                    op1 = op1 - op2;
                    break;
                case FOIS:
                    op1 = op1 * op2;
                    break;
                case DIV:
                    if (op2 != 0) {
                        op1 = op1 / op2;
                    } else {
                        Toast.makeText(this, "Division par zéro", Toast.LENGTH_LONG).show();
                        return;
                    }
                    break;
                default:
                    Log.d("Compute", "Opérateur non reconnu: " + operator.toString());
                    return;
            }
            op2 = 0;
            isOp1 = true;
            updateDisplay();
        }
    }



    private static final int BUTTON_PLUS = R.id.buttonPlus;
    private static final int BUTTON_MINUS = R.id.buttonMinus;
    private static final int BUTTON_MULTIPLY = R.id.buttonMultiply;
    private static final int BUTTON_DIVIDE = R.id.buttonDivide;

    public void setOperator(View v)
    {
        if (!isOp1) {
            if (v.getId() == BUTTON_PLUS) {
                operator = Ops.PLUS;
            } else if (v.getId() == BUTTON_MINUS) {
                operator = Ops.MOINS;
            } else if (v.getId() == BUTTON_MULTIPLY) {
                operator = Ops.FOIS;
            } else if (v.getId() == BUTTON_DIVIDE) {
                operator = Ops.DIV;
            } else {
                Toast.makeText(this, "Opérateur non reconnu", Toast.LENGTH_LONG).show();
                return;
            }
        }
        isOp1 = false;
        updateDisplay();
    }

    public void addNumber(View v)
    {
        try
        {
            int val = Integer.parseInt(((Button)v).getText().toString());
            if (isOp1)
            {
                op1 = op1 * 10 + val;
                updateDisplay();
            } else {
                op2 = op2 * 10 + val;
                updateDisplay();
            }
        }
        catch (NumberFormatException | ClassCastException e)
        {
            Toast.makeText(this, "Valeur erronée",Toast.LENGTH_LONG).show();
        }}

    private void updateDisplay()
    {
        int v =op1;
        if(!isOp1)
        {
            v=op2;
        }
        screen.setText(String.format("%9d",v));
    }

}
