package FRONTEND;

import BACKEND.Pck_Model.Model;
import BACKEND.Pck_Procedure.Procedure;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.List;

public class ViewVendas extends JFrame implements ActionListener {

    JTable tabela = new JTable();

    DefaultTableModel modelo = new DefaultTableModel();

    JButton btItem = new JButton();
    JButton btRegVendas = new JButton();

    TableRowSorter<DefaultTableModel> sorter; // REALIZA A FILTRAGEM

    JTextField txtFiltro = new JTextField();

    JLabel filtro = new JLabel();

    public ViewVendas() {

        setTitle("Recanto dos Pássaros - Vendas");
        setBounds(0, 100, 650, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().setBackground(new Color(245, 235, 221));

        // COR PRIMÁRIA TEXTO
        Color textoCor = new Color(81, 38, 21);

        // COR BOTÃO PRIMÁRIO
        // (AÇÕES IMPORTANTES: OK, CADASTRAR, SALVAR, CONFIRMAR E VER ITENS)
        Color botaoPrimario = new Color(224, 204, 186);

        // COR BOTÃO SECUNDÁRIO
        // (AÇÕES NEUTRAS: CONSULTAR, VOLTAR, CANCELAR E FILTRAR)
        Color botaoSecundario = new Color(236, 221, 208);

        // COR BOTÃO DE ALERTA
        // (AÇÕES DE RISCO: REMOVER E EXCLUIR)
        Color botaoAlerta = new Color(215, 170, 170);

        // COR BORDA DOS BOTÕES
        Color bordaBotao = new Color(81, 38, 21);

        // TÍTULO
        JLabel titulo = new JLabel("VENDAS");
        titulo.setBounds(0, 10, 650, 35);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 28));
        titulo.setForeground(textoCor);
        getContentPane().add(titulo);

        // FILTRO
        filtro.setBounds(0, 50, 650, 20);
        filtro.setHorizontalAlignment(SwingConstants.CENTER);
        filtro.setText("Filtrar pelo código ou valor total:");
        filtro.setFont(new Font("Arial", Font.BOLD, 14));
        filtro.setForeground(textoCor);
        getContentPane().add(filtro);

        // CAMPO FILTRO
        txtFiltro.setBounds(170, 80, 310, 28);
        txtFiltro.setFont(new Font("Arial", Font.PLAIN, 15));
        txtFiltro.setBorder(new LineBorder(bordaBotao, 1));
        txtFiltro.setBackground(Color.WHITE);
        getContentPane().add(txtFiltro);

        // TABELA
        JScrollPane scroll = new JScrollPane(tabela);
        scroll.setBounds(10, 120, 615, 260);
        getContentPane().add(scroll);

        modelo.addColumn("CÓDIGO");
        modelo.addColumn("VALOR_TOTAL");

        tabela.setModel(modelo);
        // p/ não permitir que o usuário consiga expandir e ordernar os registros/tuplas
        tabela.getTableHeader().setReorderingAllowed(false);
        tabela.getTableHeader().setResizingAllowed(false);

        tabela.setBackground(Color.WHITE);
        tabela.setForeground(textoCor);
        tabela.setGridColor(new Color(220, 210, 200));
        tabela.setSelectionBackground(botaoSecundario);
        tabela.setSelectionForeground(textoCor);
        tabela.setRowHeight(28);

        tabela.getTableHeader().setBackground(botaoPrimario);
        tabela.getTableHeader().setForeground(textoCor);
        tabela.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

        sorter = new TableRowSorter<>(modelo); // RELACIONA COM O ROWSORTER PARA FAZER BUSCA DINAMICA
        tabela.setRowSorter(sorter);

        // EVENTO QUE INICIA A FILTRAGEM COM O TEXTO DIGITADO NO TEXTFIELD
        txtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyReleased(java.awt.event.KeyEvent evt) {

                aplicarFiltro();
            }
        });

        Procedure venda = new Procedure();
        List<Model> lista = venda.Venda();
        for (int i = 0; i < lista.size(); i++) {
            Model m = lista.get(i);
            modelo.addRow(new Object[]{
                    m.getCod_venda(),m.getValor_total()
            });
        }

        // BOTÃO DE REGISTRAR OS ITENS DA VENDA (PONTO DE VENDA)
        btRegVendas.setText("PONTO DE VENDA");
        btRegVendas.setBounds(100, 400, 250, 45);
        btRegVendas.setFont(new Font("Arial", Font.BOLD, 17));
        btRegVendas.setBackground(botaoPrimario);
        btRegVendas.setForeground(textoCor);
        btRegVendas.setBorder(new LineBorder(bordaBotao, 1));
        btRegVendas.setFocusPainted(false);
        btRegVendas.addActionListener(this);
        getContentPane().add(btRegVendas);

        // BOTÃO VER ITENS
        btItem.setText("VER ITENS");
        btItem.setBounds(370, 400, 180, 45);
        btItem.setFont(new Font("Arial", Font.BOLD, 17));
        btItem.setBackground(botaoPrimario);
        btItem.setForeground(textoCor);
        btItem.setBorder(new LineBorder(bordaBotao, 1));
        btItem.setFocusPainted(false);
        btItem.addActionListener(this);
        getContentPane().add(btItem);

        setVisible(true);

        URL url = getClass().getResource("/Pck_Imagem/bird.png");

        if (url != null) {
            ImageIcon icon = new ImageIcon(url);
            setIconImage(icon.getImage());
        }
    }

    // AÇÃO PARA ABRIR AS JANELAS QUANDO OS BOTÕES SÃO CLICADOS
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btItem) {

            verItens();

        } else if (e.getSource() == btRegVendas) {

            ViewRegistrarVendas legal = new ViewRegistrarVendas();
            legal.setVisible(true);
            this.dispose();
        }
    }

    private void verItens() {

        // LINHA SELECIONADA
        int linha = tabela.getSelectedRow();

        if (linha != -1) {

            /* O int model MANTÉM A LINHA ORIGINAL DO REGISTRO QUANDO O FILTRO É APLICADO
               SE NÃO, ELE VAI INTERPRETAR COMO SE O REGISTRO FOSSE DE OUTRA LINHA
               QUANDO O FILTRO É APLICADO
            */

            int model = tabela.convertRowIndexToModel(linha);

            int codigoVenda = Integer.parseInt(
                    modelo.getValueAt(model, 0).toString()
            );

            String codigo = modelo.getValueAt(model, 0).toString();

            ViewItens itemVendas = new ViewItens(codigo);

            itemVendas.setVisible(true);

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Por favor, selecione uma venda na tabela para ver os seus itens.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }

    // AÇÃO PARA FILTRAGEM
    private void aplicarFiltro() {

        String texto = txtFiltro.getText();

        if (texto.trim().length() == 0) {

            // SE O CAMPO FOR NULL NÃO TEM FILTRO
            sorter.setRowFilter(null);

        } else {

            // APLICA O FILTRO EM TODAS AS COLUNAS USANDO O TEXTO DIGITADO
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + texto));
        }
    }
}