package FRONTEND;

import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.URL;

/*
A VIEW REGISTRA O PEDIDO FEITO PELO USUÁRIO
*/

public class ViewProdutos extends JFrame implements ActionListener {

    JLabel intro;

    JButton btInserir;
    JButton btConsulta;
    JButton btEditar;
    JButton btRemover;

    public ViewProdutos(){

        // INTERFACE
        setTitle("Recanto dos Pássaros - Produtos");
        setBounds(100,100,550,220);
        setLocationRelativeTo(null);// PARA INTERFACE SURGIR NO CENTRO DA TELA
        setVisible(true);
        setResizable(false);

        getContentPane().setLayout(null);// PARA MUDAR AS POSIÇÕES DOS COMPONENTES
        getContentPane().setBackground(new Color(245, 235, 221));

        // COR PADRÃO TEXTO
        Color textoCor = new Color(81, 38, 21);
        // COR BOTÃO CLARO
        Color botaoClaro = new Color(236, 223, 210);
        // COR BOTÃO ALERTA
        Color botaoAlerta = new Color(215, 170, 170);
        // COR BORDA BOTÃO
        Color bordaBotao = new Color(81, 38, 21);

        // TÍTULO
        JLabel titulo = new JLabel("PRODUTOS");
        titulo.setBounds(0, 25, 550, 35);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 28));
        titulo.setForeground(textoCor);
        getContentPane().add(titulo);

        // INTRO
        intro = new JLabel();
        intro.setText("Selecione a operação que deseja realizar:");
        intro.setBounds(0,90,550,20);
        intro.setHorizontalAlignment(SwingConstants.CENTER);
        intro.setFont(new Font("Arial",Font.BOLD,15));
        intro.setForeground(textoCor);
        getContentPane().add(intro);

        // CONSULTAR
        btConsulta = new JButton();
        btConsulta.setText("CONSULTAR");
        btConsulta.setFont(new Font("Arial", Font.BOLD, 12));
        btConsulta.setBounds(35,130,110,40);
        btConsulta.setBackground(botaoClaro);
        btConsulta.setForeground(textoCor);
        btConsulta.setBorder(new LineBorder(bordaBotao, 1));
        btConsulta.setFocusPainted(false);
        btConsulta.addActionListener(this);
        getContentPane().add(btConsulta);

        // INSERIR
        btInserir = new JButton();
        btInserir.setText("CADASTRAR");
        btInserir.setFont(new Font("Arial", Font.BOLD, 12));
        btInserir.setBounds(155,130,110,40);
        btInserir.setBackground(botaoClaro);
        btInserir.setForeground(textoCor);
        btInserir.setBorder(new LineBorder(bordaBotao, 1));
        btInserir.setFocusPainted(false);
        btInserir.addActionListener(this);
        getContentPane().add(btInserir);

        // ATUALIZAR
        btEditar = new JButton();
        btEditar.setText("EDITAR");
        btEditar.setFont(new Font("Arial", Font.BOLD, 12));
        btEditar.setBounds(275,130,110,40);
        btEditar.setBackground(botaoClaro);
        btEditar.setForeground(textoCor);
        btEditar.setBorder(new LineBorder(bordaBotao, 1));
        btEditar.setFocusPainted(false);
        btEditar.addActionListener(this);
        getContentPane().add(btEditar);

        // REMOVER
        btRemover = new JButton();
        btRemover.setText("REMOVER");
        btRemover.setFont(new Font("Arial", Font.BOLD, 12));
        btRemover.setBounds(395,130,110,40);
        btRemover.setBackground(botaoAlerta);
        btRemover.setForeground(textoCor);
        btRemover.setBorder(new LineBorder(bordaBotao, 1, true));
        btRemover.setFocusPainted(false);
        btRemover.addActionListener(this);
        getContentPane().add(btRemover);

        URL url=getClass().getResource("/Pck_Imagem/bird.png");

        if(url !=null){

            ImageIcon icon= new ImageIcon(url);

            setIconImage(icon.getImage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource() == btConsulta) {
            ViewConsultar consulta = new ViewConsultar();
            consulta.setVisible(true);

        } else if (e.getSource() == btInserir){
            ViewCadastrar inserir = new ViewCadastrar();
            inserir.setVisible(true);

        } else if(e.getSource() == btEditar){
            ViewEditar uptade=new ViewEditar();
            uptade.setVisible(true);

        } else if (e.getSource() == btRemover){
            ViewRemover delete=new ViewRemover();
            delete.setVisible(true);
        }
    }
}