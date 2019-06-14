package DTO;

public class Produto {
	
	private String nome;
	private int preco;

	public Produto(String nome, int preco) {
		this.nome = nome;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}
	public int getPreco() {
		return preco;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setPreco(int preco) {
		this.preco = preco;
	}
	@Override
	public String toString() {
		return nome + ": R$" + preco;
	}

}
