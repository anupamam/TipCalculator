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
	TextView txtSplitValue;
	TextView txtTipPercentage;
	TextView txtSplitAmount;
	double tipPercentage=15;
	int split=1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculator);
		etBillAmount = (EditText)findViewById(R.id.edtBillAmount);
		int index = etBillAmount.getText().toString().length();
		etBillAmount.setSelection(index);
		etBillAmount.setFocusable(true);
		txtSplitValue = (TextView)findViewById(R.id.txtSplitValue);
		txtTipPercentage = (TextView)findViewById(R.id.txtTipPercentage);
		
		SeekBar seekTipPercentage = (SeekBar)findViewById(R.id.seekTipPercentage);
		seekTipPercentage.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				txtTipPercentage = (TextView)findViewById(R.id.txtTipPercentage);
				txtTipPercentage.setText(progress + "% ");
				tipPercentage = (double)progress;
				tipCalculator();
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
		
		SeekBar seekSplit =  (SeekBar)findViewById(R.id.seekSplit);
		seekSplit.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				txtSplitValue = (TextView)findViewById(R.id.txtSplitValue);
				txtSplitValue.setText(progress+"");
				split = progress;
				tipCalculator();
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
	
	
	
	
	public void calculateTip(View v){
		//tipCalculator(10);
	}
	
	//public void tipCalculator(double tipPercentage){
	public void tipCalculator(){
		etBillAmount = (EditText)findViewById(R.id.edtBillAmount);
		txtTipValue = (TextView)findViewById(R.id.txtTipValue);
		txtTotalValue = (TextView)findViewById(R.id.txtTotalValue);
		txtSplitAmount = (TextView)findViewById(R.id.txtSplitAmount);
		
		double billAmount = Double.parseDouble(etBillAmount.getText().toString());
		
		
		double tip_percent = tipPercentage/100;
		double tip = (double)(billAmount*tip_percent);
		double totalAmount = billAmount + tip;
		double splitValue = (double)totalAmount/split;
		
		
		txtTipValue.setText("$" + tip);
		txtTotalValue.setText("$" + totalAmount);
		txtSplitAmount.setText("$" + splitValue);
	
		
	
		
	}
	
	
}
