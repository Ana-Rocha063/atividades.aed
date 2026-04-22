class Node {
    public Object item;
    public Node next;

    public Node(Object item) {
        this.item = item;
        this.next = null;
    }

    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }
}

public class ListaSimples {
    private Node head;

    public ListaSimples() {
        this.head = null;
    }

    public void insertFirst(Object item) {
        Node novo = new Node(item, head);
        head = novo;
    }

    public Node find(Object item) {
        Node atual = head;
        while (atual != null) {
            if (atual.item.equals(item)) return atual;
            atual = atual.next;
        }
        return null;
    }

    public void insertAfter(Node x, Object item) {
        if (x == null) return;
        Node novo = new Node(item);
        novo.next = x.next;
        x.next = novo;
    }

    public void imprimir() {
        Node atual = head;
        while (atual != null) {
            System.out.print(atual.item + " -> ");
            atual = atual.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListaSimples lista = new ListaSimples();
        lista.insertFirst("C");
        lista.insertFirst("B");
        lista.insertFirst("A");
        lista.imprimir(); // A -> B -> C -> null

        Node noB = lista.find("B");
        if (noB != null) {
            lista.insertAfter(noB, "B2");
        }
        lista.imprimir(); // A -> B -> B2 -> C -> null

        Node noZ = lista.find("Z");
        System.out.println("Busca por Z: " + noZ); // null
    }
}