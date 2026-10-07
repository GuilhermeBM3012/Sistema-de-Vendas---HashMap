package Presentation;

import Domain.*;
import Service.PagamentoServico;
import Service.PedidoServico;

import java.time.LocalDate;
import java.util.Scanner;

public class PagamentoMenu {
    private PagamentoServico pagamentoServico;
    private PedidoServico pedidoServico;
    private Scanner scanner;

    public PagamentoMenu(PagamentoServico pagamentoServico, PedidoServico pedidoServico, Scanner scanner) {
        this.pagamentoServico = pagamentoServico;
        this.pedidoServico = pedidoServico;
        this.scanner = scanner;
    }

    public void iniciar() {

        int opcao;

        do {
            System.out.println("===== MENU PAGAMENTOS =====");
            System.out.println("\n1 - Registrar pagamento");
            System.out.println("\n2 - Processar pagamento");
            System.out.println("\n3 - Consultar pagamento");
            System.out.println("\n4 - Verificar se foi processado");
            System.out.println("\n5 - Cancelar pagamento");
            System.out.println("\n0 - Voltar");

            System.out.print("\nEscolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            try {

                switch (opcao) {

                    case 1:
                        System.out.println("===== CADASTRAR PAGAMENTO =====");

                        System.out.print("\nDigite o ID do pedido: ");
                        int idPedido = scanner.nextInt();
                        scanner.nextLine();

                        Pedido pedido = pedidoServico.buscarPedidoPorId(idPedido);

                        double valor = pedido.calcularTotal();

                        System.out.println("\n===== RESUMO DO PEDIDO =====");
                        System.out.println(pedido);

                        System.out.println("\nValor a pagar: R$ " + valor);

                        System.out.println("===== FORMA DE PAGAMENTO =====");
                        System.out.println("\n1 - Pix");
                        System.out.println("\n2 - Cartão");
                        System.out.println("\n3 - Boleto");

                        System.out.print("\nEscolha uma opção: ");

                        int opcaoPagamento = scanner.nextInt();
                        scanner.nextLine();

                        Pagamento pagamento = null;

                        switch (opcaoPagamento) {

                            case 1:
                                System.out.println("===== PIX =====");

                                System.out.print("\nPercentual de desconto: ");
                                double descontoPix = scanner.nextDouble();
                                scanner.nextLine();

                                pagamento = new Pix(valor, LocalDate.now(), descontoPix);

                                break;

                            case 2:
                                System.out.println("===== CARTÃO =====");

                                System.out.print("\nQuantidade de parcelas: ");
                                int parcelas = scanner.nextInt();

                                System.out.print("Percentual de juros: ");
                                double juros = scanner.nextDouble();
                                scanner.nextLine();

                                pagamento = new Cartao(valor, LocalDate.now(), parcelas, juros);

                                break;

                            case 3:

                                System.out.println("===== BOLETO =====");

                                System.out.print("\nPercentual de desconto: ");
                                double descontoBoleto = scanner.nextDouble();

                                System.out.print("Percentual de multa: ");
                                double multa = scanner.nextDouble();
                                scanner.nextLine();

                                System.out.print("Data de vencimento (AAAA-MM-DD): ");
                                LocalDate vencimento = LocalDate.parse(scanner.nextLine());

                                pagamento = new Boleto(valor, LocalDate.now(), descontoBoleto, multa, vencimento);

                                break;

                            default:
                                System.out.println("Forma de pagamento inválida.");
                                break;
                        }

                        if (pagamento == null)
                            break;

                        pedidoServico.registrarPagamento(idPedido, pagamento);

                        System.out.println("\nPagamento cadastrado com sucesso!");

                        break;

                    case 2:
                        System.out.print("ID do pedido: ");
                        int idProcessar = scanner.nextInt();
                        scanner.nextLine();

                        pagamentoServico.processarPagamento(idProcessar);

                        System.out.println("Pagamento processado!");

                        break;

                    case 3:
                        System.out.print("ID do pedido: ");
                        int idConsultar = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println(pagamentoServico.consultarPagamento(idConsultar));

                        break;

                    case 4:
                        System.out.print("ID do pedido: ");
                        int idVerificar = scanner.nextInt();
                        scanner.nextLine();

                        boolean processado = pagamentoServico.pagamentoFoiProcessado(idVerificar);

                        System.out.println(processado ? "Pagamento processado." : "Pagamento não processado.");

                        break;

                    case 5:
                        System.out.print("ID do pedido: ");
                        int idCancelar = scanner.nextInt();
                        scanner.nextLine();

                        pagamentoServico.cancelarPagamento(idCancelar);

                        System.out.println("Pagamento cancelado!");

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
