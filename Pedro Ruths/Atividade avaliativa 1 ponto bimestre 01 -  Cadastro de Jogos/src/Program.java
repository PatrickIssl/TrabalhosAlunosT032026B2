import objetos.Jogo;

import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Jogo> jogos = new ArrayList<Jogo>();

    public static void main(String[] args){

        mostraMenu();

    }

    public static void mostraMenu() {

        int opc;

        do {

            System.out.println("========== SISTEMA DE GERENCIAMENTO ==========");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar Todos");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Atualizar");
            System.out.println("5 - Excluir");
            System.out.println("0 - Sair");
            opc = sc.nextInt();
            sc.nextLine();
            System.out.println();


            validarOpcao(opc);


        }while (opc != 0);



    }

    public static void validarOpcao(int opc) {

        switch (opc){
            case 1: {
                cadastrarJogo();
                break;
            }
            case 2: {
                listarJogos();
                break;
            }
            case 3: {
                buscarId();
                break;
            }
            case 4: {
                atualizarJogo();
                break;
            }
            case 5: {
                excluirJogo();
                break;
            }
            case 0: {
                System.out.println("Obrigado por usar o sistema!");
                break;
            }
            default: {
                System.out.println("Selecione uma opção válida!");
            }
        }


    }

    private static void excluirJogo() {

        listarJogos();
        System.out.print("Digite o ID do jogo para a exclusão: ");
        int id = sc.nextInt() - 1;
        System.out.println();
        if(id < 0 || id > jogos.size()){
            System.out.println("Digite um ID válido!");
            return;
        }
        sc.nextLine();

        Jogo jogo = jogos.get(id);
        System.out.println("Deseja excluir:");
        System.out.printf("NOME: %s | GÊNERO: %s | PREÇO: R$%.2f\n",jogo.getNome(),jogo.getGenero(),jogo.getPreco());
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        int opc = sc.nextInt();
        sc.nextLine();

        if(opc == 1){
            jogos.remove(jogo);
            System.out.println("Jogo removido!");
        }
        else {
            System.out.println("Jogo não removido!");
        }

    }

    public static void atualizarJogo() {

        listarJogos();
        System.out.print("Digite o ID do jogo para a atualização: ");
        int id = sc.nextInt() - 1;
        sc.nextLine();
        System.out.println();

        if(id < 0 || id > jogos.size()){
            System.out.println("Digite um ID válido!");
            return;
        }
        Jogo jogo = jogos.get(id);
        mostrarMenuAtualizar(jogo);

    }


    public static void mostrarMenuAtualizar(Jogo jogo) {

        int opc;

        do {
            System.out.println("========== MENU DE ATUALIZAÇÃO ==========");
            System.out.println("1 - Alterar nome");
            System.out.println("2 - Alterar gênero");
            System.out.println("3 - Alterar preço");
            System.out.println("0 - Sair");
            opc = sc.nextInt();
            sc.nextLine();

            alterarJogo(jogo, opc);

        }while (opc != 0);


    }

    public static void alterarJogo(Jogo jogo,int opc) {

        switch (opc) {
            case 1: {
                System.out.print("Digite o novo nome: ");
                jogo.setNome(sc.nextLine());
                break;
            }
            case 2: {
                System.out.print("Digite o novo gênero: ");
                jogo.setGenero(sc.nextLine());
                break;
            }
            case 3: {
                System.out.print("Digite o novo preço: R$");
                jogo.setPreco(sc.nextDouble());
                sc.nextLine();
                break;
            }
            case 0: {
                System.out.println("Voltando ao menu principal ...");
                break;
            }
            default: {
                System.out.println("Selecione uma opção válida!");
            }
        }
    }

    public static void buscarId() {

        int id;
        System.out.print("Digite o ID para procurar o jogo: ");
        id = sc.nextInt() - 1;
        sc.nextLine();

        if(id > jogos.size() || id < 0){
            System.out.println("Digite um ID válido!");
            return;
        }

        Jogo jogo = jogos.get(id);

        System.out.println();
        System.out.println("Jogo selecionado:");
        System.out.printf("NOME: %s | GÊNERO: %s | PREÇO: R$%.2f\n",jogo.getNome(),jogo.getGenero(),jogo.getPreco());
        System.out.println();

    }

    public static void listarJogos() {

        System.out.println("========== JOGOS ==========");
        for(int i=0;i<jogos.size();i++){
            Jogo jogo = jogos.get(i);
            System.out.printf("ID: %d | NOME: %s | GÊNERO: %s | PREÇO: R$%.2f\n",jogo.getId(),jogo.getNome(),jogo.getGenero(),jogo.getPreco());
        }
        System.out.println();
    }

    public static void cadastrarJogo() {

        Jogo jogo = new Jogo();

        System.out.print("Digite o nome do jogo: ");
        jogo.setNome(sc.nextLine());
        if(jogo.getNome().isBlank()){
            System.out.println("É necessário digitar o nome do jogo!");
            return;
        }
        for (Jogo x: jogos){
            if (x.getNome().equals(jogo.getNome())){
                System.out.println("Jogo já cadastrado no sistema!");
                return;
            }
        }

        System.out.print("Digite o gênero do Jogo: ");
        jogo.setGenero(sc.nextLine());
        if(jogo.getGenero().isBlank()){
            System.out.println("É necessário digitar o gênero do jogo!");
            return;
        }

        System.out.print("Digite o preço do jogo: R$");
        jogo.setPreco(sc.nextDouble());
        sc.nextLine();
        if(jogo.getPreco() < 0) {
            System.out.println("Preço precisa ser maior que zero!");
            return;
        }

        jogo.setId(jogos.size() + 1);
        for (Jogo x: jogos){
            if (x.getId() == jogo.getId()){
                jogo.setId(x.getId() + 1);
            }
        }

        jogos.add(jogo);
        System.out.println("\nJogo Adicionado !\n");

    }

}


