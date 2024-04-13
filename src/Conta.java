public class Conta {

    private Cliente dono = new Cliente();
    private double saldo = 0;
    private int numero = -1;
    private double limite = 0;
    private Operacao[] operacoes = new Operacao[1000];;
    private int numOperacoes = 0;
    private static int totalContas;

    public Conta() {
        Conta.totalContas++;
    }

    // Get totalContas
    public static int getTotalContas() {
        return Conta.totalContas;
    }

    // Get numOperacoes
    public int getNumOperacoes() {
        return this.numOperacoes;
    }


    // Set dono
    public void setDono(Cliente dono) {
        this.dono = dono;
    }


    // Get dono
    public Cliente getDono() {
        return this.dono;
    }


    // Set numero
    public void setNumero(int numero) {
        this.numero = numero;
    }


    // Get numero
    public int getNumero() {
        return this.numero;
    }


    // Get saldo
    public double getSaldo() {
        return this.saldo;
    }


    // Set limite
    public boolean setLimite(double limite) {
        if (limite < 0) {
            this.limite = 0;
            System.out.println("Limite inválido.");
            return false;
        } else {
            this.limite = limite;
            return true;
        }
    }


    // Get numero
    public double getLimite() {
        return this.limite;
    }


    public boolean depositar(double valor) {
        if (this.numOperacoes < 1000) {


            if (valor > 0.0) {
                this.operacoes[numOperacoes] = new Operacao('d', valor);
                this.numOperacoes++;


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


    public boolean sacar(double valor) {
        if (this.numOperacoes < 1000) {


            if (valor > 0.0 && valor <= this.saldo) {
                this.operacoes[numOperacoes] = new Operacao('s', valor);
                this.numOperacoes++;


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


    public boolean transferir(Conta contaDestino, double valor) {
        boolean saqueRealizado = this.sacar(valor);

        if (saqueRealizado) {
            boolean depositoRealizado = contaDestino.depositar(valor);
            return depositoRealizado;
        } else {
            return false;
        }
    }


    // Imprime os dados da conta
    public void imprimir() {
        System.out.println("Dono da conta: " + this.dono.nome);
        System.out.println("CPF: " + this.dono.cpf);
        System.out.println("Gênero " + this.dono.sexo);
        System.out.println("Idade: " + this.dono.idade);
        System.out.println("Endereço: " + this.dono.endereco);
        System.out.println("Número da conta: " + this.numero);
        System.out.println("Saldo atual: " + this.saldo);
        System.out.println("Limite: " + this.limite);
    }


    // Imprime o histórico
    public void extrato() {
        for (int i = 0; i < numOperacoes; i++) {
            System.out.println(operacoes[i].getData() + "  " + operacoes[i].getTipo() + "\t" + operacoes[i].getValor());
        }
    }
}
