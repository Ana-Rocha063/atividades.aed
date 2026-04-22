public class MeuArrayDinamico {
    private int[] dados;
    private int tamanho; 

    public MeuArrayDinamico(int capacidadeInicial) {
        this.dados = new int[capacidadeInicial];
        this.tamanho = 0;
    }

    private void resize() {
        // TODO 1a: novo array com o dobro do tamanho atual
        int[] novo = new int[dados.length * 2];
        // TODO 1b: copiar elementos
        for (int i = 0; i < tamanho; i++) {
            novo[i] = dados[i];
        }
        // TODO 1c: apontar para o novo array
        dados = novo;
    }

    public void add(int valor) {
        // TODO 2a: se cheio, chama resize
        if (tamanho == dados.length) {
            resize();
        }
        // TODO 2b e 2c: adiciona valor e incrementa tamanho
        dados[tamanho] = valor;
        tamanho++;
    }

    public void remove(int indice) {
        if (indice < 0 || indice >= tamanho)
            throw new IndexOutOfBoundsException("Indice invalido: " + indice);

        // TODO 1: deslocar elementos para a esquerda
        for (int i = indice; i < tamanho - 1; i++) {
            dados[i] = dados[i + 1];
        }
        // TODO 2: decremente tamanho
        tamanho--;
    }

    public int size() {
        return tamanho;
    }

    public void imprimir() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < tamanho; i++) {
            sb.append(dados[i]);
            if (i < tamanho - 1) sb.append(", ");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        MeuArrayDinamico arr = new MeuArrayDinamico(2);
        arr.add(10);
        arr.add(20);
        arr.imprimir(); // [10, 20]
        
        arr.add(30); 
        arr.add(40);
        arr.imprimir(); // [10, 20, 30, 40]
        System.out.println("Tamanho: " + arr.size()); // 4

        arr.remove(1); 
        arr.imprimir(); // [10, 30, 40]
        arr.remove(0); 
        arr.imprimir(); // [30, 40]
        System.out.println("Tamanho: " + arr.size()); // 2
    }
}