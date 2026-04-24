import java.util.Scanner;
public class principal {
    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        fila sistema = new fila(3);

        int opcao = 0;

        System.out.println("sistema de atendimento");

        // loop ate aperta 4
        while (opcao != 4) {
            System.out.println("\n ");
            System.out.println("1  add cliente");
            System.out.println("2  atender/deletar");
            System.out.println("3  listar fila");
            System.out.println("4  sair");
            System.out.print("escola opcao: ");

            // filtro numero
            if (leitor.hasNextInt()) {
                opcao = leitor.nextInt();
                leitor.nextLine(); // limpa o teclado
            } else {
                System.out.println("erro: nao e numero");
                leitor.nextLine(); // limpa texto
                continue; // volta pro menu
            }

            switch (opcao) {
                case 1:
                    System.out.print("digite um nome: ");
                    String nome = leitor.nextLine();
                    registrar(sistema, nome);
                    break;
                case 2:
                    realizarAtendimento(sistema);
                    break;
                case 3:
                    exibirFila(sistema);
                    break;
                case 4:
                    System.out.println("encerrando");
                    break;
                default:
                    System.out.println("opc invalida");
            }
        }

        leitor.close();
    } //fecha main


    private static void registrar(fila f, String nome) {
        if (f.adicionar(nome)) {
            System.out.println("confirmado: " + nome + " entrou na fila.");
        } else {
            System.out.println("fila cheia d+ para " + nome);
        }
    }//fecha registrar

    //mostra proximo
    private static void realizarAtendimento(fila f) {
        String cliente = f.atender();
        if (cliente != null) {
            System.out.println("chamando agora: " + cliente);
        } else {
            System.out.println("naoo tem clientes.");
        }
    }//fecha realizar atendimento

    private static void exibirFila(fila f) {
        System.out.println("\nfila atual:");

        int total = f.getTotal();

        if (total == 0) {
            System.out.println("vazia");
        } else {
            for (int i = 0; i < total; i++) {
                String nome = f.getNomePelaPosicao(i);
                System.out.println((i + 1) + "º - " + nome);
            }
        }
    }//fecha exb fila
}//fecha principal