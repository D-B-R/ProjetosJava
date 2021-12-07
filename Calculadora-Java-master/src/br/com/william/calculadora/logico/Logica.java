/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.william.calculadora.logico;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class Logica {
    public static String exprecao;
    @SuppressWarnings("unchecked")
    public static String calcula(String exprecao){
        Logica.exprecao=exprecao;
        List<String> operadores;
        operadores = devolveOperadores(exprecao);
        List numeros=devolveNumeros(exprecao);
//      System.out.println(operadores);
//       System.out.println(numeros);
        double valor;
        valor = calculaAns(numeros,operadores);
        return ""+valor;
    }

    private static ArrayList<String> devolveOperadores(String exprecao) {
        ArrayList<String> operadores;
        operadores = new ArrayList<>();
        int cont=0;
        for(char i:exprecao.toCharArray()){
            if(isOperador(i)&&cont!=0){
//                System.out.println(i);
                operadores.add(new StringBuffer().append(i).toString());
                cont=0;
                continue;
            }
            cont=1;
        }
        return operadores;
    }
    private static  boolean isOperador(char x){
        if(x=='-'||x=='+'||x=='/'||x=='*')return true;
        return false;
    }

    private static ArrayList<Double> devolveNumeros(String exprecao) {
         ArrayList<Double> numeros;
        numeros = new ArrayList<>();
        StringBuffer number=new StringBuffer();
        exprecao+="+";
         for(char i:exprecao.toCharArray()){
            if(!isOperador(i)){
                number.append(i);
                continue;
//                System.out.println("i = "+i);
            }
            else{
                if(number.toString().length()==0){
                    number.append(i);
//                    System.out.println(i);
                    continue;
                }
                else{ 
                    double numero=Double.parseDouble(number.toString());
                    numeros.add(numero);
                    number=new StringBuffer();   
                }
            }
        }
                
         return numeros;
    }
    public static double calculaAns(List<Double> numeros,List<String> operadores){
        double valor=0;
        int j=0;
        for(int i=0;i<numeros.size()-1;i++){
            if(valor==0){
                valor=operacao(numeros.get(i),operadores.get(j),numeros.get(i+1));
                j++;
            }
            else{
                valor=operacao(valor,operadores.get(j),numeros.get(i+1));
                j++;
            }
        }
        return valor;
        
    }
    public static double operacao(double a,String c,double b){
        double valor=0;
        switch(c){
                case "+":
                    valor=a+b;
                    break;
                case "-":
                    valor=a-b;
                    break;
                case "*":
                    valor=a*b;
                    break;
                case "/":
                    valor=a/b;
                    break;
        }
        return valor;
    }
}
