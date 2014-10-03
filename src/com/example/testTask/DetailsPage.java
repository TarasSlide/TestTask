package com.example.testTask;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsPage extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_page);
        TextView contentText = (TextView) findViewById(R.id.contentText);
        contentText.setText(getIntent().getExtras().getString("CONTENT_TEXT"));
    }
}