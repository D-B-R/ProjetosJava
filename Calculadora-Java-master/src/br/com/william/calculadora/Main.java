/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.william.calculadora;

import br.com.william.calculadora.gui.CalculadoraGui;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author usuario
 */
public class Main {
    private static void lookAndFeel() {

    	try {
    	    for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
    	        if ("Nimbus".equals(info.getName())) {
    	            UIManager.setLookAndFeel(info.getClassName());
    	            break;
    	        }
    	    }
    	} catch (UnsupportedLookAndFeelException e) {
    	    // handle exception
    	} catch (ClassNotFoundException e) {
    	    // handle exception
    	} catch (InstantiationException e) {
    	    // handle exception
    	} catch (IllegalAccessException e) {
    	    // handle exception
    	}
    	
    }
    public Main(){
        lookAndFeel();
        new CalculadoraGui().setVisible(true);
    }
    public static void main(String[] args) {
        new Main();
    }
}
