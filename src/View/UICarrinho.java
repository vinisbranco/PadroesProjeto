package View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Icon;
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
    private static JButton botaoCadastro;
    
    private static JFrame janelaCriacao;
    
	public UICarrinho() {
		// TODO Auto-generated constructor stub
	}

	public void inicializaUI() {
	
		janela = new JFrame("MVC Completo V3");
        campoTexto = new JTextField(3);
        botao = new JButton("Adicionar no carrinho");
        botaoCadastro = new JButton("Adicionar produto");
        
        botaoCadastro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				janelaCriacao = new JFrame("Criar produto");
				JPanel janelaProduto = new JPanel();
				janelaProduto.setSize(2000, 2000);
			
				
				janelaProduto.add(new JTextField("Insira o nome do produto", 25));
				
				janelaProduto.add(new JTextField("Insira o preço do produto", 25));
				
				JButton botaoAdicionar = new JButton("Adicionar");
				
				botaoAdicionar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						
					}
				});
				
				
				janelaProduto.add(botaoAdicionar);
				
				
				
				
				janelaCriacao.getContentPane().add(janelaProduto);
				
				
				
				
				janelaCriacao.pack();
				janelaCriacao.setVisible(true);
				
				
				
			}
		});
        
        campoTexto.setEnabled(false);
        JPanel painel = new JPanel();
        painel.add(campoTexto);
        painel.add(botao);
        painel.add(botaoCadastro);
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
