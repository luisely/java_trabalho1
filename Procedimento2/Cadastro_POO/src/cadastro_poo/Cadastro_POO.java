
package cadastro_poo;
import java.io.IOException;
import java.util.Scanner;
import model.*;


public class Cadastro_POO {
   public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);
        PessoaFisicaRepo repoFisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoJuridica = new PessoaJuridicaRepo();
        String tipo,prefixoP, prefixoJ;
        int id;

        int opcao;
        do {
            System.out.println("===============================================");
            System.out.println("1 - Incluir");
            System.out.println("2 - Alterar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Buscar pelo ID");
            System.out.println("5 - Exibir todos");
            System.out.println("6 - Persistir Dados");
            System.out.println("7 - Recuperar dados");
            System.out.println("0 - Sair");
            System.out.println("===============================================");
            
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Escolha o tipo (F - Pessoa Física | J - Pessoa Jurídica):");
                    tipo = scanner.next().toLowerCase();
                    if ("f".equals(tipo)) {
                        System.out.println("Informe o nome:");
                        String nome = scanner.next();
                        System.out.println("Informe o CPF:");
                        String cpf = scanner.next();
                        System.out.println("Informe a idade:");
                        int idade = scanner.nextInt();
                        PessoaFisica pessoaFisica = new PessoaFisica(repoFisica.nextId(),nome, cpf, idade);
                        repoFisica.inserir(pessoaFisica);
                        System.out.println("Pessoa física incluída com sucesso.");

                    } else if ("j".equals(tipo)) {
                        System.out.println("Informe o nome:");
                        String nome = scanner.next();
                        System.out.println("Informe o CNPJ:");
                        String cnpj = scanner.next();
                        PessoaJuridica pessoaJuridica = new PessoaJuridica(repoJuridica.nextId(),nome, cnpj);
                        repoJuridica.inserir(pessoaJuridica);
                        System.out.println("Pessoa jurídica incluída com sucesso.");
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;
                case 2:
                    System.out.println("Escolha o tipo (F - Pessoa Física | J - Pessoa Jurídica):");
                    tipo = scanner.next().toLowerCase();
                    if ("f".equals(tipo)) {
                        System.out.println("Escolha o ID");
                        id = scanner.nextInt();
                        System.out.println("Informe o nome:");
                        String nome = scanner.next();
                        System.out.println("Informe o CPF:");
                        String cpf = scanner.next();
                        System.out.println("Informe a idade:");
                        int idade = scanner.nextInt();
                        PessoaFisica pessoaFisica = new PessoaFisica(id,nome, cpf, idade);
                        repoFisica.alterar(pessoaFisica);
                        System.out.println("Pessoa Fisica alterada com sucesso.");
                        
                        System.out.println("\nPressione Enter para mostrar o menu novamente...");
                        scanner.nextLine();
                        scanner.nextLine();
                    } else if ("j".equals(tipo)) {
                        System.out.println("Escolha o ID");
                        id = scanner.nextInt();
                        System.out.println("Informe o nome:");
                        String nome = scanner.next();
                        System.out.println("Informe o CNPJ:");
                        String cnpj = scanner.next();
                        PessoaJuridica pessoaJuridica = new PessoaJuridica(id,nome, cnpj);
                        repoJuridica.alterar(pessoaJuridica);
                        System.out.println("Pessoa Juridica alterada com sucesso.");
                        
                        System.out.println("\nPressione Enter para mostrar o menu novamente...");
                        scanner.nextLine();
                        scanner.nextLine();
                    } else {
                        System.out.println("Opção inválida.");
                    }

                    break;
                case 3:
                    System.out.println("Escolha o tipo (F - Pessoa Física, J - Pessoa Jurídica):");
                    tipo = scanner.next().toLowerCase();
                     if ("f".equals(tipo)) {
                         System.out.println("Digite o ID: ");
                         id = scanner.nextInt();
                         repoFisica.excluir(id);
                     }
                    break;
                case 4:
                    System.out.println("Escolha o ID");
                    id = scanner.nextInt();
                    repoFisica.obter(id).exibir();
                    
                    System.out.println("\nPressione Enter para mostrar o menu novamente...");
                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                case 5:
                    System.out.println("\nPESSOAS FISICAS...");
                    for (PessoaFisica pessoaF : repoFisica.obterTodos()) {
                        pessoaF.exibir();
                        System.out.println();
                    }
                    
                    System.out.println("\nPESSOAS JURIDICAS...");
                    for (PessoaJuridica pessoaJ : repoJuridica.obterTodos()) {
                        pessoaJ.exibir();
                        System.out.println();
                    }
                    
                    System.out.println("\nPressione Enter para mostrar o menu novamente...");
                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                case 6:
                    System.out.println("Escolha o nome para salvar os dados Pessoas Fisicos");
                    prefixoP = scanner.next().toLowerCase();
                    
                    System.out.println("Escolha o nome para salvar os dados Pessoas Juridicas");
                    prefixoJ = scanner.next().toLowerCase();
                    
                    try {
                        repoFisica.persistir(prefixoP + "_fisicas.bin");
                        repoJuridica.persistir(prefixoJ + "_juridicas.bin");
                        System.out.println("Dados salvos com sucesso!");

                    } catch (IOException e){
                        System.out.println(e);
                        break;
                    }
                    break;
                case 7:
                    
                    System.out.println("Escolha o nome para salvar os dados Pessoas Fisicos");
                    prefixoP = scanner.next().toLowerCase();
                    
                    System.out.println("Escolha o nome para salvar os dados Pessoas Juridicas");
                    prefixoJ = scanner.next().toLowerCase();
                    try {
                        repoFisica.recuperar(prefixoP + "_fisicas.bin");
                        repoJuridica.recuperar(prefixoJ + "_juridicas.bin");
                        System.out.println("Dados carregados com sucesso!");
                    } catch (IOException | ClassNotFoundException e){
                        System.out.println(e);
                        break;
                    }
                    break;
                case 0:
                    System.out.println("Finalizando execução...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
  
}