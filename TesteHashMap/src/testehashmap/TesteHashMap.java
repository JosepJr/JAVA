/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testehashmap;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Josep
 */
public class TesteHashMap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        HashMap<String, Integer> cedulas = new HashMap<>();
        
        cedulas.put("Cem", 100);
        cedulas.put("dem", 100);
        cedulas.put("eem", 100);
        
        System.out.println("forEach");
        cedulas.forEach((key, value) -> {
            System.out.println("Key: " + key + "value: " + value);
        });
        
        System.out.println("\nfor comum");
        for (Map.Entry<String, Integer> pair: cedulas.entrySet()){
            System.out.println("Key: " + pair.getKey()+ "Value: " + pair.getValue());
        }
        
    }
    
}
