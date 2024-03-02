package DAO;

import conexao.Conexao;
import entity.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    public boolean validarLogin(String username, String password) {
        try {
            Connection conn = Conexao.getConnection();
            String sql = "SELECT id, nome, login, senha, email FROM usuario WHERE login = ? AND senha = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            boolean isValid = rs.next();
            conn.close();
            return isValid;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean cadastrarUsuario(String nome, String username, String password, String email) {
        try {
            Connection conn = Conexao.getConnection();
            String sql = "INSERT INTO usuario(nome, login, senha, email) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, username);
            stmt.setString(3, password);
            stmt.setString(4, email);

            int rowsInserted = stmt.executeUpdate();
            conn.close();

            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
