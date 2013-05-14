package br.com.luguia.arceus.view.gui.inicializacao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class ConfigSql extends JFrame {

        private JPanel contentPane;
        private final JPanel panel = new JPanel();
        private JTextField textField;
        private JTextField textField_1;
        private JTextField textField_2;

        
        public ConfigSql() {
                setTitle("Setings");
                setResizable(false);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setBounds(100, 100, 300, 300);
                contentPane = new JPanel();
                contentPane.setBackground(Color.WHITE);
                contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                setContentPane(contentPane);
                contentPane.setLayout(null);
                panel.setBackground(UIManager.getColor("Button.focus"));
                panel.setBounds(0, 0, 294, 271);
                contentPane.add(panel);
                panel.setLayout(null);
                
                textField = new JTextField();
                textField.setForeground(new Color(0, 0, 0));
                textField.setBackground(new Color(255, 255, 255));
                textField.setBounds(10, 36, 274, 28);
                panel.add(textField);
                textField.setColumns(10);
                
                textField_1 = new JTextField();
                textField_1.setBounds(10, 100, 274, 28);
                panel.add(textField_1);
                textField_1.setColumns(10);
                
                textField_2 = new JTextField();
                textField_2.setBounds(10, 166, 274, 28);
                panel.add(textField_2);
                textField_2.setColumns(10);
                
                JLabel lblNewLabel = new JLabel("Host");
                lblNewLabel.setForeground(new Color(25, 25, 112));
                lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 13));
                lblNewLabel.setBounds(10, 11, 46, 14);
                panel.add(lblNewLabel);
                
                JLabel lblNewLabel_1 = new JLabel("User");
                lblNewLabel_1.setForeground(new Color(25, 25, 112));
                lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 13));
                lblNewLabel_1.setBounds(10, 75, 46, 14);
                panel.add(lblNewLabel_1);
                
                JLabel lblNewLabel_2 = new JLabel("Pass");
                lblNewLabel_2.setForeground(new Color(25, 25, 112));
                lblNewLabel_2.setFont(new Font("Calibri", Font.PLAIN, 13));
                lblNewLabel_2.setBounds(10, 141, 46, 14);
                panel.add(lblNewLabel_2);
                
                JButton btnNewButton = new JButton("Continuar");
                btnNewButton.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		new TipoEscolha().setVisible(true);
                		
                	
                		dispose();
                	}
                });
                btnNewButton.setFont(new Font("Calibri", Font.BOLD, 13));
                btnNewButton.setForeground(new Color(0, 0, 255));
                btnNewButton.setBackground(UIManager.getColor("CheckBox.foreground"));
                btnNewButton.setBounds(179, 220, 105, 40);
                panel.add(btnNewButton);
                
                JButton btnVoltar = new JButton("Voltar");
                btnVoltar.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		new EscolhaBanco().setVisible(true);
                		
                		
                		dispose();
                		
                	}
                });
                btnVoltar.setFont(new Font("Calibri", Font.BOLD, 13));
                btnVoltar.setBackground(UIManager.getColor("CheckBox.foreground"));
                btnVoltar.setForeground(new Color(0, 0, 255));
                btnVoltar.setBounds(10, 220, 105, 40);
                panel.add(btnVoltar);
        }
}
