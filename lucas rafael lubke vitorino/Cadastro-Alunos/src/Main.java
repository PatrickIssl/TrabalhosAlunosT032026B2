import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // lista que guarda os alunos
    static ArrayList<Aluno> alunos = new ArrayList<Aluno>();

    // scanner para ler o que o usuário digita
    static Scanner scanner = new Scanner(System.in);

    static int proximoId = 1;

    public static void main(String[] args) {
        int opcao = -1;

        // o menu repete até digitar 0
        while (opcao != 0) {
            System.out.println();
            System.out.println("========== SISTEMA DE GERENCIAMENTO ==========");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar todos");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Atualizar");
            System.out.println("5 - Excluir");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                cadastrar();
            } else if (opcao == 2) {
                listar();
            } else if (opcao == 3) {
                buscarPorId();
            } else if (opcao == 4) {
                atualizar();
            } else if (opcao == 5) {
                excluir();
            } else if (opcao == 0) {
                System.out.println("Encerrando o programa.");
            } else {
                System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    // cadastrar um aluno novo
    public static void cadastrar() {
        System.out.print("Nome do aluno: ");
        String nome = scanner.nextLine();

        System.out.print("Nota do aluno: ");
        double nota = scanner.nextDouble();

        // cria o objeto aluno
        Aluno novo = new Aluno(proximoId, nome, nota);

        // guarda na lista
        alunos.add(novo);

        // soma 1 para o próximo aluno ter outro id
        proximoId = proximoId + 1;

        System.out.println("Aluno cadastrado! ID: " + novo.getId());
    }

    // mostrar todos os alunos
    public static void listar() {
        if (alunos.size() == 0) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            System.out.println("--- Lista de alunos ---");
            for (int i = 0; i < alunos.size(); i++) {
                mostrarAluno(alunos.get(i));
            }
        }
    }

    // buscar um aluno pelo id
    public static void buscarPorId() {
        System.out.print("Digite o ID: ");
        int id = scanner.nextInt();

        Aluno a = buscarAluno(id);

        if (a == null) {
            System.out.println("ID não encontrado.");
        } else {
            mostrarAluno(a);
        }
    }

    // atualizar nome e nota de um aluno
    public static void atualizar() {
        if (alunos.size() == 0) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            System.out.print("Digite o ID do aluno: ");
            int id = scanner.nextInt();

            Aluno a = buscarAluno(id);

            if (a == null) {
                System.out.println("ID não encontrado.");
            } else {
                System.out.print("Novo nome: ");
                a.setNome(scanner.next());

                System.out.print("Nova nota: ");
                a.setNota(scanner.nextDouble());

                System.out.println("Aluno atualizado!");
            }
        }
    }

    // excluir um aluno
    public static void excluir() {
        if (alunos.size() == 0) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            System.out.print("Digite o ID do aluno: ");
            int id = scanner.nextInt();

            Aluno a = buscarAluno(id);

            if (a == null) {
                System.out.println("ID não encontrado.");
            } else {
                alunos.remove(a);
                System.out.println("Aluno excluído!");
            }
        }
    }

    // procura o aluno na lista pelo id
    // se achar, devolve o aluno; se não achar, devolve null
    public static Aluno buscarAluno(int id) {
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getId() == id) {
                return alunos.get(i);
            }
        }
        return null;
    }

    // mostra os dados do aluno na tela
    public static void mostrarAluno(Aluno a) {
        System.out.println("ID: " + a.getId() + " | Nome: " + a.getNome() + " | Nota: " + a.getNota());
    }
}