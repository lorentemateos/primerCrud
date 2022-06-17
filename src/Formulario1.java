import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Formulario1 {

	private JFrame frmIntroducionDeMateriales;
	private JTextField caja1;
	private JTextField caja2;

	/**
	 * Launch the application.
	 */
	private void limpiarCuadrosDeTexto() {
		caja1.setText(null);
		caja2.setText(null);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario1 window = new Formulario1();
					window.frmIntroducionDeMateriales.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Formulario1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIntroducionDeMateriales = new JFrame();
		frmIntroducionDeMateriales.setFont(new Font("Dialog", Font.BOLD, 14));
		frmIntroducionDeMateriales.setTitle("Introducion de Materiales");
		frmIntroducionDeMateriales.setBounds(100, 100, 525, 376);
		frmIntroducionDeMateriales.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIntroducionDeMateriales.getContentPane().setLayout(null);
		
		caja1 = new JTextField();
		caja1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		caja1.setBounds(237, 57, 78, 19);
		frmIntroducionDeMateriales.getContentPane().add(caja1);
		caja1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Id Material");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(29, 60, 138, 13);
		frmIntroducionDeMateriales.getContentPane().add(lblNewLabel);
		
		caja2 = new JTextField();
		caja2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		caja2.setBounds(237, 110, 203, 19);
		frmIntroducionDeMateriales.getContentPane().add(caja2);
		caja2.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre del Material");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(29, 113, 138, 13);
		frmIntroducionDeMateriales.getContentPane().add(lblNewLabel_1);
		
		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					
					java.sql.Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/matriculabd","root","cf4b");
			
					String id_Mat=caja1.getText(), nomb_Mat=caja2.getText();
					
					String query="INSERT INTO materias(id_materia, nombre_materia) value('"+id_Mat+"','"+nomb_Mat+"')";
					 
					PreparedStatement stmt = conexion.prepareStatement("INSERT INTO matriculabd VALUES (?,?)");
					stmt.executeUpdate(query);
					JOptionPane.showMessageDialog(null,"Materia Agregada Campeon");
					limpiarCuadrosDeTexto();
					} catch(Exception e1) {
						JOptionPane.showMessageDialog(null,"ERROR");
						
					
				}
			}
		});
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnGuardar.setBounds(29, 190, 151, 21);
		frmIntroducionDeMateriales.getContentPane().add(btnGuardar);
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					
					java.sql.Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/matriculabd","root","cf4b");
			
					/*String id_Mat=caja1.getText(), nomb_Mat=caja2.getText();
					
					String query="UPDATE materias SET nombre_materia='"+nomb_Mat+"' WHERE id_materia="+id_Mat;

					PreparedStatement stmt = conexion.prepareStatement("UPDATE materia SET nombre_materia = ? Where id_materia = ?");
					JOptionPane.showMessageDialog(null,"marcador");

					stmt.executeUpdate(query);*/
					PreparedStatement stmt = conexion.prepareStatement("UPDATE materias SET nombre_materia = ? Where id_materia = ?");
					//String query="UPDATE materias SET id_materia='"+id_Mat+"', nombre_materia='"+nomb_Mat+" ");
					stmt.setString(1,caja2.getText());
					stmt.setString(2,caja1.getText());
					JOptionPane.showMessageDialog(null,"marcador");
					int resultado = stmt.executeUpdate();
					
					if(resultado > 0) {
						JOptionPane.showMessageDialog(null,"Materia Modificada Campeon");
						limpiarCuadrosDeTexto();
					}else JOptionPane.showMessageDialog(null,"Imposible Modificar Campeon");
					
					} catch(Exception e1) {
						JOptionPane.showMessageDialog(null,"ERROR");
						
					
				}
				
				
				
				
			}
		});
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnModificar.setBounds(273, 192, 151, 21);
		frmIntroducionDeMateriales.getContentPane().add(btnModificar);
		
		JButton btnBorrar = new JButton("BORRAR");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
				
					java.sql.Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/matriculabd","root","cf4b");
					PreparedStatement stmt = conexion.prepareStatement("DELETE FROM materias Where id_materia = ?");
					stmt.setString(1,caja1.getText());
				
					int resultado = stmt.executeUpdate();
					
					if(resultado > 0 ) {
						JOptionPane.showMessageDialog(null,"Registro Eliminado Manazas");
						limpiarCuadrosDeTexto();
					}else JOptionPane.showMessageDialog(null,"No se pudo eliminar PECADOR");
					
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null,"ERROR");
			
		}
	
			}
		});
		btnBorrar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBorrar.setBounds(29, 241, 151, 21);
		frmIntroducionDeMateriales.getContentPane().add(btnBorrar);
		 
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSalir.setBounds(273, 243, 151, 21);
		frmIntroducionDeMateriales.getContentPane().add(btnSalir);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
					
						Class.forName("com.mysql.jdbc.Driver");
					
						java.sql.Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/matriculabd","root","cf4b");
						PreparedStatement stmt = conexion.prepareStatement("Select nombre_materia from materias Where id_materia = ?");
						//String query="UPDATE materias SET id_materia='"+id_Mat+"', nombre_materia='"+nomb_Mat+" ");
						stmt.setString(1,caja1.getText());
						//stmt.setString(2,caja2.getText());
						ResultSet resultSet = null;
						resultSet = stmt.executeQuery();
						
						//JOptionPane.showMessageDialog(null,"marcador");
						//int resultado = stmt.executeUpdate();
						
						if(resultSet.next()) {
							caja2.setText(resultSet.getString("nombre_materia"));
						}else JOptionPane.showMessageDialog(null,"Identificador de Materia no Encontrado");
						
					}catch(Exception e1) {
						JOptionPane.showMessageDialog(null,"ERROR");
				
			}
		}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBuscar.setBounds(364, 55, 111, 21);
		frmIntroducionDeMateriales.getContentPane().add(btnBuscar);
	}
}
