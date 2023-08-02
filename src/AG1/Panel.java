package AG1;

import java.util.ArrayList;
import java.util.Collections;

public class Panel extends javax.swing.JFrame {
    private ArrayList<String> cromosomas = new ArrayList<>();

    public Panel() {
        initComponents();
        cromosomas.add("");
    }
    
    private static int anadir(ArrayList<Individuo> p, ArrayList<Integer> apt, int suma){
        int d = Collections.max(apt);
        int index = apt.indexOf(d);
        String c = p.get(index).getCromosoma();
        Individuo i = new Individuo();
        i.setCromosoma(c);
        p.add(i);
        apt.add(d);
        suma += apt.get(apt.size()-1);
        return suma;
    }
    
    private static void imprimirPoblacion(ArrayList<Individuo> p, ArrayList<Integer> apt){
        for(int i=0; i<p.size(); i++)
            System.out.println(i + ". [" + p.get(i).getCromosoma() + "], Aptitud: "+ apt.get(i));
        
    }
    
    private static String imprimirPoblacion2(ArrayList<Individuo> p, ArrayList<Integer> apt){
        String cad = "";
        for(int i=0; i<p.size(); i++)
            cad += i + ". [" + p.get(i).getCromosoma() + "], Aptitud: "+ apt.get(i) + "\n";
       return cad; 
    }
    
    public void iniciar(String pal, int tamP, int ite){
        //Scanner x = new Scanner(System.in);
        //System.out.print("Ingrese una palabra: ");
        //String pal = x.nextLine().toLowerCase().replaceAll(" ", "");
        //System.out.print("Ingrese un tamanio de poblacion: ");
        //int tamP = x.nextInt();
        //System.out.println();
        
        ArrayList<Integer> apt = new ArrayList<>();
        ArrayList<Individuo> p;
        ArrayList<Integer> indices;
        Poblacion pob = new Poblacion(pal, tamP);
        FitnessFunction ff = new FitnessFunction(pal);
        Seleccion sel = new Seleccion();
        int suma = 0;
        pob.initPoblacion();
        p = pob.getPob();
        
        for(int i=0; i<p.size(); i++){
            int ev = ff.evaluar(p.get(i));
            suma += ev;
            apt.add(ev);
        }
        
        if(p.size() % 2 != 0)
            suma = anadir(p, apt, suma);
        System.out.println("\t\tPrimera Poblacion\n");
        imprimirPoblacion(p, apt);
        System.out.println("\nLa suma es: " + suma + ", el tamaño es: " + p.size());
        indices = sel.Ruleta(p, apt, suma);
        System.out.println("Indices: " + indices);
        int con = 1, n = 0;
        
        //while(!apt.contains(pal.length()*2)){
        while(n<ite || !cromosomas.contains(pal)){
            cromosomas.clear();
            suma = 0;
            apt.clear();
            pob.cruzar(p, indices);
            p = pob.getPob();
            int mut = Math.round(p.size() * .05f);
            for(int i=0; i<mut; i++){
                pob.mutar(p.get(i));
            }
            for(int i=0; i<p.size(); i++){
                suma += ff.evaluar(p.get(i));
                apt.add(ff.evaluar(p.get(i)));
                cromosomas.add(p.get(i).getCromosoma());
            }
            if(p.size() % 2 != 0)
                suma = anadir(p, apt, suma);
            
            System.out.println("\t\tPoblacion "+con);
            imprimirPoblacion(p, apt);
            System.out.println("\nLa suma es: " + suma + ", el tamaño es: " + p.size());
            indices = sel.Ruleta(p, apt, suma);
            System.out.println("Indices: " + indices);
            //break;
            n++;
            con++;
        }
        String aux = "\t\tUltima poblacion\n\n";
        System.out.println("\t\tUltima poblacion");
        imprimirPoblacion(p, apt);
        aux += imprimirPoblacion2(p, apt);
        
        if(!cromosomas.contains(pal)){
            System.out.println("\nPalabra [" + pal + "] NO ENCONTRADA!!");
            aux += "\nPalabra [" + pal + "] NO ENCONTRADA!!";
        }
        else{
            System.out.println("\nPalabra [" + cromosomas.get(cromosomas.indexOf(pal)) + "] ENCONTRADA EN EL INDICE: " + cromosomas.indexOf(pal));
            aux += "\nPalabra [" + cromosomas.get(cromosomas.indexOf(pal)) + "] ENCONTRADA EN EL INDICE: " + cromosomas.indexOf(pal);
        }
        txtArea.setText(aux);
        p.clear();
        apt.clear();
        cromosomas.clear();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtPO = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtIte = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        txtPob = new javax.swing.JTextField();
        btnIni = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Palabra Objetivo:");

        jLabel2.setText("Poblacion:");

        txtIte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIteActionPerformed(evt);
            }
        });

        txtArea.setEditable(false);
        txtArea.setColumns(20);
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);

        jLabel3.setText("Numero de iteraciones: ");

        txtPob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPobActionPerformed(evt);
            }
        });

        btnIni.setText("Iniciar");
        btnIni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtPO, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPob, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtIte, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(btnIni)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIni))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtIte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIteActionPerformed

    private void txtPobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPobActionPerformed

    private void btnIniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniActionPerformed
        String pal = txtPO.getText().toLowerCase().replaceAll(" ", "");
        int tamP = Integer.parseInt(txtPob.getText());
        int ite = Integer.parseInt(txtIte.getText());
        iniciar(pal, tamP, ite);
    }//GEN-LAST:event_btnIniActionPerformed


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Panel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JTextField txtIte;
    private javax.swing.JTextField txtPO;
    private javax.swing.JTextField txtPob;
    // End of variables declaration//GEN-END:variables
}
