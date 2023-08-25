package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.example.dao.ConnectionManager;
import com.example.dao.estadoDAO;
import com.example.model.Marca;
import com.example.model.Produto;

public class App {
    public static void main(String[] args) {
        System.out.println("apenas um teste");
        new App();
    }

    public App(){
        try(var conn = ConnectionManager.getConnection()){
          carregarDriverJDBC(); 
        
          var estadoDAO = new estadoDAO(conn);
            
          estadoDAO.listar();
          estadoDAO.localizar("PR");
            listarDadosTabela(conn, "produto");

            var marca = new Marca();
            marca.setId(1L);

            var produto = new Produto();
            produto.setMarca(marca);
            produto.setNome("Produto teste");
            produto.setValor(5);

            //inserirProduto(conn, produto);
            //excluirProduto(conn, 201);
            //listarDadosTabela(conn, "produto");
            
        } catch (SQLException e) {
            System.err.println("Não foi possível conectar ao banco de dados: " + e.getMessage());
        }        
    }

    private void excluirProduto(Connection conn, long i) {
        var sql = "delete from produto where id = ?";
     
        try (var statement = conn.prepareStatement(sql)){
         statement.setLong(1, i); 
         statement.executeUpdate();      
          } catch (SQLException e) {
          System.err.println("Erro ao excluir Produto " + e.getMessage());     
          }
    }

    private void inserirProduto(Connection conn, Produto produto) {
      var sql = "insert into produto (nome, marca_id, valor) values (?, ?, ?)";
     
      try (var statement = conn.prepareStatement(sql)){
       statement.setString(1, produto.getNome()); 
       statement.setLong(2, produto.getMarca().getId()); 
       statement.setDouble(3, produto.getValor());
       statement.executeUpdate();      
        } catch (SQLException e) {
        System.err.println("Erro ao inserir Produto " + e.getMessage());     
        }
    }

    private void listarDadosTabela(Connection conn, String tabela) {
        var sql = "select * from " + tabela;
        //System.out.println(sql);
        try {
            var statement = conn.createStatement();
            var result = statement.executeQuery(sql);

            var metadata = result.getMetaData();
            int cols = metadata.getColumnCount();

            for (int i = 1; i <= cols; i++) {
                System.out.printf("%-25s | ", metadata.getColumnName(i));
            }
            System.out.println();

            while(result.next()){
                for (int i = 1; i <= cols; i++) {
                    System.out.printf("%-25s | ", result.getString(i));
                }
                System.out.println();
            }
        } catch (SQLException e) {
            System.err.println("Erro na execução da consulta: " + e.getMessage());
        }
        
    }  

    private void carregarDriverJDBC() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Não foi possível carregar a biblioteca para acesso ao banco de dados: " + e.getMessage());
        }
    }
}
