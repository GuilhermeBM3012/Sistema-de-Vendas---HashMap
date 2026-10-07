package Presentation;

import Domain.Pedido;
import Service.PedidoServico;

import java.util.Scanner;

public class PedidoMenu {
    private PedidoServico pedidoServico;
    private Scanner scanner;

    public PedidoMenu(
            PedidoServico pedidoServico,
            Scanner scanner) {

        this.pedidoServico = pedidoServico;
        this.scanner = scanner;
    }

    public void iniciar() {

        int opcao;

        do {
            System.out.println("===== MENU PEDIDOS =====");
            System.out.println("\n1 - Criar pedido");
            System.out.println("\n2 - Buscar pedido por ID");
            System.out.println("\n3 - Adicionar produto");
            System.out.println("\n4 - Remover produto");
            System.out.println("\n5 - Alterar quantidade");
            System.out.println("\n6 - Aprovar pedido");
            System.out.println("\n7 - Cancelar pedido");
            System.out.println("\n8 - Finalizar pedido");
            System.out.println("\n9 - Calcular total");
            System.out.println("\n10 - Listar pedidos");
            System.out.println("\n0 - Voltar");

            System.out.print("\nEscolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            try {

                switch (opcao) {

                    case 1:
                        System.out.println("\n===== CRIAR PEDIDO =====");

                        System.out.print("Digite o ID do cliente: ");
                        int idCliente = scanner.nextInt();
                        scanner.nextLine();

                        Pedido pedido = pedidoServico.criarPedido(idCliente);

                        System.out.println("\nPedido criado com sucesso!");
                        System.out.println("ID do pedido: " + pedido.getId());

                        int continuar;

                        do {

                            System.out.println("\n===== ADICIONAR PRODUTO =====");

                            System.out.print("Digite o ID do produto: ");
                            int idProduto = scanner.nextInt();

                            System.out.print("Digite a quantidade: ");
                            int quantidade = scanner.nextInt();
                            scanner.nextLine();

                            pedidoServico.adicionarProduto(pedido.getId(), idProduto, quantidade);
                            System.out.println("Produto adicionado com sucesso!");

                            System.out.println("\n===== RESUMO DO PEDIDO =====");
                            System.out.println(pedidoServico.buscarPedidoPorId(pedido.getId()));

                            System.out.print("Deseja adicionar outro produto? (1 - Sim / 0 - Não): ");

                            continuar = scanner.nextInt();
                            scanner.nextLine();

                        } while (continuar == 1);

                        System.out.println("\n===== PEDIDO FINALIZADO =====");

                        Pedido pedidoFinal = pedidoServico.buscarPedidoPorId(pedido.getId());

                        System.out.println(pedidoFinal);

                        break;

                    case 2:
                        System.out.print("ID do pedido: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println(pedidoServico.buscarPedidoPorId(id));

                        break;

                    case 3:
                        System.out.println("Adicionar produto");

                        break;

                    case 4:
                        System.out.println("Remover produto");

                        break;

                    case 5:
                        System.out.println("Alterar quantidade");

                        break;

                    case 6:
                        System.out.print("ID do pedido: ");
                        int idAprovar = scanner.nextInt();
                        scanner.nextLine();

                        pedidoServico.aprovarPedido(idAprovar);

                        System.out.println("Pedido aprovado!");

                        break;

                    case 7:
                        System.out.print("ID do pedido: ");
                        int idCancelar = scanner.nextInt();
                        scanner.nextLine();

                        pedidoServico.cancelarPedido(idCancelar);

                        System.out.println("Pedido cancelado!");

                        break;

                    case 8:
                        System.out.print("ID do pedido: ");
                        int idFinalizar = scanner.nextInt();
                        scanner.nextLine();

                        pedidoServico.finalizarPedido(idFinalizar);

                        System.out.println("Pedido finalizado!");

                        break;

                    case 9:
                        System.out.print("ID do pedido: ");
                        int idTotal = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Total: R$ " + pedidoServico.calcularTotalPedido(idTotal));

                        break;

                    case 10:
                        System.out.println(pedidoServico.listarTodosPedidos());

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
