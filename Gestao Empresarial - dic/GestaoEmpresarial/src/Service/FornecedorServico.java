package Service;

import Domain.Endereco;
import Domain.Fornecedor;
import Infrastructure.FornecedorRepositorio;
import Exception.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FornecedorServico {
    private FornecedorRepositorio fornecedorRepository;

    public FornecedorServico(FornecedorRepositorio fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    public void cadastrarFornecedor(Fornecedor fornecedor) {
        if (fornecedor == null)
            throw new IllegalArgumentException("Fornecedor não pode ser nulo.");

        if (fornecedorRepository.existeFornecedorPorCNPJ(fornecedor.getCnpj()))
            throw new IllegalArgumentException("Já existe um fornecedor cadastrado com esse CNPJ.");

        fornecedorRepository.adicionarFornecedor(fornecedor);
    }

    public Fornecedor buscarFornecedorPorId(int id) {
        Fornecedor fornecedor = fornecedorRepository.buscarFornecedorPorID(id);

        if (fornecedor == null)
            throw new FornecedorNaoEncontradoException("Fornecedor não encontrado.");

        return fornecedor;
    }

    public Fornecedor buscarFornecedorPorCnpj(String cnpj) {
        Fornecedor fornecedor = fornecedorRepository.buscarFornecedorPorCNPJ(cnpj);

        if (fornecedor == null)
            throw new FornecedorNaoEncontradoException("Fornecedor não encontrado.");

        return fornecedor;
    }

    public void removerFornecedor(int id) {
        fornecedorRepository.removerFornecedor(id);
    }

    public void alterarEndereco(int id, Endereco novoEndereco) {
        Fornecedor fornecedor = buscarFornecedorPorId(id);

        if (novoEndereco == null)
            throw new EnderecoInvalidoException("O novo endereço não pode ser nulo.");

        fornecedor.setEndereco(novoEndereco);
    }

    public List<Fornecedor> buscarFornecedoresPorNome(String nome) {
        if (nome == null || nome.isBlank())
            throw new IllegalArgumentException("O nome da empresa não pode ser vazio.");

        List<Fornecedor> fornecedoresEncontrados = new ArrayList<>();

        for (Fornecedor fornecedor : fornecedorRepository.listarTodos().values()) {
            if (fornecedor.getNomeEmpresa().toLowerCase().contains(nome.toLowerCase()))
                fornecedoresEncontrados.add(fornecedor);
        }

        return fornecedoresEncontrados;
    }

    public Map<Integer, Fornecedor> listarTodosFornecedores() {
        return fornecedorRepository.listarTodos();

    }
}
