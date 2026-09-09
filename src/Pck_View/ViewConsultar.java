package Pck_View;

import Pck_Model.Model;
import Pck_Procedure.Procedure;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.List;

public class ViewConsultar extends JFrame implements ActionListener {

    JTable tabela = new JTable();
    DefaultTableModel modelo = new DefaultTableModel();
    JButton btEditar = new JButton();
    JButton btRemover = new JButton();
    JButton btOk = new JButton();
    TableRowSorter<DefaultTableModel> sorter;
    JTextField txtFiltro = new JTextField();
    JLabel filtro = new JLabel();

    public static ViewConsultar instanciaAtiva = null;

    public ViewConsultar() {

        setTitle("Recanto dos Pássaros - Consultar");
        setBounds(100, 100, 860, 560);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().setBackground(new Color(245, 235, 221));

        // COR PRIMÁRIA TEXTO
        Color textoCor = new Color(81, 38, 21);

        // COR BOTÃO CLARO
        Color botaoClaro = new Color(236, 223, 210);

        // COR BOTÃO PRIMÁRIO
        Color botaoPrimario = new Color(224, 204, 186);

        // COR BOTÃO ALERTA
        Color botaoAlerta = new Color(215, 170, 170);

        // COR BORDA BOTÃO
        Color bordaBotao = new Color(81, 38, 21);

        // TÍTULO
        JLabel titulo = new JLabel("CONSULTAR");
        titulo.setBounds(0, 10, 860, 35);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 28));
        titulo.setForeground(textoCor);
        getContentPane().add(titulo);

        // TEXTO FILTRO
        filtro.setText("Filtre os produtos pelo nome ou pela data:");
        filtro.setBounds(0, 55, 860, 20);
        filtro.setHorizontalAlignment(SwingConstants.CENTER);
        filtro.setFont(new Font("Arial", Font.BOLD, 15));
        filtro.setForeground(textoCor);
        getContentPane().add(filtro);

        // CAMPO FILTRO
        txtFiltro.setBounds(275, 82, 310, 30);
        txtFiltro.setFont(new Font("Arial", Font.PLAIN, 15));
        txtFiltro.setBorder(new LineBorder(bordaBotao, 1));
        getContentPane().add(txtFiltro);

        // TABELA
        JScrollPane scroll = new JScrollPane(tabela);

        // área da tabela
        scroll.setBounds(20, 130, 800, 300);

        getContentPane().add(scroll);

        modelo.addColumn("CÓDIGO");
        modelo.addColumn("PRODUTO");
        modelo.addColumn("QUANTIDADE");
        modelo.addColumn("QTD_MÍNIMA");
        modelo.addColumn("PREÇO");
        modelo.addColumn("DATA");
        modelo.addColumn("REGISTRO");

        tabela.setModel(modelo);

        // p/ não permitir que o usuário consiga expandir e ordenar os registros/tuplas
        tabela.getTableHeader().setReorderingAllowed(false);
        tabela.getTableHeader().setResizingAllowed(false);

        tabela.setBackground(Color.WHITE);
        tabela.setForeground(textoCor);
        tabela.setGridColor(new Color(220, 210, 200));
        tabela.setSelectionBackground(botaoClaro);
        tabela.setSelectionForeground(textoCor);
        tabela.setRowHeight(28);

        tabela.getTableHeader().setBackground(botaoClaro);
        tabela.getTableHeader().setForeground(textoCor);
        tabela.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

        // tamanho das colunas/atributos
        tabela.getColumnModel().getColumn(0).setPreferredWidth(80);   // CÓDIGO
        tabela.getColumnModel().getColumn(1).setPreferredWidth(180);  // PRODUTO
        tabela.getColumnModel().getColumn(2).setPreferredWidth(120);  // QUANTIDADE
        tabela.getColumnModel().getColumn(3).setPreferredWidth(140);  // QTD_MÍNIMA
        tabela.getColumnModel().getColumn(4).setPreferredWidth(90);   // PREÇO
        tabela.getColumnModel().getColumn(5).setPreferredWidth(120);  // DATA
        tabela.getColumnModel().getColumn(6).setPreferredWidth(180);  // REGISTRO

        ViewEstoqueCritico rend = new ViewEstoqueCritico();

        for (int i = 0; i < tabela.getColumnCount(); i++) {
            tabela.getColumnModel().getColumn(i).setCellRenderer(rend);
        }

        sorter = new TableRowSorter<>(modelo);
        tabela.setRowSorter(sorter);

        // FILTRAGEM DINÂMICA
        txtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                aplicarFiltro();
            }
        });

        // CONSULTA
        Procedure consulta = new Procedure();

        List<Model> lista = consulta.Consulta();

        for (int i = 0; i < lista.size(); i++) {

            Model m = lista.get(i);

            modelo.addRow(new Object[]{
                    m.getCodigo(),
                    m.getNome(),
                    m.getQuantidade(),
                    m.getQuantidade_min(),
                    m.getPreco(),
                    m.getData(),
                    m.getRegistro()
            });
        }

        // BOTÃO REMOVER
        btRemover.setText("REMOVER");
        btRemover.setBounds(40, 455, 160, 40);
        btRemover.setFont(new Font("Arial", Font.BOLD, 15));
        btRemover.setBackground(botaoAlerta);
        btRemover.setForeground(textoCor);
        btRemover.setBorder(new LineBorder(bordaBotao, 1));
        btRemover.setFocusPainted(false);
        btRemover.addActionListener(this);
        getContentPane().add(btRemover);

        // BOTÃO EDITAR
        btEditar.setText("EDITAR");
        btEditar.setBounds(350, 455, 160, 40);
        btEditar.setFont(new Font("Arial", Font.BOLD, 15));
        btEditar.setBackground(botaoClaro);
        btEditar.setForeground(textoCor);
        btEditar.setBorder(new LineBorder(bordaBotao, 1));
        btEditar.setFocusPainted(false);
        btEditar.addActionListener(this);
        getContentPane().add(btEditar);

        // BOTÃO OK
        btOk.setText("OK");
        btOk.setBounds(650, 455, 160, 40);
        btOk.setFont(new Font("Arial", Font.BOLD, 15));
        btOk.setBackground(botaoPrimario);
        btOk.setForeground(textoCor);
        btOk.setBorder(new LineBorder(bordaBotao, 1));
        btOk.setFocusPainted(false);
        btOk.addActionListener(this);
        getContentPane().add(btOk);

        URL url = getClass().getResource("/Pck_Imagem/bird.png");

        if (url != null) {
            ImageIcon icon = new ImageIcon(url);
            setIconImage(icon.getImage());
        }

        recarregarDadosTabela();
        instanciaAtiva = this;

// Garante que se o usuário fechar a janela, o ponteiro fica nulo
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                instanciaAtiva = null;
            }
        });

        setVisible(true);
    }

    public void recarregarDadosTabela() {
        modelo.setRowCount(0); // Limpa a tabela atual
        Procedure consulta = new Procedure();
        List<Model> lista = consulta.Consulta();

        for (Model m : lista) {
            modelo.addRow(new Object[]{
                    m.getCodigo(),
                    m.getNome(),
                    m.getQuantidade(),
                    m.getQuantidade_min(),
                    m.getPreco(),
                    m.getData(),
                    m.getRegistro()
            });
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btEditar) {

            ViewEditar upt = new ViewEditar();
            upt.setVisible(true);

        } else if (e.getSource() == btRemover) {

            ViewRemover del = new ViewRemover();
            del.setVisible(true);

        } else if (e.getSource() == btOk) {

            dispose();
        }
    }

    // FILTRAGEM
    private void aplicarFiltro() {

        String texto = txtFiltro.getText();

        if (texto.trim().length() == 0) {

            sorter.setRowFilter(null);

        } else {

            sorter.setRowFilter(
                    RowFilter.regexFilter("(?i)" + texto)
            );
        }
    }
}