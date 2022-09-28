package com.gicproject.salamticketnumberapp.led;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;


import com.gicproject.salamticketnumberapp.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import android_serialport_api.SerialPort;



public class LedActivity extends Activity implements SeekBar.OnSeekBarChangeListener, View.OnClickListener {

	private Button btn_loop;
	private Button btn_scrolling;
	private Button btn_stop;
	private Button btn_back;

	private String str_l = "";
	private String str_r = "";
	private String str_g = "";
	private String str_b = "";

	public static int numL;   //brightness values
	public static int numB;   //blue values
	public static int numG;   //green values
	public static int numR;   //red values

	private SeekBar seekBar_b,seekBar_r,seekBar_g ,seekBar_l;

	public static FileOutputStream out = null;

	public static Object lock;




	SerialPort ttyS1;
	int s = 100;
	int count = 0;



	int time = 10;
	int scrollingTime = 300;
	int scrollingCount = 1;
	//Handler handlerLoop = new Handler();
	Runnable runnableLoop = new Runnable() {        //LOOP thread
		@Override
		public void run() {
			try {
				value();
			//	if(count == 1){
					//btn_loop.setBackgroundResource(R.drawable.bloop);
					ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);     //Open the baud rate
					UartSend.UartAllB(ttyS1, "ttyS1").run();                       //All the blue lights on
					time = 2000;
				/*}else if(count == 2){
				//	btn_loop.setBackgroundResource(R.drawable.gloop);
					ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);     //Open the baud rate
					UartSend.UartAllG(ttyS1, "ttyS1").run();                       //All the green lights on
					time = 2000;
				}else if(count == 3){
				//	btn_loop.setBackgroundResource(R.drawable.rloop);
					ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);     //Open the baud rate
					UartSend.UartAllR(ttyS1, "ttyS1").run();                       //All the red lights on
					count = 0;
					time = 2000;
				}
				count++;
*/

			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}

			//handlerLoop .postDelayed(this, time);
		}
	};

	Handler handlerScrolling = new Handler();
	Runnable runnableScrolling = new Runnable() {              //Scrolling  thread

		@Override
		public void run() {
			// TODO Auto-generated method stub
			//LoopLamps();
			try {
				value();
				ScrollingLamps();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			handlerScrolling.postDelayed(this, scrollingTime);
		}
	};


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		LampsUtil lampsUtil = new LampsUtil();
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		init();

	}


	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		btn_stop.performClick();
	}

	private void	init(){

		btn_loop = (Button) findViewById(R.id.btn_loop);
		btn_loop.setOnClickListener(this);

		btn_scrolling = (Button) findViewById(R.id.btn_scrolling);
		btn_scrolling.setOnClickListener(this);

		btn_stop = (Button) findViewById(R.id.btn_stop);
		btn_stop.setOnClickListener(this);

		btn_back = (Button) findViewById(R.id.btn_back);
		btn_back.setOnClickListener(this);

		seekBar_b = (SeekBar) findViewById(R.id.seekbar_b);
		seekBar_b.setOnSeekBarChangeListener(this);

		seekBar_r = (SeekBar) findViewById(R.id.seekbar_r);
		seekBar_r.setOnSeekBarChangeListener(this);

		seekBar_g = (SeekBar) findViewById(R.id.seekbar_g);
		seekBar_g.setOnSeekBarChangeListener(this);

		seekBar_l = (SeekBar) findViewById(R.id.seekbar_L);
		seekBar_l.setOnSeekBarChangeListener(this);


	}

	// onProgressChanged
	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub


	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
		// TODO Auto-generated method stub
		switch (seekBar.getId()) {
			case R.id.seekbar_b:
				Integer b = seekBar.getProgress();
				str_b = b.toHexString(b);
				try {
					value();
					Send();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			//	btn_loop.setBackgroundResource(R.drawable.hloop);
				//btn_scrolling.setBackgroundResource(R.drawable.hloop);
				btn_scrolling.setEnabled(true);
				btn_loop.setEnabled(true);
			//	handlerLoop .removeCallbacks(runnableLoop);
			//	handlerScrolling.removeCallbacks(runnableScrolling);
				break;

			case R.id.seekbar_r:
				Integer r = seekBar.getProgress();
				str_r = r.toHexString(r);
				System.out.println("str r:"+str_r);
				//btn_loop.performClick();
				try {
					value();
					Send();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//btn_loop.setBackgroundResource(R.drawable.hloop);
			//	btn_scrolling.setBackgroundResource(R.drawable.hloop);
				btn_scrolling.setEnabled(true);
				btn_loop.setEnabled(true);
	//			handlerLoop .removeCallbacks(runnableLoop);
				handlerScrolling.removeCallbacks(runnableScrolling);
				break;

			case R.id.seekbar_g:
				Integer g = seekBar.getProgress();
				str_g = g.toHexString(g);
				System.out.println("str g:"+str_g);
				try {
					value();
					Send();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			//	btn_loop.setBackgroundResource(R.drawable.hloop);
			//	btn_scrolling.setBackgroundResource(R.drawable.hloop);
				btn_scrolling.setEnabled(true);
				btn_loop.setEnabled(true);
	//			handlerLoop .removeCallbacks(runnableLoop);
				handlerScrolling.removeCallbacks(runnableScrolling);
				break;

			case R.id.seekbar_L:
				Integer l_old = 224;
				Integer l = seekBar.getProgress() + l_old;
				str_l = l.toHexString(l);

				break;
			default:
				break;
		}

	}

	public void value(){
		//num1=stringsimpleToByte("55");
		// num2=stringsimpleToByte("AA");
		if(str_b.equals("")){
			numB=stringsimpleToByte("11");
		}
		else{
			numB=stringsimpleToByte(str_b);
		}
		if(str_r.equals("")){
			numR=stringsimpleToByte("11");
		}else{
			numR=stringsimpleToByte(str_r);
		}
		if(str_g.equals("")){
			numG=stringsimpleToByte("11");
		}else{
			numG=stringsimpleToByte(str_g);
		}
		if(str_l.equals("")){
			numL=stringsimpleToByte("f4");
		}else{
			numL=stringsimpleToByte(str_l);
			System.out.println("str_l"+str_l);
			if(str_l.equals("f0")){
				numL=stringsimpleToByte("f1");
			}
		}
	}

	public void Send() throws Exception, IOException{                  //All the lights
		value();
		ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
		UartSend.UartAllOn(ttyS1, "ttyS1").run();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.btn_loop:
			//	btn_scrolling.setBackgroundResource(R.drawable.hloop);
				count = 0;
				time = 10;
				btn_loop.setEnabled(false);
				btn_scrolling.setEnabled(true);
			//	handlerScrolling.removeCallbacks(runnableScrolling);
				runnableLoop.run();
			//	handlerLoop .postDelayed(runnableLoop, time);
				break;
			case R.id.btn_scrolling:
			//	btn_scrolling.setBackgroundResource(R.drawable.bloop);
				//btn_loop.setBackgroundResource(R.drawable.hloop);
				btn_loop.setEnabled(true);
				btn_scrolling.setEnabled(false);
				handlerScrolling.postDelayed(runnableScrolling, scrollingTime);
	//			handlerLoop .removeCallbacks(runnableLoop);
				break;

			case R.id.btn_stop:
			//	btn_loop.setBackgroundResource(R.drawable.hloop);
			//	btn_scrolling.setBackgroundResource(R.drawable.hloop);
				btn_scrolling.setEnabled(true);
				btn_loop.setEnabled(true);
			//	handlerLoop .removeCallbacks(runnableLoop);
		//		handlerScrolling.removeCallbacks(runnableScrolling);
				try {
					ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
					UartSend.UartAllOff(ttyS1, "ttyS1").run();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

				break;

			case R.id.btn_back:
				Intent intent = new Intent(Intent.ACTION_MAIN);
				intent.addCategory(Intent.CATEGORY_HOME);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(intent);
				break;

			default:
				break;
		}
	}

	public void ScrollingLamps(){
		value();
		try {
			if(scrollingCount == 1){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_1(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 2){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_1(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 3){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_1(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 4){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_2(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 5){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_2(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 6){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_2(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 7){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_3(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 8){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_3(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 9){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_3(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 10){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_4(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 11){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_4(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 12){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_4(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 13){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_5(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 14){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_5(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 15){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_5(ttyS1, "ttyS1").run();
			}

			else if(scrollingCount == 16){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_6(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 17){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_6(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 18){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_6(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 19){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_7(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 20){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_7(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 21){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_7(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 22){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_8(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 23){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_8(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 24){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_8(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 25){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_9(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 26){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_9(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 27){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_9(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 28){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_10(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 29){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_10(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 30){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_10(ttyS1, "ttyS1").run();
			}

			else if(scrollingCount == 31){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_11(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 32){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_11(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 33){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_11(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 34){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_12(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 35){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_12(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 36){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_12(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 37){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_13(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 38){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_13(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 39){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_13(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 40){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_14(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 41){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_14(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 42){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_14(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 43){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_15(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 44){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_15(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 45){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_15(ttyS1, "ttyS1").run();
			}

			else if(scrollingCount == 46){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_16(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 47){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_16(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 48){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_16(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 49){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_17(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 50){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_17(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 51){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_17(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 52){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_18(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 53){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_18(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 54){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_18(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 55){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_19(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 56){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_19(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 57){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_19(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 58){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_20(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 59){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_20(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 60){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_20(ttyS1, "ttyS1").run();
			}

			else if(scrollingCount == 61){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_21(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 62){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_21(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 63){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_21(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 64){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_22(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 65){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_22(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 66){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_22(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 67){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_23(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 68){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_23(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 69){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_23(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 70){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_24(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 71){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_24(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 72){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_24(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 73){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_25(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 74){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_25(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 75){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_25(ttyS1, "ttyS1").run();
			}

			else if(scrollingCount == 76){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_26(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 77){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_26(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 78){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_26(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 79){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_27(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 80){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_27(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 81){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_27(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 82){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_28(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 83){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_28(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 84){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_28(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 85){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_29(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 86){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_29(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 87){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_29(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 88){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_30(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 89){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_30(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 90){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_30(ttyS1, "ttyS1").run();
			}

			else if(scrollingCount == 91){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_31(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 92){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_31(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 93){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_31(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 94){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_32(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 95){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_32(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 96){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_32(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 97){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_33(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 98){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_33(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 99){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_33(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 100){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_34(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 101){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_34(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 102){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_34(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 103){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_35(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 104){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_35(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 105){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_35(ttyS1, "ttyS1").run();
			}

			else if(scrollingCount == 106){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_36(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 107){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_36(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 108){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_36(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 109){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_37(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 110){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_37(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 111){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_37(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 112){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_38(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 113){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_38(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 114){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_38(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 115){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_39(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 116){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_39(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 117){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_39(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 118){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_40(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 119){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_40(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 120){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_40(ttyS1, "ttyS1").run();
			}

			else if(scrollingCount == 121){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_41(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 122){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_41(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 123){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_41(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 124){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_42(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 125){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_42(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 126){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_42(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 127){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_43(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 128){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_43(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 129){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_43(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 130){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_44(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 131){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_44(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 132){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_44(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 133){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_45(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 134){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_45(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 135){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_45(ttyS1, "ttyS1").run();
			}


			else if(scrollingCount == 136){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_46(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 137){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_46(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 138){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_46(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 139){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_47(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 140){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_47(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 141){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_47(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 142){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_48(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 143){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_48(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 144){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_48(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 145){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_49(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 146){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_49(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 147){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_49(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 148){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_50(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 149){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_50(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 150){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_50(ttyS1, "ttyS1").run();
			}

			else if(scrollingCount == 151){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_51(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 152){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_51(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 153){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_51(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 154){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartB_52(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 155){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartG_52(ttyS1, "ttyS1").run();
			}else if(scrollingCount == 156){
				ttyS1 = new SerialPort(new File("/dev/ttyS1"), 115200, 0);
				UartSend.UartR_52(ttyS1, "ttyS1").run();
				scrollingCount = 0;
			}
			scrollingCount++;


		} catch (SecurityException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}




	public static int  stringsimpleToByte(String in){
		int b=Integer.parseInt(in,16);
		return b;
	}
}
