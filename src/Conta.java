
public class Conta {

    Cliente dono = new Cliente();
    double saldo;
    int numero;
    double limite;
    String agencia;

    Operacao[] operacoes = new Operacao[1000];

    int numOperacoes = 0;

    boolean depositar(double valor) {
        if (this.numOperacoes < 1000) {

            this.operacoes[numOperacoes] = new Operacao('d', valor);
            this.numOperacoes++;

            if (valor > 0.0) {
                this.saldo += valor;
                return true;
            } else {
                return false;
            }
        } else {
            System.out.println("Numero máximo de operações atingido.");
            return false;
        }
    }


    boolean sacar(double valor) {
        if (this.numOperacoes < 1000) {

            this.operacoes[numOperacoes] = new Operacao('s', valor);
            this.numOperacoes++;

            if (valor > 0.0 && valor <= this.saldo) {
                this.saldo -= valor;
                return true;
            } else {
                return false;
            }
        } else {
            System.out.println("Numero máximo de operações atingido.");
            return false;
        }
    }


    boolean transferir(Conta contaDestino, double valor) {
        boolean saqueRealizado = this.sacar(valor);

        if(saqueRealizado) {
            boolean depositoRealizado = contaDestino.depositar(valor);
            return depositoRealizado;
        } else {
            return false;
        }
    }

    void imprimir() {
        System.out.println("Dono da conta: " + this.dono.nome);
        System.out.println("CPF: " + this.dono.cpf);
        System.out.println("Endereço: " + this.dono.endereco);
        System.out.println("Idade: " + this.dono.idade);
        System.out.println("Gênero " + this.dono.sexo);
        System.out.println("Número da conta: " + this.numero);
        System.out.println("Saldo atual: " + this.saldo);
        System.out.println("Limite: " + this.limite);
    }

    void extrato() {
        for(int i = 0; i < numOperacoes; i++) {
            System.out.println(operacoes[i].data+ "  " +operacoes[i].tipo+ "\t" +operacoes[i].valor);
        }
    }
}
