/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Telas;




import DAO.UsuarioDAO;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 



public class TelaLogin extends javax.swing.JFrame {

    
     private JTextField txtUsername;
    private JPasswordField txtPassword;

   
    public TelaLogin() {
       
       setTitle("Tela de Login");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel lblUsername = new JLabel("Login:");
        JLabel lblPassword = new JLabel("Senha:");

        txtUsername = new JTextField();
        txtPassword = new JPasswordField();

        JButton btnLogin = new JButton("Entrar");
        JButton btnRegister = new JButton("Cadastrar Novo Usuário");
        
    btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String password = new String(txtPassword.getPassword());

                UsuarioDAO usuarioDAO = new UsuarioDAO();
                if (usuarioDAO.validarLogin(username, password)) {
                    JOptionPane.showMessageDialog(null, "Acesso Autorizado");
                    // Faça o redirecionamento ou ação desejada aqui
                } else {
                    JOptionPane.showMessageDialog(null, "Acesso Negado");
                }
            }
        });
    
    btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a tela de login
                new TelaCadastro().setVisible(true); // Abre a tela de cadastro
            }
        });

        panel.add(lblUsername);
        panel.add(txtUsername);
        panel.add(lblPassword);
        panel.add(txtPassword);
        panel.add(btnLogin);
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
        
         SwingUtilities.invokeLater(new Runnable()  {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
