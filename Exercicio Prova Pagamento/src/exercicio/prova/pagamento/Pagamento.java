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
public class Pagamento {
    private double valor;
    private boolean pago;
    private String recebeu;

    public Pagamento(double valor){
        this.valor = valor;
    }
    
    public String getRecebeu() {
        return recebeu;
    }

    public void setRecebeu(String recebeu) {
        this.recebeu = recebeu;
    }
    
    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Pagamento{" + "valor=" + valor + ", pago=" + pago + ", recebeu=" + recebeu + '}';
    }
    
}
