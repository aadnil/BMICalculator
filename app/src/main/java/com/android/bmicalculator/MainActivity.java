package com.android.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText edit_text, edit_text1,outputbmi;
Button computebmi;
Double weight, height, result;
String getHeight,getWeight,getHeightInMeters,bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_text=findViewById(R.id.edit_text);
        edit_text1=findViewById(R.id.edit_text1);
        outputbmi=findViewById(R.id.outputbmi);

        computebmi=findViewById(R.id.computebmi);
        computebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calculate cal=new Calculate(getHeight,getWeight);
                cal.setEdittext(edit_text.getText().toString());
                cal.setEdittext1(edit_text1.getText().toString());
                getHeight=cal.getEdittext();
                getWeight=cal.getEdittext1();
                getHeightInMeters=Double.parseDouble(getHeight)/100+"";
                bmi=Double.parseDouble(getWeight)/((Double.parseDouble(getHeightInMeters))*
                        (Double.parseDouble(getHeightInMeters)))+"";
                outputbmi.setText(bmi);

                if(Double.parseDouble(bmi) < 18.5)
                {
                    Toast.makeText(MainActivity.this, "UnderWeight", Toast.LENGTH_LONG).show();

                }
                if(Double.parseDouble(bmi) > 18.5 && Double.parseDouble(bmi) <=24.9)
                {
                    Toast.makeText(MainActivity.this, "Normal", Toast.LENGTH_LONG).show();

                }
                if(Double.parseDouble(bmi) > 25 && Double.parseDouble(bmi) <=29.9)
                {
                    Toast.makeText(MainActivity.this, "Overweight", Toast.LENGTH_LONG).show();

                }
                if(Double.parseDouble(bmi) >=30)
                {
                    Toast.makeText(MainActivity.this, "Obsesity", Toast.LENGTH_LONG).show();

                }

            }
        });
    }
}
