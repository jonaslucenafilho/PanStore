package br.com.pan.store.entidades;

/**
*
* @author Tiago Almeida
*/

public class PagamentoPix extends FormaDePagamento {
	// Classe Construtora
	public PagamentoPix() {
		this.getId(2);
		this.getNome("Pagmento em Pix");
	};
	
	//@Override
	public Double calculaValor() {
		return this.calculaValor * 0.80;
	}
	
}	






//double totalpix;
	//public double PagamentoPix( double ) {
	//	return PagamentoPix();
	//};

	//@Override
	//public Double calculaValor() {
	//	return this.getCalculaValor * 0.80;
	//}
	//public Double calculaValor() {
	//	double totalpix = 0;
		
	//	PagamentoPix = this.getCalculaValor();	
		//if(this.getCalculaValor() == pix) {
		//	pix = getCalculaValor * 0.8f;
	//	}
		
		//;
		//double pix = 0; 
	
	//if (this.calculaValor() == pix) {
		//	pix = getCalculaValor * 80/100;
		
	//	Double PagamentoPix;
	//	return PagamentoPix;
		
	//}


	//public PagamentoPix(Double calculaValor) {
	//	this.PagamentoPix =
		
	//}
	//return {PagamentoPix};
