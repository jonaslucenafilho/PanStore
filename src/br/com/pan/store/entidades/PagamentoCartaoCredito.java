package br.com.pan.store.entidades;

public class PagamentoCartaoCredito extends FormaDePagamento{

	public PagamentoCartaoCredito(Integer id) {
		super(id, "Cartão Crédito", 3, 0.0);
	}
	
	@Override
	public Double calculaValor(Carrinho carrinho) {
        
		Double valorTotal = 0.0;
		Double valorAux = 0.0;
		for (CarrinhoItem itemCarrinho : carrinho.getItens()) {
			valorAux = itemCarrinho.getQuantidade() * itemCarrinho.getPrecoVendido();
			valorTotal = valorTotal + valorAux;
		}
		
		Double valorDesconto = valorTotal * (this.getDesconto() / 100);
		valorTotal = valorTotal - valorDesconto;
		return valorTotal;
    }
	
}
