package Presentation;

import Domain.Cliente;
import Domain.Endereco;
import Service.ClienteServico;

import java.util.Scanner;

public class ClienteMenu {
    private ClienteServico clienteServico;
    private Scanner scanner;

    public ClienteMenu(ClienteServico clienteServico, Scanner scanner) {
        this.clienteServico = clienteServico;
        this.scanner = scanner;
    }

    public void iniciar() {
        int opcao;

        do {
            System.out.println("===== MENU CLIENTES =====");
            System.out.println("\n1 - Cadastrar cliente");
            System.out.println("\n2 - Buscar cliente por ID");
            System.out.println("\n3 - Alterar endereço");
            System.out.println("\n4 - Alterar telefone");
            System.out.println("\n5 - Remover cliente");
            System.out.println("\n6 - Listar clientes");
            System.out.println("\n0 - Voltar");

            System.out.print("\nEscolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            try {

                switch (opcao) {

                    case 1:
                        System.out.println("===== CADASTRO DE CLIENTE =====\n");

                        System.out.print("Nome completo: ");
                        String nome = scanner.nextLine();

                        System.out.print("CPF: ");
                        String cpf = scanner.nextLine();

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

                        System.out.print("Limite de crédito: ");
                        double limiteCredito = scanner.nextDouble();
                        scanner.nextLine();

                        Cliente cliente = new Cliente(nome, cpf, telefone, email, endereco, limiteCredito);

                        clienteServico.cadastrarCliente(cliente);

                        System.out.println("\nCliente cadastrado com sucesso!");

                        break;

                    case 2:
                        System.out.print("Digite o ID: ");
                        int idBusca = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println(clienteServico.buscarClientePorId(idBusca));

                        break;

                    case 3:
                        System.out.println("\n===== ALTERAR ENDEREÇO =====");

                        System.out.print("Digite o ID do cliente: ");
                        int idEndereco = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("\n===== NOVO ENDEREÇO =====");

                        System.out.print("Rua: ");
                        String novaRua = scanner.nextLine();

                        System.out.print("Número: ");
                        int novoNumeroRua = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Complemento: ");
                        String novoComplemento = scanner.nextLine();

                        System.out.print("Bairro: ");
                        String novoBairro = scanner.nextLine();

                        System.out.print("Cidade: ");
                        String novaCidade = scanner.nextLine();

                        System.out.print("Estado: ");
                        String novoEstado = scanner.nextLine();

                        System.out.print("CEP: ");
                        String novoCep = scanner.nextLine();

                        Endereco novoEndereco = new Endereco(novaRua, novoNumeroRua, novoComplemento,
                                novoBairro, novaCidade, novoEstado, novoCep);

                        clienteServico.alterarEndereco(idEndereco, novoEndereco);

                        System.out.println("\nEndereço alterado com sucesso!");

                        break;

                    case 4:
                        System.out.print("Digite o ID: ");
                        int idTelefone = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Novo telefone: ");
                        String tel = scanner.nextLine();

                        clienteServico.alterarTelefone(idTelefone, tel);

                        System.out.println("Telefone alterado!");

                        break;

                    case 5:
                        System.out.print("Digite o ID: ");
                        int idRemover = scanner.nextInt();
                        scanner.nextLine();

                        clienteServico.removerCliente(idRemover);

                        System.out.println("Cliente removido!");

                        break;

                    case 6:
                        clienteServico.listarTodosClientes();

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
