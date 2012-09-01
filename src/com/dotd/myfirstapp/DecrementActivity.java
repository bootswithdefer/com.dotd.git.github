package com.dotd.myfirstapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DecrementActivity extends Activity implements OnClickListener {

	private TextView txtCounter;
	private int mycounter;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decrement);
        
        mycounter = 0;
        
        Bundle extras = getIntent().getExtras();
        if (extras != null)
        	mycounter = extras.getInt("counter");

        txtCounter = (TextView) findViewById(R.id.textCounter);
        txtCounter.setText("Counter: " + Integer.toString(mycounter));
                
        Button btnDecrement = (Button) findViewById(R.id.btnDecrement);
        btnDecrement.setOnClickListener(this);
        Button btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_decrement, menu);
        return true;
    }
    
	public void onClick(View v) {
		if (v.getId() == R.id.btnDecrement) {
			mycounter--;
	        txtCounter.setText("Counter: " + Integer.toString(mycounter));
		}
		else if (v.getId() == R.id.btnBack) {
			finish();
		}
	}
	
	@Override
	public void finish() {
		Intent data = new Intent();
		data.putExtra("counter",  mycounter);
		setResult(RESULT_OK, data);
		super.finish();
	}

}
