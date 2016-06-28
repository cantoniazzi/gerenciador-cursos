package com.gerenciador.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gerenciador.model.Instrutor;

public class InstrutorDAO {
	
	public Instrutor load(int id) throws SQLException{
        Connection conexao = null;
        CallableStatement clst = null;
        Instrutor instrutor = new Instrutor();
        
        try {
        	clst = Conexao.getConexao().prepareCall("{call ssi_0073156_get_instrutor(?, ?, ?, ?, ?)}");
            
        	clst.setInt(1, id);
        	clst.registerOutParameter(2, java.sql.Types.VARCHAR);
        	clst.registerOutParameter(3, java.sql.Types.VARCHAR);
        	clst.registerOutParameter(4, java.sql.Types.FLOAT);
        	clst.registerOutParameter(5, java.sql.Types.VARCHAR);
        	
			// execute ssi_0073156_get_instrutor store procedure
        	clst.executeUpdate();
        	
        	instrutor.setId(id);
        	instrutor.setNome(clst.getString(2));
        	instrutor.setEmail(clst.getString(3));
        	instrutor.setValorHora(clst.getDouble(4));
        	instrutor.setCertificados(clst.getString(5));
        	
        } catch(SQLException e) {
			System.out.println(e.getMessage());
        } finally {
            Conexao.close(conexao);
            
            if (clst != null) {
            	clst.close();
			}
            
        }
        
        return instrutor;
    }
	
	public void add(Instrutor instrutor){
        Connection conexao = null;
        
        try {
        	CallableStatement clst = Conexao.getConexao().prepareCall("{call ssi_0073156_add_instrutor(?, ?, ?, ?)}");
        	clst.setString(1, instrutor.getNome());
            clst.setString(2, instrutor.getEmail());
            clst.setDouble(3, instrutor.getValorHora());
            clst.setString(4, instrutor.getCertificados());
            clst.execute();
            clst.close();
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            Conexao.close(conexao);    
        }
    } 
	
	public void edit(Instrutor instrutor) {
		Connection conexao = null;
		
        try {
        	CallableStatement clst = Conexao.getConexao().prepareCall("{call ssi_0073156_edit_instrutor(?, ?, ?, ?, ?)}");
        	clst.setInt(1, instrutor.getId());
        	clst.setString(2, instrutor.getNome());
            clst.setString(3, instrutor.getEmail());
            clst.setDouble(4, instrutor.getValorHora());
            clst.setString(5, instrutor.getCertificados());
            clst.execute();
            clst.close();
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            Conexao.close(conexao);    
        }
		
	}

	public void delete(Instrutor instrutor) {
		Connection conexao = null;
        
        try {
        	CallableStatement clst = Conexao.getConexao().prepareCall("{call ssi_0073156_delete_instrutor(?)}");
            clst.setInt(1, instrutor.getId());
            clst.execute();
            clst.close();
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            Conexao.close(conexao);    
        }
		
	}
	
	public List<Instrutor> list() {
        List<Instrutor> instrutores = new ArrayList<Instrutor>();
        Connection conexao = null;
        
        try {
            Statement statement = Conexao.getConexao().createStatement();
            String query = "select INSTRUTOR_ID, INSTRUTOR_NOME, EMAIL, VALOR_HORA, CERTIFICADOS from ssi_0073156_INSTRUTORES";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
            	Instrutor instrutor = new Instrutor();
               
            	instrutor.setId(rs.getInt("INSTRUTOR_ID"));
            	instrutor.setNome(rs.getString("INSTRUTOR_NOME"));
            	instrutor.setEmail(rs.getString("EMAIL"));
            	instrutor.setValorHora(rs.getDouble("VALOR_HORA"));;
            	instrutor.setCertificados(rs.getString("CERTIFICADOS"));;
                
                //adiciona na lista
            	instrutores.add(instrutor);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            Conexao.close(conexao);
        }
        
        return instrutores;
    }

	
}
