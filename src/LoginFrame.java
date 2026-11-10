import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtContrasena;
    private JLabel lblMensaje;

    public LoginFrame() {
        setTitle("Fidness - Inicio de sesión");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelCentro = new JPanel(new GridLayout(6, 1, 5, 5));
        panelCentro.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JLabel lblTitulo = new JLabel("FIDNESS", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        JLabel lblSubtitulo = new JLabel("Consulte ejercicios y cree sus rutinas de entrenamiento", SwingConstants.CENTER);
        
        txtUsuario = new JTextField();
        txtUsuario.setBorder(BorderFactory.createTitledBorder("Usuario"));
        
        txtContrasena = new JPasswordField();
        txtContrasena.setBorder(BorderFactory.createTitledBorder("Contraseña"));

        lblMensaje = new JLabel("", SwingConstants.CENTER);
        lblMensaje.setForeground(Color.RED);

        JButton btnIngresar = new JButton("Ingresar");
        
        panelCentro.add(lblTitulo);
        panelCentro.add(lblSubtitulo);
        panelCentro.add(txtUsuario);
        panelCentro.add(txtContrasena);
        panelCentro.add(lblMensaje);
        panelCentro.add(btnIngresar);

        JPanel panelSur = new JPanel(new GridLayout(2, 1));
        JButton btnRegistro = new JButton("¿Aún no tiene cuenta? Regístrese aquí");
        btnRegistro.setContentAreaFilled(false);
        btnRegistro.setBorderPainted(false);
        
        JLabel lblEstado = new JLabel("Conectado al servidor localhost:5000");
        lblEstado.setFont(new Font("Arial", Font.PLAIN, 10));
        
        panelSur.add(btnRegistro);
        panelSur.add(lblEstado);

        add(panelCentro, BorderLayout.CENTER);
        add(panelSur, BorderLayout.SOUTH);

        btnIngresar.addActionListener(e -> {
            String usuario = txtUsuario.getText();
            String clave = new String(txtContrasena.getPassword());
            
            if (usuario.isEmpty() || clave.isEmpty()) {
                lblMensaje.setText("Credenciales incorrectas. Intente de nuevo.");
            } else if (usuario.equals("smorales") && clave.equals("123456")) {
                JOptionPane.showMessageDialog(null, "Bienvenido a Fidness");
            } else {
                lblMensaje.setText("Credenciales incorrectas. Intente de nuevo.");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginFrame().setVisible(true));
    }
}