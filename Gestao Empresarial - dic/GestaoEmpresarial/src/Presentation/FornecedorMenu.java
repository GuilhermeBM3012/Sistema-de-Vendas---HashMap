package Presentation;

import Domain.Endereco;
import Domain.Fornecedor;
import Service.FornecedorServico;

import java.util.Scanner;

public class FornecedorMenu {
    private FornecedorServico fornecedorServico;
    private Scanner scanner;

    public FornecedorMenu(FornecedorServico fornecedorServico, Scanner scanner) {
        this.fornecedorServico = fornecedorServico;
        this.scanner = scanner;
    }

    public void iniciar() {

        int opcao;

        do {
            System.out.println("===== MENU FORNECEDORES =====");
            System.out.println("\n1 - Cadastrar fornecedor");
            System.out.println("\n2 - Buscar fornecedor por ID");
            System.out.println("\n3 - Remover fornecedor");
            System.out.println("\n4 - Listar fornecedores");
            System.out.println("\n0 - Voltar");

            System.out.print("\nEscolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            try {

                switch (opcao) {

                    case 1:
                        System.out.println("===== CADASTRO DE FORNECEDOR =====\n");

                        System.out.print("Nome da empresa: ");
                        String nomeEmpresa = scanner.nextLine();

                        System.out.print("CNPJ: ");
                        String cnpj = scanner.nextLine();

                        System.out.print("Telefone: ");
                        String telefone = scanner.nextLine();

                        System.out.print("E-mail: ");
                        String email = scanner.nextLine();

                        System.out.println("\n===== ENDEREÇO =====");

                        System.out.print("Rua: ");
                        String rua = scanner.nextLine();

                        System.out.print("Número: ");
                        int numeroRua = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Complemento: ");
                        String complemento = scanner.nextLine();

                        System.out.print("Bairro: ");
                        String bairro = scanner.nextLine();

                        System.out.print("Cidade: ");
                        String cidade = scanner.nextLine();

                        System.out.print("Estado: ");
                        String estado = scanner.nextLine();

                        System.out.print("CEP: ");
                        String cep = scanner.nextLine();

                        Endereco endereco = new Endereco(rua, numeroRua, complemento, bairro, cidade,
                                estado, cep);

                        Fornecedor fornecedor = new Fornecedor(nomeEmpresa, cnpj, telefone, email, endereco);

                        fornecedorServico.cadastrarFornecedor(fornecedor);

                        System.out.println("\nFornecedor cadastrado com sucesso!");

                        break;

                    case 2:
                        System.out.print("Digite o ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println(fornecedorServico.buscarFornecedorPorId(id));

                        break;

                    case 3:
                        System.out.print("Digite o ID: ");
                        int idRemover = scanner.nextInt();
                        scanner.nextLine();

                        fornecedorServico.removerFornecedor(idRemover);

                        System.out.println("Fornecedor removido!");

                        break;

                    case 4:
                        fornecedorServico.listarTodosFornecedores();

                        break;

                    case 0:

                        break;

                    default:
                        System.out.println("Opção inválida.");
                }

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }

        } while (opcao != 0);
    }
}
