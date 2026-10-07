package Presentation;

import Service.*;

import java.util.Scanner;

public class MenuPrincipal {
    private ClienteServico clienteServico;
    private FornecedorServico fornecedorServico;
    private ProdutoServico produtoServico;
    private FuncionarioServico funcionarioServico;
    private EstoqueServico estoqueServico;
    private PedidoServico pedidoServico;
    private PagamentoServico pagamentoServico;

    private Scanner scanner;


    public MenuPrincipal(ClienteServico clienteServico, FornecedorServico fornecedorServico,
                         ProdutoServico produtoServico, FuncionarioServico funcionarioServico,
                         EstoqueServico estoqueServico, PedidoServico pedidoServico,
                         PagamentoServico pagamentoServico) {

        this.clienteServico = clienteServico;
        this.fornecedorServico = fornecedorServico;
        this.produtoServico = produtoServico;
        this.funcionarioServico = funcionarioServico;
        this.estoqueServico = estoqueServico;
        this.pedidoServico = pedidoServico;
        this.pagamentoServico = pagamentoServico;

        this.scanner = new Scanner(System.in);
    }


    public void iniciar() {

        int opcao;

        do {
            System.out.println("===============================\n");
            System.out.println("        SISTEMA DE VENDAS      \n");
            System.out.println("===============================");
            System.out.println("\n1 - Clientes");
            System.out.println("\n2 - Fornecedores");
            System.out.println("\n3 - Produtos");
            System.out.println("\n4 - Funcionários");
            System.out.println("\n5 - Estoque");
            System.out.println("\n6 - Pedidos");
            System.out.println("\n7 - Pagamentos");
            System.out.println("\n0 - Sair");
            System.out.println("================================\n");

            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    abrirMenuClientes();
                    break;

                case 2:
                    abrirMenuFornecedores();
                    break;

                case 3:
                    abrirMenuProdutos();
                    break;

                case 4:
                    abrirMenuFuncionarios();
                    break;

                case 5:
                    abrirMenuEstoque();
                    break;

                case 6:
                    abrirMenuPedidos();
                    break;

                case 7:
                    abrirMenuPagamentos();
                    break;

                case 0:
                    System.out.println("\nSistema encerrado.");
                    break;

                default:
                    System.out.println("\nOpção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }

    private void abrirMenuClientes() {ClienteMenu menu = new ClienteMenu(clienteServico, scanner);
        menu.iniciar();
    }

    private void abrirMenuFornecedores() {
        FornecedorMenu menu = new FornecedorMenu(fornecedorServico, scanner);
        menu.iniciar();
    }

    private void abrirMenuProdutos() {
        ProdutoMenu menu = new ProdutoMenu(produtoServico, fornecedorServico, scanner);
        menu.iniciar();
    }

    private void abrirMenuFuncionarios() {
        FuncionarioMenu menu = new FuncionarioMenu(funcionarioServico, scanner);
        menu.iniciar();
    }

    private void abrirMenuEstoque() {
        EstoqueMenu menu = new EstoqueMenu(estoqueServico, scanner);
        menu.iniciar();
    }

    private void abrirMenuPedidos() {
        PedidoMenu menu = new PedidoMenu(pedidoServico, scanner);
        menu.iniciar();
    }

    private void abrirMenuPagamentos() {
        PagamentoMenu menu = new PagamentoMenu(pagamentoServico, pedidoServico, scanner);
        menu.iniciar();
    }
}
