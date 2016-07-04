package com.gerenciador.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.gerenciador.model.Usuario;

/**
 *
 * @author Cássio
 */
public class UsuarioDAO {
    
	public Usuario load(int id) throws SQLException, ParseException{
        Connection conexao = null;
        CallableStatement clst = null;
        
        Usuario usuario = new Usuario();
        String procedure = "{call ssi_0073156_get_usuario(?, ?, ?, ?)}";
        
        try {
        	clst = Conexao.getConexao().prepareCall(procedure);
            
        	clst.setInt(1, id);
        	clst.registerOutParameter(2, java.sql.Types.VARCHAR);
        	clst.registerOutParameter(3, java.sql.Types.VARCHAR);
        	clst.registerOutParameter(4, java.sql.Types.VARCHAR);
        	
			// execute ssi_0073156_get_usuario store procedure
        	clst.executeUpdate();
        
        	usuario.setId(id);
        	usuario.setNome(clst.getString(2));
        	usuario.setEmail(clst.getString(3));
        	usuario.setSenha(clst.getString(4));
        	
        
        } catch(SQLException e) {
			System.out.println(e.getMessage());
        } finally {
            Conexao.close(conexao);
            
            if (clst != null) {
            	clst.close();
			}
            
        }
        
        return usuario;
    }
    
    public void add(Usuario usuario){
        Connection conexao = null;
        
        String procedure = "{call ssi_0073156_add_usuario(?, ?, ?)}";
        
        try {
        	CallableStatement clst = Conexao.getConexao().prepareCall(procedure);
        	clst.setString(1, usuario.getNome());
        	clst.setString(2, usuario.getEmail());
        	clst.setString(3, usuario.getSenha());
        	clst.execute();
            clst.close();
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            Conexao.close(conexao);    
        }
    }
    
    public void edit(Usuario usuario) {
		Connection conexao = null;
		
		String procedure = "{call ssi_0073156_edit_usuario(?, ?, ?, ?)}";
		
        try {
        	CallableStatement clst = Conexao.getConexao().prepareCall(procedure);
        	clst.setInt(1, usuario.getId());
        	clst.setString(2, usuario.getNome());
        	clst.setString(3, usuario.getEmail());
        	clst.setString(4, usuario.getSenha());
            clst.execute();
            clst.close();
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            Conexao.close(conexao);    
        }
		
	}
    
    public void delete(Usuario usuario) {
		Connection conexao = null;
        
        try {
        	CallableStatement clst = Conexao.getConexao().prepareCall("{call ssi_0073156_delete_usuario(?)}");
            clst.setInt(1, usuario.getId());
            clst.execute();
            clst.close();
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            Conexao.close(conexao);    
        }
		
	}
    
    //retorna lista de usuários
    public List<Usuario> list() {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        Connection conexao = null;
        
        try {
            Statement statement = Conexao.getConexao().createStatement();
            ResultSet rs = statement.executeQuery("select * from SSI_0073156_usuarios");
            while (rs.next()) {
                Usuario usuario = new Usuario();
        
                usuario.setId(rs.getInt("usuario_id"));
                usuario.setNome(rs.getString("usuario_nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                
                //adiciona na lista
                usuarios.add(usuario);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            Conexao.close(conexao);
        }
        
        return usuarios;
    }
    public Usuario Login(String email, String senha) throws SQLException, ParseException{
    	Connection conexao = null;
        CallableStatement clst = null;
        
        Usuario usuario = new Usuario();
        String procedure = "{call ssi_0073156_login_usuario(?, ?, ? ,?)}";
        
        try {
        	clst = Conexao.getConexao().prepareCall(procedure);
            
        	clst.setString(1, email);
        	clst.setString(2, senha);
        	clst.registerOutParameter(3, java.sql.Types.INTEGER);
        	clst.registerOutParameter(4, java.sql.Types.VARCHAR);
        	
			// execute ssi_0073156_login_usuario store procedure
        	clst.executeUpdate();
        
        	usuario.setId(clst.getInt(3));
        	usuario.setNome(clst.getString(4));
        	usuario.setEmail(email);
        	usuario.setSenha(senha);
        	usuario.setLogado(true);
        
        } catch(SQLException e) {
			System.out.println(e.getMessage());
        } finally {
            Conexao.close(conexao);
            
            if (clst != null) {
            	clst.close();
			}
            
        }
        
        return usuario;
    }
    
}
