package Controller;

import DTO.Cliente;

public class ClienteController {

	public static Cliente cliente;
	
	public ClienteController() {
	}
	
	public void criaCliente(String nome, String cpf) {
		Cliente c = new Cliente(nome,cpf);
		ClienteController.cliente = c;
	}

}
