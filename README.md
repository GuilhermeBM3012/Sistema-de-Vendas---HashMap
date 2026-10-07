# Sistema de Vendas em Java — HashMap

Projeto desenvolvido em Java com foco em Programação Orientada a Objetos (POO), simulando um sistema de vendas com gerenciamento de clientes, fornecedores, produtos, pedidos, pagamentos, funcionários e estoque.

Nesta versão do projeto, os dados são armazenados em memória utilizando **`HashMap`**, permitindo trabalhar com uma estrutura de chave e valor para facilitar a busca e o gerenciamento das entidades.

## 📌 Funcionalidades

O sistema permite:

* Cadastro, consulta, alteração e remoção de clientes
* Cadastro e gerenciamento de fornecedores
* Cadastro de produtos
* Produtos de diferentes categorias:

  * Eletrônicos
  * Roupas
  * Alimentos
* Controle de quantidade em estoque
* Criação e gerenciamento de pedidos
* Adição e remoção de produtos dos pedidos
* Cálculo de subtotal, frete e valor total
* Diferentes formas de pagamento:

  * Pix
  * Cartão
  * Boleto
* Processamento e cancelamento de pagamentos
* Gerenciamento de funcionários
* Operações relacionadas ao estoque
* Validações e tratamento de exceções

## 🏗️ Estrutura do Projeto

O projeto foi organizado seguindo uma separação de responsabilidades:

```text
src/
├── Application/
│   └── Main.java
│
├── Domain/
│   ├── Cliente.java
│   ├── Endereco.java
│   ├── Fornecedor.java
│   ├── Produto.java
│   ├── Eletronico.java
│   ├── Roupa.java
│   ├── Alimento.java
│   ├── Pedido.java
│   ├── ItemPedido.java
│   ├── Pagamento.java
│   ├── Pix.java
│   ├── Cartao.java
│   ├── Boleto.java
│   └── ...
│
├── Infrastructure/
│   ├── ClienteRepositorio.java
│   ├── FornecedorRepositorio.java
│   ├── ProdutoRepositorio.java
│   ├── PedidoRepositorio.java
│   └── ...
│
├── Service/
│   ├── ClienteServico.java
│   ├── FornecedorServico.java
│   ├── ProdutoServico.java
│   ├── PedidoServico.java
│   └── ...
│
├── Presentation/
│   ├── MenuPrincipal.java
│   ├── ClienteMenu.java
│   ├── ProdutoMenu.java
│   ├── PedidoMenu.java
│   └── ...
│
└── Exception/
    └── ...
```

### Responsabilidade das camadas

**Domain:** contém as entidades e regras relacionadas aos objetos do sistema.

**Infrastructure:** contém os repositórios responsáveis pelo armazenamento dos dados em memória utilizando `HashMap`.

**Service:** contém as regras de negócio e faz a comunicação entre a apresentação, os repositórios e o domínio.

**Presentation:** contém os menus utilizados para interação com o usuário através do terminal.

**Application:** contém a classe `Main`, responsável por inicializar o sistema e suas dependências.

**Exception:** contém as exceções personalizadas utilizadas para tratar situações inválidas.

## 🗂️ Armazenamento com HashMap

Diferentemente de uma estrutura baseada em `ArrayList`, nesta versão os repositórios utilizam `HashMap`.

O `HashMap` armazena os dados no formato:

```text
chave → valor
```

Por exemplo, um repositório de clientes pode utilizar o ID do cliente como chave:

```java
private Map<Integer, Cliente> clientes;

public ClienteRepositorio() {
    clientes = new HashMap<>();
}
```

Ao cadastrar um cliente:

```java
clientes.put(cliente.getId(), cliente);
```

Para buscar um cliente pelo ID:

```java
public Cliente buscarClientePorId(int id) {
    return clientes.get(id);
}
```

Para verificar se um cliente existe:

```java
public boolean existeClientePorId(int id) {
    return clientes.containsKey(id);
}
```

Para remover:

```java
public void removerCliente(int id) {
    clientes.remove(id);
}
```

### `Map` e `HashMap`

O projeto utiliza a interface `Map` e a implementação `HashMap`:

```java
Map<Integer, Cliente> clientes = new HashMap<>();
```

Nesse exemplo:

* `Integer` representa a **chave**;
* `Cliente` representa o **valor**;
* o ID do cliente é utilizado como chave;
* o objeto `Cliente` é armazenado como valor.

Essa abordagem facilita operações de busca, verificação e remoção utilizando o identificador da entidade.

## ⚡ Vantagens do HashMap

O uso de `HashMap` é especialmente interessante quando as entidades possuem um identificador único.

Por exemplo:

```java
clientes.get(10);
```

permite buscar diretamente o cliente associado à chave `10`.

Além disso, podemos verificar rapidamente se uma chave existe:

```java
clientes.containsKey(10);
```

E remover um registro:

```java
clientes.remove(10);
```

Isso torna o `HashMap` bastante adequado para repositórios que precisam realizar muitas operações utilizando IDs.

## 💻 Tecnologias e conceitos utilizados

* Java
* Programação Orientada a Objetos (POO)
* Encapsulamento
* Herança
* Polimorfismo
* Abstração
* Classes abstratas
* Interfaces
* Enum
* Construtores
* Sobrescrita de métodos (`@Override`)
* `Map`
* `HashMap`
* Chave e valor
* `put()`
* `get()`
* `containsKey()`
* `remove()`
* `LocalDate`
* `instanceof`
* Exceções personalizadas
* Repository Pattern
* Service Layer
* Separação de responsabilidades

## 💰 Cálculo de pedidos

O sistema realiza cálculos automaticamente para os pedidos.

O subtotal é calculado a partir dos produtos e suas respectivas quantidades.

O frete considera o peso dos produtos alimentícios:

```text
Frete = 10 + (peso total × 2)
```

O valor total do pedido é:

```text
Total = Subtotal + Frete
```

Também existem regras específicas para cada forma de pagamento, como descontos no Pix, juros no cartão e descontos/multas no boleto.

## ▶️ Como executar o projeto

### 1. Clone o repositório

No terminal:

```bash
git clone URL_DO_SEU_REPOSITORIO
```

Depois, entre na pasta do projeto:

```bash
cd nome-do-projeto
```

### 2. Abra o projeto na IDE

O projeto pode ser aberto em uma IDE compatível com Java, como:

* IntelliJ IDEA
* Eclipse
* Visual Studio Code

### 3. Localize a classe `Main`

A classe principal está localizada no pacote:

```text
Application
```

O arquivo principal é:

```text
Application/Main.java
```

Ele contém o método:

```java
public static void main(String[] args)
```

### 4. Execute o projeto

Execute o arquivo `Main.java`.

A aplicação será iniciada no terminal e o `MenuPrincipal` será apresentado.

### 5. Utilize o sistema

A partir do menu principal, é possível acessar as funcionalidades disponíveis, como:

* Clientes
* Fornecedores
* Produtos
* Pedidos
* Pagamentos
* Funcionários
* Estoque

> **Observação:** os dados são armazenados em memória utilizando `HashMap`. Portanto, eles são perdidos quando a aplicação é encerrada.

## 🎯 Objetivos de Aprendizagem

O principal objetivo do projeto é aplicar, na prática, conceitos fundamentais de Java e Programação Orientada a Objetos.

Durante o desenvolvimento, foram trabalhados os seguintes conhecimentos:

* Compreender e aplicar os princípios de Programação Orientada a Objetos;
* Criar e utilizar classes, objetos, atributos e métodos;
* Aplicar encapsulamento através de modificadores de acesso e getters/setters;
* Utilizar herança para representar diferentes tipos de produtos e pagamentos;
* Aplicar polimorfismo através de classes abstratas e sobrescrita de métodos;
* Trabalhar com classes abstratas e métodos abstratos;
* Utilizar `enum` para representar categorias e estados;
* Trabalhar com coleções utilizando `Map` e `HashMap`;
* Compreender o conceito de chave e valor;
* Utilizar métodos como `put()`, `get()`, `containsKey()` e `remove()`;
* Utilizar IDs como chaves para facilitar a localização das entidades;
* Trabalhar com datas utilizando `LocalDate`;
* Criar exceções personalizadas para validação das regras do sistema;
* Separar responsabilidades entre as diferentes camadas da aplicação;
* Aplicar o padrão Repository para gerenciamento dos dados;
* Aplicar uma camada Service para centralizar regras de negócio;
* Desenvolver uma aplicação interativa utilizando menus no terminal;
* Praticar organização e estruturação de um projeto Java.

## 📚 Objetivo do Projeto

Este projeto foi desenvolvido com finalidade acadêmica, buscando consolidar os conhecimentos de Java e Programação Orientada a Objetos através da construção de uma aplicação completa de gerenciamento de vendas.

A utilização do `HashMap` também teve como objetivo proporcionar uma experiência prática com estruturas de dados baseadas em chave e valor, explorando uma alternativa ao armazenamento utilizando listas.

O projeto foi estruturado de forma que o armazenamento em memória fique separado das regras de negócio, permitindo que futuramente os repositórios possam ser adaptados para trabalhar com um banco de dados.

## 🔄 ArrayList x HashMap

Uma das diferenças entre as duas versões do projeto está na forma de armazenamento dos dados.

### ArrayList

```java
List<Cliente> clientes = new ArrayList<>();
```

Os objetos são armazenados em uma lista e normalmente precisam ser percorridos para localizar um determinado elemento.

### HashMap

```java
Map<Integer, Cliente> clientes = new HashMap<>();
```

Cada objeto é associado a uma chave, permitindo realizar operações diretamente através dessa chave.

Por exemplo:

```java
clientes.put(cliente.getId(), cliente);

Cliente cliente = clientes.get(id);
```

Assim, o `HashMap` é uma estrutura especialmente útil quando o acesso aos objetos é frequentemente realizado através de um identificador único.

## 👨‍💻 Autor

**Guilherme Milani**

Projeto desenvolvido para fins acadêmicos.
