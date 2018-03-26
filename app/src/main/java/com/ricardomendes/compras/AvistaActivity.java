package com.ricardomendes.compras;

import android.content.pm.ActivityInfo;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.ricardomendes.compras.Logic.Calculos;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class AvistaActivity extends AppCompatActivity {
    EditText desconto;
    ImageButton confirma;
    TextView valorComDesconto;
    TextView valorSemDesconto;
    TextView valorDesconto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avista);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        desconto = (EditText) findViewById(R.id.editTextDesconto);
        confirma = (ImageButton) findViewById(R.id.calculoDesconto);
        valorComDesconto = (TextView) findViewById(R.id.txtValorCom);
        valorSemDesconto = (TextView) findViewById(R.id.txtValorSem);
        valorDesconto = (TextView) findViewById(R.id.txtDesc);
        confirma.setOnClickListener(OnClickConfirm());
    }

    private View.OnClickListener OnClickConfirm() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(desconto.getText().toString().equals("")){
                    Toast.makeText(AvistaActivity.this,
                            "Para prosseguir com os cálculos é necessário informar um valor de porcentagem válido(0-100)",
                            Toast.LENGTH_LONG).show();
                }else {
                    double conf = Double.parseDouble(desconto.getText().toString());
                    if (conf > 100 || conf < 0) {
                        Toast.makeText(AvistaActivity.this,
                                "Para prosseguir com os cálculos é necessário informar um valor de porcentagem válido(0-100)",
                                Toast.LENGTH_LONG).show();
                    } else {
                        Bundle args = getIntent().getExtras();
                        String valor = args.getString("valorCompra");
                        Calculos calcular = new Calculos(valor);
                        double valueDesc = calcular.valorDesconto(desconto.getText().toString());
                        double valueComDesc = calcular.valorComDesconto();
                        DecimalFormat df = new DecimalFormat("0.##");
                        String dx = df.format(valueDesc);
                        String dx2 = df.format(valueComDesc);
                        valorDesconto.setText("Valor do desconto: R$" + dx);
                        valorComDesconto.setText("Valor com desconto: R$" + dx2);
                        valorSemDesconto.setText("Valor sem desconto: R$" + valor);
                    }
                }
            }
        };
    }
}
