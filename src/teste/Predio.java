/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.util.ArrayList;
import java.util.List;

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
        for(Predio f: lista){
            System.out.println(f.andar);
        }
        return null;
    }

    @Override
    public List<Character> elevadorMaisFrequentado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Character> periodoMaiorFluxoElevadorMaisFrequentado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Character> elevadorMenosFrequentado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Character> periodoMenorFluxoElevadorMenosFrequentado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Character> periodoMaiorUtilizacaoConjuntoElevadores() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float percentualDeUsoElevadorA() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float percentualDeUsoElevadorB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float percentualDeUsoElevadorC() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float percentualDeUsoElevadorD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float percentualDeUsoElevadorE() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
      
}
