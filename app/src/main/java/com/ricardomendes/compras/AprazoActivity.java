package com.ricardomendes.compras;

import android.content.pm.ActivityInfo;
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

public class AprazoActivity extends AppCompatActivity {
    ImageButton confirm;
    EditText juros;
    EditText qtde;
    TextView qtdeParc;
    TextView valorParc;
    TextView valorTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprazo);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        confirm = (ImageButton) findViewById(R.id.calculoParcelas);
        juros = (EditText) findViewById(R.id.editTextJuros);
        qtde = (EditText) findViewById(R.id.editTextQtde);
        qtdeParc = (TextView) findViewById(R.id.txtQtde);
        valorParc = (TextView) findViewById(R.id.txtValor);
        valorTotal = (TextView) findViewById(R.id.txtValorTotal);

        confirm.setOnClickListener(OnClickConfirm());
    }

    private View.OnClickListener OnClickConfirm() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (juros.getText().toString().equals("") || qtde.getText().toString().equals("")) {
                    qtdeParc.setText("");
                    valorParc.setText("");
                    valorTotal.setText("");
                    Toast.makeText(AprazoActivity.this,
                            "Para prosseguir com os cálculos é necessário informar um valor de juros e quantidade de parcelas!",
                            Toast.LENGTH_LONG).show();
                } else {
                    double conf = Double.parseDouble(juros.getText().toString());
                    if (conf > 100 || conf < 0) {
                        qtdeParc.setText("");
                        valorParc.setText("");
                        valorTotal.setText("");
                        Toast.makeText(AprazoActivity.this,
                                "Para prosseguir com os cálculos é necessário informar uma porcentagem de juros válido(0-100)",
                                Toast.LENGTH_LONG).show();
                    } else {
                        Bundle args = getIntent().getExtras();
                        String valor = args.getString("valorCompra");
                        Calculos calc = new Calculos(valor);
                        double valorP = calc.valorParcela(qtde.getText().toString(), juros.getText().toString());
                        DecimalFormat df = new DecimalFormat("0.##");
                        String dx = df.format(valorP);
                        qtdeParc.setText("Quantidade de parcelas: " + qtde.getText().toString());
                        valorParc.setText("Valor de cada parcela c/ juros: R$" + dx);
                        valorTotal.setText("Valor da compra s/ juros: R$" + valor);
                    }
                }
            }
        };
    }
}
