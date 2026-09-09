package Pck_View;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class ViewPrincipal extends JFrame implements ActionListener {

    JLabel saudacao;
    JLabel instrucao1, logo;

    JButton btEstoque;
    JButton btVendas;

    public ViewPrincipal() {

        // INTERFACE
        setTitle("Recanto dos Pássaros - Início ");
        setSize(550, 520);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // container principal
        getContentPane().setLayout(new GridBagLayout()); // centralizar o bloco do conteúdo
        getContentPane().setBackground(new Color(245, 235, 221));

        // crição do painel que organiza todos os componentes na vertical
        // é a "base" da interface
        JPanel painelCentral = new JPanel();
        painelCentral.setLayout(new BoxLayout(painelCentral, BoxLayout.Y_AXIS));
        painelCentral.setOpaque(false); // remover fundo padrão do painel p/ manter o design (não fica cinza padrão)

        // COR PADRÃO TEXTO
        Color textoCor = new Color(81, 38, 21);

        // COR BOTÃO CLARO
        Color botaoClaro = new Color(236, 223, 210);

        // COR BORDA BOTÃO
        Color bordaBotao = new Color(81, 38, 21);

        // LOGO
        URL img = getClass().getResource("/Pck_Imagem/logotipo.png");

        if (img != null) {
            ImageIcon ico = new ImageIcon(img);
            Image imge = ico.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            logo = new JLabel(new ImageIcon(imge));
            logo.setAlignmentX(Component.CENTER_ALIGNMENT); // centralizar o logotipo no BoxLayout
            painelCentral.add(logo);
            painelCentral.add(Box.createRigidArea(new Dimension(0, 15))); // espaçamento vertical
        }

        // SAUDAÇÃO
        saudacao = new JLabel("Olá, seja bem-vindo(a)!");
        saudacao.setFont(new Font("Arial", Font.BOLD, 28));
        saudacao.setForeground(textoCor);
        saudacao.setAlignmentX(Component.CENTER_ALIGNMENT);
        painelCentral.add(saudacao);
        painelCentral.add(Box.createRigidArea(new Dimension(0, 10)));

        // INSTRUÇÃO
        instrucao1 = new JLabel("Selecione se deseja gerenciar os produtos ou consultar as vendas:");
        instrucao1.setFont(new Font("Arial", Font.BOLD, 16));
        instrucao1.setForeground(textoCor);
        instrucao1.setAlignmentX(Component.CENTER_ALIGNMENT);
        painelCentral.add(instrucao1);
        painelCentral.add(Box.createRigidArea(new Dimension(0, 25)));

        // criar painel p/ organizar os botões lado a lado dentro da interface
        // esse painel serve apenas para agrupar e alinhar os componentes horizontal
        JPanel painelBotoes = new JPanel();
        // definir layout horizontal p/ posicionar os botões um do lado do outro
        painelBotoes.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0)); // 20px de espaço entre eles
        painelBotoes.setOpaque(false); // remover fundo padrão do painel p/ manter o design (não fica cinza padrão)

        // BOTÃO ESTOQUE
        btEstoque = new JButton("PRODUTOS");
        btEstoque.setFont(new Font("Arial", Font.BOLD, 12));

        // tamanho fixo ideal do botão
        // (quando a tela estiver ou não expandida)
        btEstoque.setPreferredSize(new Dimension(120, 40));

        btEstoque.setBackground(botaoClaro);
        btEstoque.setForeground(textoCor);
        btEstoque.setBorder(new LineBorder(bordaBotao, 1));
        btEstoque.setFocusPainted(false);
        btEstoque.addActionListener(this);
        painelBotoes.add(btEstoque);

        // BOTÃO VENDAS
        btVendas = new JButton("VENDAS");
        btVendas.setFont(new Font("Arial", Font.BOLD, 12));
        btVendas.setPreferredSize(new Dimension(110, 40));
        btVendas.setBackground(botaoClaro);
        btVendas.setForeground(textoCor);
        btVendas.setBorder(new LineBorder(bordaBotao, 1));
        btVendas.setFocusPainted(false);
        btVendas.addActionListener(this);

        painelBotoes.add(btVendas);

        // adicionar o painel de botões dentro do painel central (jpanel)
        painelCentral.add(painelBotoes);

        // adicionar o painel centralizado na janela principal (jframe)
        // define o layout que centraliza o painel na tela
        getContentPane().add(painelCentral, new GridBagConstraints());

        // ÍCONE DA JANELA
        URL url = getClass().getResource("/Pck_Imagem/bird.png"); // caminho do logotipo

        if (url != null) { // confere se a imagem não foi encontrada
            ImageIcon icon = new ImageIcon(url);
            setIconImage(icon.getImage());
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btEstoque) {
            ViewProdutos estoque = new ViewProdutos();
            estoque.setVisible(true);

        } else if (e.getSource() == btVendas) {
            ViewVendas vend = new ViewVendas();
            vend.setVisible(true);
        }
    }
}