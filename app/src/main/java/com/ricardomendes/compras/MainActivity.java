package com.ricardomendes.compras;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private ImageButton btcalcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        btcalcular = (ImageButton) findViewById(R.id.btCalcular);

        btcalcular.setOnClickListener(OnClickCalcular());
    }

    private View.OnClickListener OnClickCalcular() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EscolhaActivity.class);
                startActivity(intent);
            }
        };
    }
}
