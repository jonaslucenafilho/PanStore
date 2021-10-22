package br.com.pan.store.entidades;

public class PagamentoDinheiro extends FormaDePagamento {

	public PagamentoDinheiro(Integer id, String nome, Integer nParcelas, Double taxaJuros) {
		super(id, nome, nParcelas, taxaJuros);
	}

	@Override
	public Double calculaValor(Carrinho carrinho) {
		Double total = 0.0;
		
		for (CarrinhoItem item : carrinho.getItens()) {	
			total += item.getQuantidade() * item.getPrecoVendido();		
		}
		
		total -= total * (this.getDesconto() / 100);
		
		return total;
	}	
}
