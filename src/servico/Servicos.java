package servico;

import dominio.Loja;
import dominio.Roupa;

public class Servicos {
    public static void divulgarRoupa(Loja loja, String modelo, int tamanho) {
        System.out.println("DIVULGACAO: ");
        Roupa roupa = loja.getCamisa(modelo, tamanho);
        System.out.println(roupa.getModelo());
        System.out.println(roupa.getCor());
        System.out.println(roupa.getTamanho());
        System.out.println(roupa.getValor());
    }
}
