package DTO;
import java.util.Observable;

import View.UICarrinho;

import java.awt.List;
import java.util.ArrayList;

public class Carrinho extends Observable {

	private static volatile Carrinho instance;
	private static int count;
	private ArrayList<ModelListener> models;
	private static ArrayList<Produto> produtos;
	private static Cliente cliente;
	private static int precoFinal;
	private static boolean pago;
	
	private Carrinho(Cliente cliente, int precoFinal) {
		this.cliente = cliente;
		this.precoFinal = precoFinal;
		models = new ArrayList<ModelListener>();
		pago = false;
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
	
	public void setValor(int v) {
		count = v;
		for(ModelListener m: models) {
			m.valorAlterado(count);
		}
	}
	
	public static ArrayList<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(ArrayList<Produto> produtos) {
		Carrinho.produtos = produtos;
		setChanged();
        notifyObservers();
		
	}
	public static int getPrecoFinal() {
		return precoFinal;
	}
	public void setPrecoFinal(int precoFinal) {
		Carrinho.precoFinal = precoFinal;
		setChanged();
        notifyObservers();
	}
	
	public void incrementaValor() {
		count++;
		for(ModelListener m: models) {
			m.valorAlterado(count);
		}
	}
	
	public void addModelListener(ModelListener l) {
		models.add(l);
	}
	
	public static boolean isPago() {
		return pago;
	}
	
	public static void setPago(boolean pago) {
		Carrinho.pago = pago;
	}
	
@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "produtos: "+produtos.toString() + " cliente: " +cliente+ " Total: " + precoFinal; 
	}

	
	

}
