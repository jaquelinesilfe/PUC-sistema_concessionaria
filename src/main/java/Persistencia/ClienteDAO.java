
package Persistencia;

import Entidade.Cliente;
import java.util.ArrayList;
import java.sql.*;


public class ClienteDAO{

	private ConexaoBD conexao;
	
	public ClienteDAO() {
		conexao = new ConexaoBD();
	}
	
    public int inserirCliente(Cliente cliente) {
    	
    	int isSucesso = 0;
    	
    	try{
            Connection connection = conexao.getConnection();
            
            String sql = "INSERT INTO cliente(nome, telefone, email, sexo, datanascimento, ativo) VALUES (?, ?, ?, ?, ?, ?)";
            
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getTelefone());
            ps.setString(3, cliente.getEmail());
            ps.setString(4, cliente.getSexo());
            ps.setString(5, cliente.getDatanascimento());
            ps.setInt(6, 1);
            
            System.out.println(sql);
            
            isSucesso = ps.executeUpdate();
            
            connection.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
      return isSucesso;
    }

    public ArrayList<Cliente> listaClienteTodos() {
    	
    	ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
    	
        try {
        	String sql = "select * from cliente where ativo = 1";
        	Connection connection = conexao.getConnection();
        	PreparedStatement ps = connection.prepareStatement(sql);
        	ResultSet resultado = ps.executeQuery();
        	
        	while(resultado.next()) {
        		Cliente cliente = new Cliente();
        		cliente.setIdCliente(resultado.getInt("idcliente"));
        		cliente.setNome(resultado.getString("nome"));
        		cliente.setTelefone(resultado.getString("telefone"));
        		cliente.setEmail(resultado.getString("email"));
        		cliente.setSexo(resultado.getString("sexo"));
        		cliente.setDatanascimento(resultado.getString("datanascimento"));
        		
        		listaCliente.add(cliente);
        	}
        	
        	connection.close();
        	
        }catch(Exception erro) {
        	System.out.println("Erro durante listagem de dados!" + erro.getMessage());
        }
        
        return listaCliente;
    }

    public Cliente listaClientePorNome(String nome) {
    	
    	Cliente cliente = new Cliente();
    	
        try {
        	String sql = "select * from cliente where nome = ? and ativo = 1";
        	Connection connection = conexao.getConnection();
        	PreparedStatement ps = connection.prepareStatement(sql);
        	ps.setString(1, nome);
        	ResultSet resultado = ps.executeQuery();
        	
        	if(resultado.next()) {
        		cliente.setIdCliente(resultado.getInt("idcliente"));
        		cliente.setNome(resultado.getString("nome"));
        		cliente.setTelefone(resultado.getString("telefone"));
        		cliente.setEmail(resultado.getString("email"));
        		cliente.setSexo(resultado.getString("sexo"));
        		cliente.setDatanascimento(resultado.getString("datanascimento"));
        	}
        	
        	connection.close();
        	
        }catch (Exception e) {
        	System.out.println("Erro durante listagem de dados!" + e.getMessage());
        }
        
        return cliente;
    }

    public boolean excluirCliente(int idCliente) {
        
        try {
        
        	Connection connection = conexao.getConnection();
            //String sql = "delete from cliente where idcliente = ?";
        	String sql = "update cliente set ativo = 0 where idcliente = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idCliente);
            
            ps.execute();
            
            connection.close();
        	
        } catch (Exception e) {
            System.out.println("Erro durante a exclusão de dados!!!");
            return false;
        }
        
        return true;
    }

}
