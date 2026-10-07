package Presentation;

import Service.EstoqueServico;

import java.util.Scanner;

public class EstoqueMenu {
    private EstoqueServico estoqueServico;
    private Scanner scanner;

    public EstoqueMenu(EstoqueServico estoqueServico, Scanner scanner) {
        this.estoqueServico = estoqueServico;
        this.scanner = scanner;
    }

    public void iniciar() {

        int opcao;

        do {
            System.out.println("===== MENU ESTOQUE =====");
            System.out.println("\n1 - Adicionar quantidade");
            System.out.println("\n2 - Remover quantidade");
            System.out.println("\n3 - Atualizar quantidade");
            System.out.println("\n4 - Consultar quantidade");
            System.out.println("\n5 - Verificar disponibilidade");
            System.out.println("\n6 - Listar produtos");
            System.out.println("\n7 - Produtos com estoque baixo");
            System.out.println("\n8 - Quantidade total em estoque");
            System.out.println("\n0 - Voltar");

            System.out.print("\nEscolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            try {

                switch (opcao) {

                    case 1:
                        System.out.print("ID do produto: ");
                        int idAdicionar = scanner.nextInt();

                        System.out.print("Quantidade: ");
                        int quantidadeAdicionar = scanner.nextInt();
                        scanner.nextLine();

                        estoqueServico.adicionarProduto(idAdicionar, quantidadeAdicionar);

                        System.out.println("Quantidade adicionada!");

                        break;

                    case 2:
                        System.out.print("ID do produto: ");
                        int idRemover = scanner.nextInt();

                        System.out.print("Quantidade: ");
                        int quantidadeRemover = scanner.nextInt();
                        scanner.nextLine();

                        estoqueServico.removerProduto(idRemover, quantidadeRemover);

                        System.out.println("Quantidade removida!");

                        break;

                    case 3:
                        System.out.print("ID do produto: ");
                        int idAtualizar = scanner.nextInt();

                        System.out.print("Nova quantidade: ");
                        int novaQuantidade = scanner.nextInt();
                        scanner.nextLine();

                        estoqueServico.atualizarQuantidade(idAtualizar, novaQuantidade);

                        System.out.println("Estoque atualizado!");

                        break;

                    case 4:
                        System.out.print("ID do produto: ");
                        int idConsultar = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Quantidade: " + estoqueServico.consultarQuantidade(idConsultar));

                        break;

                    case 5:
                        System.out.print("ID do produto: ");
                        int idDisponibilidade = scanner.nextInt();

                        System.out.print("Quantidade desejada: ");
                        int quantidade = scanner.nextInt();
                        scanner.nextLine();

                        boolean disponivel = estoqueServico.verificarDisponibilidade(idDisponibilidade, quantidade);

                        System.out.println(disponivel ? "Produto disponível." : "Estoque insuficiente.");

                        break;

                    case 6:
                        System.out.println(estoqueServico.listarProdutosEmEstoque());

                        break;

                    case 7:
                        System.out.print("Limite de estoque: ");
                        int limite = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println(estoqueServico.listarProdutosEstoqueBaixo(limite));

                        break;

                    case 8:
                        System.out.println("Quantidade total: " + estoqueServico.calcularQuantidadeTotalEstoque());

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
