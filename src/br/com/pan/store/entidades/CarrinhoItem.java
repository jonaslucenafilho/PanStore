package br.com.pan.store.entidades;

public class CarrinhoItem {
    public Produto produto;
    public Integer quantidade;
    public Double precoVendido;

    public CarrinhoItem(Produto produto, Integer quantidade, Double precoVendido) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoVendido = precoVendido;
    }

	public Produto getProduto() {
		return produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public Double getPrecoVendido() {
		return precoVendido;
	}
}
