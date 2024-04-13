public class Main {
    public static void main(String[] args) {

        Conta[] contas = new Conta[2];
        Cliente dono = new Cliente();
        contas[0] = new Conta();

        dono.nome = "Ana";
        dono.idade = 16;
        dono.sexo = 'f';
        dono.cpf = 12345678;
        dono.endereco = "Minha casa";

        contas[0].setDono(dono);
        contas[0].setNumero(87654321);
        contas[0].setLimite(5000);

        contas[0].depositar(2000);
        contas[0].depositar(2000);

        // Imprime a média de operações realizadas em relação ao número de contas
        System.out.println("Média de operações realizadas em relação ao número de contas: " + (Operacao.getTotalOperacoes()/Conta.getTotalContas()));

    }
}
