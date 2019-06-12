package Negócio;

import Model.Carrinho;
import Model.Cliente;

public class PagamentoDebito implements FormaPagamento{

	public PagamentoDebito() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public double finalizaCompra(Cliente cliente, Carrinho c) {
		// TODO Auto-generated method stub
		return 0;
	}

}
