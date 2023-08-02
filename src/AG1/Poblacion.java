package AG1;

import java.util.*;

public class Poblacion {
    private String pal;
    private int tamP;
    private ArrayList<Individuo> pob = new ArrayList<>();
    
    public Poblacion(String pal, int tamP){
        this.pal = pal;
        this.tamP = tamP;
    }
    
    public Poblacion(ArrayList pob){
        this.pob = pob;
    }
    
    public String getPal(){
        return this.pal;
    }
    
    public void initPoblacion(){
        for(int i=0; i<tamP; i++)
            pob.add(new Individuo(pal.length()));
    }
    
    public Individuo getInd(int index){
        return pob.get(index);
    }
    
    public ArrayList getPob(){
        return this.pob;
    }
    
    public void cruzar(ArrayList<Individuo> pob, ArrayList<Integer> indices){
        ArrayList<Individuo> padres = new ArrayList<>();
        ArrayList<Individuo> madres = new ArrayList<>();
        
        for(int i=0; i<pob.size(); i+=2)
            padres.add(pob.get(indices.get(i)));
        for(int i=1; i<pob.size(); i+=2)
            madres.add(pob.get(indices.get(i)));
        pob.clear();
        for(int i=0; i<padres.size(); i++){
            String padre = padres.get(i).getCromosoma();
            String madre = madres.get(i).getCromosoma();
            int mitad = Math.round(padre.length()/2);
            String hijo1 = padre.substring(0, mitad) + madre.substring(mitad, madre.length());
            String hijo2 = madre.substring(0, mitad) + padre.substring(mitad, padre.length());
            //System.out.println("Hijo 1: " + hijo1);
            //System.out.println("Hijo 2: " + hijo2);
            Individuo ind1 = new Individuo();
            ind1.setCromosoma(hijo1);
            Individuo ind2 = new Individuo();
            ind2.setCromosoma(hijo2);
            pob.add(ind1);
            pob.add(ind2);
        }
        this.pob = pob;
    }
    
    public void mutar(Individuo ind){
        String alfabeto = "abcdefghijklmnopqrtsuvwxyz";
        String cromosoma = ind.getCromosoma();
        float div = cromosoma.length() / 5f;
        int numVeces = Math.round(div);
        if(numVeces > 0){
            for(int i=0; i<numVeces; i++){
                Random r = new Random();
                Random r2 = new Random();
                cromosoma = ind.getCromosoma();
                int idx = r.nextInt(cromosoma.length());
                int idx2 = r2.nextInt(alfabeto.length());
                String mutar =  cromosoma.replaceFirst(Character.toString(cromosoma.charAt(idx)), Character.toString(alfabeto.charAt(idx2)));
                ind.setCromosoma(mutar);
                System.out.println("Mutacion: [" + cromosoma + "] -> [" + mutar + "]\n");
            }
        }else{
            Random r = new Random();
            Random r2 = new Random();
            cromosoma = ind.getCromosoma();
            int idx = r.nextInt(cromosoma.length());
            int idx2 = r2.nextInt(alfabeto.length());
            String mutar =  cromosoma.replaceFirst(Character.toString(cromosoma.charAt(idx)), Character.toString(alfabeto.charAt(idx2)));
            ind.setCromosoma(mutar);
            System.out.println("Mutacion: [" + cromosoma + "] -> [" + mutar + "]\n");
        }
    }
}
