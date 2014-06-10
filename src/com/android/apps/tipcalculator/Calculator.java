package com.android.apps.tipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class Calculator extends Activity {
	
	EditText etBillAmount;
	TextView txtTipValue;
	TextView txtTotalValue;
	EditText etSplit;
	TextView txtSplitValue;
	TextView txtTipPercentage;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculator);
		etBillAmount = (EditText)findViewById(R.id.edtBillAmount);
		int index = etBillAmount.getText().toString().length();
		etBillAmount.setSelection(index);
		etBillAmount.setFocusable(true);
		//etSplit = (EditText)findViewById(R.id.edtSplit);
		txtTipPercentage = (TextView)findViewById(R.id.txtTipPercentage);
		
		SeekBar seekTipPercentage = (SeekBar)findViewById(R.id.seekTipPercentage);
		seekTipPercentage.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				txtTipPercentage.setText(progress + "% ");
				tipCalculator((double)progress);
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
	}
	
	
	private void setupListViewListener(){
		etBillAmount.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				//tipCalculator();
				
			}
		});
	}
	
	public void calculateTip(View v){
		tipCalculator(10);
	}
	
	public void tipCalculator(double tipPercentage){
		etBillAmount = (EditText)findViewById(R.id.edtBillAmount);
		txtTipValue = (TextView)findViewById(R.id.txtTipValue);
		txtTotalValue = (TextView)findViewById(R.id.txtTotalValue);
		//etSplit = (EditText)findViewById(R.id.edtSplit);
		//txtSplitValue = (TextView)findViewById(R.id.txtSplitValue);
		
		double billAmount = Double.parseDouble(etBillAmount.getText().toString());
		int splitInto = 1; 
		
		double tip_percent = tipPercentage/100;
		double tip = (double)(billAmount*tip_percent);
		double totalAmount = billAmount + tip;
		double splitValue = (double)totalAmount/splitInto;
		
		
		txtTipValue.setText("$" + tip);
		txtTotalValue.setText("$" + totalAmount);
//		txtSplitValue.setText("$" + splitValue);
	
		
	
		
	}
	
	
}
