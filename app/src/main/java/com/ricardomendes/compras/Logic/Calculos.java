package com.ricardomendes.compras.Logic;

/**
 * Created by Ricardo Mendes on 24/03/2018.
 */

public class Calculos {
    private double valorCompra, valorParcela, valorDesconto;

    public Calculos(String valorCompra){
        this.valorCompra = Double.parseDouble(valorCompra);
    }

    public double valorDesconto(String desconto){
        double desc = Double.parseDouble(desconto);
        valorDesconto = valorCompra * (desc/100);
        return valorDesconto;
    }
    public double valorComDesconto(){
        return valorCompra - valorDesconto;
    }
    public double valorParcela(String qtde, String jur){
        double quantidade, juros;
        quantidade = Double.parseDouble(qtde);
        juros = Double.parseDouble(jur);
        valorParcela = (valorCompra / quantidade) * (juros/100);
        valorParcela += (valorCompra/quantidade);
        return valorParcela;
    }
}
