import javax.swing.*;
import java.awt.*;

public class RegistroFrame extends JFrame {
    private JTextField txtNombreCompleto;
    private JTextField txtUsuario;
    private JPasswordField txtContrasena;
    private JPasswordField txtConfirmarContrasena;
    private JLabel lblMensaje;

    public RegistroFrame() {
        setTitle("Fidness - Registro de cliente");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelCentro = new JPanel(new GridLayout(8, 1, 5, 5));
        panelCentro.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));

        JLabel lblTitulo = new JLabel("Crear cuenta de cliente", SwingConstants.LEFT);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));

        txtNombreCompleto = new JTextField();
        txtNombreCompleto.setBorder(BorderFactory.createTitledBorder("Nombre completo"));

        txtUsuario = new JTextField();
        txtUsuario.setBorder(BorderFactory.createTitledBorder("Usuario"));

        txtContrasena = new JPasswordField();
        txtContrasena.setBorder(BorderFactory.createTitledBorder("Contraseña (mínimo 6 caracteres)"));

        txtConfirmarContrasena = new JPasswordField();
        txtConfirmarContrasena.setBorder(BorderFactory.createTitledBorder("Confirmar contraseña"));

        lblMensaje = new JLabel("Todos los campos son obligatorios", SwingConstants.LEFT);
        lblMensaje.setForeground(Color.DARK_GRAY);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnCancelar = new JButton("Cancelar");
        JButton btnCrearCuenta = new JButton("Crear cuenta");

        panelBotones.add(btnCancelar);
        panelBotones.add(btnCrearCuenta);

        panelCentro.add(lblTitulo);
        panelCentro.add(txtNombreCompleto);
        panelCentro.add(txtUsuario);
        panelCentro.add(txtContrasena);
        panelCentro.add(txtConfirmarContrasena);
        panelCentro.add(lblMensaje);

        add(panelCentro, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        btnCancelar.addActionListener(e -> dispose());

        btnCrearCuenta.addActionListener(e -> {
            try {
                validarRegistro();
            } catch (IllegalArgumentException ex) {
                lblMensaje.setText(ex.getMessage());
                lblMensaje.setForeground(Color.RED);
            }
        });
    }

    private void validarRegistro() {
        String usuario = txtUsuario.getText();
        String clave = new String(txtContrasena.getPassword());
        String confirmacion = new String(txtConfirmarContrasena.getPassword());

        if (usuario.isEmpty() || clave.isEmpty()) {
            throw new IllegalArgumentException("Todos los campos son obligatorios");
        }
        if (clave.length() < 6) {
            throw new IllegalArgumentException("La contraseña debe tener al menos 6 caracteres");
        }
        if (!clave.equals(confirmacion)) {
            throw new IllegalArgumentException("Las contraseñas no coinciden");
        }
        
        lblMensaje.setText("Cuenta creada exitosamente");
        lblMensaje.setForeground(new Color(0, 153, 0));
    }
}