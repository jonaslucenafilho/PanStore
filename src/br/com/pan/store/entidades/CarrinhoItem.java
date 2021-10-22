package br.com.pan.store.entidades;

public class CarrinhoItem {
    private Produto produto;
    private Double quantidade;
    private Double precoVendido;

    public CarrinhoItem(Produto produto, Double quantidade, Double precoVendido) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoVendido = precoVendido;
    }
}
