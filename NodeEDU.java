package exercicioLista;

public class Node { // Objeto do tipo node

	private Node next;
	private int info;

	public Node(int info) {
		this.setInfo(info);
		this.setNext(null);
	}

	public void setInfo(int info) {
		this.info = info;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getNext() {
		return this.next;
	}

	public int getInfo() {
		return this.info;
	}

}
