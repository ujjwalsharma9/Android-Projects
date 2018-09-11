package com.my.converter;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.ClipboardManager;
import android.graphics.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.text.*;


public class DecbinActivity extends Activity {

	private LinearLayout linear1;
	private CheckBox d2b;
	private CheckBox b2d;
	private TextView iptext;
	private EditText input;
	private TextView optext;
	private EditText output;
	private Button convert;

	private double num = 0;
	private double rem = 0;
	private double i = 0;
	private double ans = 0;
	private String Ans = "";
	private double j = 0;




	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.decbin);
		initialize();
		initializeLogic();
	}

	private void  initialize() {
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		d2b = (CheckBox) findViewById(R.id.d2b);
		b2d = (CheckBox) findViewById(R.id.b2d);
		iptext = (TextView) findViewById(R.id.iptext);
		input = (EditText) findViewById(R.id.input);
		optext = (TextView) findViewById(R.id.optext);
		output = (EditText) findViewById(R.id.output);
		convert = (Button) findViewById(R.id.convert);


		convert.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				if (!(b2d.isChecked() || d2b.isChecked())) {
					showMessage("Please select an option...");
				}
				else {
					if (input.getText().toString().length() > 0) {
						if (d2b.isChecked()) {
							_dec_to_bin(Double.parseDouble(input.getText().toString()));
						}
						else {
							_check(input.getText().toString());
							_bin_to_d(input.getText().toString());
						}
					}
					else {
						showMessage("Please enter a valid input..");
					}
				}
			}
		});
		b2d.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				d2b.setChecked(false);
				optext.setText("Decimal:");
				iptext.setText("Binary:");
				input.setText("0");
				output.setText("0");
				input.setEnabled(true);
			}
		});
		d2b.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				b2d.setChecked(false);
				iptext.setText("Decimal:");
				optext.setText("Binary:");
				input.setText("0");
				output.setText("0");
				input.setEnabled(true);
			}
		});
		d2b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _buttonView, final boolean _isChecked)  { 
				if (!_isChecked) {
					b2d.setChecked(true);
					optext.setText("Decimal:");
					iptext.setText("Binary:");
					input.setText("0");
					output.setText("0");
				}
			}
		});
		b2d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _buttonView, final boolean _isChecked)  { 
				if (!_isChecked) {
					d2b.setChecked(true);
					iptext.setText("Decimal:");
					optext.setText("Binary:");
					input.setText("0");
					output.setText("0");
				}
			}
		});

	}

	private void  initializeLogic() {
		output.setEnabled(false);
		input.setEnabled(false);
	}


	private void _dec_to_bin (final double _dec) {
		Ans = " ";
		num = _dec;
		i = 1;
		while(true) {
			if (num == 0) {
				break;
			}
			rem = num % 2;
			num = num / 2;
			Ans = String.valueOf((long)(rem)).concat(Ans);
		}
		output.setText(Ans);
	}
	private void _check (final String _bin) {
		if (_bin.indexOf("2") > -1) {
			showMessage("Not a valid input!!");
			input.setText("0");
		}
		if (_bin.indexOf("3") > -1) {
			showMessage("Not a valid input!!");
			input.setText("0");
		}
		if (_bin.indexOf("4") > -1) {
			showMessage("Not a valid input!!");
			input.setText("0");
		}
		if (_bin.indexOf("5") > -1) {
			showMessage("Not a valid input!!");
			input.setText("0");
		}
		if (_bin.indexOf("6") > -1) {
			showMessage("Not a valid input!!");
			input.setText("0");
		}
		if (_bin.indexOf("7") > -1) {
			showMessage("Not a valid input!!");
			input.setText("0");
		}
		if (_bin.indexOf("8") > -1) {
			showMessage("Not a valid input!!");
			input.setText("0");
		}
		if (_bin.indexOf("9") > -1) {
			showMessage("Not a valid input!!");
			input.setText("0");
		}
	}
	private void _bin_to_d (final String _bin) {
		ans = 0;
		i = 1;
		j = _bin.length() - 1;
		for(int _repeat37 = 0; _repeat37 < (int)(_bin.length()); _repeat37++) {
			rem = Double.parseDouble(_bin.substring((int)(j), (int)(j + 1)));
			ans = ans + (rem * i);
			i = i * 2;
			j--;
		}
		output.setText(String.valueOf((long)(ans)));
	}




	// created automatically
	private void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}

	private int getLocationX(View _v) {
		 int _location[] = new int[2];
		 _v.getLocationInWindow(_location);
		 return _location[0];
	}

	private int getLocationY(View _v) {
		 int _location[] = new int[2];
		 _v.getLocationInWindow(_location);
		 return _location[1];
	}

	private int getRandom(int _minValue ,int _maxValue){
		Random random = new Random();
		return random.nextInt(_maxValue - _minValue + 1) + _minValue;
	}

	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
				_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}

	private float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}

	private int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}

	private int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}


}
