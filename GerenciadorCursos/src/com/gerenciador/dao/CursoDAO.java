package com.gerenciador.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gerenciador.model.Curso;

public class CursoDAO {
	
	public Curso load(int id) throws SQLException{
        Connection conexao = null;
        CallableStatement clst = null;
        Curso curso = new Curso();
        
        try {
        	clst = Conexao.getConexao().prepareCall("{call ssi_0073156_get_curso(?, ?, ?, ?, ?)}");
            
        	clst.setInt(1, id);
        	clst.registerOutParameter(2, java.sql.Types.VARCHAR);
        	clst.registerOutParameter(3, java.sql.Types.VARCHAR);
        	clst.registerOutParameter(4, java.sql.Types.INTEGER);
        	clst.registerOutParameter(5, java.sql.Types.DOUBLE);
        	
			// execute ssi_0073156_get_curso store procedure
        	clst.executeUpdate();
        	
        	curso.setId(id);
        	curso.setNome(clst.getString(2));
        	curso.setRequisito(clst.getString(3));
        	curso.setCargaHoraria(clst.getInt(4));
        	curso.setPreco(clst.getDouble(5));
        	
        } catch(SQLException e) {
			System.out.println(e.getMessage());
        } finally {
            Conexao.close(conexao);
            
            if (clst != null) {
            	clst.close();
			}
            
        }
        
        return curso;
    }
	
	public void add(Curso curso){
        Connection conexao = null;
        
        try {
        	CallableStatement clst = Conexao.getConexao().prepareCall("{call ssi_0073156_add_curso(?, ?, ?, ?)}");
            clst.setString(1, curso.getNome());
            clst.setString(2, curso.getRequisito());
            clst.setInt(3, curso.getCargaHoraria());
            clst.setDouble(4, curso.getPreco());
            clst.execute();
            clst.close();
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            Conexao.close(conexao);    
        }
    } 
	
	public void edit(Curso curso) {
		Connection conexao = null;
        
        try {
        	CallableStatement clst = Conexao.getConexao().prepareCall("{call ssi_0073156_edit_curso(?, ?, ?, ?, ?)}");
        	clst.setInt(1, curso.getId());
        	clst.setString(2, curso.getNome());
            clst.setString(3, curso.getRequisito());
            clst.setInt(4, curso.getCargaHoraria());
            clst.setDouble(5, curso.getPreco());
            clst.execute();
            clst.close();
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            Conexao.close(conexao);    
        }
		
	}

	public void delete(Curso curso) {
		Connection conexao = null;
        
        try {
        	CallableStatement clst = Conexao.getConexao().prepareCall("{call ssi_0073156_delete_curso(?)}");
            clst.setInt(1, curso.getId());
            clst.execute();
            clst.close();
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            Conexao.close(conexao);    
        }
		
	}
	
	public List<Curso> list() {
        List<Curso> cursos = new ArrayList<Curso>();
        Connection conexao = null;
        
        try {
            Statement statement = Conexao.getConexao().createStatement();
            String query = "select CURSO_ID, CURSO_NOME, REQUISITO, CARGA_HORARIA, PRECO from ssi_0073156_cursos";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Curso curso = new Curso();
               
                curso.setId(rs.getInt("CURSO_ID"));
                curso.setNome(rs.getString("CURSO_NOME"));
                curso.setRequisito(rs.getString("REQUISITO"));
                curso.setCargaHoraria(rs.getInt("CARGA_HORARIA"));
                curso.setPreco(rs.getDouble("PRECO"));
                
                //adiciona na lista
                cursos.add(curso);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            Conexao.close(conexao);
        }
        
        return cursos;
    }

	
}
