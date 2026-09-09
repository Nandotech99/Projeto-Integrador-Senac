package FRONTEND;

import BACKEND.Pck_Controler.Controler;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class ViewEditarPreco extends JFrame implements ActionListener {

    JLabel titulo = new JLabel();
    JLabel intro = new JLabel();
    JLabel code = new JLabel();
    JLabel novoPreco = new JLabel();
    JLabel Date = new JLabel();
    JLabel Obs = new JLabel();
    JTextField txtObs = new JTextField();
    JTextField txtPreco = new JTextField();
    JTextField txtDate = new JTextField();
    JTextField txtCode = new JTextField();
    JButton btOk = new JButton();
    JButton btConsultar = new JButton();

    public ViewEditarPreco() {

        setTitle("Recanto dos Pássaros - Editar Preço");
        setBounds(100, 100, 500, 490);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
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

        // COR BORDA DOS BOTÕES
        Color bordaBotao = new Color(81, 38, 21);

        // TÍTULO
        titulo.setText("EDITAR PREÇO");
        titulo.setBounds(0, 10, 500, 35);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 28));
        titulo.setForeground(textoCor);
        getContentPane().add(titulo);

        // INTRO
        intro.setText("Insira as informações do produto que deseja editar:");
        intro.setBounds(0, 60, 500, 20);
        intro.setHorizontalAlignment(SwingConstants.CENTER);
        intro.setFont(new Font("Arial", Font.BOLD, 16));
        intro.setForeground(textoCor);
        getContentPane().add(intro);

        // LEGENDA P/ CAMPOS OBRIGATÓRIOS
        // deixar textos do campo obrigatório em itálico
        JLabel obrigatorio = new JLabel("*Campos obrigatórios");
        obrigatorio.setBounds(0, 82, 500, 20);
        obrigatorio.setHorizontalAlignment(SwingConstants.CENTER);
        obrigatorio.setForeground(new Color(237, 33, 0)); // cor vermelho escarlate #ED2100
        obrigatorio.setFont(new Font("Arial", Font.ITALIC, 14));
        getContentPane().add(obrigatorio);

        // CÓDIGO - TEXTO
        code.setText("CÓDIGO*:");
        code.setFont(new Font("Arial", Font.BOLD, 20));
        code.setBounds(40, 130, 180, 25);
        code.setForeground(textoCor);
        getContentPane().add(code);

        // CÓDIGO - CAMPO
        txtCode.setBounds(250, 125, 190, 40);
        txtCode.setFont(new Font("Arial", Font.PLAIN, 20));
        txtCode.setBorder(new LineBorder(bordaBotao, 1));
        getContentPane().add(txtCode);

        // NOVO PREÇO - TEXTO
        novoPreco.setText("NOVO PREÇO*:");
        novoPreco.setFont(new Font("Arial", Font.BOLD, 20));
        novoPreco.setBounds(40, 185, 210, 25);
        novoPreco.setForeground(textoCor);
        getContentPane().add(novoPreco);

        // NOVO PREÇO - CAMPO
        txtPreco.setBounds(250, 180, 190, 40);
        txtPreco.setFont(new Font("Arial", Font.PLAIN, 20));
        txtPreco.setBorder(new LineBorder(bordaBotao, 1));
        getContentPane().add(txtPreco);

        // DATA - TEXTO
        Date.setText("DATA*:");
        Date.setFont(new Font("Arial", Font.BOLD, 20));
        Date.setBounds(40, 240, 180, 25);
        Date.setForeground(textoCor);
        getContentPane().add(Date);

        // DATA - CAMPO
        txtDate.setBounds(250, 235, 190, 40);
        txtDate.setFont(new Font("Arial", Font.PLAIN, 20));
        txtDate.setBorder(new LineBorder(bordaBotao, 1));
        getContentPane().add(txtDate);

        // REGISTRO - TEXTO
        Obs.setText("REGISTRO:");
        Obs.setFont(new Font("Arial", Font.BOLD, 20));
        Obs.setBounds(40, 295, 180, 25);
        Obs.setForeground(textoCor);
        getContentPane().add(Obs);

        // REGISTRO - CAMPO
        txtObs.setBounds(250, 290, 190, 40);
        txtObs.setFont(new Font("Arial", Font.PLAIN, 20));
        txtObs.setBorder(new LineBorder(bordaBotao, 1));
        getContentPane().add(txtObs);

        // BOTÃO CONSULTAR
        btConsultar.setText("CONSULTAR");
        btConsultar.setFont(new Font("Arial", Font.BOLD, 15));
        btConsultar.setBounds(70, 380, 150, 45);
        btConsultar.setBackground(botaoSecundario);
        btConsultar.setForeground(textoCor);
        btConsultar.setBorder(new LineBorder(bordaBotao, 1));
        btConsultar.setFocusPainted(false);
        btConsultar.addActionListener(this);
        getContentPane().add(btConsultar);

        // BOTÃO "OK" PARA EDITAR
        btOk.setText("OK");
        btOk.setFont(new Font("Arial", Font.BOLD, 15));
        btOk.setBounds(260, 380, 150, 45);
        btOk.setBackground(botaoPrimario);
        btOk.setForeground(textoCor);
        btOk.setBorder(new LineBorder(bordaBotao, 1));
        btOk.setFocusPainted(false);
        btOk.addActionListener(this);
        getContentPane().add(btOk);

        // LOGOTIPO
        URL url = getClass().getResource("/Pck_Imagem/bird.png");

        if (url != null) {
            ImageIcon icon = new ImageIcon(url);
            setIconImage(icon.getImage());
        }

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btConsultar) {
            ViewConsultar consulta = new ViewConsultar();
            consulta.setVisible(true);

        } else if (e.getSource() == btOk) {

            try {
                // VERIFICA CAMPOS OBRIGATÓRIOS
                if (txtCode.getText().trim().isEmpty() ||
                        txtPreco.getText().trim().isEmpty() ||
                        txtDate.getText().trim().isEmpty()) {

                    throw new Exception("Preencha os campos obrigatórios antes de editar o produto.");
                }

                // COLETA OS DADOS
                int cod = Integer.parseInt(txtCode.getText());
                double preco = Double.parseDouble(txtPreco.getText());
                String dt = txtDate.getText();
                String reg = txtObs.getText();

                // CHAMA O CONTROLLER
                Controler controler = new Controler();

                controler.AtualizarPreco(cod, preco, dt, reg);

                JOptionPane.showMessageDialog(this, "Produto " + cod + " atualizado com sucesso!");

                // LIMPA OS CAMPOS
                txtCode.setText("");
                txtPreco.setText("");
                txtDate.setText("");
                txtObs.setText("");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Os campos Código e Novo Preço devem conter apenas números.");
            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        this,
                        ex.getMessage()
                );
            }
        }
    }
}