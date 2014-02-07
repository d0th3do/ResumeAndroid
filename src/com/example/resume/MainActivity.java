package com.example.resume;

import java.util.Arrays;
import java.util.List;

import android.os.AsyncTask;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TableRow;
import android.widget.TextView;
/*
 * @author 	Kenneth Link
 * date		2/7/2014
 * 
 * 
 * */
@SuppressLint("NewApi") public class MainActivity extends Activity implements OnClickListener {

	private Button newButton;
	private Button openButton; 
	private ListView newList; 
	private ListView openList;
	private TableRow newListRow;
	private TableRow openListRow;
	private ArrayAdapter newAdapter, openAdapter;
	private TextView newResumeItem;
    
	private final String[] newActions = { "New Resume", "New Test", "New OMG" };
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	Log.d("DEBUG:", "TEST_TEST_TEST");
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newButton = (Button) findViewById(R.id.new_button);
        openButton = (Button) findViewById(R.id.open_button);
        newList = (ListView) findViewById(R.id.new_list);
        openList = (ListView) findViewById(R.id.open_list);
        newListRow = (TableRow) findViewById(R.id.new_list_row);
        openListRow = (TableRow) findViewById(R.id.open_list_row);
        
        newList.setItemsCanFocus(true);
        openList.setItemsCanFocus(true);
        
        newAdapter = new ArrayAdapter<String>(this, R.layout.main_row, R.id.list_item, newActions);
        openAdapter = new ArrayAdapter<String>(this, R.layout.main_row, R.id.list_item , newActions);
        
        
        newList.setAdapter(newAdapter);
        openList.setAdapter(openAdapter);
        
        newList.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
        	@Override
        	public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
        		Log.d("DEBUG:", "TEST_TEST_TEST1");
        		newListRow.getHandler().post(new Runnable() {
        			public void run() {
		        		if(newListRow.getVisibility() == View.VISIBLE){
		        	    	//newListRow.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.new_fade_out));
		        			newList.setVisibility(View.INVISIBLE);
		        			ResumeHelper.collapse(newListRow);
		        	    	//newListRow.setAlpha(0.0f);
		        	    	newListRow.setVisibility(View.GONE);
		    	    	}
		    	    	if(openListRow.getVisibility() == View.VISIBLE){
		    	    		openList.setVisibility(View.INVISIBLE);
		        	    	//openListRow.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.open_fade_out));
		        	    	ResumeHelper.collapse(openListRow);
		        	    	//openListRow.setAlpha(0.0f);
		        	    	openListRow.setVisibility(View.GONE);
		    	    	}
		    	    	setContentView(R.layout.new_resume);
		    	    	//code to switch to new activity
        			}
        		});
        	}
        });
        /*new OnItemClickListener() { 
        	@Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        		newListRow.getHandler().post(new Runnable() {
        			public void run() {
        		    	Log.d("DEBUG:", "TEST_TEST_TEST1");
        				if(newListRow.getVisibility() == View.VISIBLE){
                	    	newListRow.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.new_fade_out));
                	    	newListRow.setAlpha(0.0f);
                	    	newListRow.setVisibility(View.GONE);
            	    	}
            	    	if(openListRow.getVisibility() == View.VISIBLE){
            	    		
                	    	openListRow.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.open_fade_out));
                	    	openListRow.setAlpha(0.0f);
                	    	openListRow.setVisibility(View.GONE);
            	    	}
        	    }
            });}});*/
        openList.setOnItemClickListener(new OnItemClickListener() { 
        	@Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        	    	Log.d("DEBUG:", "****** Position="+position+" id="+id+"*********");
        			if(newListRow.getVisibility() == View.VISIBLE){
        				newList.setVisibility(View.INVISIBLE);
        				ResumeHelper.collapse(openListRow);
            	    	//newListRow.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.new_fade_out));
            	    	//newListRow.setAlpha(0.0f);
            	    	newListRow.setVisibility(View.GONE);
        	    	}
        	    	if(openListRow.getVisibility() == View.VISIBLE){
        	    		openList.setVisibility(View.INVISIBLE);
        	    		ResumeHelper.collapse(openListRow);
            	    	//openListRow.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.open_fade_out));
            	    	//openListRow.setAlpha(0.0f);
            	    	openListRow.setVisibility(View.GONE);
        	    	}
    	    }
        	});
        //ExpandableListAdapter openAdapter = openList.getExpandableListAdapter();
        openButton.setOnClickListener(new View.OnClickListener(){ public void onClick(View v) {
        	openListRow.getHandler().post(new Runnable() {
        	    public void run() {
        	    	if(newListRow.getVisibility() == View.VISIBLE){
        	    		newList.setVisibility(View.INVISIBLE);
        	    		ResumeHelper.collapse(newListRow);
            	    	//newListRow.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.new_fade_out));
            	    	//newListRow.setAlpha(0.0f);
            	    	newListRow.setVisibility(View.GONE);
        	    	}
        	    	if(openListRow.getVisibility() == View.GONE){
        	    		//openListRow.setAlpha(0.0f);
        	    		ResumeHelper.expand(openListRow);
        	    		openList.setVisibility(View.VISIBLE);
        	    		openListRow.setVisibility(View.VISIBLE);
            	    	//openListRow.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.open_fade_in));
            	    	//openListRow.setAlpha(1.0f);
        	    		
        	    	}
        	    	
        	    	
        	    	
        	    	//newList.setSelected(true);
                	//newList.setPressed(true);
                	//newListRow.invalidate();
        	    }
        	});}});
        newButton.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {
        	newListRow.getHandler().post(new Runnable() {
        	    public void run() {
        	    	
        	    	
        	    	if(openListRow.getVisibility() == View.VISIBLE){
        	    		openList.setVisibility(View.INVISIBLE);
        	    		ResumeHelper.collapse(openListRow);

            	    	//openListRow.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.open_fade_out));
            	    	//openListRow.setAlpha(0.0f);
            	    	openListRow.setVisibility(View.GONE);
        	    	}
        	    	if(newListRow.getVisibility() == View.GONE){
        	    		ResumeHelper.expand(newListRow);
        	    		newList.setVisibility(View.VISIBLE);

        	    		//newListRow.setAlpha(0.0f);
        	    		newListRow.setVisibility(View.VISIBLE);
            	    	//newListRow.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.new_fade_in));
            	    	//newListRow.setAlpha(1.0f);
        	    	}        	    	

        	    	
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
