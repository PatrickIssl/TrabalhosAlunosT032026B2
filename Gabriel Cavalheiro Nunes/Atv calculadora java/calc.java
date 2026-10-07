import java.util.Scanner;

public class calc{
public static void main(String[] args){
Scanner sc = new Scanner(System.in);

System.out.println("digite o primeiro numero: ");
int x = sc.nextInt();

System.out.println("qual o segundo numero : ");
int y = sc.nextInt();

System.out.println("qual operacao deseja fazer (- + * / ) ? ");
sc.nextLine();
String op = sc.nextLine();

int soma=0;

if("-".equals(op))
soma = x - y;

if("+".equals(op))
soma = x + y;

if("*".equals(op))
soma = x * y;

if("/".equals(op))
soma = x / y;

System.out.printf("o resultado e :%d", soma);
}
}







