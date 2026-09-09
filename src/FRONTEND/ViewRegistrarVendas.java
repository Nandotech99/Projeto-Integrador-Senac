package FRONTEND;

import BACKEND.Pck_Controler.Controler;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class ViewRegistrarVendas extends JFrame implements ActionListener {

    // Componentes da Interface
     JButton btItem = new JButton();
     JButton btFim = new JButton();
     JTextField txtCodigo = new JTextField();
     JTextField txtQuantidade = new JTextField();
     JLabel Codigo = new JLabel();
     JLabel Quantidade = new JLabel();
     JLabel intro;

    // ATRIBUTOS DE CONTROLE DA VENDA ATIVA
    private int idVendaAtual = -1;
    private Controler controler = new Controler();

    public ViewRegistrarVendas() {
        // Configurações da Janela
        setTitle("Recanto dos Pássaros - Registrar Vendas ou Itens");
        setBounds(100, 100, 550, 460);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().setBackground(new Color(245, 235, 221));

        // PALETA DE CORES
        Color textoCor = new Color(81, 38, 21);
        Color botaoPrimario = new Color(235, 220, 200);
        Color botaoSecundario = new Color(245, 235, 221);
        Color bordaBotao = new Color(81, 38, 21);

        // TÍTULO DA TELA
        JLabel titulo = new JLabel("REGISTRAR VENDAS OU ITENS");
        titulo.setBounds(0, 40, 550, 35);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 28));
        titulo.setForeground(textoCor);
        getContentPane().add(titulo);

        // INTRO
        intro = new JLabel();
        intro.setText("Registre a venda e, em seguida, adicione os itens.");
        intro.setBounds(0,80,550,20);
        intro.setHorizontalAlignment(SwingConstants.CENTER);
        intro.setFont(new Font("Arial",Font.BOLD,15));
        intro.setForeground(textoCor);
        getContentPane().add(intro);

        // CAIXA DE TEXTO: CÓDIGO DO PRODUTO
        txtCodigo.setBounds(250, 180, 190, 40);
        txtCodigo.setFont(new Font("Arial", Font.PLAIN, 17));
        txtCodigo.setBorder(new LineBorder(bordaBotao, 1));
        getContentPane().add(txtCodigo);

        // CAIXA DE TEXTO: QUANTIDADE
        txtQuantidade.setBounds(250, 235, 190, 40);
        txtQuantidade.setFont(new Font("Arial", Font.PLAIN, 17));
        txtQuantidade.setBorder(new LineBorder(bordaBotao, 1));
        getContentPane().add(txtQuantidade);

        // LABEL: CÓDIGO
        Codigo.setText("CÓDIGO:");
        Codigo.setFont(new Font("Arial", Font.BOLD, 20));
        Codigo.setForeground(textoCor);
        Codigo.setBounds(40, 185, 210, 25);
        getContentPane().add(Codigo);

        // LABEL: QUANTIDADE
        Quantidade.setText("QUANTIDADE:");
        Quantidade.setFont(new Font("Arial", Font.BOLD, 20));
        Quantidade.setForeground(textoCor);
        Quantidade.setBounds(40, 240, 180, 25);
        getContentPane().add(Quantidade);

        // BOTÃO: ADICIONAR ITEM
        btItem.setText("ADICIONAR ITEM");
        btItem.setFont(new Font("Arial", Font.BOLD, 14));
        btItem.setBounds(95, 320, 180, 48);
        btItem.setBackground(botaoSecundario);
        btItem.setForeground(textoCor);
        btItem.setBorder(new LineBorder(bordaBotao, 1));
        btItem.setFocusPainted(false);
        btItem.addActionListener(this);
        getContentPane().add(btItem);

        // BOTÃO: OK
        btFim.setText("FINALIZAR VENDA");
        btFim.setFont(new Font("Arial", Font.BOLD, 14));
        btFim.setBounds(285, 320, 180, 48);
        btFim.setBackground(botaoPrimario);
        btFim.setForeground(textoCor);
        btFim.setBorder(new LineBorder(bordaBotao, 1));
        btFim.setFocusPainted(false);
        btFim.addActionListener(this);
        getContentPane().add(btFim);

        // ÍCONE DA JANELA
        URL url = getClass().getResource("/Pck_Imagem/bird.png");
        if (url != null) {
            ImageIcon icon = new ImageIcon(url);
            setIconImage(icon.getImage());
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        try {
            // AÇÃO DO BOTÃO ADICIONAR ITEM
            if (evt.getSource() == btItem) {
                // Se for o primeiro item da compra, abre a venda no banco de dados
                if (idVendaAtual == -1) {
                    idVendaAtual = controler.abrirNovaVenda();
                }

                int cod = Integer.parseInt(txtCodigo.getText());
                int qtd = Integer.parseInt(txtQuantidade.getText());

                // Executa a procedure através do controller enviando o ID estável da venda
                controler.adicionarItemVenda(idVendaAtual, cod, qtd);

                JOptionPane.showMessageDialog(this, "Item " + cod + " inserido na venda nº " + idVendaAtual);

                // Limpa os campos para a próxima inserção de item
                txtCodigo.setText("");
                txtQuantidade.setText("");
            }

            // AÇÃO DO BOTÃO FINALIZAR
            if (evt.getSource() == btFim) {
                if (idVendaAtual != -1) {
                    JOptionPane.showMessageDialog(this, "Venda nº " + idVendaAtual + " finalizada com sucesso!");

                    // Reseta o ID para que a próxima abertura de tela inicie um novo ciclo limpo
                    idVendaAtual = -1;
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Nenhum item foi adicionado a esta venda ainda!");
                }
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha apenas números inteiros válidos nos campos.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao processar operação: " + ex.getMessage());
        }
    }
}