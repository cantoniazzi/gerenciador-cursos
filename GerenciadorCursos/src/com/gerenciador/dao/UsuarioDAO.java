package com.gerenciador.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.gerenciador.model.Usuario;

/**
 *
 * @author Cássio
 */
public class UsuarioDAO {
    
    //adiciona usuário
    public String adicionar(Usuario usuario){
        String retorno = "falha";
        String consulta = "";
        Conexao conexao = new Conexao();
        Connection conn = null;
        try {
            Statement stmt = (Statement) conexao.getConexao().createStatement();
            
            consulta = " insert into usuarios(tipo, login, senha) " +
                       " values('" + usuario.getTipo() + "','" + usuario.getLogin() + "','" + usuario.getSenha() + "')";
            stmt.execute(consulta);
            retorno = "usuário adicionado com sucesso!";
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            conexao.close(conn);
        }
        return retorno;
    }
    
    //retorna lista de usuários
    public List<Usuario> listar() {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        Conexao conexao = new Conexao();
        Connection conn = null;
        
        try {
            Statement statement = conexao.getConexao().createStatement();
            ResultSet rs = statement.executeQuery("select * from usuarios");
            while (rs.next()) {
                Usuario usuario = new Usuario();
        
                usuario.setId(rs.getInt("usuario_id"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTipo(rs.getString("tipo"));
                
                //adiciona na lista
                usuarios.add(usuario);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            conexao.close(conn);
        }
        
        return usuarios;
    }
    public Usuario Login(String email, String senha){
        Conexao conexao = new Conexao();
        Connection conn = null;
        String consulta =  "select * from SSI_0073156_USUARIOS where email = '" + email + "' and senha = '" + senha + "'";
        Usuario usuario = new Usuario();
        
        try{
            Statement statement = conexao.getConexao().createStatement();
            ResultSet rs = statement.executeQuery(consulta);
            while (rs.next()) {
                usuario.setId(rs.getInt("usuario_id"));
                usuario.setLogin(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setLogado(true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            conexao.close(conn);
        }
        return usuario;
    }
    
}
