
package cadastro_poo;
import java.io.IOException;
import model.*;

public class Cadastro_POO {
    public static void main(String[] args) {
        try {
            // Teste para pessoas físicas
            PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
            repo1.inserir(new PessoaFisica(1, "Beatriz", "401.239.240-90", 30));
            repo1.inserir(new PessoaFisica(2, "Maria", "466.057.990-54", 25));
            repo1.inserir(new PessoaFisica(3, "Fernando", "515.781.590-59", 35));

            // Persistência
            repo1.persistir("pessoas_fisicas.dat");
            System.out.println("Dados da pessoa Fisica Armazenados");

            // Recuperação
            PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
            repo2.recuperar("pessoas_fisicas.dat");
            System.out.println("Dados da pessoa Fisica Recuperados");

            // Exibição
            System.out.println("Pessoas Fisicas recuperadas:");
            for (PessoaFisica pessoa : repo2.obterTodos()) {
                pessoa.exibir();
                System.out.println();
            }

            // Teste para pessoas jurídicas
            PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
            repo3.inserir(new PessoaJuridica(1, "Vault-Tec", "28.337.692/0001-87"));
            repo3.inserir(new PessoaJuridica(2, "Umbrela Corp.", "01.682.970/0001-87"));

            // Persistência
            repo3.persistir("pessoas_juridicas.dat");

            // Recuperação
            PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
            repo4.recuperar("pessoas_juridicas.dat");

            // Exibição
            System.out.println("\nPessoas Juridicas recuperadas:");
            for (PessoaJuridica pessoa : repo4.obterTodos()) {
                pessoa.exibir();
                System.out.println();
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
