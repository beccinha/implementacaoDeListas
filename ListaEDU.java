package exercicioLista;
 
import java.util.Scanner;
 
public class Lista {
 
    private static Node inicio, auxiliar;
    private static int contador;
 
    public Lista(int info) {
        inicio = new Node(info);
    }
 
    public static void printList() { // TODO add exception
        if (inicio == null) { // Verifica se a lista esta vazia
            System.out.println("Lista vazia!");
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
            System.out.println("Lista esvaziada com sucesso");
        } else {
            inicio = null;
 
        }
    }
 
    public static void addElement(int info) {// TODO add exception
        if (inicio == null) { // verifica se a lista esta vazia
            inicio = new Node(info); // cria o node inicial
            System.out.println("Elemento criado com sucesso");
            auxiliar = inicio; // aponta o auxiliar para o inicio
            contador++; // acrescenta o contador
        } else {
            auxiliar.setNext(new Node(info)); // Seta o proximo node
            contador++; // Adiciona 1 ao contador
            auxiliar = auxiliar.getNext(); // Aponta o auxiliar para o proximo
                                            // node do antigo auxiliar
            System.out.println("Elemento adicionado com sucesso");
 
        }
    }
 
    public static int searchElement(int info) { // Busca o elemento recebido na
                                                // lista
        if (inicio != null) {
            auxiliar = inicio; // Aponta o auxiliar para o inicio da lista
            for (int i = 0; i < contador; i++) {
                if (auxiliar.getInfo() == info) { // Verifica se a info do node
                                                    // e igual a recebida
                    return auxiliar.getInfo(); // Caso seja, retorna a info do
                                                // node
                }
                auxiliar = auxiliar.getNext(); // Aponta o auxiliar para o
                                                // proximo node
            }
        }
        return 0;
 
    }
 
    public static int searchElementPosition(int info) { // Busca a posicao do
                                                        // elemento recebido
        if (inicio != null) {
            auxiliar = inicio; // Aponta o auxiliar para o inicio da lista
            for (int i = 0; i < contador; i++) {
                if (auxiliar.getInfo() == info) { // Verifica se a info do node
                                                    // e igual a recebida
                    return (i + 1); // Caso seja, retorna a info do
                                    // node
                }
                auxiliar = auxiliar.getNext(); // Aponta o auxiliar para o
                                                // proximo node
            }
        }
        return 0;
    }
 
    public static int searchXElement(int n) { // Busca o elemento na posicao
                                                // recebida
        if (inicio != null) { // Verifica se a lista e vazia
            auxiliar = inicio; // Aponta o auxiliar para o inicio
            for (int i = 0; i < n - 1; i++) {
                auxiliar = auxiliar.getNext(); // Aponta o auxiliar para o
                                                // proximo ate chegar a posicao
                                                // desejada
            }
 
            return auxiliar.getInfo();// Retorna a info do node buscado
        }
        return 0;
    }
 
    public static void delete(int numero) { // Deleta um node
 
        int position = searchElementPosition(numero); // Atribui o valor da
                                                        // posicao encontrada a
                                                        // variavel
        auxiliar = inicio; // Aponta o auxiliar para o inicio
        for (int i = 0; i < position; i++) { // Percorre a lista ate o anterior
                                                // ao node que deseja deletar
            if (i == (position - 2)) {
                auxiliar.setNext(auxiliar.getNext().getNext()); // Atribui o
                                                                // proximo do
                                                                // proximo como
                                                                // o proximo
                                                                // node do
                                                                // auxiliar,
                                                                // retirando
                                                                // assim o node
                                                                // desejado
                contador--;
            } else if ((position - 2) == (-1)) { // Caso a posicao seja a
                                                    // primeira
                System.out.println("Impossivel excluir o primeiro node");
            }
            if (auxiliar.getNext() != null) { // Verifica se a lista acabou
                auxiliar = auxiliar.getNext();
            }
 
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
        System.out.println(searchElementPosition(7));
        delete(7);
        delete(3);
        delete(8);
        printList();
        cleanList();
        printList();
    }
 
}
