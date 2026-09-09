package Pck_View;

import Pck_Controler.Controler;
import Pck_Model.Model;
import Pck_Procedure.Procedure;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class ViewCadastrar extends JFrame implements ActionListener {

    JLabel intro = new JLabel();
    JLabel codigo = new JLabel();
    JLabel nome = new JLabel();
    JLabel quantidade = new JLabel();
    JLabel data = new JLabel();
    JLabel registro = new JLabel();
    JLabel quantidadeMin = new JLabel();
    JLabel preco = new JLabel();

    JTextField txtQuantidadeMin = new JTextField();
    JTextField txtCodigo = new JTextField();
    JTextField txtNome = new JTextField();
    JTextField txtData = new JTextField();
    JTextField txtQuantidade = new JTextField();
    JTextField txtRegistro = new JTextField();
    JTextField txtPreco = new JTextField();

    JButton btOk = new JButton();
    JButton btConsultar = new JButton();

    public ViewCadastrar() {

        setTitle("Recanto dos Pássaros - Cadastrar");
        setBounds(100, 100, 620, 650);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().setBackground(new Color(245, 235, 221));

        // COR PRIMÁRIA TEXTO
        Color textoCor = new Color(81, 38, 21);

        // COR BOTÃO PRIMÁRIO
        Color botaoPrimario = new Color(224, 204, 186);

        // COR BOTÃO SECUNDÁRIO
        Color botaoSecundario = new Color(236, 221, 208);

        // COR BORDA DOS BOTÕES
        Color bordaBotao = new Color(81, 38, 21);

        // TÍTULO
        JLabel titulo = new JLabel("CADASTRAR");
        titulo.setBounds(0, 10, 620, 35);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 28));
        titulo.setForeground(textoCor);
        getContentPane().add(titulo);

        // INTRO
        intro.setText("Preencha os campos a seguir para cadastrar:");
        intro.setBounds(0, 55, 620, 25);
        intro.setHorizontalAlignment(SwingConstants.CENTER);
        intro.setFont(new Font("Arial", Font.BOLD, 16));
        intro.setForeground(textoCor);
        getContentPane().add(intro);

        // CAMPOS OBRIGATÓRIOS
        JLabel obrigatorio = new JLabel("*Campos obrigatórios");
        obrigatorio.setBounds(0, 80, 620, 20);
        obrigatorio.setHorizontalAlignment(SwingConstants.CENTER);
        obrigatorio.setForeground(new Color(237,33,0));
        obrigatorio.setFont(new Font("Arial", Font.ITALIC, 14));
        getContentPane().add(obrigatorio);

        // CÓDIGO
        codigo.setText("CÓDIGO*:");
        codigo.setFont(new Font("Arial", Font.BOLD, 20));
        codigo.setBounds(40, 130, 200, 30);
        codigo.setForeground(textoCor);
        getContentPane().add(codigo);

        txtCodigo.setBounds(260, 125, 300, 40);
        txtCodigo.setFont(new Font("Arial", Font.PLAIN, 20));
        txtCodigo.setBorder(new LineBorder(bordaBotao, 1));
        getContentPane().add(txtCodigo);

        // PRODUTO
        nome.setText("PRODUTO*:");
        nome.setFont(new Font("Arial", Font.BOLD, 20));
        nome.setBounds(40, 185, 200, 30);
        nome.setForeground(textoCor);
        getContentPane().add(nome);

        txtNome.setBounds(260, 180, 300, 40);
        txtNome.setFont(new Font("Arial", Font.PLAIN, 20));
        txtNome.setBorder(new LineBorder(bordaBotao, 1));
        getContentPane().add(txtNome);

        // QUANTIDADE
        quantidade.setText("QUANTIDADE*:");
        quantidade.setFont(new Font("Arial", Font.BOLD, 20));
        quantidade.setBounds(40, 240, 200, 30);
        quantidade.setForeground(textoCor);
        getContentPane().add(quantidade);

        txtQuantidade.setBounds(260, 235, 300, 40);
        txtQuantidade.setFont(new Font("Arial", Font.PLAIN, 20));
        txtQuantidade.setBorder(new LineBorder(bordaBotao, 1));
        getContentPane().add(txtQuantidade);

        // QUANTIDADE MÍNIMA
        quantidadeMin.setText("QUANTIDADE MÍNIMA*:");
        quantidadeMin.setFont(new Font("Arial", Font.BOLD, 18));
        quantidadeMin.setBounds(40, 295, 220, 30);
        quantidadeMin.setForeground(textoCor);
        getContentPane().add(quantidadeMin);

        txtQuantidadeMin.setBounds(260, 290, 300, 40);
        txtQuantidadeMin.setFont(new Font("Arial", Font.PLAIN, 20));
        txtQuantidadeMin.setBorder(new LineBorder(bordaBotao, 1));
        getContentPane().add(txtQuantidadeMin);

        // PREÇO
        preco.setText("PREÇO*:");
        preco.setFont(new Font("Arial", Font.BOLD, 20));
        preco.setBounds(40, 350, 200, 30);
        preco.setForeground(textoCor);
        getContentPane().add(preco);

        txtPreco.setBounds(260, 345, 300, 40);
        txtPreco.setFont(new Font("Arial", Font.PLAIN, 20));
        txtPreco.setBorder(new LineBorder(bordaBotao, 1));
        getContentPane().add(txtPreco);

        // DATA
        data.setText("DATA*:");
        data.setFont(new Font("Arial", Font.BOLD, 20));
        data.setBounds(40, 405, 200, 30);
        data.setForeground(textoCor);
        getContentPane().add(data);

        txtData.setBounds(260, 400, 300, 40);
        txtData.setFont(new Font("Arial", Font.PLAIN, 20));
        txtData.setBorder(new LineBorder(bordaBotao, 1));
        getContentPane().add(txtData);

        // REGISTRO
        registro.setText("REGISTRO:");
        registro.setFont(new Font("Arial", Font.BOLD, 20));
        registro.setBounds(40, 460, 200, 30);
        registro.setForeground(textoCor);
        getContentPane().add(registro);

        txtRegistro.setBounds(260, 455, 300, 40);
        txtRegistro.setFont(new Font("Arial", Font.PLAIN, 20));
        txtRegistro.setBorder(new LineBorder(bordaBotao, 1));
        getContentPane().add(txtRegistro);

        // BOTÃO CONSULTAR
        btConsultar.setText("CONSULTAR");
        btConsultar.setFont(new Font("Arial", Font.BOLD, 17));
        btConsultar.setBounds(70, 545, 170, 45);
        btConsultar.setBackground(botaoSecundario);
        btConsultar.setForeground(textoCor);
        btConsultar.setBorder(new LineBorder(bordaBotao, 1));
        btConsultar.setFocusPainted(false);
        btConsultar.addActionListener(this);
        getContentPane().add(btConsultar);

        // BOTÃO OK
        btOk.setText("OK");
        btOk.setFont(new Font("Arial", Font.BOLD, 17));
        btOk.setBounds(360, 545, 170, 45);
        btOk.setBackground(botaoPrimario);
        btOk.setForeground(textoCor);
        btOk.setBorder(new LineBorder(bordaBotao, 1));
        btOk.setFocusPainted(false);
        btOk.addActionListener(this);
        getContentPane().add(btOk);

        // ÍCONE
        URL url = getClass().getResource("/Pck_Imagem/bird.png");
        if (url != null) {
            ImageIcon icon = new ImageIcon(url);
            setIconImage(icon.getImage());
        }

        // AUTOCOMPLETE PALAVRAS
        List<String> palavras = new java.util.ArrayList<>();
        JPopupMenu popupSugestoes = new JPopupMenu();
        JList<String> listaSugestoes = new JList<>();

        popupSugestoes.setFocusable(false);
        popupSugestoes.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        try {
            java.io.InputStream is = getClass().getResourceAsStream("/Pck_Imagem/produtos.txt");

            if (is == null) {
                throw new java.io.FileNotFoundException("O arquivo produtos.txt não foi encontrado no pacote Pck_Imagem.");
            }

            BufferedReader br = new BufferedReader(new java.io.InputStreamReader(is, "UTF-8"));
            String linha;

            while ((linha = br.readLine()) != null) {
                palavras.add(linha);
            }
            br.close();
            Collections.sort(palavras);

        } catch (IOException e) {
            e.printStackTrace();
        }

        txtNome.getDocument().addDocumentListener(
                new javax.swing.event.DocumentListener() {
                    @Override
                    public void insertUpdate(javax.swing.event.DocumentEvent e) {
                        popupSugestoes.setVisible(false);
                        mostrarSugestoes();
                    }

                    @Override
                    public void removeUpdate(javax.swing.event.DocumentEvent e) {
                        popupSugestoes.setVisible(false);
                        mostrarSugestoes();
                    }

                    @Override
                    public void changedUpdate(javax.swing.event.DocumentEvent e) {
                        popupSugestoes.setVisible(false);
                        mostrarSugestoes();
                    }

                    private void mostrarSugestoes() {
                        String texto = txtNome.getText();
                        if (texto.isEmpty()) {
                            popupSugestoes.setVisible(false);
                            return;
                        }

                        List<String> encontrados = new java.util.ArrayList<>();
                        for (String palavra : palavras) {
                            if (palavra.toLowerCase().startsWith(texto.toLowerCase())) {
                                encontrados.add(palavra);
                            }
                        }

                        if (encontrados.isEmpty()) {
                            popupSugestoes.setVisible(false);
                            return;
                        }

                        listaSugestoes.setListData(encontrados.toArray(new String[0]));
                        popupSugestoes.removeAll();

                        JScrollPane scroll = new JScrollPane(listaSugestoes);
                        scroll.setPreferredSize(new Dimension(txtNome.getWidth(), 100));
                        popupSugestoes.add(scroll);

                        if (!popupSugestoes.isVisible()) {
                            popupSugestoes.show(txtNome, 0, txtNome.getHeight());
                        }
                    }
                }
        );

        listaSugestoes.addMouseListener(
                new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent e) {
                        String selecionado = listaSugestoes.getSelectedValue();
                        if (selecionado != null) {
                            txtNome.setText(selecionado);
                            popupSugestoes.setVisible(false);
                        }
                    }
                }
        );
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btOk) {
            try {
                // Validação CAMPOS VAZIOS
                if (txtCodigo.getText().trim().isEmpty() ||
                        txtNome.getText().trim().isEmpty() ||
                        txtQuantidade.getText().trim().isEmpty() ||
                        txtQuantidadeMin.getText().trim().isEmpty() ||
                        txtData.getText().trim().isEmpty()) {
                    throw new Exception(
                            "Preencha todos os campos obrigatórios antes de cadastrar o produto."
                    );
                }

                int codigo = Integer.parseInt(txtCodigo.getText());

                //ALERTA CÓDIGO JÁ EXISTENTE
                Procedure consultaProcedure = new Procedure();
                List<Model> listaProdutos = consultaProcedure.Consulta();
                for (Model p : listaProdutos) {
                    if (p.getCodigo() == codigo) {
                        throw new Exception("Operação cancelada! Já existe um produto cadastrado com o código: " + codigo);
                    }
                }

                String nome = txtNome.getText();
                int quantidade = Integer.parseInt(txtQuantidade.getText());
                int quantidade_min = Integer.parseInt(txtQuantidadeMin.getText());
                double preco = Double.parseDouble(txtPreco.getText());
                String data = txtData.getText();
                String registro = txtRegistro.getText();

                // ALERTA LIMITE DE CARACTERES
                if (registro.length() > 100) {
                    throw new Exception("O campo REGISTRO excede o limite permitido!\n"
                            + "Você digitou " + registro.length() + " caracteres. O limite é 50.");
                }

                Controler controler = new Controler();
                controler.Inserir(codigo, nome, quantidade, quantidade_min, preco, data, registro);

                JOptionPane.showMessageDialog(
                        this,
                        "Produto " + nome + " cadastrado com sucesso!");

                // LIMPEZA DOS CAMPOS APOS ACÃO
                txtCodigo.setText("");
                txtNome.setText("");
                txtQuantidade.setText("");
                txtQuantidadeMin.setText("");
                txtPreco.setText("");
                txtData.setText("");
                txtRegistro.setText("");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "Os campos Código, Quantidade, Quantidade Mínima e Preço devem conter apenas números válidos."
                );
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(
                        this,
                        ex.getMessage(),
                        "Aviso do Sistema",
                        JOptionPane.WARNING_MESSAGE
                );
            }

        } else if (e.getSource() == btConsultar) {
            ViewConsultar consulta = new ViewConsultar();
            consulta.setVisible(true);
        }
    }
}