public class Cofrinho {
    private String dono;
    private double saldo;
    private double metaecon;

    public Cofrinho(String dono, double metaecon) {
        this.dono = dono;
        this.saldo = 0.0;
        this.metaecon = metaecon;
    }

    public void depositar(double valor) {
        if(valor > 0){
            this.saldo += valor;
            System.out.printf("Deposito de %.2f realizado com sucesso!%n", valor);
        } else {
            System.out.println("Valor deve ser positivo, tente novamente!");
        }
    }

    public void retirar(double valor) {
        if(valor <= 0){
            System.out.println("Valor deve ser positivo, tente novamente!");
        } else if(valor <= this.saldo){
            this.saldo -= valor;
            System.out.printf("Valor de %.2f retirado com sucesso!%n", valor);
        } else {
            System.out.printf("Saldo insuficiente para retirar R$ %.2f. Saldo atual R$ %.2f%n", valor, this.saldo);
        }
    }

    public void verificarmeta () {
        if (this.saldo >= this.metaecon){
            System.out.printf("Perfeito %s! A meta diaria de R$ %.2f foi atingida!%n", this.dono, this.metaecon);
        } else {
            double falta = this.metaecon - this.saldo;
            System.out.printf("A meta ainda não foi alcancada. Falta R$ %.2f para atingir R$ %.2f%n", falta,  this.metaecon);
        }
    }

    public void exibirsaldo () {
        System.out.printf("Saldo atual de %s equivale a R$ %.2f%n", this.dono, this.saldo);
    }

    public static void main(String[] args) {
        Cofrinho meucofrinho = new Cofrinho("Luan", 500.0);

        System.out.println("Estado inicial");
        meucofrinho.exibirsaldo();
        meucofrinho.verificarmeta();
        System.out.printf("%n");

        System.out.println("Realizando Depositos");
        meucofrinho.depositar(200.0);
        meucofrinho.depositar(100.0);
        meucofrinho.exibirsaldo();
        System.out.printf("%n");

        System.out.println("Tentativa invalida de saque!");
        meucofrinho.retirar(400.0);
        System.out.printf("%n");

        System.out.println("Verificar Meta!");
        meucofrinho.verificarmeta();
        System.out.printf("%n");

        System.out.println("Atingindo Meta!");
        meucofrinho.depositar(500.0);
        System.out.printf("%n");

        System.out.println("Verificacao final!");
        meucofrinho.verificarmeta();
    }
}
