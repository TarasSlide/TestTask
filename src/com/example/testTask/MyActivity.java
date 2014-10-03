package com.example.testTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MyActivity extends Activity implements OnItemClickListener {

    private String[] contentText = new String[3];

    public String[] fillArrayByRandomText(){
        for (int i=0; i<contentText.length; i++){
            contentText[i] = RandomTextGenerator.nextText();
        }
        return contentText;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final Button refreshButton = (Button) findViewById(R.id.refreshButton);
        fillArrayByRandomText();

        final ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, contentText);
        final ListView lvMain = (ListView)findViewById(R.id.lvMain);
        lvMain.setAdapter(adapter);

        lvMain.setOnItemClickListener(this);
        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              fillArrayByRandomText();
              adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, final long l) {
        if(i > 2) return;
        Intent intent = new Intent(this, DetailsPage.class);
        intent.putExtra("STRING_I_NEED", contentText[i]);
        startActivity(intent);
    }
 }
