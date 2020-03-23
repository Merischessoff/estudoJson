/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author pc
 */
public class Predio implements IElevadorService{
    private int andar;
    private char elevador;
    private char turno;
    private List <Predio> lista  = new ArrayList();

    public Predio(int andar, char elevador, char turno) {
        this.andar = andar;
        this.elevador = elevador;
        this.turno = turno;
    }

    Predio() {}

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public char getElevador() {
        return elevador;
    }

    public void setElevador(char elevador) {
        this.elevador = elevador;
    }

    public char getTurno() {
        return turno;
    }

    public void setTurno(char turno) {
        this.turno = turno;
    }
    
    public List <Predio> getLista() {
        return lista;
    }

    public void setLista(List <Predio> lista) {
        this.lista = lista;
    }
    
    @Override
    public String toString() {
        return "Elevador{" + "andar=" + andar + ", elevador=" + elevador + ", turno=" + turno + '}';
    }

    @Override
    public List<Integer> andarMenosUtilizado() {
        List <Integer> aux = new ArrayList();
        Map<Integer,Integer> mapa = new TreeMap<Integer, Integer>();
        int menor = 0;
            for(Predio f: lista){
               if(!mapa.containsKey(f.andar)){
                   mapa.put(f.andar, 1);
                   //System.out.println("nao tem na lista " + f.andar);
               }else{
                   mapa.put(f.andar, mapa.get(f.andar)+1);
                   //System.out.println("tem na lista " + f.andar + "valor " + mapa.get(f.andar));
                   if(f.andar < menor){
                    menor = mapa.get(f.andar);
                   }
               }
            }
            aux.add(menor);
            //System.out.println(menor);
        return aux;
    }

    @Override
    public List<Character> elevadorMaisFrequentado() {
        List <Character> aux = new ArrayList();
        Map<Character,Integer> mapa = new TreeMap<Character, Integer>();
        char maior = 0;
        int mais=1;
            for(Predio f: lista){
               if(!mapa.containsKey(f.elevador)){
                   mapa.put(f.elevador, 1);
                   if(mapa.get(f.elevador) >= mais){
                    maior = f.elevador;
                    mais = mapa.get(f.elevador);
                   }
               }else{
                   mapa.put(f.elevador, mapa.get(f.elevador)+1);
                   if(mapa.get(f.elevador) > mais){
                    maior = f.elevador;
                    mais = mapa.get(f.elevador);
                   }
               }
            }
            aux.add(maior);
            //System.out.println(maior);
        return aux;
    }

    @Override
    public List<Character> periodoMaiorFluxoElevadorMaisFrequentado() {
        List <Character> aux = elevadorMaisFrequentado();
        Character elevador = aux.get(0);
        Map<Character,Integer> mapa = new TreeMap<Character, Integer>();
        char maior = 0;
        int mais=1;
            for(Predio f: lista){
               if(!mapa.containsKey(f.turno)){
                   mapa.put(f.turno, 1);
                   if(mapa.get(f.turno) >= mais){
                    maior = f.turno;
                    mais = mapa.get(f.turno);
                   }
               }else if(f.elevador == elevador){
                   mapa.put(f.turno, mapa.get(f.turno)+1);
                   if(mapa.get(f.turno) > mais){
                    maior = f.turno;
                    mais = mapa.get(f.turno);
                   }
               }
            }
            List <Character> aux1 = new ArrayList();
            aux1.add(maior);
            //System.out.println(maior);
        return aux1;
    }

    @Override
    public List<Character> elevadorMenosFrequentado() {
        List <Character> aux = new ArrayList();
        Map<Character,Integer> mapa = new TreeMap<Character, Integer>();
        char menor = 0;
        int menos=1;
            for(Predio f: lista){
               if(!mapa.containsKey(f.elevador)){
                   mapa.put(f.elevador, 1);
                   if(mapa.get(f.elevador) <= menos){
                    menor = f.elevador;
                    menos = mapa.get(f.elevador);
                   }
               }else{
                   mapa.put(f.elevador, mapa.get(f.elevador)+1);
                   if(mapa.get(f.elevador) < menos){
                    menor = f.elevador;
                    menos = mapa.get(f.elevador);
                   }
               }
            }
            aux.add(menor);
            //System.out.println(menor);
        return aux;
    }

    @Override
    public List<Character> periodoMenorFluxoElevadorMenosFrequentado() {
      List <Character> aux = elevadorMenosFrequentado();
        Character elevador = aux.get(0);
        Map<Character,Integer> mapa = new TreeMap<Character, Integer>();
        char menor = 0;
        int menos=1;
            for(Predio f: lista){
               if(!mapa.containsKey(f.turno)){
                   mapa.put(f.turno, 1);
                   if(mapa.get(f.turno) <= menos){
                    menor = f.turno;
                    menos = mapa.get(f.turno);
                   }
               }else if(f.elevador == elevador){
                   mapa.put(f.turno, mapa.get(f.turno)+1);
                   if(mapa.get(f.turno) < menos){
                    menor = f.turno;
                    menos = mapa.get(f.turno);
                   }
               }
            }
            List <Character> aux1 = new ArrayList();
            aux1.add(menor);
            //System.out.println(maior);
        return aux1;
    }

    @Override
    public List<Character> periodoMaiorUtilizacaoConjuntoElevadores() {
        Map<Character,Integer> mapa = new TreeMap<Character, Integer>();
        char maior = 0;
        int mais=1;
            for(Predio f: lista){
               if(!mapa.containsKey(f.turno)){
                   mapa.put(f.turno, 1);
                   if(mapa.get(f.turno) >= mais){
                    maior = f.turno;
                    mais = mapa.get(f.turno);
                   }
               }else{
                   mapa.put(f.turno, mapa.get(f.turno)+1);
                   if(mapa.get(f.turno) > mais){
                    maior = f.turno;
                    mais = mapa.get(f.turno);
                   }
               }
            }
            List <Character> aux1 = new ArrayList();
            aux1.add(maior);
            return aux1;
    }

    @Override
    public float percentualDeUsoElevadorA() {
        int contA = 0;
        int contT = 0;
        int i=0;
            for(i=0; i<lista.size();i++){
                if(lista.get(i).elevador == 'A'){
                   contA++; 
                }
             contT++;
            }
        
        float percentual = ((contA * 100) / contT);
        System.out.println("Contador A " + contA + " " + contT);
        return percentual;    
    }

    @Override
    public float percentualDeUsoElevadorB() {
        int contB = 0;
        int contT = 0;
        int i=0;
            for(i=0; i<lista.size();i++){
                if(lista.get(i).elevador == 'B'){
                   contB++; 
                }
             contT++;
            }
        
        float percentual = ((contB * 100) / contT);
        
        return percentual;    
       
    }

    @Override
    public float percentualDeUsoElevadorC() {
        int contC = 0;
        int contT = 0;
        int i=0;
            for(i=0; i<lista.size();i++){
                if(lista.get(i).elevador == 'C'){
                   contC++; 
                }
             contT++;
            }
        
        float percentual = ((contC * 100) / contT);
        
        return percentual;
        
    }

    @Override
    public float percentualDeUsoElevadorD() {
        int contD = 0;
        int contT = 0;
        int i=0;
            for(i=0; i<lista.size();i++){
                if(lista.get(i).elevador == 'D'){
                   contD++; 
                }
             contT++;
            }
        
        float percentual = ((contD * 100) / contT);
        
        return percentual;
        
    }

    @Override
    public float percentualDeUsoElevadorE() {
        int contE = 0;
        int contT = 0;
        int i=0;
            for(i=0; i<lista.size();i++){
                if(lista.get(i).elevador == 'E'){
                   contE++; 
                }
             contT++;
            }
        
        float percentual = ((contE * 100) / contT);
        
        return percentual;
        
    }

    
      
}
