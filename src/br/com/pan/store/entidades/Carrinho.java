package br.com.pan.store.entidades;

import java.util.ArrayList;

public class Carrinho {
    private Integer id;
    private String nomeCliente;
    private FormaDePagamento formaPagamento;
    private Integer notaFiscal;
    private ArrayList<CarrinhoItem> itens;

    public Carrinho(Integer id, String nomeCliente, FormaDePagamento formaPagamento) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.formaPagamento = formaPagamento;
    }

    public void AdicionarItem(CarrinhoItem carrinhoItem){
        itens.add(carrinhoItem);
    }

    public void GerarCupomFiscal(){
        System.out.println("CUPOM FISCAL");
    }
}
