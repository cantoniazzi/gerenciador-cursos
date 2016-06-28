package com.gerenciador.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gerenciador.model.Curso;
import com.gerenciador.model.Instrutor;
import com.gerenciador.model.Turma;
import com.gerenciador.dao.CursoDAO;
import com.gerenciador.dao.InstrutorDAO;

public class TurmaDAO {
	
	public Turma load(int id) throws SQLException{
        Connection conexao = null;
        CallableStatement clst = null;
        
        Turma turma = new Turma();
        String procedure = "{call ssi_0073156_get_turma(?, ?, ?, ?, ?, ?)}";
        
        try {
        	clst = Conexao.getConexao().prepareCall(procedure);

        	clst.setInt(1, id);
        	clst.registerOutParameter(2, java.sql.Types.INTEGER);
        	clst.registerOutParameter(3, java.sql.Types.INTEGER);
        	clst.registerOutParameter(4, java.sql.Types.VARCHAR);
        	clst.registerOutParameter(5, java.sql.Types.VARCHAR);
        	clst.registerOutParameter(6, java.sql.Types.INTEGER);
        	
			// execute ssi_0073156_get_turma store procedure
        	clst.executeUpdate();
        
        	turma.setId(id);
        	turma.setInstrutor(new InstrutorDAO().load(clst.getInt(2)));
        	turma.setCurso(new CursoDAO().load(clst.getInt(3)));
        	turma.setDataInicio(clst.getString(4));
        	turma.setDataFim(clst.getString(5));
        	turma.setCargaHoraria(clst.getInt(6));
        	
        } catch(SQLException e) {
			System.out.println(e.getMessage());
        } finally {
            Conexao.close(conexao);
            
            if (clst != null) {
            	clst.close();
			}
            
        }
        
        return turma;
    }
	
	public void add(Turma turma){
        Connection conexao = null;
        
        String procedure = "{call ssi_0073156_add_turma(?, ?, ?, ?, ?)}";
        
        try {
        	CallableStatement clst = Conexao.getConexao().prepareCall(procedure);
        	clst.setInt(1, turma.getInstrutor().getId());
        	clst.setInt(2, turma.getCurso().getId());
        	clst.setString(3, turma.getDataInicio());
        	clst.setString(4, turma.getDataFim());
        	clst.setInt(5, turma.getCargaHoraria());
        	clst.execute();
            clst.close();
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            Conexao.close(conexao);    
        }
    }
	
	public void edit(Turma turma) {
		Connection conexao = null;
		
		String procedure = "{call ssi_0073156_edit_turma(?, ?, ?, ?, ?, ?)}";
		
        try {
        	CallableStatement clst = Conexao.getConexao().prepareCall(procedure);
        	clst.setInt(1, turma.getId());
        	clst.setInt(2, turma.getInstrutor().getId());
        	clst.setInt(3, turma.getCurso().getId());
        	clst.setString(4, turma.getDataInicio());
        	clst.setString(5, turma.getDataFim());
        	clst.setInt(6, turma.getCargaHoraria());
            clst.execute();
            clst.close();
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            Conexao.close(conexao);    
        }
		
	}
	
	public void delete(Turma turma) {
		Connection conexao = null;
        
        try {
        	CallableStatement clst = Conexao.getConexao().prepareCall("{call ssi_0073156_delete_turma(?)}");
            clst.setInt(1, turma.getId());
            clst.execute();
            clst.close();
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            Conexao.close(conexao);    
        }
		
	}
	
	public List<Turma> list() {
        List<Turma> turmas = new ArrayList<Turma>();
        Connection conexao = null;
        
        try {
            Statement statement = Conexao.getConexao().createStatement();
            String query = "select TURMA_ID, INSTRUTOR_ID, CURSO_ID, DATA_INICIO, DATA_FIM, CARGA_HORARIA FROM ssi_0073156_TURMAS";
         	
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
            	Turma turma = new Turma();
            	Instrutor instrutor = rs.getInt("INSTRUTOR_ID") != 0 ? new InstrutorDAO().load(rs.getInt("INSTRUTOR_ID")) : new Instrutor();
            	Curso curso = rs.getInt("CURSO_ID") != 0 ? new CursoDAO().load(rs.getInt("CURSO_ID")) : new Curso();
            	
            	turma.setId(rs.getInt("TURMA_ID"));
            	turma.setInstrutor(instrutor);
            	turma.setCurso(curso);
            	turma.setDataInicio(rs.getString("DATA_INICIO"));
            	turma.setDataFim(rs.getString("DATA_FIM"));
            	
                //adiciona na lista
            	turmas.add(turma);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            Conexao.close(conexao);
        }
        
        return turmas;
    }

}
