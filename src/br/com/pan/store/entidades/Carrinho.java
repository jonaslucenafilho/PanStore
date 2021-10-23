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
    
    public ArrayList<CarrinhoItem> getItens() {
		return itens;
	}

	public void AdicionarItem(CarrinhoItem carrinhoItem){
        itens.add(carrinhoItem);
    }

    public void GerarCupomFiscal(){
        System.out.println("=============================================");
        System.out.println("                CUPOM FISCAL");
        System.out.println("=============================================");
        System.out.format("%-26s%-12s%-15s\n", "PRODUTO", "QUANT", "PREÇO");
        for (CarrinhoItem item:itens) {
            System.out.format("%-26s%-12d%-15.2f\n", item.getProduto().getNome(), item.getQuantidade(), item.getPrecoVendido());
        }
        System.out.println("=============================================\n");
    }
}
