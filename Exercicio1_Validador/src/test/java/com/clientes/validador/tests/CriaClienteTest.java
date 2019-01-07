package com.clientes.validador.tests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.clientes.validador.CNPJApoioDocumento;
import com.clientes.validador.CPFApoioDocumento;
import com.clientes.validador.model.Cliente;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Clayton
 */
public class CriaClienteTest {

    public CriaClienteTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void CPF1() throws Exception {
        String strCPF = CPFApoioDocumento.getInstance().gerar(false);
        Cliente cliente = new Cliente("Fulano", strCPF);
        System.out.println(cliente);
    }

    @Test(expected = Exception.class)
    public void CPF2() throws Exception {
        String strCPF2 = "123456789101";
        Cliente cliente = new Cliente("Fulano", strCPF2);
        System.out.println(cliente);
    }
    
     @Test(expected = Exception.class)
    public void CPF3NomeVazio() throws Exception {
        String strCPF2 = "123456789101";
        Cliente cliente = new Cliente("", strCPF2);
        System.out.println(cliente);
    }
    
       @Test(expected = Exception.class)
    public void CPF3NomeNullo() throws Exception {
        String strCPF2 = "123456789101";
        Cliente cliente = new Cliente(null, strCPF2);
        System.out.println(cliente);
    }


    @Test
    public void CNPJ1() throws Exception {
        String strCNPJ = CNPJApoioDocumento.getInstance().gerar(false);
        Cliente cliente = new Cliente("Fulano", strCNPJ);
        System.out.println(cliente);
    }

}
