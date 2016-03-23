
public class Lista {

	private static Node head;
	private static Node aux;/* Serve para pecorrer a lista */

	public Lista() {
		// inicio = new Node(info);
	}

	public static void addElement(int numero) {

		if (head == null) {/* caso a lista não esteja criada */
			head = new Node(numero);

		} else {/* vai da sequencia ao resto da sequencia */
			aux = head;
			if (aux.getInfo() > numero) {
				Node aux2 = new Node(
						numero);/*
								 * foi criado um aux temporario para armazenar o
								 * resto da lista
								 */
				aux2.setNext(aux);
				head = aux2;
			} else if (aux.getInfo() < numero) {
				while (aux.getNext() != null) {
					if (aux.getNext().getInfo() < numero)
						aux = aux.getNext();
					else
						break;
				}
				Node aux2 = aux.getNext();
				aux.setNext(new Node(numero));
				aux = aux.getNext();
				aux.setNext(aux2);
			} else {
				System.out.println("Números iguais, não adiciona");
				// TODO
			}
		}

	}

	public static void printList() { // TODO add exception
		if (head == null) { // Verifica se a lista esta vazia
			System.out.println("Lista vazia");
			// TODO Exceção
		} else {
			aux = head; /* Aponta o auxiliar para o inicio da lista */
			while (aux != null) {
				System.out.print(
						aux.getInfo() + " "); /* Imprimi a info do auxiliar */
				aux = aux.getNext();/* Aponta o auxiliar para o proximo node */
			}
		}
	}

	public static void delete(int numero) { // Deleta um node

		int position = searchElementPosition(numero, head);
		if (position == 0) {
			head = head.getNext();
		} else {
			aux = head;
			while (aux.getNext().getInfo() != numero) {
				aux = aux.getNext();
			}
			aux.setNext(aux.getNext().getNext());
		}

	}

	public static void cleanList() {
		if (head == null) {
			System.out.println("Lista já está vazia");
			// TODO Exceção
		} else {
			head = null;
		}
	}

	public static void searchElement(int numero) {
		aux = head;
		while (aux != null && numero != aux.getInfo()) {

			aux = aux.getNext();
		}
		if (aux == null) {
			System.out.println("Esse número não se encontra na lista!");
		} else {
			System.out.println("O numero esta na lista!");
		}

	}

	public static int getElement(int numero) {
		int retorno = 0;
		if (numero == 0) {
			retorno = head.getInfo();
		} else {
			int contador = 0;
			head = aux;
			while (contador < numero) {
				if (aux == null) {
					System.out.println("Posição invalida!");
					break;
				} else {
					contador++;
					aux = aux.getNext();
				}
			}
			retorno = aux.getInfo();
		}
		return retorno;
	}

	private static int searchElementPosition(int numero, Node no) {
		if (no == null) {
			if (no.getInfo() == numero) {
				return 0;
			} else {
				return 1 + searchElementPosition(numero, no.getNext());
			}
		} else {
			throw new RuntimeException();
		}

	}

	@Override
	public String toString() {
		return "Lista [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
