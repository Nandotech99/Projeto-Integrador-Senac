package FRONTEND;

import BACKEND.Pck_Controler.Controler;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class ViewEditarQuantidade extends JFrame implements ActionListener {

        JLabel titulo = new JLabel();
        JLabel intro = new JLabel();
        JLabel codigo = new JLabel();
        JLabel novaquantidade = new JLabel();
        JLabel data = new JLabel();
        JLabel registro = new JLabel();
        JTextField txtCodigo = new JTextField();
        JTextField txtQuantidade = new JTextField();
        JTextField txtData = new JTextField();
        JTextField txtRegistro = new JTextField();
        JButton btOk = new JButton();
        JButton btConsultar = new JButton();

        public ViewEditarQuantidade() {

                setTitle("Recanto dos Pássaros - Editar Quantidade");
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
                titulo.setText("EDITAR QUANTIDADE");
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
                obrigatorio.setForeground(new Color(237,33,0)); // cor vermelho escarlate #ED2100
                obrigatorio.setFont(new Font("Arial", Font.ITALIC, 14));
                getContentPane().add(obrigatorio);

                // CÓDIGO - TEXTO
                codigo.setText("CÓDIGO*:");
                codigo.setFont(new Font("Arial", Font.BOLD, 20));
                codigo.setBounds(40, 130, 180, 25);
                codigo.setForeground(textoCor);
                getContentPane().add(codigo);

                // CÓDIGO - CAMPO
                txtCodigo.setBounds(250, 125, 190, 40);
                txtCodigo.setFont(new Font("Arial", Font.PLAIN, 20));
                txtCodigo.setBorder(new LineBorder(bordaBotao, 1));
                getContentPane().add(txtCodigo);

                // NOVA QUANTIDADE - TEXTO
                novaquantidade.setText("NOVA QUANTIDADE*:");
                novaquantidade.setFont(new Font("Arial", Font.BOLD, 20));
                novaquantidade.setBounds(40, 185, 210, 25);
                novaquantidade.setForeground(textoCor);
                getContentPane().add(novaquantidade);

                // NOVA QUANTIDADE - CAMPO
                txtQuantidade.setBounds(250, 180, 190, 40);
                txtQuantidade.setFont(new Font("Arial", Font.PLAIN, 20));
                txtQuantidade.setBorder(new LineBorder(bordaBotao, 1));
                getContentPane().add(txtQuantidade);

                // DATA - TEXTO
                data.setText("DATA*:");
                data.setFont(new Font("Arial", Font.BOLD, 20));
                data.setBounds(40, 240, 180, 25);
                data.setForeground(textoCor);
                getContentPane().add(data);

                // DATA - CAMPO
                txtData.setBounds(250, 235, 190, 40);
                txtData.setFont(new Font("Arial", Font.PLAIN, 20));
                txtData.setBorder(new LineBorder(bordaBotao, 1));
                getContentPane().add(txtData);

                // REGISTRO - TEXTO
                registro.setText("REGISTRO:");
                registro.setFont(new Font("Arial", Font.BOLD, 20));
                registro.setBounds(40, 295, 180, 25);
                registro.setForeground(textoCor);
                getContentPane().add(registro);

                // REGISTRO - CAMPO
                txtRegistro.setBounds(250, 290, 190, 40);
                txtRegistro.setFont(new Font("Arial", Font.PLAIN, 20));
                txtRegistro.setBorder(new LineBorder(bordaBotao, 1));
                getContentPane().add(txtRegistro);

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
                                if (txtCodigo.getText().trim().isEmpty() ||
                                        txtQuantidade.getText().trim().isEmpty() ||
                                        txtData.getText().trim().isEmpty()) {

                                        throw new Exception(
                                                "Preencha os campos obrigatórios antes de editar o produto."
                                        );
                                }

                                // COLETA OS DADOS
                                int cod = Integer.parseInt(txtCodigo.getText());
                                int qtd = Integer.parseInt(txtQuantidade.getText());
                                String dt = txtData.getText();
                                String reg = txtRegistro.getText();

                                // CHAMA O CONTROLLER
                                Controler controler = new Controler();
                                controler.Update(cod, qtd, dt, reg);

                                JOptionPane.showMessageDialog(
                                        this,
                                        "Produto " + cod + " atualizado com sucesso!"
                                );

                                // LIMPA OS CAMPOS
                                txtCodigo.setText("");
                                txtQuantidade.setText("");
                                txtData.setText("");
                                txtRegistro.setText("");

                        } catch (NumberFormatException ex) {

                                JOptionPane.showMessageDialog(
                                        this,
                                        "Os campos Código e Quantidade devem conter apenas números."
                                );

                        } catch (Exception ex) {

                                JOptionPane.showMessageDialog(
                                        this,
                                        ex.getMessage()
                                );
                        }
                }
        }
}