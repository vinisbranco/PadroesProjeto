package Negócio;

import DTO.Carrinho;
import DTO.Cliente;

public class PagamentoDebito implements FormaPagamento{

	public PagamentoDebito() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public double finalizaCompra(Cliente cliente, Carrinho c) {
		Carrinho.setPago(true);
		return Carrinho.getPrecoFinal();
	}

}
