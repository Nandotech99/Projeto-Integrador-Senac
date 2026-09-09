package FRONTEND;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class ViewEditar extends JFrame implements ActionListener {

    //Coisas necessarias kkkk
    JButton btPreco = new JButton();
    JButton btQuantidade = new JButton();

    JLabel intro;
    JLabel Preco = new JLabel();
    JLabel Quantidade = new JLabel();

    // PALETA DE CORES
    Color textoCor = new Color(81, 38, 21);
    Color botaoPrimario = new Color(235, 220, 200);
    Color botaoClaro = new Color(236, 223, 210);
    Color bordaBotao = new Color(81, 38, 21);

    public ViewEditar() {
        setTitle("Recanto dos Pássaros - Editar");
        setBounds(100, 100, 550, 220);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().setBackground(new Color(245, 235, 221));

        //Titulo
        JLabel titulo = new JLabel("EDITAR");
        titulo.setBounds(0, 25, 550, 20);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 28));
        titulo.setForeground(textoCor);
        getContentPane().add(titulo);

        // INTRO
        intro = new JLabel();
        intro.setText("Selecione qual informação deseja editar:");
        intro.setBounds(0,80,550,20);
        intro.setHorizontalAlignment(SwingConstants.CENTER);
        intro.setFont(new Font("Arial",Font.BOLD,15));
        intro.setForeground(textoCor);
        getContentPane().add(intro);

        //Botoes(1)
        btQuantidade.setText("EDITAR QUANTIDADE");
        btQuantidade.setFont(new Font("Arial", Font.BOLD, 14));
        btQuantidade.setBounds(65, 120, 200, 45);
        btQuantidade.setBackground(botaoClaro);
        btQuantidade.setForeground(textoCor);
        btQuantidade.setBorder(new LineBorder(bordaBotao, 1));
        btQuantidade.setFocusPainted(false);
        btQuantidade.addActionListener(this);
        getContentPane().add(btQuantidade);

        //Botoes(2)
        btPreco.setText("EDITAR PREÇO");
        btPreco.setFont(new Font("Arial", Font.BOLD, 14));
        btPreco.setBounds(285, 120, 200, 45);
        btPreco.setBackground(botaoClaro);
        btPreco.setForeground(textoCor);
        btPreco.setBorder(new LineBorder(bordaBotao, 1));
        btPreco.setFocusPainted(false);
        btPreco.addActionListener(this);
        getContentPane().add(btPreco);

        URL url = getClass().getResource("/Pck_Imagem/bird.png");

        if (url !=null) {

            ImageIcon icon = new ImageIcon (url);

            setIconImage(icon.getImage());
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btQuantidade) {
            ViewEditarQuantidade quantidade = new ViewEditarQuantidade();
            quantidade.setVisible(true);

        } else if (e.getSource() == btPreco) {

            ViewEditarPreco legal = new ViewEditarPreco();
            legal.setVisible(true);
        }
        // É aqui dentro que vai colocar a lógica dos cliques dos botões
        // Exemplo: se o usuário clicar no botão "Salvar Preço", o código chamará a sua procedure aqui dentro.
    }
}
