
package Telas;

import DAO.UsuarioDAO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class TelaCadastro extends JFrame {
    private JTextField txtNome;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JTextField txtEmail;

    public TelaCadastro() {
        setTitle("Tela de Cadastro");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel lblNome = new JLabel("Nome:");
        JLabel lblUsername = new JLabel("Login:");
        JLabel lblPassword = new JLabel("Senha:");
        JLabel lblEmail = new JLabel("Email:");

        txtNome = new JTextField();
        txtUsername = new JTextField();
        txtPassword = new JPasswordField();
        txtEmail = new JTextField();

        JButton btnRegister = new JButton("Cadastrar");

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                String username = txtUsername.getText();
                String password = new String(txtPassword.getPassword());
                String email = txtEmail.getText();

                UsuarioDAO usuarioDAO = new UsuarioDAO();
                if (usuarioDAO.cadastrarUsuario(nome, username, password, email)) {
                    JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso");
                    dispose(); // Fecha a tela de cadastro
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário");
                }
            }
        });

        panel.add(lblNome);
        panel.add(txtNome);
        panel.add(lblUsername);
        panel.add(txtUsername);
        panel.add(lblPassword);
        panel.add(txtPassword);
        panel.add(lblEmail);
        panel.add(txtEmail);
        panel.add(btnRegister);

        add(panel);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {
   
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
