package br.com.pan.store.entidades;

/**
*
* @author Tiago Almeida
*/

public class PagamentoDinheiro extends FormaDePagamento {
	// Classe Construtora
	public PagamentoDinheiro() {
		this.getId(1);
		this.getNome("Pagmento em Dinheiro");
	};
	
	//@Override
	public Double calculaValor() {
		return this.calculaValor * 0.80;
	}
	
}




	
	
	
	//public double calculaValor;
	
	//void calculaValor() {
	//	if (this)
	//}
