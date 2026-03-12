package src.Interfaz;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import src.Reportes.Token;
import src.Reportes.ErrorL;

public class VentanaReporte extends JDialog {

    public VentanaReporte(JFrame parent, String titulo, String[] columnas, List<?> datos) {
        super(parent, titulo, true); 
        setSize(600, 400);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        // Tabla
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
        JTable tabla = new JTable(modelo);
        tabla.setFillsViewportHeight(true);

        
        for (Object obj : datos) {
            if (obj instanceof Token) {
                Token t = (Token) obj;
                modelo.addRow(new Object[]{t.tipo, t.lexema, t.linea + 1, t.columna + 1});
            } else if (obj instanceof ErrorL) {
                ErrorL e = (ErrorL) obj;
                modelo.addRow(new Object[]{e.tipo, e.descripcion, e.linea + 1, e.columna + 1});
            }
        }

        add(new JScrollPane(tabla), BorderLayout.CENTER);

        // Botón cerrar
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> dispose());
        add(btnCerrar, BorderLayout.SOUTH);
    }
}
