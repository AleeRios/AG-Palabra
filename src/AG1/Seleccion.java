package AG1;

import java.util.*;

public class Seleccion {
    ArrayList<Individuo> pob = new ArrayList<>();
    
    public Seleccion(){
        
    }
    
    public ArrayList Ruleta(ArrayList<Individuo> pob, ArrayList<Integer> mej, int suma){
        ArrayList<Integer> al = new ArrayList<>();
        ArrayList<Integer> indices = new ArrayList<>();
        for(int i=0; i<mej.size(); i++){
            Random r = new Random();
            int num = r.nextInt(suma+1);
            al.add(num);
            int cont = 0, s = 0;
            for(int j=0; j<mej.size(); j++){
                if(s <= num){
                    s += mej.get(j);
                    cont++;
                }
                if(s >= num){
                    indices.add(cont-1);
                    break;
                }
            }
        }
        System.out.println("Aleatorios generados: " + al);
        //System.out.println(indices);
        return indices;
    }
}
