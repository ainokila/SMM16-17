/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.cvr.graficos;

/**
 * Colores disponibles para poder elegir
 * @author Cristian Vélez Ruiz
 */
public enum EnumColor {
    NEGRO,ROJO,AZUL,BLANCO,AMARILLO,VERDE,NINGUNO;
    
    /**
     * Metodo para obtener el valor en string del enum
     * @return String - Color del enum seleccionado
     */
    @Override
    public String toString(){
        switch(this) {
            case NEGRO: return "Negro";
            case ROJO: return "Rojo";
            case AZUL: return "Azul";
            case BLANCO: return "Blanco";
            case AMARILLO: return "Amarillo";
            case VERDE: return "Verde";
            case NINGUNO: return "No seleccionado";

            default: throw new IllegalArgumentException();
        }
    }
    
    /**
     * Metodo para obtener el valor en java.awt.Color del enum
     * @return java.awt.Color - Color del enum seleccionado
     */
    public java.awt.Color getColor(){
        switch(this) {
            case NEGRO: return java.awt.Color.black;
            case ROJO: return java.awt.Color.red;
            case AZUL: return java.awt.Color.blue;
            case BLANCO: return java.awt.Color.white;
            case AMARILLO: return java.awt.Color.yellow;
            case VERDE: return java.awt.Color.green;
            case NINGUNO: return java.awt.Color.white;

            default: throw new IllegalArgumentException();
        }
    }
    
    
}


