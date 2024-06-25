/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import java.util.Random;


/**
 *
 * @author Milton Rodriguez
 */
public class Concurrencia {
    Fumador1 fumador1 = new Fumador1();
    Fumador2 fumador2 = new Fumador2();
    Fumador3 fumador3 = new Fumador3();
    Agente agente = new Agente();
    Mesa mesa = new Mesa();
    
    
    
    public void iniciar(){
        
        agente.puedeponeringredientes=true;
        fumador1.puedefumar=false;
        fumador2.puedefumar=false;
        fumador3.puedefumar=false;
        ponerIngredientesMesa();
    }
    
    public void fumar(){
        if(fumador1.puedefumar){
            System.out.println("Fumador 1 que tiene cerillas toma "+ mesa.objetosmesa.get(0)+","+mesa.objetosmesa.get(1)+", y fuma...");
            agente.puedeponeringredientes=true;//desbloquea al agente
            fumador1.puedefumar=false;
            esperar(2);
        }
        if(fumador2.puedefumar){
            System.out.println("Fumador 2 que tiene papel toma "+ mesa.objetosmesa.get(0)+","+mesa.objetosmesa.get(1)+", y fuma...");
            agente.puedeponeringredientes=true;//desbloquea al agente
            fumador2.puedefumar=false;
            esperar(2);
        }
        if(fumador3.puedefumar){
            System.out.println("Fumador 3 que tiene tabaco toma "+ mesa.objetosmesa.get(0)+","+mesa.objetosmesa.get(1)+", y fuma...");
            agente.puedeponeringredientes=true;//desbloquea al agente
            fumador3.puedefumar=false;
            esperar(2);
        }
    }
    
    public void ponerIngredientesMesa(){
        
        
        if(agente.puedeponeringredientes){
            mesa.objetosmesa.clear();//quita los ingredientes de la mesa para poner los nuevos
            
            Random dado = new Random();//genera dos numeros aleatorios diferentes entre 1 y 3
            int num_al;
            int [] arreglo = {0,0};//quiero que aqui queden al final 10 numeros aleatorios no repetidos, del 1 al 10
        
        
            for(int i=0;i<=1;i++){
                if(i==0){
                    num_al = 0;
                }else{
                    num_al = dado.nextInt(3)+1;
                }
            
            
            
            while(num_al==arreglo[0]||num_al==arreglo[1]){
                num_al = dado.nextInt(3)+1;
            }
            
            arreglo[i] = num_al;
            
            }
        
            //for(int i=0;i<arreglo.length;i++){
                //System.out.println(arreglo[i]);
            //}
            
            //en base a los aleatorios pone los elementos en la mesa
            //el equivalente a poner los ingredientes es guardar las cadenas en el arraylist
            if(arreglo[0]==1){
                mesa.objetosmesa.add("Cerillas");
            }
            if(arreglo[0]==2){
                mesa.objetosmesa.add("Papel");
            }
            if(arreglo[0]==3){
                mesa.objetosmesa.add("Tabaco");
            }
            
            if(arreglo[1]==1){
                mesa.objetosmesa.add("Cerillas");
            }
            if(arreglo[1]==2){
                mesa.objetosmesa.add("Papel");
            }
            if(arreglo[1]==3){
                mesa.objetosmesa.add("Tabaco");
            }
            
            System.out.println("Agente pone sobre la mesa "+mesa.objetosmesa.get(0)+", "+mesa.objetosmesa.get(1));
            esperar(2);
            
            agente.puedeponeringredientes=false;//se bloquea el agente
            
            
            buscarFumadorCorrecto();//desbloquea al fumador que tiene el tercer ingrediente (el faltante)
            
            
            
        }
        
        
    }
    
    public void buscarFumadorCorrecto(){
        
        if(!fumador1.ingrediente.equals(mesa.objetosmesa.get(0)) && !fumador1.ingrediente.equals(mesa.objetosmesa.get(1))){
            fumador1.puedefumar=true;
            fumar();
        }
        
        if(!fumador2.ingrediente.equals(mesa.objetosmesa.get(0)) && !fumador2.ingrediente.equals(mesa.objetosmesa.get(1))){
            fumador2.puedefumar=true;
            fumar();
        }
        
        if(!fumador3.ingrediente.equals(mesa.objetosmesa.get(0)) && !fumador3.ingrediente.equals(mesa.objetosmesa.get(1))){
            fumador3.puedefumar=true;
            fumar();
        }
        
        
        
        ponerIngredientesMesa();
        
    }
    
    public void esperar(int segundos){//metodo que usa el metodo sleep de la clase Thread para poner a "dormir" el programa un cierto tiempo en milisegundos.
        try {
            Thread.sleep(segundos * 1000);
         } catch (Exception e) {
            System.out.println(e);
         }
    } 
    
    
    
    public static void main(String[] args){
        Concurrencia c = new Concurrencia();
        c.iniciar();
    }
    
}
