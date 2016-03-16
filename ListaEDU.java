package exercicioLista;

import java.util.Scanner;

public class Lista {

	private static Node inicio, auxiliar, auxiliarMovel;
	private static int contador;

	public Lista(int info) {
		inicio = new Node(info);
	}

	public static void printList() { // TODO add exception
		if (inicio == null) { // Verifica se a lista esta vazia
			System.out.println("Lista vazia");
		} else {
			auxiliar = inicio; // Aponta o auxiliar para o inicio da lista
			for (int i = 0; i < contador; i++) {
				System.out.println(auxiliar.getInfo()); // Imprimi a info do
														// auxiliar
				auxiliar = auxiliar.getNext();// Aponta o auxiliar para o
												// proximo node
			}
		}
	}

	public static void cleanList() {
		if (inicio == null) {
			System.out.println("Lista vazia");
		} else {
			inicio = null;

		}
	}

	public static void addElement(int info) {// TODO add exception
		if (inicio == null) { // verifica se a lista esta vazia
			inicio = new Node(info); // cria o node inicial
			System.out.println("ok 1");
			auxiliar = inicio; // aponta o auxiliar para o inicio
			contador++; // acrescenta o contador
		} else {
			auxiliar.setNext(new Node(info)); // Seta o proximo node
			contador++; // Adiciona 1 ao contador
			auxiliar = auxiliar.getNext(); // Aponta o auxiliar para o proximo
											// node do antigo auxiliar
			System.out.println("OK");

		}
	}

	public static Node searchElement(int info) {
		if (inicio != null) {
			auxiliar = inicio; // Aponta o auxiliar para o inicio da lista
			for (int i = 0; i < contador; i++) {
				if (auxiliar.getInfo() == info) { // Verifica se a info do node
													// e igual a recebida
					return auxiliar; // Caso seja, imprimi o node
				}
				auxiliar = auxiliar.getNext(); // Aponta o auxiliar para o
												// proximo node
			}
		}
		return null;

	}

	public static Node searchXElement(int n) {
		if (inicio != null) { // Verifica se a lista e vazia
			auxiliar = inicio; // Aponta o auxiliar para o inicio
			for (int i = 0; i < n - 1; i++) {
				auxiliar = auxiliar.getNext(); // Aponta o auxiliar para o
												// proximo ate chegar a posicao
												// desejada
			}

			return auxiliar;// Imprimi o node buscado
		}
		return null;
	}

	public static void deleteElement(int info) {//TODO
		auxiliar = searchElement(info);
		if(auxiliar != null){
			
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Insira um numero: ");
		int x = 0;

		do {
			addElement(sc.nextInt());
			System.out.println("outro: ");
			x++;
		} while (x <= 10);

		System.out.println("Wait...");
		printList();
		System.out.println(searchElement(3));
		System.out.println(searchXElement(3));
		cleanList();
		printList();
	}

}
