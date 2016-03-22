
public class Lista {

	private static Node node;
	private static Node aux;/* Serve para pecorrer a lista */
	private static int contador;

	public Lista() {
		// inicio = new Node(info);
	}

	public static void addElement(int numero) {
		if (node == null) {/* caso a lista não esteja criada */
			node = new Node(numero);
			// System.out.println("criou a primeira!");
			/* só pra saber se add a primeira */
		} else {/* vai da sequencia ao resto da sequencia */
			aux = node;
			if (aux.getInfo() > numero) {
				Node aux2 = new Node(numero);/*
								 * foi criado um aux temporario para armazenar o
								 * resto da lista
								 */
				aux2.setNext(aux);
				node = aux2;
			} else if (aux.getInfo() < numero) {
				do {
					aux = aux.getNext();
				} while (aux.getInfo() < numero);
				Node aux2 = new Node(numero);
				aux.setNext(aux2);
			} else {
				System.out.println("Números iguais, não adiciona");
				// TODO Exceção
				
			}
		}

	}

	/*
	 * private static void ordenarElementos(Node list) { Node aux; if (list !=
	 * null) { if(aux.getNext().getInfo() < ){
	 * 
	 * } } else { System.out.println("Lista vazia!"); } }
	 */

	public static void printList() { // TODO add exception
		if (node == null) { // Verifica se a lista esta vazia
			System.out.println("Lista vazia");
			//TODO Exceção
		} else {
			aux = node; /* Aponta o auxiliar para o inicio da lista */
			do {
				System.out.println(aux.getInfo()); /* Imprimi a info do	auxiliar */
				aux = aux.getNext();/* Aponta o auxiliar para o proximo node */
			} while (aux.getNext() != null); 
		}
	}

	public static void delete(int numero) {
		if (numero == aux.getInfo()) {
			if (numero == aux.getInfo()) {
				aux = node;
				do{
					aux = aux.getNext();
				} while(numero != aux.getInfo());
				
			}
		} else {
			System.out.println("Não exite esse elemento!");
			// TODO Exceção
		}

	}

	public static void cleanList() {
		if (node == null) {
			System.out.println("Lista já está vazia");
			//TODO Exceção
		} else {
			node.setNext(null);
		}
	}

	public static void searchElement(int numero) {
		if (numero == aux.getInfo()) {
			aux = node;
			do{
				aux = aux.getNext();
			} while(numero != aux.getInfo());
				System.out.println("O numero esta na lista!");
		} else {
			System.out.println("Esse número não se encontra na lista!");
			//TODO Exceção
		}
	}

	public static Node getElement(int numero) {
		Node retorno = null;
		if (numero == aux.getInfo()) {
			aux = node;
			do{
				aux = aux.getNext();
			} while(numero != aux.getInfo());
				retorno = aux;
		} else {
			System.out.println("Esse número não se encontra na lista!");
			//TODO Exceção
		}
		return retorno;
	}

	@Override
	public String toString() {
		return "Lista [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
