package Pck_View;

import Pck_Model.Model;
import Pck_Procedure.Procedure;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.List;

public class ViewItens extends JFrame implements ActionListener {
    JButton btVoltar = new JButton();
    JTable tabela = new JTable();
    DefaultTableModel modelo = new DefaultTableModel();

    public ViewItens(String codigoVenda ) {
        setTitle("Recanto dos Pássaros - Itens");
        setBounds(0, 100, 650, 450);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);
        setVisible(true);

        getContentPane().setBackground(new Color(245,235,221));
        Color botaoSecundario = new Color(236, 221, 208);
        // COR PADRÃO TEXTO
        Color textoCor = new Color(81, 38, 21);
        // COR BOTÃO CLARO
        Color botaoClaro = new Color(236, 223, 210);
        // COR BORDA BOTÃO
        Color bordaBotao = new Color(81, 38, 21);

        // LOGO
        URL img = getClass().getResource("/Pck_Imagem/logotipo.png");

        JScrollPane scroll = new JScrollPane(tabela);
        scroll.setBounds(10, 15, 615, 325);
        getContentPane().add(scroll);

        modelo.addColumn("COD_ITEM");
        modelo.addColumn("COD_PROD");
        modelo.addColumn("PRODUTO");
        modelo.addColumn("PREÇO");
        modelo.addColumn("QUANTIDADE");
        tabela.setModel(modelo);

        //TABELA COR
        tabela.setGridColor(new Color (220,210,200));
        tabela.setBackground(Color.WHITE);
        tabela.setForeground(textoCor);
        tabela.setSelectionBackground(botaoSecundario);
        tabela.setSelectionForeground(textoCor);
        tabela.setRowHeight(28);

        //IMPEDE QUE O USUARIO REDIMENSIONE A TABELA OU MUDE A ORDEM
         tabela.getTableHeader().setReorderingAllowed(false);
         tabela.getTableHeader().setResizingAllowed(false);
         tabela.getTableHeader().setBackground(botaoSecundario);
         tabela.getTableHeader().setForeground(textoCor);

        // MODIFICA A FONTE DA TABELA
        tabela.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

        //BOTAO VOLTAR
        btVoltar.setText("VOLTAR");
        btVoltar.setBounds(10, 355, 120, 50);
        btVoltar.setFont(new Font("Arial", Font.BOLD, 15));
        btVoltar.setBorder(new LineBorder(bordaBotao,1));
        btVoltar.setForeground(textoCor);
        btVoltar.setBackground(botaoClaro);
        btVoltar.setFocusPainted(false);
        btVoltar.addActionListener(this);
        getContentPane().add(btVoltar);

        Procedure item = new Procedure();
        List<Model> lista = item.Item(Integer.parseInt(codigoVenda));
        for (int i = 0; i < lista.size(); i++) {
            Model m = lista.get(i);
            modelo.addRow(new Object[]{
                   m.getCod_item(),
                   m.getCod_produtoFK(),
                   m.getProdutoFK(),
                   m.getPrecoFK(),
                   m.getQuantidadeFK()
            });
        }

        // ÍCONE
        URL url = getClass().getResource("/Pck_Imagem/bird.png");

        if (url != null) {
            ImageIcon icon = new ImageIcon(url);
            setIconImage(icon.getImage());
        }

    }

    // AÇÃO PARA VOLTAR
    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == btVoltar) {
            this.dispose();
        }
    }
}























