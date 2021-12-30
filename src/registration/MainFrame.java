package registration;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;



public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtnome;
	private JTextField txtcognome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("REGISTRAZIONE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 723, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("cognome");
		lblNewLabel.setBounds(21, 86, 114, 41);
		contentPane.add(lblNewLabel);
		
		txtnome = new JTextField();
		txtnome.setBounds(21, 57, 96, 19);
		contentPane.add(txtnome);
		txtnome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("nome");
		lblNewLabel_1.setBounds(21, 28, 114, 41);
		contentPane.add(lblNewLabel_1);
		
		txtcognome = new JTextField();
		txtcognome.setColumns(10);
		txtcognome.setBounds(21, 122, 96, 19);
		contentPane.add(txtcognome);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = txtnome.getText();
				String cognome = txtcognome.getText();
				
				Connection con1;
				PreparedStatement insert;
				
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
					
					insert = con1.prepareStatement("insert into record(nome,cognome) values (?,?)");
					
					insert.setString(1, nome);
					insert.setString(2, cognome);
					
					insert.executeUpdate();
					
					JOptionPane.showMessageDialog(btnNewButton, "Utente aggiunto!");
					
					txtnome.setText("");
					txtcognome.setText("");
					
					
					
					
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(21, 178, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(21, 209, 85, 21);
		contentPane.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(21, 243, 85, 21);
		contentPane.add(btnDelete);
	}
}
