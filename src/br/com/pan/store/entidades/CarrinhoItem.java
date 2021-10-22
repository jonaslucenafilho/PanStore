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

	public Produto getProduto() {
		return produto;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public Double getPrecoVendido() {
		return precoVendido;
	}
}
