package br.com.pan.store.entidades;

public class PagamentoDinheiro extends FormaDePagamento {

	public PagamentoDinheiro(Integer id ) {
		super(id, "Dinheiro", 1, 20.0);
	}

	@Override
	public Double calculaValor(Carrinho carrinho) {
		Double total = 0.0;
		
		for (CarrinhoItem item : carrinho.getItens()) {	
			total += item.getQuantidade() * item.getPrecoVendido();
		}
		
		return total - ( total * (this.getDesconto() / 100) ) ;
	}	
}
