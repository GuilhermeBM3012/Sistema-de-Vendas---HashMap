package Presentation;

import Domain.*;
import Service.ClienteServico;
import Service.FornecedorServico;
import Service.ProdutoServico;

import java.time.LocalDate;
import java.util.Scanner;

public class ProdutoMenu {
    private ProdutoServico produtoServico;
    private FornecedorServico fornecedorServico;
    private Scanner scanner;

    public ProdutoMenu(ProdutoServico produtoServico, FornecedorServico fornecedorServico, Scanner scanner) {

        this.produtoServico = produtoServico;
        this.fornecedorServico = fornecedorServico;
        this.scanner = scanner;
    }

    public void iniciar() {

        int opcao;

        do {
            System.out.println("===== MENU PRODUTOS =====");
            System.out.println("\n1 - Cadastrar produto");
            System.out.println("\n2 - Buscar produto por ID");
            System.out.println("\n3 - Atualizar preço");
            System.out.println("\n4 - Remover produto");
            System.out.println("\n5 - Listar produtos");
            System.out.println("\n6 - Buscar por faixa de preço");
            System.out.println("\n0 - Voltar");

            System.out.print("\nEscolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            try {

                switch (opcao) {

                    case 1:
                        System.out.println("\n===== CADASTRO DE PRODUTO =====");

                        System.out.print("Nome do produto: ");
                        String nome = scanner.nextLine();

                        System.out.print("Descrição: ");
                        String descricao = scanner.nextLine();

                        System.out.print("Preço: ");
                        double preco = scanner.nextDouble();

                        System.out.print("Quantidade em estoque: ");
                        int quantidadeEstoque = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("\n===== FORNECEDOR =====");

                        System.out.print("Digite o ID do fornecedor: ");
                        int idFornecedor = scanner.nextInt();
                        scanner.nextLine();

                        Fornecedor fornecedor = fornecedorServico.buscarFornecedorPorId(idFornecedor);

                        System.out.println("===== CATEGORIA =====");
                        System.out.println("\n1 - Eletrônico");
                        System.out.println("\n2 - Roupa");
                        System.out.println("\n3 - Alimento");

                        System.out.print("\nEscolha a categoria: ");

                        int opcaoCategoria = scanner.nextInt();
                        scanner.nextLine();

                        Produto produto = null;

                        switch (opcaoCategoria) {

                            case 1:
                                System.out.println("\n===== DADOS DO ELETRÔNICO =====");

                                System.out.print("Marca: ");
                                String marca = scanner.nextLine();

                                System.out.print("Modelo: ");
                                String modelo = scanner.nextLine();

                                System.out.print("Garantia (meses): ");
                                int garantiaMeses = scanner.nextInt();

                                System.out.print("Voltagem: ");
                                int voltagem = scanner.nextInt();
                                scanner.nextLine();

                                produto = new Eletronico(nome, descricao, preco, quantidadeEstoque,
                                        fornecedor, CategoriaProduto.ELETRONICO, marca, modelo, garantiaMeses, voltagem);

                                break;

                            case 2:
                                System.out.println("\n===== DADOS DA ROUPA =====");

                                System.out.print("Tamanho: ");
                                String tamanho = scanner.nextLine();

                                System.out.print("Cor: ");
                                String cor = scanner.nextLine();

                                System.out.print("Material: ");
                                String material = scanner.nextLine();

                                produto = new Roupa(nome, descricao, preco, quantidadeEstoque, fornecedor,
                                        CategoriaProduto.ROUPA, tamanho, cor, material);

                                break;

                            case 3:
                                System.out.println("\n===== DADOS DO ALIMENTO =====");

                                System.out.print("Data de validade (AAAA-MM-DD): ");
                                LocalDate validade = LocalDate.parse(scanner.nextLine());

                                System.out.print("Peso por unidade (kg): ");
                                double peso = scanner.nextDouble();
                                scanner.nextLine();

                                produto = new Alimento(nome, descricao, preco, quantidadeEstoque, fornecedor,
                                        CategoriaProduto.ALIMENTO, validade, peso);

                                break;

                            default:
                                System.out.println("Categoria inválida.");
                                break;
                        }

                        if (produto != null) {
                            produtoServico.cadastrarProduto(produto);

                            System.out.println("\nProduto cadastrado com sucesso!");
                        }

                        break;

                    case 2:
                        System.out.print("Digite o ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println(produtoServico.buscarProdutoPorId(id));

                        break;

                    case 3:
                        System.out.print("ID do produto: ");
                        int idPreco = scanner.nextInt();

                        System.out.print("Novo preço: ");
                        double novoPreco = scanner.nextDouble();
                        scanner.nextLine();

                        produtoServico.atualizarPreco(idPreco, novoPreco);

                        System.out.println("Preço atualizado!");

                        break;

                    case 4:
                        System.out.print("ID do produto: ");
                        int idRemover = scanner.nextInt();
                        scanner.nextLine();

                        produtoServico.removerProduto(idRemover);

                        System.out.println("Produto removido!");
                        break;

                    case 5:
                        produtoServico.listarTodosProdutos();
                        break;

                    case 6:
                        System.out.print("Preço mínimo: ");
                        double minimo = scanner.nextDouble();

                        System.out.print("Preço máximo: ");
                        double maximo = scanner.nextDouble();
                        scanner.nextLine();

                        System.out.println(produtoServico.buscarProdutosPorFaixaDePreco(minimo, maximo));
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
