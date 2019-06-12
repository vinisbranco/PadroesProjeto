package Negócio;

import Model.Carrinho;
import Model.Cliente;

public interface FormaPagamento {
	double finalizaCompra(Cliente cliente, Carrinho c);
}
