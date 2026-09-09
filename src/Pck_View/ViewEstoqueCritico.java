package Pck_View;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.*;
import java.awt.*;

public class ViewEstoqueCritico extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {

        // Obtém o componente original (a célula)
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Convertemos o índice da linha, caso a tabela esteja filtrada/ordenada
        int modelRow = table.convertRowIndexToModel(row);

        // Pegamos os valores das colunas 2 (Quantidade) e 3 (Qtd_Minima) do modelo
        try {
            Object qtdObj = table.getModel().getValueAt(modelRow, 2);
            Object minObj = table.getModel().getValueAt(modelRow, 3);

            if (qtdObj != null && minObj != null) {
                int qtd = Integer.parseInt(qtdObj.toString());
                int min = Integer.parseInt(minObj.toString());

                if (qtd < min) {
                    c.setBackground(new Color(255, 100, 100));
                    c.setForeground(Color.BLACK);

                    if (isSelected) {
                        c.setBackground(new Color(200, 0, 0));
                        c.setForeground(Color.WHITE);
                    }
                } else {
                    // Restaura cores para linhas normais
                    if (isSelected) {
                        c.setBackground(table.getSelectionBackground());
                        c.setForeground(table.getSelectionForeground());
                    } else {
                        c.setBackground(table.getBackground());
                        c.setForeground(table.getForeground());
                    }
                }
            }
        } catch (Exception ex) {
        }

        return c;
    }
}