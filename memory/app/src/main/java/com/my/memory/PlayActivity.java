package com.my.memory;

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


public class PlayActivity extends Activity {

	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private Button start;
	private Button reset;
	private TextView textview1;
	private TextView level;
	private TextView red;
	private TextView yellow;
	private TextView green;
	private TextView blue;

	private double lev = 0;
	private double i = 0;
	private double j = 0;

	private ArrayList<Double> color = new ArrayList<Double>();

	private Timer _timer = new Timer();
	private TimerTask delay;
	private TimerTask delay1;
	private Intent win = new Intent();
	private MediaPlayer mp;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.play);
		initialize();
		initializeLogic();
	}

	private void  initialize() {
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		start = (Button) findViewById(R.id.start);
		reset = (Button) findViewById(R.id.reset);
		textview1 = (TextView) findViewById(R.id.textview1);
		level = (TextView) findViewById(R.id.level);
		red = (TextView) findViewById(R.id.red);
		yellow = (TextView) findViewById(R.id.yellow);
		green = (TextView) findViewById(R.id.green);
		blue = (TextView) findViewById(R.id.blue);






		start.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				reset.setEnabled(true);
				j = 0;
				if (!((lev == 1) || start.getText().toString().equals("Retry"))) {
					i = i + 2;
				}
				start.setText("Start");
				for(int _repeat17 = 0; _repeat17 < (int)(i); _repeat17++) {
					color.add(Double.valueOf(getRandom((int)(1), (int)(4))));
				}
				delay = new TimerTask() {
							@Override
								public void run() {
									runOnUiThread(new Runnable() {
									@Override
										public void run() {
														if (j == i) {
												delay.cancel();
											_normal();
											_play();
										}
										else {
											_highlight(color.get((int)(j)).doubleValue());
											delay1 = new TimerTask() {
														@Override
															public void run() {
																runOnUiThread(new Runnable() {
																@Override
																	public void run() {
																												_normal();
																	}
																});
															}
														};
														_timer.schedule(delay1, (int)(500));
											j++;
										}
										}
									});
								}
							};
							_timer.scheduleAtFixedRate(delay, (int)(0), (int)(1500));
			}
		});
		reset.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				color.clear();
				start.setVisibility(View.VISIBLE);
				red.setEnabled(false);
				yellow.setEnabled(false);
				green.setEnabled(false);
				blue.setEnabled(false);
				reset.setText("Reset");
				reset.setEnabled(false);
				start.setEnabled(true);
				level.setText(String.valueOf((long)(lev)));
			}
		});
		red.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				_highlight(1);
				delay1 = new TimerTask() {
							@Override
								public void run() {
									runOnUiThread(new Runnable() {
									@Override
										public void run() {
														_normal();
										}
									});
								}
							};
							_timer.schedule(delay1, (int)(500));
				if (color.get((int)(j)).doubleValue() == 1) {
					j++;
					_check();
				}
				else {
					showMessage("Wrong!!!!");
					red.setEnabled(false);
					yellow.setEnabled(false);
					green.setEnabled(false);
					blue.setEnabled(false);
					start.setEnabled(true);
					start.setText("Retry");
					reset.setEnabled(false);
				}
			}
		});
		yellow.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				_highlight(2);
				delay1 = new TimerTask() {
							@Override
								public void run() {
									runOnUiThread(new Runnable() {
									@Override
										public void run() {
														_normal();
										}
									});
								}
							};
							_timer.schedule(delay1, (int)(500));
				if (color.get((int)(j)).doubleValue() == 2) {
					j++;
					_check();
				}
				else {
					showMessage("Wrong!!!!");
					red.setEnabled(false);
					yellow.setEnabled(false);
					green.setEnabled(false);
					blue.setEnabled(false);
					start.setEnabled(true);
					start.setText("Retry");
					reset.setEnabled(false);
				}
			}
		});
		green.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				_highlight(3);
				delay1 = new TimerTask() {
							@Override
								public void run() {
									runOnUiThread(new Runnable() {
									@Override
										public void run() {
														_normal();
										}
									});
								}
							};
							_timer.schedule(delay1, (int)(500));
				if (color.get((int)(j)).doubleValue() == 3) {
					j++;
					_check();
				}
				else {
					showMessage("Wrong!!!!");
					red.setEnabled(false);
					yellow.setEnabled(false);
					green.setEnabled(false);
					blue.setEnabled(false);
					start.setEnabled(true);
					start.setText("Retry");
					reset.setEnabled(false);
				}
			}
		});
		blue.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				_highlight(4);
				delay1 = new TimerTask() {
							@Override
								public void run() {
									runOnUiThread(new Runnable() {
									@Override
										public void run() {
														_normal();
										}
									});
								}
							};
							_timer.schedule(delay1, (int)(500));
				if (color.get((int)(j)).doubleValue() == 4) {
					j++;
					_check();
				}
				else {
					showMessage("Wrong!!!!");
					red.setEnabled(false);
					yellow.setEnabled(false);
					green.setEnabled(false);
					blue.setEnabled(false);
					start.setEnabled(true);
					start.setText("Retry");
					reset.setEnabled(false);
				}
			}
		});

	}

	private void  initializeLogic() {
		red.setEnabled(false);
		yellow.setEnabled(false);
		green.setEnabled(false);
		blue.setEnabled(false);
		reset.setEnabled(false);
		lev = 1;
		i = 5;
	}

	@Override
	public void onStop() {
		super.onStop();
				mp.release();
	}

	private void _highlight (final double _block) {
		if (_block == 1) {
			mp = MediaPlayer.create(getApplicationContext(), R.raw.pianod);
			mp.start();
			mp.setLooping(false);
			red.setBackgroundColor(0xFFF50057);
			yellow.setBackgroundColor(0xFFFFD600);
			green.setBackgroundColor(0xFF388E3C);
			blue.setBackgroundColor(0xFF1565C0);
		}
		if (_block == 2) {
			mp = MediaPlayer.create(getApplicationContext(), R.raw.pianoe);
			mp.start();
			mp.setLooping(false);
			red.setBackgroundColor(0xFFC62828);
			yellow.setBackgroundColor(0xFFEEFF41);
			green.setBackgroundColor(0xFF388E3C);
			blue.setBackgroundColor(0xFF1565C0);
		}
		if (_block == 3) {
			mp = MediaPlayer.create(getApplicationContext(), R.raw.pianof);
			mp.start();
			mp.setLooping(false);
			red.setBackgroundColor(0xFFC62828);
			yellow.setBackgroundColor(0xFFFFD600);
			green.setBackgroundColor(0xFF76FF03);
			blue.setBackgroundColor(0xFF1565C0);
		}
		if (_block == 4) {
			mp = MediaPlayer.create(getApplicationContext(), R.raw.pianog);
			mp.start();
			mp.setLooping(false);
			red.setBackgroundColor(0xFFC62828);
			yellow.setBackgroundColor(0xFFFFD600);
			green.setBackgroundColor(0xFF388E3C);
			blue.setBackgroundColor(0xFF18FFFF);
		}
	}
	private void _normal () {
		red.setBackgroundColor(0xFFC62828);
		yellow.setBackgroundColor(0xFFFFD600);
		green.setBackgroundColor(0xFF388E3C);
		blue.setBackgroundColor(0xFF1565C0);
	}
	private void _play () {
			delay.cancel();
		j = 0;
		start.setEnabled(false);
		showMessage("Enter the sequence...");
		red.setEnabled(true);
		yellow.setEnabled(true);
		green.setEnabled(true);
		blue.setEnabled(true);
	}
	private void _check () {
		if (j == i) {
			showMessage("That's correct!!!!!");
			red.setEnabled(false);
			yellow.setEnabled(false);
			green.setEnabled(false);
			blue.setEnabled(false);
			start.setEnabled(false);
			lev++;
			if (lev == 7) {
				win.setClass(getApplicationContext(), WinActivity.class);
				startActivity(win);
			}
			else {
				start.setVisibility(View.GONE);
				reset.setText("Next Level");
			}
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
