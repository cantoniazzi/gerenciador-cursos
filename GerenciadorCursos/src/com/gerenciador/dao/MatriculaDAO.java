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
import com.gerenciador.model.Matricula;
import com.gerenciador.model.Turma;

public class MatriculaDAO {
	
	public Matricula load(int id) throws SQLException{
        Connection conexao = null;
        CallableStatement clst = null;
        
        Matricula matricula = new Matricula();
        String procedure = "{call ssi_0073156_get_matricula(?, ?, ?, ?)}";
        
        try {
        	clst = Conexao.getConexao().prepareCall(procedure);

        	clst.setInt(1, id);
        	clst.registerOutParameter(2, java.sql.Types.INTEGER);
        	clst.registerOutParameter(3, java.sql.Types.INTEGER);
        	clst.registerOutParameter(4, java.sql.Types.VARCHAR);
        	
			// execute ssi_0073156_get_turma store procedure
        	clst.executeUpdate();
        
        	matricula.setId(id);
        	matricula.setTurma(new TurmaDAO().load(clst.getInt(2)));
        	try {
				matricula.setAluno(new AlunoDAO().load(clst.getInt(3)));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	//matricula.setAluno(new AlunoDAO().load(clst.getInt(3)));
        	matricula.setDataMatricula(clst.getString(4));
        	
        } catch(SQLException e) {
			System.out.println(e.getMessage());
        } finally {
            Conexao.close(conexao);
            
            if (clst != null) {
            	clst.close();
			}
            
        }
        
        return matricula;
    }
	
	public void add(Matricula matricula){
        Connection conexao = null;
        
        String procedure = "{call ssi_0073156_add_matricula(?, ?, ?)}";
        
        try {
        	CallableStatement clst = Conexao.getConexao().prepareCall(procedure);
        	clst.setInt(1, matricula.getTurma().getId());
        	clst.setInt(2, matricula.getAluno().getId());
        	clst.setString(3, matricula.getDataMatricula());
        	clst.execute();
            clst.close();
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            Conexao.close(conexao);    
        }
    }
	
	public void edit(Matricula matricula) {
		Connection conexao = null;
		
		String procedure = "{call ssi_0073156_edit_matricula(?, ?, ?, ?,)}";
		
        try {
        	CallableStatement clst = Conexao.getConexao().prepareCall(procedure);
        	clst.setInt(1, matricula.getId());
        	clst.setInt(2, matricula.getTurma().getId());
        	clst.setInt(3, matricula.getAluno().getId());
        	clst.setString(4,matricula.getDataMatricula());
        	clst.execute();
            clst.close();
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            Conexao.close(conexao);    
        }
		
	}
	
	public void delete(Matricula matricula) {
		Connection conexao = null;
        
        try {
        	CallableStatement clst = Conexao.getConexao().prepareCall("{call ssi_0073156_delete_matricula(?)}");
            clst.setInt(1, matricula.getId());
            clst.execute();
            clst.close();
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            Conexao.close(conexao);    
        }
		
	}
	
	public List<Matricula> list() {
        List<Matricula> matriculas = new ArrayList<Matricula>();
        Connection conexao = null;
        
        try {
            Statement statement = Conexao.getConexao().createStatement();
            String query = "select MATRICULA_ID, TURMA_ID ALUNO_ID, DATA_MATRICULA FROM ssi_0073156_MATRICULAS";
         	
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
            	Matricula matricula = new Matricula();
            	Turma turma = rs.getInt("TURMA_ID") != 0 ? new TurmaDAO().load(rs.getInt("TURMA_ID")) : new Turma();
            	Aluno aluno = rs.getInt("ALUNO_ID") != 0 ? new AlunoDAO().load(rs.getInt("ALUNO_ID")) : new Aluno();
            	
            	matricula.setId(rs.getInt("MATRICULA_ID"));
            	matricula.setTurma(turma);
            	matricula.setAluno(aluno);
            	matricula.setDataMatricula(rs.getString("DATA_INICIO"));
            	
                //adiciona na lista
            	matriculas.add(matricula);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            Conexao.close(conexao);
        }
        
        return matriculas;
    }

}
