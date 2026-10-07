package Service;

import Domain.Cliente;
import Domain.Endereco;
import Infrastructure.ClienteRepositorio;
import Exception.ClienteNaoEncontradoException;
import Exception.TelefoneInvalidoException;
import Exception.QtdPontosInvalidoException;
import Exception.EnderecoInvalidoException;

public class ClienteServico {
    private ClienteRepositorio clienteRepository;

    public ClienteServico(ClienteRepositorio clienteRepository){this.clienteRepository = clienteRepository;}

    public void cadastrarCliente(Cliente cliente) {
        if (cliente == null)
            throw new IllegalArgumentException("Cliente não pode ser nulo.");

        if (clienteRepository.exiteClientePorCPF(cliente.getCpf()))
            throw new IllegalArgumentException("Já existe um cliente cadastrado com esse cpf");

        clienteRepository.adicionarCliente(cliente);
    }

    public Cliente buscarClientePorId(int id) {
        Cliente cliente = clienteRepository.buscarClientePorID(id);

        if (cliente == null)
            throw new ClienteNaoEncontradoException("Cliente não encontrado.");

        return cliente;
    }

    public Cliente buscarClientePorCpf(String cpf) {
        Cliente cliente = clienteRepository.buscarClientePorCpf(cpf);

        if (cliente == null)
            throw new ClienteNaoEncontradoException("Cliente não encontrado.");

        return cliente;
    }

    public void removerCliente(int id) {
        clienteRepository.removerCliente(id);
    }

    public void alterarEndereco(int id, Endereco novoEndereco) {
        Cliente cliente = buscarClientePorId(id);

        if (novoEndereco == null)
            throw new EnderecoInvalidoException("O novo endereço não pode ser nulo.");

        cliente.setEndereco(novoEndereco);
    }

    public void alterarTelefone(int id, String novoTelefone) {
        Cliente cliente = buscarClientePorId(id);

        if (novoTelefone == null || novoTelefone.isBlank())
            throw new TelefoneInvalidoException("Telefone inválido.");

        cliente.setTelefone(novoTelefone);
    }

    public void adicionarPontosFidelidade(int id, int pontos) {
        Cliente cliente = buscarClientePorId(id);

        if (pontos <= 0)
            throw new QtdPontosInvalidoException("A quantidade de pontos deve ser maior que zero.");

        cliente.setPontosFidelidade(cliente.getPontosFidelidade() + pontos);
    }

    public void listarTodosClientes() {
        clienteRepository.listarTodos();
    }
}
