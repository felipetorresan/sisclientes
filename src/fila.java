public class fila {
    private String[] clientes;
    private int totalClientes;
    private final int CAPACIDADE;

    //construtor
    public fila(int capacidade) {
        this.CAPACIDADE = capacidade;
        this.clientes = new String[capacidade];
        this.totalClientes = 0;
    }//fecha contrutor

    // add
    public boolean adicionar(String nome) {
        if (totalClientes < CAPACIDADE) {
            clientes[totalClientes] = nome;
            totalClientes++;
            return true;
        }
        return false; // fila cheia
    }//fecha add

    // deleta
    public String atender() {
        if (totalClientes == 0) {
            return null;
        }
        //pega da posicao 0
        String proximo = clientes[0];

        // move td pra frente
        for (int i = 0; i < totalClientes - 1; i++) {
            clientes[i] = clientes[i + 1];
        }

        clientes[totalClientes - 1] = null;
        totalClientes--;
        return proximo;
    }//fecha deleta

    public String[] getClientes() {
        // mostra os cliente da lista
        String[] ativos = new String[totalClientes];
        for (int i = 0; i < totalClientes; i++) {
            // O > 1 > 2 > 3
            ativos[i] = this.clientes[i];
        }
        return ativos;
    }//fecha getclinte

    // quantas vezes roda o loop
    public int getTotal() {
        return this.totalClientes;
    }

    // pega nomes de i de clientes
    public String getNomePelaPosicao(int i) {
        return this.clientes[i];
    }
}//fecha fila