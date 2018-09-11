package com.my.tictac;

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


public class MainActivity extends Activity {

	private TextView textview1;
	private Spinner spinner1;
	private Button play;
	private LinearLayout linear2;
	private LinearLayout linear1;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private Button t1;
	private Button t2;
	private Button t3;
	private Button t4;
	private Button t5;
	private Button t6;
	private Button t7;
	private Button t8;
	private Button t9;

	private String us_ch = "";
	private String ai_ch = "";
	private double i = 0;
	private double pos = 0;
	private double set = 0;
	private String ch = "";
	private double win = 0;

	private ArrayList<String> List = new ArrayList<String>();



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initialize();
		initializeLogic();
	}

	private void  initialize() {
		textview1 = (TextView) findViewById(R.id.textview1);
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		play = (Button) findViewById(R.id.play);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		t1 = (Button) findViewById(R.id.t1);
		t2 = (Button) findViewById(R.id.t2);
		t3 = (Button) findViewById(R.id.t3);
		t4 = (Button) findViewById(R.id.t4);
		t5 = (Button) findViewById(R.id.t5);
		t6 = (Button) findViewById(R.id.t6);
		t7 = (Button) findViewById(R.id.t7);
		t8 = (Button) findViewById(R.id.t8);
		t9 = (Button) findViewById(R.id.t9);


		play.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				t1.setBackgroundColor(0xFF9E9E9E);
				t1.setTextColor(0xFF000000);
				t1.setText("_");
				t2.setBackgroundColor(0xFF9E9E9E);
				t2.setTextColor(0xFF000000);
				t2.setText("_");
				t3.setBackgroundColor(0xFF9E9E9E);
				t3.setTextColor(0xFF000000);
				t3.setText("_");
				t4.setBackgroundColor(0xFF9E9E9E);
				t4.setTextColor(0xFF000000);
				t4.setText("_");
				t5.setBackgroundColor(0xFF9E9E9E);
				t5.setTextColor(0xFF000000);
				t5.setText("_");
				t6.setBackgroundColor(0xFF9E9E9E);
				t6.setTextColor(0xFF000000);
				t6.setText("_");
				t7.setBackgroundColor(0xFF9E9E9E);
				t7.setTextColor(0xFF000000);
				t7.setText("_");
				t8.setBackgroundColor(0xFF9E9E9E);
				t8.setTextColor(0xFF000000);
				t8.setText("_");
				t9.setBackgroundColor(0xFF9E9E9E);
				t9.setTextColor(0xFF000000);
				t9.setText("_");
				play.setText("Game in progress..");
				play.setEnabled(false);
				spinner1.setEnabled(false);
				t1.setEnabled(true);
				t2.setEnabled(true);
				t3.setEnabled(true);
				t4.setEnabled(true);
				t5.setEnabled(true);
				t6.setEnabled(true);
				t7.setEnabled(true);
				t8.setEnabled(true);
				t9.setEnabled(true);
				us_ch = List.get((int)(spinner1.getSelectedItemPosition()));
				i = 0;
				showMessage("You chose ".concat(us_ch));
				if (us_ch.equals("X")) {
					ai_ch = "0";
					showMessage("Your turn");
				}
				else {
					ai_ch = "X";
					_ai_set();
				}
			}
		});
		t1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				i++;
				t1.setTextColor(0xFFB71C1C);
				t1.setText(us_ch);
				t1.setEnabled(false);
				_check("YOU", us_ch);
				if ((win == 0) && (i < 9)) {
					_ai_set();
				}
			}
		});
		t2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				i++;
				t2.setTextColor(0xFFB71C1C);
				t2.setText(us_ch);
				t2.setEnabled(false);
				_check("YOU", us_ch);
				if ((win == 0) && (i < 9)) {
					_ai_set();
				}
			}
		});
		t3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				i++;
				t3.setTextColor(0xFFB71C1C);
				t3.setText(us_ch);
				t3.setEnabled(false);
				_check("YOU", us_ch);
				if ((win == 0) && (i < 9)) {
					_ai_set();
				}
			}
		});
		t4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				i++;
				t4.setTextColor(0xFFB71C1C);
				t4.setText(us_ch);
				t4.setEnabled(false);
				_check("YOU", us_ch);
				if ((win == 0) && (i < 9)) {
					_ai_set();
				}
			}
		});
		t5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				i++;
				t5.setTextColor(0xFFB71C1C);
				t5.setText(us_ch);
				t5.setEnabled(false);
				_check("YOU", us_ch);
				if ((win == 0) && (i < 9)) {
					_ai_set();
				}
			}
		});
		t6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				i++;
				t6.setTextColor(0xFFB71C1C);
				t6.setText(us_ch);
				t6.setEnabled(false);
				_check("YOU", us_ch);
				if ((win == 0) && (i < 9)) {
					_ai_set();
				}
			}
		});
		t7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				i++;
				t7.setTextColor(0xFFB71C1C);
				t7.setText(us_ch);
				t7.setEnabled(false);
				_check("YOU", us_ch);
				if ((win == 0) && (i < 9)) {
					_ai_set();
				}
			}
		});
		t8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				i++;
				t8.setTextColor(0xFFB71C1C);
				t8.setText(us_ch);
				t8.setEnabled(false);
				_check("YOU", us_ch);
				if ((win == 0) && (i < 9)) {
					_ai_set();
				}
			}
		});
		t9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				i++;
				t9.setTextColor(0xFFB71C1C);
				t9.setText(us_ch);
				t9.setEnabled(false);
				_check("YOU", us_ch);
				if ((win == 0) && (i < 9)) {
					_ai_set();
				}
			}
		});

	}

	private void  initializeLogic() {
		List.add("0");
		List.add("X");
		spinner1.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, List));
		t1.setEnabled(false);
		t2.setEnabled(false);
		t3.setEnabled(false);
		t4.setEnabled(false);
		t5.setEnabled(false);
		t6.setEnabled(false);
		t7.setEnabled(false);
		t8.setEnabled(false);
		t9.setEnabled(false);
	}


	private void _ai_set () {
		ch = "X";
		set = 0;
		pos = 0;
		if (i < 3) {
			while(true) {
				pos = getRandom((int)(1), (int)(9));
				if (pos == 1) {
					ch = t1.getText().toString();
				}
				if (pos == 2) {
					ch = t2.getText().toString();
				}
				if (pos == 3) {
					ch = t3.getText().toString();
				}
				if (pos == 4) {
					ch = t4.getText().toString();
				}
				if (pos == 5) {
					ch = t5.getText().toString();
				}
				if (pos == 6) {
					ch = t6.getText().toString();
				}
				if (pos == 7) {
					ch = t7.getText().toString();
				}
				if (pos == 8) {
					ch = t8.getText().toString();
				}
				if (pos == 9) {
					ch = t9.getText().toString();
				}
				if (ch.equals("_")) {
					set = 1;
					break;
				}
			}
		}
		else {
			if (t1.getText().toString().equals(t2.getText().toString()) && (!t1.getText().toString().equals("_") && t3.getText().toString().equals("_"))) {
				pos = 3;
				set = 1;
			}
			if (t1.getText().toString().equals(t3.getText().toString()) && (!t1.getText().toString().equals("_") && t2.getText().toString().equals("_"))) {
				pos = 2;
				set = 1;
			}
			if (t2.getText().toString().equals(t3.getText().toString()) && (!t2.getText().toString().equals("_") && t1.getText().toString().equals("_"))) {
				pos = 1;
				set = 1;
			}
			if (t4.getText().toString().equals(t5.getText().toString()) && (!t4.getText().toString().equals("_") && t6.getText().toString().equals("_"))) {
				pos = 6;
				set = 1;
			}
			if (t4.getText().toString().equals(t6.getText().toString()) && (!t4.getText().toString().equals("_") && t5.getText().toString().equals("_"))) {
				pos = 5;
				set = 1;
			}
			if (t5.getText().toString().equals(t6.getText().toString()) && (!t5.getText().toString().equals("_") && t4.getText().toString().equals("_"))) {
				pos = 4;
				set = 1;
			}
			if (t7.getText().toString().equals(t8.getText().toString()) && (!t7.getText().toString().equals("_") && t9.getText().toString().equals("_"))) {
				pos = 9;
				set = 1;
			}
			if (t7.getText().toString().equals(t9.getText().toString()) && (!t7.getText().toString().equals("_") && t8.getText().toString().equals("_"))) {
				pos = 8;
				set = 1;
			}
			if (t8.getText().toString().equals(t9.getText().toString()) && (!t8.getText().toString().equals("_") && t7.getText().toString().equals("_"))) {
				pos = 7;
				set = 1;
			}
			if (t1.getText().toString().equals(t4.getText().toString()) && (!t1.getText().toString().equals("_") && t7.getText().toString().equals("_"))) {
				pos = 7;
				set = 1;
			}
			if (t1.getText().toString().equals(t7.getText().toString()) && (!t1.getText().toString().equals("_") && t4.getText().toString().equals("_"))) {
				pos = 4;
				set = 1;
			}
			if (t4.getText().toString().equals(t7.getText().toString()) && (!t4.getText().toString().equals("_") && t1.getText().toString().equals("_"))) {
				pos = 1;
				set = 1;
			}
			if (t2.getText().toString().equals(t5.getText().toString()) && (!t2.getText().toString().equals("_") && t8.getText().toString().equals("_"))) {
				pos = 8;
				set = 1;
			}
			if (t2.getText().toString().equals(t8.getText().toString()) && (!t2.getText().toString().equals("_") && t5.getText().toString().equals("_"))) {
				pos = 5;
				set = 1;
			}
			if (t5.getText().toString().equals(t8.getText().toString()) && (!t5.getText().toString().equals("_") && t2.getText().toString().equals("_"))) {
				pos = 2;
				set = 1;
			}
			if (t3.getText().toString().equals(t6.getText().toString()) && (!t3.getText().toString().equals("_") && t9.getText().toString().equals("_"))) {
				pos = 9;
				set = 1;
			}
			if (t3.getText().toString().equals(t9.getText().toString()) && (!t3.getText().toString().equals("_") && t6.getText().toString().equals("_"))) {
				pos = 6;
				set = 1;
			}
			if (t6.getText().toString().equals(t9.getText().toString()) && (!t6.getText().toString().equals("_") && t3.getText().toString().equals("_"))) {
				pos = 3;
				set = 1;
			}
			if (t5.getText().toString().equals(t9.getText().toString()) && (!t5.getText().toString().equals("_") && t1.getText().toString().equals("_"))) {
				pos = 1;
				set = 1;
			}
			if (t1.getText().toString().equals(t5.getText().toString()) && (!t1.getText().toString().equals("_") && t9.getText().toString().equals("_"))) {
				pos = 9;
				set = 1;
			}
			if (t1.getText().toString().equals(t9.getText().toString()) && (!t1.getText().toString().equals("_") && t5.getText().toString().equals("_"))) {
				pos = 5;
				set = 1;
			}
			if (t3.getText().toString().equals(t5.getText().toString()) && (!t3.getText().toString().equals("_") && t7.getText().toString().equals("_"))) {
				pos = 7;
				set = 1;
			}
			if (t3.getText().toString().equals(t7.getText().toString()) && (!t3.getText().toString().equals("_") && t5.getText().toString().equals("_"))) {
				pos = 5;
				set = 1;
			}
			if (t5.getText().toString().equals(t7.getText().toString()) && (!t5.getText().toString().equals("_") && t3.getText().toString().equals("_"))) {
				pos = 3;
				set = 1;
			}
		}
		if (set == 0) {
			while(true) {
				pos = getRandom((int)(1), (int)(9));
				if (pos == 1) {
					ch = t1.getText().toString();
				}
				if (pos == 2) {
					ch = t2.getText().toString();
				}
				if (pos == 3) {
					ch = t3.getText().toString();
				}
				if (pos == 4) {
					ch = t4.getText().toString();
				}
				if (pos == 5) {
					ch = t5.getText().toString();
				}
				if (pos == 6) {
					ch = t6.getText().toString();
				}
				if (pos == 7) {
					ch = t7.getText().toString();
				}
				if (pos == 8) {
					ch = t8.getText().toString();
				}
				if (pos == 9) {
					ch = t9.getText().toString();
				}
				if (ch.equals("_")) {
					set = 1;
					break;
				}
			}
		}
		_ai_play();
	}
	private void _ai_play () {
		i++;
		if (pos == 1) {
			t1.setTextColor(0xFF1A237E);
			t1.setEnabled(false);
			t1.setText(ai_ch);
		}
		if (pos == 2) {
			t2.setTextColor(0xFF1A237E);
			t2.setEnabled(false);
			t2.setText(ai_ch);
		}
		if (pos == 3) {
			t3.setTextColor(0xFF1A237E);
			t3.setEnabled(false);
			t3.setText(ai_ch);
		}
		if (pos == 4) {
			t4.setTextColor(0xFF1A237E);
			t4.setEnabled(false);
			t4.setText(ai_ch);
		}
		if (pos == 5) {
			t5.setTextColor(0xFF1A237E);
			t5.setEnabled(false);
			t5.setText(ai_ch);
		}
		if (pos == 6) {
			t6.setTextColor(0xFF1A237E);
			t6.setEnabled(false);
			t6.setText(ai_ch);
		}
		if (pos == 7) {
			t7.setTextColor(0xFF1A237E);
			t7.setEnabled(false);
			t7.setText(ai_ch);
		}
		if (pos == 8) {
			t8.setTextColor(0xFF1A237E);
			t8.setEnabled(false);
			t8.setText(ai_ch);
		}
		if (pos == 9) {
			t9.setTextColor(0xFF1A237E);
			t9.setEnabled(false);
			t9.setText(ai_ch);
		}
		_check("A.I.", ai_ch);
	}
	private void _checkgame () {
		if ((win == 1) || (i == 9)) {
			t1.setEnabled(false);
			t2.setEnabled(false);
			t3.setEnabled(false);
			t4.setEnabled(false);
			t5.setEnabled(false);
			t6.setEnabled(false);
			t7.setEnabled(false);
			t8.setEnabled(false);
			t9.setEnabled(false);
			spinner1.setEnabled(true);
			play.setEnabled(true);
			play.setText(" Tap to restart Game");
		}
	}
	private void _check (final String _player, final String _C) {
		win = 0;
		if (i > 3) {
			if (t1.getText().toString().equals(t2.getText().toString()) && (t2.getText().toString().equals(t3.getText().toString()) && t1.getText().toString().equals(_C))) {
				win = 1;
				t1.setTextColor(0xFF311B92);
				t1.setBackgroundColor(0xFFF57F17);
				t2.setTextColor(0xFF311B92);
				t2.setBackgroundColor(0xFFF57F17);
				t3.setTextColor(0xFF311B92);
				t3.setBackgroundColor(0xFFF57F17);
			}
			if (t4.getText().toString().equals(t5.getText().toString()) && (t5.getText().toString().equals(t6.getText().toString()) && t4.getText().toString().equals(_C))) {
				win = 1;
				t4.setTextColor(0xFF311B92);
				t4.setBackgroundColor(0xFFF57F17);
				t5.setTextColor(0xFF311B92);
				t5.setBackgroundColor(0xFFF57F17);
				t6.setTextColor(0xFF311B92);
				t6.setBackgroundColor(0xFFF57F17);
			}
			if (t7.getText().toString().equals(t8.getText().toString()) && (t8.getText().toString().equals(t9.getText().toString()) && t7.getText().toString().equals(_C))) {
				win = 1;
				t7.setTextColor(0xFF311B92);
				t7.setBackgroundColor(0xFFF57F17);
				t8.setTextColor(0xFF311B92);
				t8.setBackgroundColor(0xFFF57F17);
				t9.setTextColor(0xFF311B92);
				t9.setBackgroundColor(0xFFF57F17);
			}
			if (t1.getText().toString().equals(t4.getText().toString()) && (t4.getText().toString().equals(t7.getText().toString()) && t1.getText().toString().equals(_C))) {
				win = 1;
				t1.setTextColor(0xFF311B92);
				t1.setBackgroundColor(0xFFF57F17);
				t4.setTextColor(0xFF311B92);
				t4.setBackgroundColor(0xFFF57F17);
				t7.setTextColor(0xFF311B92);
				t7.setBackgroundColor(0xFFF57F17);
			}
			if (t2.getText().toString().equals(t5.getText().toString()) && (t5.getText().toString().equals(t8.getText().toString()) && t2.getText().toString().equals(_C))) {
				win = 1;
				t2.setTextColor(0xFF311B92);
				t2.setBackgroundColor(0xFFF57F17);
				t5.setTextColor(0xFF311B92);
				t5.setBackgroundColor(0xFFF57F17);
				t8.setTextColor(0xFF311B92);
				t8.setBackgroundColor(0xFFF57F17);
			}
			if (t3.getText().toString().equals(t6.getText().toString()) && (t6.getText().toString().equals(t9.getText().toString()) && t3.getText().toString().equals(_C))) {
				win = 1;
				t3.setTextColor(0xFF311B92);
				t3.setBackgroundColor(0xFFF57F17);
				t6.setTextColor(0xFF311B92);
				t6.setBackgroundColor(0xFFF57F17);
				t9.setTextColor(0xFF311B92);
				t9.setBackgroundColor(0xFFF57F17);
			}
			if (t1.getText().toString().equals(t5.getText().toString()) && (t5.getText().toString().equals(t9.getText().toString()) && t1.getText().toString().equals(_C))) {
				win = 1;
				t1.setTextColor(0xFF311B92);
				t1.setBackgroundColor(0xFFF57F17);
				t5.setTextColor(0xFF311B92);
				t5.setBackgroundColor(0xFFF57F17);
				t9.setTextColor(0xFF311B92);
				t9.setBackgroundColor(0xFFF57F17);
			}
			if (t3.getText().toString().equals(t5.getText().toString()) && (t5.getText().toString().equals(t7.getText().toString()) && t7.getText().toString().equals(_C))) {
				win = 1;
				t3.setTextColor(0xFF311B92);
				t3.setBackgroundColor(0xFFF57F17);
				t5.setTextColor(0xFF311B92);
				t5.setBackgroundColor(0xFFF57F17);
				t7.setTextColor(0xFF311B92);
				t7.setBackgroundColor(0xFFF57F17);
			}
		}
		if (win == 1) {
			showMessage(_player.concat(" won this match!!!!"));
		}
		else {
			if (i == 9) {
				showMessage("Its a DRAW!!!!!");
			}
		}
		_checkgame();
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
