
public class ArrayLista {
	private int tam;
	private int cont = 0;
	private Integer[] lista;

	public ArrayLista(int tam) {
		lista = new Integer[tam];
	}

	public void addElementArray(int numero) {
		if (cont == 0) {
			lista[0] = numero;
			cont++;
		} else {
			for (int i = 0; i <= cont; i++) {
				if (lista[i] == null) {
					lista[i] = numero;

				} else {
					lista[i + 1] = numero;
				}
			}
			cont++;
		}
	}

	public int searchBinary(int numero) {

		int aux = tam / 2;
		while (lista[aux] != numero) {
			if (lista[aux] < numero) {
				aux = aux + aux / 2;
			} else {
				aux /= 2;
			}
		}
		return lista[aux];
	}
}
