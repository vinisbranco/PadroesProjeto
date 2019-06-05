package View;

import Controller.CarrinhoController;
import Model.Carrinho;
import Model.Cliente;

public class Programa {

	static Carrinho m;
	public Programa() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
			Cliente cliente = new Cliente("Faustinho", "11111");
		 	m = Carrinho.getInstance(cliente, 0);
	        UICarrinho v = new UICarrinho ();
	        CarrinhoController c = new CarrinhoController();
	        c.associaModel(m);
	        c.associaView(v);
	        v.inicializaUI();
	        v.associaController(c);
	        c.inicializaModel(0);
	        
	}

}
