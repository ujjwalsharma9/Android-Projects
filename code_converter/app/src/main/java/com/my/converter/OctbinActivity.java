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


public class OctbinActivity extends Activity {

	private LinearLayout linear1;
	private CheckBox o2b;
	private CheckBox b2o;
	private TextView iptext;
	private EditText input;
	private TextView optext;
	private EditText output;
	private Button convert;

	private double ans = 0;
	private double num = 0;
	private double i = 0;
	private double rem = 0;
	private String Ans = "";
	private double j = 0;
	private String Bin = "";
	private double check = 0;

	private ArrayList<String> binary = new ArrayList<String>();



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.octbin);
		initialize();
		initializeLogic();
	}

	private void  initialize() {
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		o2b = (CheckBox) findViewById(R.id.o2b);
		b2o = (CheckBox) findViewById(R.id.b2o);
		iptext = (TextView) findViewById(R.id.iptext);
		input = (EditText) findViewById(R.id.input);
		optext = (TextView) findViewById(R.id.optext);
		output = (EditText) findViewById(R.id.output);
		convert = (Button) findViewById(R.id.convert);


		convert.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				if (!(o2b.isChecked() || b2o.isChecked())) {
					showMessage("Please select an option..");
				}
				else {
					if (input.getText().toString().length() > 0) {
						if (o2b.isChecked()) {
							_check_oct(input.getText().toString());
						}
						else {
							_check_bin(input.getText().toString());
						}
					}
					else {
						showMessage("Please enter a valid input.");
					}
				}
			}
		});
		o2b.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				input.setEnabled(true);
				b2o.setChecked(false);
				optext.setText("Binary:");
				iptext.setText("Octal:");
				input.setText("0");
				output.setText("0");
			}
		});
		b2o.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				input.setEnabled(true);
				o2b.setChecked(false);
				iptext.setText("Binary:");
				optext.setText("Octal:");
				input.setText("0");
				output.setText("0");
			}
		});

	}

	private void  initializeLogic() {
		output.setEnabled(false);
		input.setEnabled(false);
		binary.add("000");
		binary.add("001");
		binary.add("010");
		binary.add("011");
		binary.add("100");
		binary.add("101");
		binary.add("110");
		binary.add("111");
	}


	private void _oct_to_bin (final double _oct) {
		Ans = " ";
		num = _oct;
		while(true) {
			if (num == 0) {
				break;
			}
			rem = num % 10;
			Ans = binary.get((int)(rem)).concat(Ans);
			num = num / 10;
		}
		output.setText(Ans);
	}
	private void _bin_to_oct (final String _bin) {
		ans = 0;
		i = 1;
		j = _bin.length();
		while(true) {
			if (j == 0) {
				break;
			}
			rem = binary.indexOf(_bin.substring((int)(j - 3), (int)(j)));
			ans = ans + (rem * i);
			i = i * 10;
			j = j - 3;
		}
		output.setText(String.valueOf((long)(ans)));
	}
	private void _check_bin (final String _bin) {
		check = 1;
		if (_bin.indexOf("2") > -1) {
			check = 0;
		}
		if (_bin.indexOf("3") > -1) {
			check = 0;
		}
		if (_bin.indexOf("3") > -1) {
			check = 0;
		}
		if (_bin.indexOf("4") > -1) {
			check = 0;
		}
		if (_bin.indexOf("5") > -1) {
			check = 0;
		}
		if (_bin.indexOf("6") > -1) {
			check = 0;
		}
		if (_bin.indexOf("7") > -1) {
			check = 0;
		}
		if (_bin.indexOf("8") > -1) {
			check = 0;
		}
		if (_bin.indexOf("9") > -1) {
			check = 0;
		}
		if (check == 0) {
			showMessage("Not a valid input!!");
			input.setText("0");
		}
		else {
			Bin = _bin;
			if ((Bin.length() % 3) == 1) {
				Bin = "00".concat(Bin);
			}
			else {
				if ((Bin.length() % 3) == 2) {
					Bin = "0".concat(Bin);
				}
			}
			_bin_to_oct(Bin);
		}
	}
	private void _check_oct (final String _oct) {
		check = 1;
		if (_oct.indexOf("8") > -1) {
			check = 0;
		}
		if (_oct.indexOf("9") > -1) {
			check = 0;
		}
		if (check == 0) {
			showMessage("Not a valid input!!!");
			input.setText("0");
		}
		else {
			_oct_to_bin(Double.parseDouble(_oct));
		}
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
