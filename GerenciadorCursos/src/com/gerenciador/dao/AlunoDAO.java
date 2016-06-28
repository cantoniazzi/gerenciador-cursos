package com.gerenciador.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.gerenciador.model.Aluno;

public class AlunoDAO {
	
	public Aluno load(int id) throws SQLException, ParseException{
        Connection conexao = null;
        CallableStatement clst = null;
        
        Aluno aluno = new Aluno();
        String procedure = "{call ssi_0073156_get_aluno(?, ?, ?, ?, ?, ?)}";
        
        try {
        	clst = Conexao.getConexao().prepareCall(procedure);
            
        	clst.setInt(1, id);
        	clst.registerOutParameter(2, java.sql.Types.VARCHAR);
        	clst.registerOutParameter(3, java.sql.Types.VARCHAR);
        	clst.registerOutParameter(4, java.sql.Types.VARCHAR);
        	clst.registerOutParameter(5, java.sql.Types.VARCHAR);
        	clst.registerOutParameter(6, java.sql.Types.VARCHAR);
        	
			// execute ssi_0073156_get_instrutor store procedure
        	clst.executeUpdate();
        
        	aluno.setId(id);
        	aluno.setNome(clst.getString(2));
        	aluno.setCpf(clst.getString(3));
        	aluno.setEmail(clst.getString(4));
        	aluno.setFone(clst.getString(5));
			aluno.setDataNascimento(clst.getString(6));
       	
        } catch(SQLException e) {
			System.out.println(e.getMessage());
        } finally {
            Conexao.close(conexao);
            
            if (clst != null) {
            	clst.close();
			}
            
        }
        
        return aluno;
    }
	
	public void add(Aluno aluno){
        Connection conexao = null;
        
        String procedure = "{call ssi_0073156_add_aluno(?, ?, ?, ?, ?)}";
        
        try {
        	CallableStatement clst = Conexao.getConexao().prepareCall(procedure);
        	clst.setString(1, aluno.getNome());
        	clst.setString(2, aluno.getCpf());
        	clst.setString(3, aluno.getEmail());
        	clst.setString(4, aluno.getFone());
        	clst.setString(5, aluno.getDataNascimento());
            clst.execute();
            clst.close();
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            Conexao.close(conexao);    
        }
    }
	
	public void edit(Aluno aluno) {
		Connection conexao = null;
		
		String procedure = "{call ssi_0073156_edit_aluno(?, ?, ?, ?, ?, ?)}";
		
        try {
        	CallableStatement clst = Conexao.getConexao().prepareCall(procedure);
        	clst.setInt(1, aluno.getId());
        	clst.setString(2, aluno.getNome());
        	clst.setString(3, aluno.getCpf());
        	clst.setString(4, aluno.getEmail());
        	clst.setString(5, aluno.getFone());
        	clst.setString(6, aluno.getDataNascimento());
            clst.execute();
            clst.close();
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            Conexao.close(conexao);    
        }
		
	}
	
	public void delete(Aluno aluno) {
		Connection conexao = null;
        
        try {
        	CallableStatement clst = Conexao.getConexao().prepareCall("{call ssi_0073156_delete_aluno(?)}");
            clst.setInt(1, aluno.getId());
            clst.execute();
            clst.close();
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            Conexao.close(conexao);    
        }
		
	}
	
	public List<Aluno> list() {
        List<Aluno> alunos = new ArrayList<Aluno>();
        Connection conexao = null;
        
        try {
            Statement statement = Conexao.getConexao().createStatement();
            String query = "select ALUNO_ID, ALUNO_NOME, CPF, EMAIL, FONE, DATA_NASCIMENTO from ssi_0073156_ALUNOS";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
            	Aluno aluno = new Aluno();
               
            	aluno.setId(rs.getInt("ALUNO_ID"));
            	aluno.setNome(rs.getString("ALUNO_NOME"));
            	aluno.setCpf(rs.getString("CPF"));
            	aluno.setEmail(rs.getString("EMAIL"));
            	aluno.setFone(rs.getString("FONE"));
            	aluno.setDataNascimento(rs.getString("DATA_NASCIMENTO"));
            	
                //adiciona na lista
            	alunos.add(aluno);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            Conexao.close(conexao);
        }
        
        return alunos;
    }
}
