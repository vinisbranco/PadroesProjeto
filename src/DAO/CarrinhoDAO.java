package DAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CarrinhoDAO {

	public CarrinhoDAO() {
		// TODO Auto-generated constructor stub
	}

	public static String get() throws IOException {
		String response = "";
		int count = 1;
		String path = "/Database";
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String linha = "";
		while (true) {
			if (linha != null) {
				response = response + "\n"+ count + ": " + linha;
				System.out.println(linha);
				count++;
			} else
				break;
			linha = buffRead.readLine();
		}
		buffRead.close();
		return response;
	}

	public static void push(String conteudo) throws IOException {
		String path = "/Database";
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		String linha = "";
		Scanner in = new Scanner(System.in);
		System.out.println("Escreva algo: ");
		linha = in.nextLine();
		buffWrite.append(linha + "\n");
		buffWrite.close();
	}
}
