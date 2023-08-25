package com.example;

import com.example.model.Cliente;

public class AppClasses {
    
    public static void main(String[] args) {
        Cliente cliente = new Cliente();

        cliente.setRenda(10000);
        cliente.setSexo('M');
        cliente.setAnoNascimento(1991);
        
        System.out.println(cliente.getRenda());
        System.out.println(cliente.getSexo());
        System.out.println(cliente.getAnoNascimento());
    }

}
