package View;

import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ListModel;

import com.sun.prism.paint.Color;

import Controller.CarrinhoController;
import DTO.Produto;
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
		botao = new JButton("Adicionar no produto carrinho");

		JPanel painel = new JPanel();

		campoTexto.setEnabled(false);

		janela.setSize(2000, 2000);

		
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		Produto p = new Produto("TV Sony 40'", 2000);
		produtos.add(p);
		Produto p2 = new Produto("Sofa", 1400);
		produtos.add(p2);
		Produto p3 = new Produto("Armario", 2000);
		produtos.add(p3);
		Produto p4 = new Produto("Geladeira Brastemp", 3000);
		produtos.add(p4);
		Produto p5 = new Produto("Notebook Dell", 2500);
		produtos.add(p5);
		Produto p6 = new Produto("Torradeira", 80);
		produtos.add(p6);
		
		String[] produtosData = new String[6];
		
		for(int i = 0; i < produtosData.length; i++) {
			produtosData[i] = produtos.get(i).toString();
		}

		painel.add(new JList<String>(produtosData));

		painel.add(campoTexto);

		painel.add(botao);

		janela.getContentPane().add(painel);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		janela.setLocationRelativeTo(null);

		janela.doLayout();

		janela.pack();
		janela.setVisible(true);

	}

	public void associaController(CarrinhoController c) {
		botao.addActionListener(c);
	}

	@Override
	public void valorAlterado(int v) {
		campoTexto.setText("" + v);
	}

}
