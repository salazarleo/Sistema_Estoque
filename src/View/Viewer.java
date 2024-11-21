package View;

import java.util.Scanner;

import Controller.db_Connection;
import Model.Produtos;

public class Viewer {
    public void viewer (){
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\nSISTEMA DE GERENCIAMENTO DE ESTOQUE");
            System.out.println("1 - Gerenciar Produtos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    gerenciarProdutos(scanner);
                    break;
          
                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opcao invalida.");
                    break;
            }
        } while (option != 0);
    }

    private static void gerenciarProdutos(Scanner scanner) {
        int option;

        do {
            System.out.println("\nGERENCIAR PRODUTOS");
            System.out.println("1 - Criar Produto");
            System.out.println("2 - Listar Estoque com Produtos");
            System.out.println("3 - Consultar Produto por ID");
            System.out.println("4 - Editar Produto");
            System.out.println("5 - Excluir Produto");
            System.out.println("0 - Voltar ao Menu Principal");
            System.out.print("Escolha uma opcao: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Preco: ");
                    double preco = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Descricao: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Material: ");
                    String material = scanner.nextLine();
                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();
                    Produtos novoProduto = new Produtos(nome, preco, descricao, material, quantidade);
                    db_Connection.criarProduto(novoProduto);
                    break;

                case 2:
                    System.out.println("LISTA DE PRODUTOS:");
                    db_Connection dbConnection = new db_Connection();
                    for (Produtos produto : dbConnection.lerProdutos()) {
                        produto.imprimir();
                    }
                    break;

                case 3:
                    System.out.print("Digite o ID do produto para consulta: ");
                    int idConsulta = scanner.nextInt();
                    boolean encontrado = false;
                    db_Connection dbConnection2 = new db_Connection();
                    for (Produtos produto : dbConnection2.lerProdutos()) {
                        if (produto.getProdutoID() == idConsulta) {
                            produto.imprimir();
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Produto nao encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Digite o ID do produto a ser editado: ");
    int idProdutoEditar = scanner.nextInt();
    scanner.nextLine(); // Consumir a nova linha

    db_Connection dbConnection3 = new db_Connection();
    boolean produtoEncontrado = false;

    for (Produtos produtos : dbConnection3.lerProdutos()) {
        if (produtos.getProdutoID() == idProdutoEditar) {
            produtoEncontrado = true;
            System.out.print("Novo nome: ");
            produtos.setNome(scanner.nextLine());
            System.out.print("Novo preco: ");
            produtos.setPreco(scanner.nextDouble());
            scanner.nextLine(); // Consumir a nova linha
            System.out.print("Nova descricao: ");
            produtos.setDescricao(scanner.nextLine());
            System.out.print("Novo material: ");
            produtos.setMaterial(scanner.nextLine());
            System.out.print("Nova quantidade: ");
            produtos.setQuantidade(scanner.nextInt());
            scanner.nextLine(); // Consumir a nova linha

            db_Connection.atualizarProduto(produtos);
            System.out.println("Produto atualizado com sucesso.");
            break;
        }
    }

    if (!produtoEncontrado) {
        System.out.println("Produto com ID " + idProdutoEditar + " não encontrado.");
    }
    break;

                case 5:
                    System.out.print("Digite o ID do produto a ser excluido: ");
                    int idProdutoExcluir = scanner.nextInt();
                    db_Connection.deletarProduto(idProdutoExcluir);
                    System.out.println("Produto excluido.");
                    break;

                case 0:
                    System.out.println("Retornando ao menu principal...");
                    break;

                default:
                    System.out.println("Opção invalida.");
                    break;
            }
        } while (option != 0);
    }
}
