package Model;

import java.util.ArrayList;

public class Carrinho {

	private static volatile Carrinho instance;
	
	private static ArrayList<Produto> produtos;
	private static Cliente cliente;
	private static int precoFinal;
	
	private Carrinho(Cliente cliente, int precoFinal) {
		this.cliente = cliente;
		this.precoFinal = precoFinal;
	}
	
	public static Carrinho getInstance(Cliente cli, int precoFin) {
		if(instance == null) {
			synchronized (Carrinho.class) {
				if(instance == null) {
					instance = new Carrinho(cli,precoFin);
				}
			}
		}
		return instance;
	}
	
	public static ArrayList<Produto> getProdutos() {
		return produtos;
	}
	public static void setProdutos(ArrayList<Produto> produtos) {
		Carrinho.produtos = produtos;
	}
	public static int getPrecoFinal() {
		return precoFinal;
	}
	public static void setPrecoFinal(int precoFinal) {
		Carrinho.precoFinal = precoFinal;
	}
	
@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "produtos: "+produtos.toString() + " cliente: " +cliente+ " Total: " + precoFinal; 
	}
	
	

}
