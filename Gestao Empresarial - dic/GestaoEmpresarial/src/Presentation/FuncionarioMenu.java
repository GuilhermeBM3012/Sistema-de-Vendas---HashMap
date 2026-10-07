package Presentation;

import Service.FuncionarioServico;

import java.util.Scanner;

public class FuncionarioMenu {
    private FuncionarioServico funcionarioServico;
    private Scanner scanner;

    public FuncionarioMenu(FuncionarioServico funcionarioServico, Scanner scanner) {
        this.funcionarioServico = funcionarioServico;
        this.scanner = scanner;
    }

    public void iniciar() {

        int opcao;

        do {
            System.out.println("===== MENU FUNCIONÁRIOS =====");
            System.out.println("\n1 - Cadastrar funcionário");
            System.out.println("\n2 - Buscar funcionário por ID");
            System.out.println("\n3 - Buscar por matrícula");
            System.out.println("\n4 - Alterar salário");
            System.out.println("\n5 - Dar aumento");
            System.out.println("\n6 - Calcular salário");
            System.out.println("\n7 - Calcular folha salarial");
            System.out.println("\n8 - Remover funcionário");
            System.out.println("\n9 - Listar funcionários");
            System.out.println("\n0 - Voltar");

            System.out.print("\nEscolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            try {

                switch (opcao) {

                    case 1:
                        System.out.println("Cadastro de funcionário");
                        break;

                    case 2:
                        System.out.print("Digite o ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println(funcionarioServico.buscarFuncionarioPorId(id));

                        break;

                    case 3:
                        System.out.print("Digite a matrícula: ");
                        String matricula = scanner.nextLine();

                        System.out.println(funcionarioServico.buscarFuncionarioPorMatricula(matricula));

                        break;

                    case 4:
                        System.out.print("ID do funcionário: ");
                        int idSalario = scanner.nextInt();

                        System.out.print("Novo salário: ");
                        double salario = scanner.nextDouble();
                        scanner.nextLine();

                        funcionarioServico.alterarSalario(idSalario, salario);

                        System.out.println("Salário alterado!");

                        break;

                    case 5:
                        System.out.print("ID do funcionário: ");
                        int idAumento = scanner.nextInt();

                        System.out.print("Percentual de aumento: ");
                        double percentual = scanner.nextDouble();
                        scanner.nextLine();

                        funcionarioServico.darAumento(idAumento, percentual);

                        System.out.println("Aumento aplicado!");

                        break;

                    case 6:
                        System.out.print("ID do funcionário: ");
                        int idCalculo = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Salário: R$ " + funcionarioServico.calcularSalarioFuncionario(idCalculo));

                        break;

                    case 7:
                        System.out.println("Folha salarial: R$ " + funcionarioServico.calcularFolhaSalarial());

                        break;

                    case 8:
                        System.out.print("ID do funcionário: ");
                        int idRemover = scanner.nextInt();
                        scanner.nextLine();

                        funcionarioServico.removerFuncionario(idRemover);

                        System.out.println("Funcionário removido!");

                        break;

                    case 9:
                        System.out.println(funcionarioServico.listarTodosFuncionarios());

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
