package com.example.tipcalculator;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.widget.Toast;

public class TipCalculatorActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
        EditText etAmount = (EditText)findViewById(R.id.etAmount);
        etAmount.addTextChangedListener(new TextWatcher(){
            public void afterTextChanged(Editable s) {
        		TextView tvTipAmount = (TextView)findViewById(R.id.tvTipAmount);
        		tvTipAmount.setText(""); 
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        }); 
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tip_calculator, menu);
        return true;
    }
    
    public void onClickCompute(View v){
    	int button = ((Button)v).getId();
    	EditText etAmount = (EditText)findViewById(R.id.etAmount);
    	Float amount = null;
    	try {
    		amount = Float.valueOf(etAmount.getText().toString());
    	}
    	catch (NumberFormatException nex) {
    		Toast.makeText(this,  "Invalid number", Toast.LENGTH_SHORT).show();
    	}
    	if (amount != null) {
    		double tip = 0.0;
    		switch (button) {
    		case R.id.buttonTenPercent: 
    			tip = amount * 0.1;
    			break;
    		case R.id.buttonFifteenPercent: 
    			tip = amount * 0.15;
    			break;
    		case R.id.buttonTwentyPercent: 
    			tip = amount * 0.20;
    			break;
    		}
    		TextView tvTipAmount = (TextView)findViewById(R.id.tvTipAmount);
    		tvTipAmount.setText(String.format("The tip amount is $%.2f", tip));
    	}
    }
}
