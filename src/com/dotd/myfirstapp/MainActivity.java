package com.dotd.myfirstapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	private TextView txtCounter;
	public static final int DECREMENT_REQUEST_CODE = 0;
	private int mycounter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mycounter = 0;
        
        txtCounter = (TextView) findViewById(R.id.textCounter);
        txtCounter.setText("Counter: " + Integer.toString(mycounter));
        
        Button btn1 = (Button) findViewById(R.id.btnIncrement);
        btn1.setOnClickListener(this);
        Button btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	public void onClick(View v) {
		if (v.getId() == R.id.btnIncrement) {
			mycounter++;
	        txtCounter.setText("Counter: " + Integer.toString(mycounter));
		}
		else if (v.getId() == R.id.btnNext) {
			Intent intent = new Intent(this, DecrementActivity.class);
			intent.putExtra("counter",  mycounter);
			startActivityForResult(intent, DECREMENT_REQUEST_CODE);
		}
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		if (requestCode == DECREMENT_REQUEST_CODE && resultCode == RESULT_OK) {
			if (data.hasExtra("counter"))
				mycounter = data.getExtras().getInt("counter");
			txtCounter.setText("Counter: " + Integer.toString(mycounter));
		}
	}
}
