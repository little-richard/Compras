package com.ricardomendes.compras;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class EscolhaActivity extends AppCompatActivity {
    private ImageButton btAvista;
    private ImageButton btAprazo;
    private EditText valorCompra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolha);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        btAvista = (ImageButton) findViewById(R.id.btAvista);
        btAprazo = (ImageButton) findViewById(R.id.btAprazo);
        valorCompra = (EditText) findViewById(R.id.valorCompra);

        btAvista.setOnClickListener(OnClickAvista());
        btAprazo.setOnClickListener(OnClickAprazo());
    }

    private View.OnClickListener OnClickAprazo() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(valorCompra.getText().toString().equals("")){
                    Toast.makeText(EscolhaActivity.this, "Antes de prosseguir é necessário inserir o valor da compra!", Toast.LENGTH_LONG).show();
                }else {
                    Intent intent = new Intent(EscolhaActivity.this, AprazoActivity.class);
                    Bundle params = new Bundle();
                    params.putString("valorCompra", valorCompra.getText().toString());
                    intent.putExtras(params);
                    startActivity(intent);
                }
            }
        };
    }

    private View.OnClickListener OnClickAvista() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(valorCompra.getText().toString().equals("")){
                    Toast.makeText(EscolhaActivity.this, "Antes de prosseguir é necessário inserir o valor da compra!", Toast.LENGTH_LONG).show();
                }else {
                    Intent intent = new Intent(EscolhaActivity.this, AvistaActivity.class);
                    Bundle params = new Bundle();
                    params.putString("valorCompra", valorCompra.getText().toString());
                    intent.putExtras(params);
                    startActivity(intent);
                }
            }
        };
    }
}
