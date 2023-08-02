
package AG1;

import java.util.*;

public class Individuo {
    protected final String alfabeto = "abcdefghijklmnopqrtsuvwxyz";
    private String cromosoma = "";
    private int n;
    
    public Individuo(int n){
        init(n);
    }
    
    public Individuo(){
        
    }
    
    private void init(int n){
        for(int i=0; i<n; i++){
            Random r = new Random();
            int index = r.nextInt(alfabeto.length());
            cromosoma += Character.toString(alfabeto.charAt(index));
        }
        //cromosoma = "qazo";
        this.n = n;
    }
    
    public String getCromosoma(){
        return this.cromosoma;
    }
    
    public void setCromosoma(String cromosoma){
        this.cromosoma = cromosoma;
    }
    
}
