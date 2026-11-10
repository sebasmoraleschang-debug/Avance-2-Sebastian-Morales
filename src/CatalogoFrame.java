import javax.swing.*;
import java.awt.*;

public class CatalogoFrame extends JFrame {
    private JComboBox<String> cmbGrupoMuscular;
    private JTextField txtBuscar;
    private DefaultListModel<String> listModel;
    private JList<String> listEjercicios;
    private JTextArea txtInstrucciones;
    private JLabel lblTituloEjercicio;

    public CatalogoFrame() {
        setTitle("Fidness - Catálogo de ejercicios");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelNavegacion = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelNavegacion.add(new JLabel("FIDNESS     "));
        panelNavegacion.add(new JButton("Catálogo de ejercicios"));
        panelNavegacion.add(new JButton("Constructor de rutina"));
        panelNavegacion.add(new JButton("Mis rutinas"));
        add(panelNavegacion, BorderLayout.NORTH);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setDividerLocation(350);

        JPanel panelIzquierdo = new JPanel(new BorderLayout());
        panelIzquierdo.setBorder(BorderFactory.createTitledBorder("Ejercicios"));

        JPanel panelFiltros = new JPanel(new GridLayout(4, 1, 0, 5));
        cmbGrupoMuscular = new JComboBox<>(new String[]{"Todos", "Pierna", "Espalda", "Brazo", "Pecho", "Hombro", "Abdomen"});
        cmbGrupoMuscular.setBorder(BorderFactory.createTitledBorder("Grupo muscular"));
        
        JPanel panelBusqueda = new JPanel(new BorderLayout());
        txtBuscar = new JTextField();
        txtBuscar.setBorder(BorderFactory.createTitledBorder("Buscar por nombre"));
        JButton btnBuscar = new JButton("Buscar");
        panelBusqueda.add(txtBuscar, BorderLayout.CENTER);
        panelBusqueda.add(btnBuscar, BorderLayout.EAST);

        panelFiltros.add(cmbGrupoMuscular);
        panelFiltros.add(panelBusqueda);
        panelIzquierdo.add(panelFiltros, BorderLayout.NORTH);

        listModel = new DefaultListModel<>();
        listModel.addElement("Sentadilla con barra - Pierna");
        listModel.addElement("Prensa de piernas - Pierna");
        listModel.addElement("Zancadas con mancuernas - Pierna");
        listEjercicios = new JList<>(listModel);
        panelIzquierdo.add(new JScrollPane(listEjercicios), BorderLayout.CENTER);

        JPanel panelDerecho = new JPanel(new BorderLayout());
        panelDerecho.setBorder(BorderFactory.createTitledBorder("Cómo se ejecuta"));

        lblTituloEjercicio = new JLabel("Seleccione un ejercicio", SwingConstants.LEFT);
        lblTituloEjercicio.setFont(new Font("Arial", Font.BOLD, 16));
        panelDerecho.add(lblTituloEjercicio, BorderLayout.NORTH);

        txtInstrucciones = new JTextArea();
        txtInstrucciones.setEditable(false);
        txtInstrucciones.setLineWrap(true);
        txtInstrucciones.setWrapStyleWord(true);
        txtInstrucciones.setText("*AQUÍ IRÍAN LOS PASOS DEL EJERCICIO*");
        panelDerecho.add(new JScrollPane(txtInstrucciones), BorderLayout.CENTER);

        JPanel panelBotonAgregar = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnAgregarRutina = new JButton("+ Agregar a mi rutina");
        panelBotonAgregar.add(btnAgregarRutina);
        panelDerecho.add(panelBotonAgregar, BorderLayout.SOUTH);

        splitPane.setLeftComponent(panelIzquierdo);
        splitPane.setRightComponent(panelDerecho);
        add(splitPane, BorderLayout.CENTER);

        listEjercicios.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && listEjercicios.getSelectedValue() != null) {
                String seleccionado = listEjercicios.getSelectedValue();
                lblTituloEjercicio.setText(seleccionado.split("-")[0].trim());
                txtInstrucciones.setText("1. Mantenga la espalda recta.\n2. Baje lentamente.\n3. Vuelva a la posición inicial.");
            }
        });
    }
}