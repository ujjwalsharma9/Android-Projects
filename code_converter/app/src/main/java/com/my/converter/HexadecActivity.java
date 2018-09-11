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


public class HexadecActivity extends Activity {

	private LinearLayout linear1;
	private CheckBox h2d;
	private CheckBox d2h;
	private TextView iptext;
	private EditText input;
	private TextView optext;
	private EditText output;
	private Button convert;

	private double check = 0;
	private double j = 0;
	private double ans = 0;
	private double i = 0;
	private double rem = 0;
	private String Ans = "";
	private double num = 0;

	private ArrayList<String> hexa = new ArrayList<String>();



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hexadec);
		initialize();
		initializeLogic();
	}

	private void  initialize() {
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		h2d = (CheckBox) findViewById(R.id.h2d);
		d2h = (CheckBox) findViewById(R.id.d2h);
		iptext = (TextView) findViewById(R.id.iptext);
		input = (EditText) findViewById(R.id.input);
		optext = (TextView) findViewById(R.id.optext);
		output = (EditText) findViewById(R.id.output);
		convert = (Button) findViewById(R.id.convert);


		convert.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				if (h2d.isChecked() || d2h.isChecked()) {
					if (input.getText().toString().length() > 0) {
						if (h2d.isChecked()) {
							_check_hex(input.getText().toString());
						}
						else {
							_dec_to_hex(Double.parseDouble(input.getText().toString()));
						}
					}
					else {
						showMessage("Please enter a valid input..");
					}
				}
				else {
					showMessage("Please select an option..");
				}
			}
		});
		h2d.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				d2h.setChecked(false);
				input.setEnabled(true);
				iptext.setText("Hexadecimal:");
				optext.setText("Decimal:");
				input.setText("0");
				output.setText("0");
			}
		});
		d2h.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				h2d.setChecked(false);
				input.setEnabled(true);
				optext.setText("Hexadecimal:");
				iptext.setText("Decimal:");
				input.setText("0");
				output.setText("0");
			}
		});

	}

	private void  initializeLogic() {
		input.setEnabled(false);
		output.setEnabled(false);
		hexa.add("0");
		hexa.add("1");
		hexa.add("2");
		hexa.add("3");
		hexa.add("4");
		hexa.add("5");
		hexa.add("6");
		hexa.add("7");
		hexa.add("8");
		hexa.add("9");
		hexa.add("A");
		hexa.add("B");
		hexa.add("C");
		hexa.add("D");
		hexa.add("E");
		hexa.add("F");
	}


	private void _check_hex (final String _hex) {
		check = 1;
		j = 0;
		for(int _repeat12 = 0; _repeat12 < (int)(_hex.length()); _repeat12++) {
			if (!hexa.contains(_hex.substring((int)(j), (int)(j + 1)))) {
				check = 0;
			}
			j++;
		}
		if (check == 0) {
			showMessage("Not a valid input..");
		}
		else {
			_hex_to_dec(_hex);
		}
	}
	private void _hex_to_dec (final String _hex) {
		ans = 0;
		i = 1;
		j = _hex.length() - 1;
		for(int _repeat16 = 0; _repeat16 < (int)(_hex.length()); _repeat16++) {
			rem = hexa.indexOf(_hex.substring((int)(j), (int)(j + 1)));
			ans = (rem * i) + ans;
			i = i * 16;
			j--;
		}
		output.setText(String.valueOf((long)(ans)));
	}
	private void _dec_to_hex (final double _dec) {
		Ans = " ";
		num = _dec;
		i = 0;
		while(true) {
			if (num == 0) {
				break;
			}
			rem = num % 16;
			Ans = hexa.get((int)(rem)).concat(Ans);
			num = num / 16;
		}
		output.setText(Ans);
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
