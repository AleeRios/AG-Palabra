package AG1;

public class FitnessFunction {
    private String pal;
    
    public FitnessFunction(String pal){
        this.pal = pal;
    }
    
    private int evaluarLetras(Individuo ind){
        int cont = 0;
        String cromosoma = ind.getCromosoma();
        for(int i=0; i<pal.length(); i++){
            char c = pal.charAt(i);
            if(cromosoma.contains(Character.toString(c)))
                cont++;
            else continue;
        }
        return cont;
    }
    
    private int evaluarPosicion(Individuo ind){
        int cont = 0;
        String cromosoma = ind.getCromosoma();
        for(int i=0; i<pal.length(); i++){
            /*int p = pal.indexOf(pal.charAt(i));
            int c = cromosoma.indexOf(pal.charAt(i));
            if(p > -1 && c > -1)
                if(p == c)
                    cont++;
                else continue;
            else continue;*/
            String p = Character.toString(pal.charAt(i));
            String c = Character.toString(cromosoma.charAt(i));
            if(p.equals(c))
                cont++;
            else continue;
        }
        return cont;
    }
    
    public int evaluar(Individuo ind){
        return evaluarLetras(ind) + evaluarPosicion(ind);
    }
    
}
