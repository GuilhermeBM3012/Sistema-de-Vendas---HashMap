package Application;

import Infrastructure.*;
import Service.*;

public class SistemaAplicacao {
    private ClienteServico clienteServico;
    private FornecedorServico fornecedorServico;
    private ProdutoServico produtoServico;
    private FuncionarioServico funcionarioServico;
    private EstoqueServico estoqueServico;
    private PedidoServico pedidoServico;
    private PagamentoServico pagamentoServico;
    private PedidosRepositorio pedidoRepositorio;


    public SistemaAplicacao() {
        ClienteRepositorio clienteRepositorio = new ClienteRepositorio();

        FornecedorRepositorio fornecedorRepositorio = new FornecedorRepositorio();

        ProdutosRepositorio produtoRepositorio = new ProdutosRepositorio();

        FuncionarioRepositorio funcionarioRepositorio = new FuncionarioRepositorio();

        PedidosRepositorio pedidoRepositorio = new PedidosRepositorio();


        clienteServico = new ClienteServico(clienteRepositorio);

        fornecedorServico = new FornecedorServico(fornecedorRepositorio);

        produtoServico = new ProdutoServico(produtoRepositorio);

        funcionarioServico = new FuncionarioServico(funcionarioRepositorio);

        estoqueServico = new EstoqueServico(produtoRepositorio);

        pedidoServico = new PedidoServico(pedidoRepositorio, clienteRepositorio, produtoRepositorio);

        pagamentoServico = new PagamentoServico(pedidoRepositorio);
    }
}
