package Controller;

import java.lang.reflect.Array;
import java.util.ArrayList;

import Model.Carrinho;
import Model.Produto;

public class CarrinhoController {
	
	public static ArrayList<Produto> produtos;

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
	
	public void criaProduto(String nome, int preco) {
		Produto p = new Produto(nome, preco);
		produtos.add(p);
	}
	
	public void addProduto(Produto produto) {
		ArrayList<Produto> p = Carrinho.getProdutos();
		p.add(produto);
		Carrinho.setProdutos(p);
		int aux = Carrinho.getPrecoFinal();
		aux += produto.getPreco();
		Carrinho.setPrecoFinal(aux);
	}
	
	public void iniciaCarrinho() {
		if(ClienteController.cliente != null) {
			Carrinho.getInstance(ClienteController.cliente, 0);
		}else {
			new Exception("Cliente não possui cadastro");
		}
	}
}
