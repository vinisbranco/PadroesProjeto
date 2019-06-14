package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import DAO.CarrinhoDAO;
import DTO.Carrinho;
import DTO.Produto;
import View.UICarrinho;

public class CarrinhoController implements ActionListener {

	public static ArrayList<Produto> produtos;
	public Carrinho carrinho;
	private UICarrinho view;

	public CarrinhoController() {
		produtos = new ArrayList<Produto>();
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
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void criaNovoProduto(String nome, int preco) {
		Produto p = new Produto(nome, preco);
		produtos.add(p);
	}

	public void addProdutoCarrinho(Produto produto) {
		ArrayList<Produto> p = Carrinho.getProdutos();
		p.add(produto);
		carrinho.setProdutos(p);
		int aux = Carrinho.getPrecoFinal();
		aux += produto.getPreco();
		carrinho.setPrecoFinal(aux);
		try {
			CarrinhoDAO.push(carrinho.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getCarrinho() {
		String response = "";
		try {
			response = CarrinhoDAO.get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;

	}

	public void iniciaCarrinho() {
		if (ClienteController.cliente != null) {
			carrinho = Carrinho.getInstance(ClienteController.cliente, 0);
		} else {
			new Exception("Cliente nao possui cadastro");
		}
	}

	public void associaModel(Carrinho c) {
		carrinho = c;
	}

	public void associaView(UICarrinho c) {
		view = c;
		carrinho.addModelListener(view);
	}

	public void inicializaModel(int v) {
		carrinho.setValor(v);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		carrinho.incrementaValor();
	}
}
