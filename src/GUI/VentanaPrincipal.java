package src.Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import src.Analizadores.Lexico;
import src.Analizadores.Sintactico;
import java.io.StringReader;

public class VentanaPrincipal extends JFrame {

    private JTextArea txtEditor;
    private JTextArea txtConsola;
    private JButton btnAnalizar, btnTokens, btnErrores;

    public VentanaPrincipal() {
        setTitle("ELI NoSQL - IDE Educativo");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // --- Panel Superior: Botones ---
        JPanel panelBotones = new JPanel();
        btnAnalizar = new JButton("▶ Ejecutar Análisis");
        btnTokens = new JButton("Ver Tokens");
        btnErrores = new JButton("Ver Errores");
        
        panelBotones.add(btnAnalizar);
        panelBotones.add(btnTokens);
        panelBotones.add(btnErrores);
        add(panelBotones, BorderLayout.NORTH);

        // --- Panel Central: Editor y Consola ---
        txtEditor = new JTextArea();
        txtEditor.setFont(new Font("Consolas", Font.PLAIN, 14));
        JScrollPane scrollEditor = new JScrollPane(txtEditor);
        scrollEditor.setBorder(BorderFactory.createTitledBorder("Editor de Código ELI"));

        txtConsola = new JTextArea();
        txtConsola.setEditable(false);
        txtConsola.setBackground(Color.BLACK);
        txtConsola.setForeground(Color.GREEN);
        JScrollPane scrollConsola = new JScrollPane(txtConsola);
        scrollConsola.setPreferredSize(new Dimension(0, 150));
        scrollConsola.setBorder(BorderFactory.createTitledBorder("Consola de Salida"));

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, scrollEditor, scrollConsola);
        splitPane.setDividerLocation(450);
        add(splitPane, BorderLayout.CENTER);

        // --- Eventos ---
        btnAnalizar.addActionListener(e -> ejecutarAnalisis());
    }

    private void ejecutarAnalisis() {
        String entrada = txtEditor.getText();
        if (entrada.isEmpty()) return;

        // Limpiar reportes previos
        src.Reportes.TablaTokens.listaTokens.clear();
        src.Reportes.TablaErrores.listaErrores.clear();
        txtConsola.setText("Iniciando análisis...\n");

        try {
            Lexico lexico = new Lexico(new StringReader(entrada));
            Sintactico sintactico = new Sintactico(lexico);
            sintactico.parse();

            txtConsola.append(">>> Análisis finalizado correctamente.\n");
        } catch (Exception ex) {
            txtConsola.append(">>> Error crítico durante el análisis: " + ex.getMessage() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });
    }
}
