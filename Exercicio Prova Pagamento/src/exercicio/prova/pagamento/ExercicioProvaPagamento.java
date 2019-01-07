/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio.prova.pagamento;

/**
 *
 * @author Josep
 */
public class ExercicioProvaPagamento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pagamento p = new Pagamento(450.00);
        Pagamento p1 = new Pagamento(700.00);
        Pagamento p2 = new Pagamento(1600.00);
        Pagamento p3 = new Pagamento(14000.00);
    
        ProcessaPagamento processar = new ProcessaPagamento();
        
        p.setPago(processar.pagar(p));
        p1.setPago(processar.pagar(p1));
        p2.setPago(processar.pagar(p2));
        p3.setPago(processar.pagar(p3));
       
        System.out.println(p.toString());
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());
    }
    
}
