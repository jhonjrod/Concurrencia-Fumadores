/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Milton Rodriguez
 */
public class Fumador3 {
    public boolean puedefumar;
    public String ingrediente = "Tabaco";//tabaco
    
    public void fumar(Mesa mesa, Agente agente){
        System.out.println("Fumador 3 que tiene tabaco toma "+ mesa.objetosmesa.get(0)+","+mesa.objetosmesa.get(1)+", y fuma...");
        agente.puedeponeringredientes=true;
    }
}
