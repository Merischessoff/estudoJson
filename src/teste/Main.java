
package teste;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static java.util.Spliterators.iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

        /*Suponha que a administração do prédio 99a da Tecnopuc, com 16 andares e cinco elevadores, 
        denominados A, B, C, D e E, nos convidou a aperfeiçoar o sistema de controle dos elevadores. 
        Depois de realizado um levantamento no qual cada usuário respondia:
        a. O elevador que utiliza com mais frequência (A, B, C, D ou E);
        b. O andar ao qual se dirigia (0 a 15);
        c. O período que utilizava o elevador – M: Matutino; V: Vespertino; N: Noturno.

        Considerando que este possa evoluir para um sistema dinâmico, escreva o código que nos ajude a extrair as seguintes informações:
        a. Qual é o andar menos utilizado pelos usuários;
        b. Qual é o elevador mais frequentado e o período que se encontra maior fluxo;
        c. Qual é o elevador menos frequentado e o período que se encontra menor fluxo;
        d. Qual o período de maior utilização do conjunto de elevadores;
        e. Qual o percentual de uso de cada elevador com relação a todos os serviços prestados;*/
 
public class Main {
 
    public static void main(String[] args){
        //JSONObject jsonObject;
        JSONParser parser = new JSONParser();
        JSONArray jsonArray;
        Predio predio99 = new Predio();
        String andar="";
        String elevador="";
        String turno="";
        List <Predio>listaP = new ArrayList();
        try {
            FileReader f = new FileReader("input.json");
            jsonArray = (JSONArray) parser.parse(f);
            Iterator<JSONObject> iterator = jsonArray.iterator();
            while (iterator.hasNext()) {
                predio99 = new Predio();
                JSONObject objt = iterator.next();
                andar = objt.get("andar").toString();
                predio99.setAndar(Integer.parseInt(andar));
                elevador = objt.get("elevador").toString();
                predio99.setElevador(elevador.charAt(0));
                turno = objt.get("turno").toString();
                predio99.setTurno(turno.charAt(0));
                
                listaP.add(predio99);
            }
             predio99.setLista(listaP);
             System.out.println("Andar menos Utilizado" + predio99.andarMenosUtilizado());
             System.out.println("Elevador mais frequentado" + predio99.elevadorMaisFrequentado());
             System.out.println("Elevador menos frequentado" + predio99.elevadorMenosFrequentado());
             System.out.println("Turno com maior fluxo de elevador mais frequentado " + predio99.periodoMaiorFluxoElevadorMaisFrequentado());
             System.out.println("Turno com menor fluxo de elevador menos frequentado " + predio99.periodoMenorFluxoElevadorMenosFrequentado());
             System.out.println("Periodo em que os elevadores são mais utilizados " + predio99.periodoMaiorUtilizacaoConjuntoElevadores());
             System.out.println("Percentual Elevador A " + predio99.percentualDeUsoElevadorA()+"%");
             System.out.println("Percentual Elevador B " + predio99.percentualDeUsoElevadorB()+"%");
             System.out.println("Percentual Elevador C " + predio99.percentualDeUsoElevadorC()+"%");
             System.out.println("Percentual Elevador D " + predio99.percentualDeUsoElevadorD()+"%");
             System.out.println("Percentual Elevador E " + predio99.percentualDeUsoElevadorE()+"%");

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }catch (ParseException e) {
            e.printStackTrace();
        }
        
       
    }
}
