package com.example.taruc.lab3_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinnerAge;
    private TextView textViewPremium;
    private RadioGroup radioGroupGroup;
    private CheckBox checkBoxSmoker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerAge = (Spinner) findViewById(R.id.spinnerAge);
        textViewPremium= (TextView) findViewById(R.id.textView3);
        radioGroupGroup= (RadioGroup) findViewById(R.id.radioGroup);
        checkBoxSmoker= (CheckBox) findViewById(R.id.checkBox);

        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this, R.array.age, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerAge.setAdapter(adapter);
        spinnerAge.setOnItemSelectedListener(this);
    }

    public void calculatePremium(View v){
        double premium= 0;
        int gender= radioGroupGroup.getCheckedRadioButtonId();
        int age= spinnerAge.getSelectedItemPosition();
        boolean male = false;
        boolean smoker = false;

        if(gender == R.id.radioButtonMale){
            male= true;
        }
        if(checkBoxSmoker.isChecked()){
            smoker= true;
        }
        if (age == 0){
            premium = 50;
        }else if(age == 1){
            premium = 55;
        }else if(age == 2){
            premium = 60;
            if(male== true)
                premium+= 50;
        }else if(age == 3){
            premium = 70;
            if(male== true)
                premium+= 100;
            if(smoker == true)
                premium+= 100;
        }else if(age == 4){
            premium = 120;
            if(male== true)
                premium+= 100;
            if(smoker == true)
                premium+= 150;
        }else if(age == 5){
            premium = 160;
            if(male== true)
                premium+= 50;
            if(smoker == true)
                premium+= 150;
        }else if(age == 6){
            premium = 200;
            if(smoker == true)
                premium+= 250;
        }else if(age == 7){
            premium = 250;
            if(smoker == true)
                premium+= 250;
        }
        textViewPremium.setText("Total Premium = RM"+ String.format("%.2f",premium));
    }

    public void ResetPremium(View v){
        checkBoxSmoker.setChecked(false);
        spinnerAge.setSelection(0);
        textViewPremium.setText("Premium");
        radioGroupGroup.clearCheck();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(id == R.id.spinnerAge){
            if(position ==0){

            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
