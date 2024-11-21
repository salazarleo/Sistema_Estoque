package Controller;
import Model.Produtos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class db_Connection {

    private static final String URL = "jdbc:mysql://localhost:3306/estoque_db";
    private static final String USER = "root";
    private static final String PASSWORD = "Hj2vZuCL*<7DX#c/";

    // Criar produto
    public static void criarProduto(Produtos produtos) {

        String query = "INSERT INTO produtos (nome, preco, descricao, material, quantidade) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, produtos.getNome());
            statement.setDouble(2, produtos.getPreco());
            statement.setString(3, produtos.getDescricao());
            statement.setString(4, produtos.getMaterial());
            statement.setInt(5, produtos.getQuantidade());

            statement.executeUpdate();
            System.out.println("Produto criado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao adicionar o produto: " + e.getMessage());
        }
    }

    // Deletar produto
    public static void deletarProduto(int produtoID) {

        String query = "DELETE FROM produtos WHERE produtoID = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, produtoID);
            statement.executeUpdate();
            System.out.println("Produto deletado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao deletar produto: " + e.getMessage());
        }
    }

    // Atualizar usuário
    public static void atualizarProduto(Produtos produtos) {

        String query = "UPDATE produtos SET nome = ?, preco = ?, descricao = ?, material = ?, quantidade = ? WHERE produtoID = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, produtos.getNome());
            statement.setDouble(2, produtos.getPreco());
            statement.setString(3, produtos.getDescricao());
            statement.setString(4, produtos.getMaterial());
            statement.setInt(5, produtos.getQuantidade());
            statement.setInt(6, produtos.getProdutoID());

            statement.executeUpdate();
            System.out.println("Produto atualizado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar produto: " + e.getMessage());
        }
    }

    // Ler produto
    public List<Produtos> lerProdutos(){

        List<Produtos> produtosAll = new ArrayList<>();
        String query = "SELECT * FROM produtos";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()){
                Produtos produtos = new Produtos(resultSet.getInt("produtoID"), resultSet.getString("nome"), resultSet.getDouble("preco"), resultSet.getString("descricao"), resultSet.getString("material"), resultSet.getInt("quantidade"));
                produtosAll.add(produtos);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao ler produto: " + e.getMessage());
        }
        return produtosAll;
    }

}
