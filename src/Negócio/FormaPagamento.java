package Neg�cio;

import DTO.Carrinho;
import DTO.Cliente;

public interface FormaPagamento {
	double finalizaCompra(Cliente cliente, Carrinho c);
}
