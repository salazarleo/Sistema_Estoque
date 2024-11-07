import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Produtos> listaProdutos = new ArrayList<>();
        ArrayList<Estoque> listaEstoques = new ArrayList<>();
        int option;

        do {
            System.out.println("\nSISTEMA DE GERENCIAMENTO DE ESTOQUE");
            System.out.println("1 - Gerenciar Produtos");
            System.out.println("2 - Gerenciar Estoques");
            System.out.println("3 - Listar Estoque com Produtos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    gerenciarProdutos(listaProdutos, scanner);
                    break;

                case 2:
                    gerenciarEstoques(listaEstoques, listaProdutos, scanner);
                    break;

                case 3:
                    listarEstoquesComProdutos(listaEstoques);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (option != 0);
    }

    private static void gerenciarProdutos(ArrayList<Produtos> listaProdutos, Scanner scanner) {
        int option;

        do {
            System.out.println("\nGERENCIAR PRODUTOS");
            System.out.println("1 - Criar Produto");
            System.out.println("2 - Listar Todos os Produtos");
            System.out.println("3 - Consultar Produto por ID");
            System.out.println("4 - Editar Produto");
            System.out.println("5 - Excluir Produto");
            System.out.println("0 - Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Quantidade: ");
                    int quant = scanner.nextInt();
                    Produtos novoProduto = new Produtos(nome, quant);
                    listaProdutos.add(novoProduto);
                    System.out.println("Produto criado com sucesso! ID: " + novoProduto.getID());
                    break;

                case 2:
                    System.out.println("LISTA DE PRODUTOS:");
                    for (Produtos produto : listaProdutos) {
                        produto.imprimir();
                    }
                    break;

                case 3:
                    System.out.print("Digite o ID do produto para consulta: ");
                    int idConsulta = scanner.nextInt();
                    boolean encontrado = false;
                    for (Produtos produto : listaProdutos) {
                        if (produto.getID() == idConsulta) {
                            produto.imprimir();
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Digite o ID do produto a ser editado: ");
                    int idProdutoEditar = scanner.nextInt();
                    scanner.nextLine();
                    for (Produtos produto : listaProdutos) {
                        if (produto.getID() == idProdutoEditar) {
                            System.out.print("Novo nome: ");
                            produto.setNome(scanner.nextLine());
                            System.out.print("Nova quantidade: ");
                            produto.setQuant(scanner.nextInt());
                            System.out.println("Produto atualizado com sucesso.");
                            break;
                        }
                    }
                    break;

                case 5:
                    System.out.print("Digite o ID do produto a ser excluído: ");
                    int idProdutoExcluir = scanner.nextInt();
                    listaProdutos.removeIf(produto -> produto.getID() == idProdutoExcluir);
                    System.out.println("Produto excluído.");
                    break;

                case 0:
                    System.out.println("Retornando ao menu principal...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (option != 0);
    }

    private static void gerenciarEstoques(ArrayList<Estoque> listaEstoques, ArrayList<Produtos> listaProdutos, Scanner scanner) {
        int option;

        do {
            System.out.println("\nGERENCIAR ESTOQUES");
            System.out.println("1 - Criar Estoque");
            System.out.println("2 - Listar Todos os Estoques");
            System.out.println("3 - Adicionar Produto ao Estoque");
            System.out.println("4 - Editar Nome do Estoque");
            System.out.println("5 - Remover Produto do Estoque");
            System.out.println("0 - Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Categoria do estoque: ");
                    String categoria = scanner.nextLine();
                    Estoque novoEstoque = new Estoque(categoria);
                    listaEstoques.add(novoEstoque);
                    System.out.println("Estoque criado com sucesso.");
                    break;

                case 2:
                    System.out.println("LISTA DE ESTOQUES:");
                    for (Estoque estoque : listaEstoques) {
                        estoque.imprimir();
                    }
                    break;

                case 3:
                    System.out.print("ID do estoque: ");
                    int idEstoque = scanner.nextInt();
                    System.out.print("ID do produto: ");
                    int idProduto = scanner.nextInt();
                    Estoque estoqueParaAdicionar = null;
                    Produtos produtoParaAdicionar = null;

                    for (Estoque estoque : listaEstoques) {
                        if (estoque.getID() == idEstoque) {
                            estoqueParaAdicionar = estoque;
                            break;
                        }
                    }

                    for (Produtos produto : listaProdutos) {
                        if (produto.getID() == idProduto) {
                            produtoParaAdicionar = produto;
                            break;
                        }
                    }

                    if (estoqueParaAdicionar != null && produtoParaAdicionar != null) {
                        estoqueParaAdicionar.adicionarProduto(produtoParaAdicionar);
                        System.out.println("Produto adicionado ao estoque.");
                    } else {
                        System.out.println("Estoque ou produto não encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("ID do estoque para editar: ");
                    int idEstoqueEditar = scanner.nextInt();
                    scanner.nextLine();
                    for (Estoque estoque : listaEstoques) {
                        if (estoque.getID() == idEstoqueEditar) {
                            System.out.print("Nova categoria: ");
                            estoque.setCategoria(scanner.nextLine());
                            System.out.println("Categoria do estoque atualizada.");
                            break;
                        }
                    }
                    break;

                case 5:
                    System.out.print("ID do estoque: ");
                    int idEstoqueRemover = scanner.nextInt();
                    System.out.print("ID do produto a remover: ");
                    int idProdutoRemover = scanner.nextInt();
                    for (Estoque estoque : listaEstoques) {
                        if (estoque.getID() == idEstoqueRemover) {
                            estoque.removerProduto(idProdutoRemover);
                            System.out.println("Produto removido do estoque.");
                            break;
                        }
                    }
                    break;

                case 0:
                    System.out.println("Retornando ao menu principal...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (option != 0);
    }

    private static void listarEstoquesComProdutos(ArrayList<Estoque> listaEstoques) {
        System.out.println("\nLISTA DE ESTOQUES COM PRODUTOS:");
        for (Estoque estoque : listaEstoques) {
            estoque.imprimir();
            System.out.println();
        }
    }
}
