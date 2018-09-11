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


public class HexabinActivity extends Activity {

	private LinearLayout linear1;
	private CheckBox h2b;
	private CheckBox b2h;
	private TextView iptext;
	private EditText input;
	private TextView optext;
	private EditText output;
	private Button convert;

	private double check = 0;
	private double j = 0;
	private String Ans = "";
	private String Bin = "";

	private ArrayList<String> hexa = new ArrayList<String>();
	private ArrayList<String> binary = new ArrayList<String>();



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hexabin);
		initialize();
		initializeLogic();
	}

	private void  initialize() {
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		h2b = (CheckBox) findViewById(R.id.h2b);
		b2h = (CheckBox) findViewById(R.id.b2h);
		iptext = (TextView) findViewById(R.id.iptext);
		input = (EditText) findViewById(R.id.input);
		optext = (TextView) findViewById(R.id.optext);
		output = (EditText) findViewById(R.id.output);
		convert = (Button) findViewById(R.id.convert);


		convert.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				if (!(h2b.isChecked() || b2h.isChecked())) {
					showMessage("Please select an input...");
				}
				else {
					if (input.getText().toString().length() > 0) {
						if (h2b.isChecked()) {
							_check_hex(input.getText().toString());
						}
						else {
							_check_bin(input.getText().toString());
						}
					}
					else {
						showMessage("Please enter a valid input..");
					}
				}
			}
		});
		h2b.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				b2h.setChecked(false);
				input.setEnabled(true);
				iptext.setText("Hexadecimal:");
				optext.setText("Binary:");
				input.setText("0");
				output.setText("0");
			}
		});
		b2h.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				h2b.setChecked(false);
				input.setEnabled(true);
				optext.setText("Hexadecimal:");
				iptext.setText("Binary:");
				input.setText("0");
				output.setText("0");
			}
		});

	}

	private void  initializeLogic() {
		output.setEnabled(false);
		input.setEnabled(false);
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
		binary.add("0000");
		binary.add("0001");
		binary.add("0010");
		binary.add("0011");
		binary.add("0100");
		binary.add("0101");
		binary.add("0110");
		binary.add("0111");
		binary.add("1000");
		binary.add("1001");
		binary.add("1010");
		binary.add("1011");
		binary.add("1100");
		binary.add("1101");
		binary.add("1110");
		binary.add("1111");
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
			showMessage("Invalid input!!");
			input.setText("0");
		}
		else {
			_hex_to_bin(_hex);
		}
	}
	private void _check_bin (final String _bin) {
		check = 1;
		if (_bin.indexOf("2") > 0) {
			check = 0;
		}
		if (_bin.indexOf("3") > 0) {
			check = 0;
		}
		if (_bin.indexOf("4") > 0) {
			check = 0;
		}
		if (_bin.indexOf("5") > 0) {
			check = 0;
		}
		if (_bin.indexOf("6") > 0) {
			check = 0;
		}
		if (_bin.indexOf("7") > 0) {
			check = 0;
		}
		if (_bin.indexOf("8") > 0) {
			check = 0;
		}
		if (_bin.indexOf("9") > 0) {
			check = 0;
		}
		if (check == 0) {
			showMessage("Invalid input!!");
			input.setText("0");
		}
		else {
			Bin = _bin;
			if ((Bin.length() % 4) == 3) {
				Bin = "0".concat(Bin);
			}
			else {
				if ((Bin.length() % 4) == 2) {
					Bin = "00".concat(Bin);
				}
				else {
					if ((Bin.length() % 4) == 1) {
						Bin = "000".concat(Bin);
					}
				}
			}
			_bin_to_hex(Bin);
		}
	}
	private void _hex_to_bin (final String _hex) {
		Ans = " ";
		j = _hex.length() - 1;
		for(int _repeat17 = 0; _repeat17 < (int)(_hex.length()); _repeat17++) {
			Ans = binary.get((int)(hexa.indexOf(_hex.substring((int)(j), (int)(j + 1))))).concat(Ans);
			j--;
		}
		output.setText(Ans);
	}
	private void _bin_to_hex (final String _bin) {
		Ans = " ";
		j = _bin.length();
		while(true) {
			if (j == 0) {
				break;
			}
			Ans = hexa.get((int)(binary.indexOf(_bin.substring((int)(j - 4), (int)(j))))).concat(Ans);
			j = j - 4;
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
