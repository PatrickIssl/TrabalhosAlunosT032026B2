package aulaquatro;

import java.util.Random;
import java.util.Scanner;

public class Principal {

   static Scanner scan = new Scanner(System.in);
   
   public static void main(String[] args) {
       exercicioUm();
       
       scan.close();
   }
   
   //Jogo de Adivinhação Escreva um programa em que o usuário tenta adivinhar um número entre 1 e 10.
   //O programa deve gerar um número aleatório e dar pistas ao usuário indicando se ele precisa chutar mais
   //alto ou mais baixo.
   public static void exercicioUm() {
       Random random = new Random();
       int numeroAleatorio = random.nextInt(11);
       boolean acertou = false;
       while (!acertou) {
           System.out.println("Chute um valor: ");
           int numero = scan.nextInt();
           scan.nextLine();
           if(numero < numeroAleatorio) {
               System.out.println("Chute mais alto! ");
           }else if(numero > numeroAleatorio) {
               System.out.println("Chute mais baixo! ");
           }else {
               System.out.println("GOL!");
               acertou = true;
           }
       }
   }
   
   public static void exercicioDois() {
       
   }

}
