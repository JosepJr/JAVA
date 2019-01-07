/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compositecomputador;

import composite.Parte;
import composite.Todo;

/**
 *
 * @author Josep
 */
public class CompositeComputador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Todo CPU = new Todo("CPU",100.0);
        Todo pm = new Todo("Placa mãe", 100.0);
        Parte m1 = new Parte("16 gb", 100.00);
        Parte m2 = new Parte("16 gb", 100.00);
                
        //System.out.println(CPU.getDescricao() + " ," + CPU.getPreco());
        //System.out.println(pm.getDescricao() + " ," + pm.getPreco());
        //System.out.println(m1.getDescricao() + " ," + m1.getPreco());
        //System.out.println(m2.getDescricao() + " ," + m2.getPreco());
        
        Todo cooler = new Todo("Cooler",100.0);
        
        CPU.add(pm);
        //System.out.println(CPU.toString());
        
        pm.add(m1);
        //System.out.println(CPU.toString());
        
        pm.add(m2);
        //System.out.println(CPU.toString());
        
        CPU.add(cooler);
        System.out.println(CPU.toString());

       
        
        
        
    }
    
}
