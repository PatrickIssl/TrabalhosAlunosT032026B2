import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        System.out.print("Digite o primeiro valor: ");
        double n1 = leitor.nextDouble();
        
        System.out.print("Digite o segundo valor: ");
        double n2 = leitor.nextDouble();
        
        System.out.println("");
        System.out.println("Menu da Calculadora");
        System.out.println("1 = Somar");
        System.out.println("2 = Subtrair");
        System.out.println("3 = Multiplicar");
        System.out.println("4 = Dividir");
        System.out.print("Escolha a operacao (1 a 4): ");
        int op = leitor.nextInt();
        
        double resultado = 0;
        
        System.out.println(""); // pular linha
        
        if (op == 1) {
            resultado = n1 + n2;
            System.out.println("Resultado da soma: " + resultado);
        } 
        else if (op == 2) {
            resultado = n1 - n2;
            System.out.println("Resultado da subtracao: " + resultado);
        } 
        else if (op == 3) {
            resultado = n1 * n2;
            System.out.println("Resultado da multiplicacao: " + resultado);
        } 
        else if (op == 4) {
            if (n2 == 0) {
                System.out.println("Erro: nao existe divisao por zero.");
            } else {
                resultado = n1 / n2;
                System.out.println("Resultado da divisao: " + resultado);
            }
        } 
        else {
            System.out.println("Opcao invalida. Digite um numero de 1 a 4.");
        }
        
        leitor.close();
    }
}