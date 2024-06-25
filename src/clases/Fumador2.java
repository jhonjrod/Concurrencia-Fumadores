/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Milton Rodriguez
 */
public class Fumador2 {
    public boolean puedefumar;
    public String ingrediente = "Papel";//papel
    
    public void fumar(Mesa mesa, Agente agente){
        System.out.println("Fumador 2 que tiene papel toma "+ mesa.objetosmesa.get(0)+","+mesa.objetosmesa.get(1)+", y fuma...");
        agente.puedeponeringredientes=true;
    }
    
}
