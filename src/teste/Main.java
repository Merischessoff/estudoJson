
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
            System.out.println(predio99.getLista());
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
