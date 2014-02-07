package com.example.resume;

import java.util.Arrays;
import java.util.List;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TableRow;
/*
 * @author 	Kenneth Link
 * date		2/7/2014
 * 
 * 
 * */
public class MainActivity extends Activity implements OnClickListener {

	Button newButton;
    Button openButton; 
    ListView newList; 
    ListView openList;
    TableRow newListRow;
    TableRow openListRow;

    final String[] newActions = { "New Resume", "New Test", "New OMG" };
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newButton = (Button) findViewById(R.id.new_button);
        openButton = (Button) findViewById(R.id.open_button);
        newList = (ListView) findViewById(R.id.new_list);
        openList = (ListView) findViewById(R.id.open_list);
        newListRow = (TableRow) findViewById(R.id.new_list_row);
        openListRow = (TableRow) findViewById(R.id.open_list_row);
        
        newList.setAdapter(new ArrayAdapter<String>(this, R.layout.list_row, R.id.list_item, newActions));
        openList.setAdapter(new ArrayAdapter<String>(this, R.layout.list_row, R.id.list_item , newActions));

        //ExpandableListAdapter openAdapter = openList.getExpandableListAdapter();
        openButton.setOnClickListener(new View.OnClickListener(){ public void onClick(View v) {
        	openListRow.getHandler().post(new Runnable() {
        	    public void run() {
        	    	newListRow.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.new_fade_out));
        	    	try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        	    	newListRow.setVisibility(View.GONE);
        	    	openListRow.setVisibility(View.VISIBLE);
        	    	
        	    	//newList.setSelected(true);
                	//newList.setPressed(true);
                	//newListRow.invalidate();
        	    }
        	});}});
        newButton.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {
        	newListRow.getHandler().post(new Runnable() {
        	    public void run() {
        	    	openListRow.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.new_fade_out));
        	    	try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        	    	openListRow.setVisibility(View.GONE);
        	    	newListRow.setVisibility(View.VISIBLE);
        	    	
        	    	//newList.setSelected(true);
                	//newList.setPressed(true);
                	//newListRow.invalidate();
        	    }
        	});}});
    }

@Override
public void onClick(View v) {
	// TODO Auto-generated method stub
	
}
	
    
}
