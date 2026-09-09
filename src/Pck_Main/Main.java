package Pck_Main;

import FRONTEND.ViewPrincipal;

public class Main {

    public static void main(String[] args) {
        // 1. Inicializa o ambiente visual do software do Recanto dos Pássaros
        ViewPrincipal tela = new ViewPrincipal();
        tela.setVisible(true);
        System.out.print("A");
    }
}

/*
FLUXO MVC (Model-View-Controller)

VIEW: PEGA O PEDIDO DO USUÁRIO

CONTROLER: CRIA INSTÂNCIAS DE OBJETOS (MODEL) PARA CADA DADO
           FEITO NO PEDIDO E CHAMA A PROCEDURE PARA EXECUTAR O PEDIDO

MODEL: REGISTRA OS DADOS DO PEDIDO (SET'S) E TAMBÉM OS UTILIZA QUANDO NECESSÁRIO (GET'S)
       ALÉM DISSO, POSSUI REGRAS DE NEGÓCIO PARA QUE DADOS SEJAM INSERIDOS DA FORMA
       CORRETA

PROCEDURE: CHAMA A PROCEDURE NO MYSQL COM OS PARÂMETROS DEFINIDOS PELO CONTROLER
           E DEVOLVE O RESULTADO NA VIEW
 */