package FRONTEND;

import BACKEND.Pck_Controler.Controler;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class ViewRemover extends JFrame implements ActionListener {

    JLabel intro = new JLabel();
    JLabel codigo = new JLabel();
    JTextField txtCodigo = new JTextField();
    JButton btRemover = new JButton();
    JButton btConsultar = new JButton();

    public ViewRemover() {

        setTitle("Recanto dos Pássaros - Remover");
        setBounds(100, 100, 500, 320);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        getContentPane().setBackground(new Color(245, 235, 221));

        // COR PADRÃO TEXTO
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
        JLabel titulo = new JLabel("REMOVER");
        titulo.setBounds(0, 15, 500, 35);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 28));
        titulo.setForeground(textoCor);
        getContentPane().add(titulo);

        // INTRO
        intro.setText("Insira o código do produto que deseja remover:");
        intro.setBounds(0, 60, 500, 20);
        intro.setFont(new Font("Arial", Font.BOLD, 16));
        intro.setForeground(textoCor);
        intro.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(intro);

        // LEGENDA P/ CAMPOS OBRIGATÓRIOS
        // deixar textos do campo obrigatório em itálico
        JLabel obrigatorio = new JLabel("*Campos obrigatórios");
        obrigatorio.setBounds(0, 83, 500, 20);
        obrigatorio.setHorizontalAlignment(SwingConstants.CENTER);
        obrigatorio.setForeground(new Color(237,33,0)); // cor vermelho escarlate #ED2100
        obrigatorio.setFont(new Font("Arial", Font.ITALIC, 14));
        getContentPane().add(obrigatorio);

        // CÓDIGO - TEXTO
        codigo.setText("CÓDIGO*:");
        codigo.setFont(new Font("Arial", Font.BOLD, 20));
        codigo.setBounds(55, 125, 150, 30);
        codigo.setForeground(textoCor);
        getContentPane().add(codigo);

        // CÓDIGO - CAMPO
        txtCodigo.setBounds(220, 120, 180, 40);
        txtCodigo.setFont(new Font("Arial", Font.PLAIN, 20));
        txtCodigo.setBorder(new LineBorder(bordaBotao, 1));
        getContentPane().add(txtCodigo);

        // BOTÃO CONSULTAR
        btConsultar.setText("CONSULTAR");
        btConsultar.setBounds(55, 210, 150, 40);
        btConsultar.setFont(new Font("Arial", Font.BOLD, 15));
        btConsultar.setBackground(botaoSecundario);
        btConsultar.setForeground(textoCor);
        btConsultar.setBorder(new LineBorder(bordaBotao, 1));
        btConsultar.setFocusPainted(false);
        btConsultar.addActionListener(this);
        getContentPane().add(btConsultar);

        // BOTÃO REMOVER
        btRemover.setText("REMOVER");
        btRemover.setBounds(295, 210, 150, 40);
        btRemover.setFont(new Font("Arial", Font.BOLD, 15));
        btRemover.setBackground(botaoAlerta);
        btRemover.setForeground(textoCor);
        btRemover.setBorder(new LineBorder(bordaBotao, 1));
        btRemover.setFocusPainted(false);
        btRemover.addActionListener(this);
        getContentPane().add(btRemover);
        setVisible(true);

        URL url = getClass().getResource("/Pck_Imagem/bird.png");

        if (url != null) {
            ImageIcon icon = new ImageIcon(url);
            setIconImage(icon.getImage());
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btConsultar) {

            ViewConsultar consulta = new ViewConsultar();
            consulta.setVisible(true);

        } else if (e.getSource() == btRemover) {

            try {

                int cod = Integer.parseInt(txtCodigo.getText());

                Controler controler = new Controler();

                controler.Delete(cod);

                JOptionPane.showMessageDialog(
                        this,
                        "Produto " + cod + " removido com sucesso!"
                );

                txtCodigo.setText("");

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Erro: Verifique se inseriu um código válido!"
                );
            }
        }
    }
}