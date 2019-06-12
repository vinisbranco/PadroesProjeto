package View;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.CarrinhoController;
import DTO.Carrinho;
import DTO.ModelListener;

public class UICarrinho implements ModelListener {
	private static JTextField campoTexto;
    private static JButton botao;
    private static JFrame janela;
	public UICarrinho() {
		// TODO Auto-generated constructor stub
	}

	public void inicializaUI() {
	
		janela = new JFrame("MVC Completo V3");
        campoTexto = new JTextField(3);
        botao = new JButton("Adicionar Produto");
        
        campoTexto.setEnabled(false);
        JPanel painel = new JPanel();
        painel.add(campoTexto);
        painel.add(botao);
        janela.getContentPane().add(painel);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.pack();
        janela.setVisible(true);
        
	}

	public void associaController(CarrinhoController c){	
		botao.addActionListener(c);
	}
	
	@Override
	public void valorAlterado(int v) {
		campoTexto.setText(""+v);	
	}
	
	

}
