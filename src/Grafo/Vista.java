package Grafo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Codigo Patito
 */
public class Vista extends javax.swing.JFrame {

    public static ArrayList<Vertice> panel = new ArrayList<>();
    public static int c = 0;
    public static int cl = 0;
    public static int maxN = 10;
    public static boolean N = false;
    public static boolean L = false;
    public static Graphics h;
    public static String nombreN[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    public static String nombreL[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
        "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
    public static int maxL = nombreL.length;
    public static boolean eligioP = true;
    public Point punto;
    public static int x1, x2, y1, y2;
    public static int i = -1, j = -1;
    public static boolean MAdyacencia[][] = new boolean[maxN][maxN];
    private String matrizAdyacente = "", matrizIncedencia = "";
    int[][] matrizAdyacencia;
    private static final int INF = Integer.MAX_VALUE;

    public Vista() {
        initComponents();
        h = this.getGraphics();
        setTitle("Grafos");
        setLocationRelativeTo(null);
        setResizable(false);
        inicializa();
        btnLinea.setEnabled(false);
        btnCamino.setEnabled(false);
    }
    
    public void condicion(boolean con){
        if (con){
            lblEstado.setBackground(Color.GREEN);
        } 
    }

    public void inicializa() {
        for (int r = 0; r < maxN; r++) {
            for (int s = 0; s < maxN; s++) {
                MAdyacencia[r][s] = false;
            }
        }
    }

    public static void linea(int x, int y, int w, int z) {
        h.setColor(Color.RED);
        if (x == w && y == z) {
            h.drawArc(x + 10, y + 5, 20, 30, 320, 290);
            x = x + 15;
            y = y + 20;
        } else {
            h.drawLine(x + 20, y + 45, w + 20, z + 45);
            x = ((x + 20 - w + 20) / 2) + w;
            y = ((y + 45 - z + 45) / 2) + z;
        }
        h.setColor(Color.BLACK);
        h.drawString(nombreL[cl], x, y);
//        h.drawString(nombreL[cl], ((x + 20 - w + 20) / 2) + w, ((y + 45 - z + 45) / 2) + z);
        cl++;
    }

    public void muestraAdyacencia() {
        matrizAdyacente = "Matriz de Adyacencia  \n\n";
        int tNodos = panel.size();
        int bit = 0;
        String Nom = "";
        matrizAdyacente += "   ";
        matrizAdyacente += "  ";
        for (int k = 0; k < tNodos; k++) {
            matrizAdyacente += "  " + nombreN[k];
        }
        for (int k = 0; k < tNodos; k++) {
            matrizAdyacente += "  \n";
            for (int l = 0; l < tNodos; l++) {
                if (MAdyacencia[k][l]) {
                    bit = 1;
                } else {
                    bit = 0;
                }
                if (l == 0) {
                    Nom = nombreL[k] + "  ";
                } else {
                    Nom = "";
                }
                matrizAdyacente += Nom + bit + "   ";
            }
        }
        // Declarar la matriz de adyacencia
        matrizAdyacencia = new int[panel.size()][panel.size()];

        // Asignar los valores correspondientes
        for (int n = 0; n < panel.size(); n++) {
            for (int j = 0; j < panel.size(); j++) {
                if (MAdyacencia[n][j]) {
                    matrizAdyacencia[n][j] = 1;
                } else {
                    matrizAdyacencia[n][j] = 0;
                }
            }
        }
        setMatriz(matrizAdyacente, matrizIncedencia);
    }

    private void setMatriz(String matriz1, String matriz2) {
        System.out.println(matriz1 + "\n\n" + matriz2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnSalir1 = new javax.swing.JButton();
        btnVertice = new javax.swing.JButton();
        btnLinea = new javax.swing.JButton();
        btnCamino = new javax.swing.JButton();
        panelView = new javax.swing.JPanel();
        lblEstado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Menu"));

        btnSalir1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSalir1.setText("Limpiar");
        btnSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir1ActionPerformed(evt);
            }
        });

        btnVertice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circulo.png"))); // NOI18N
        btnVertice.setText("Vertice");
        btnVertice.setToolTipText("");
        btnVertice.setFocusPainted(false);
        btnVertice.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVertice.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVertice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerticeActionPerformed(evt);
            }
        });

        btnLinea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea.png"))); // NOI18N
        btnLinea.setText("Arista");
        btnLinea.setFocusPainted(false);
        btnLinea.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLinea.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLineaActionPerformed(evt);
            }
        });

        btnCamino.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCamino.setText("Camino más corto");
        btnCamino.setFocusPainted(false);
        btnCamino.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCamino.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCamino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaminoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnVertice, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(37, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSalir1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCamino, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(26, 26, 26))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVertice, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(btnCamino)
                .addGap(18, 18, 18)
                .addComponent(btnSalir1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        panelView.setBackground(new java.awt.Color(255, 255, 255));
        panelView.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));
        panelView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelViewMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelViewLayout = new javax.swing.GroupLayout(panelView);
        panelView.setLayout(panelViewLayout);
        panelViewLayout.setHorizontalGroup(
            panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 696, Short.MAX_VALUE)
        );
        panelViewLayout.setVerticalGroup(
            panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 556, Short.MAX_VALUE)
        );

        lblEstado.setBorder(javax.swing.BorderFactory.createTitledBorder("Estado"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerticeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerticeActionPerformed
        if (N) {
            N = false;
            L = false;
            lblEstado.setText("Vertice y Arista Desactivado");
            btnVertice.setBackground(null);
            btnLinea.setBackground(null);
        } else {
            L = false;
            N = true;
            btnVertice.setBackground(Color.decode("#79f966"));
            btnLinea.setBackground(null);
            lblEstado.setText("Vertice Activo");
        }
    }//GEN-LAST:event_btnVerticeActionPerformed

    private void btnLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLineaActionPerformed
        if (L) {
            L = false;
            N = false;
            lblEstado.setText("Vertice y Arista Desactivado");
            btnVertice.setBackground(null);
            btnLinea.setBackground(null);
        } else {
            N = false;
            L = true;
            btnLinea.setBackground(Color.decode("#79f966"));
            btnVertice.setBackground(null);
            lblEstado.setText("Arista Activo");
        }
    }//GEN-LAST:event_btnLineaActionPerformed

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
        panel.clear();
        panelView.removeAll();
        c = 0;
        cl = 0;
        N = false;
        L = false;
        eligioP = true;
        i = -1;
        j = -1;
        inicializa();
        matrizAdyacente = "";
        matrizIncedencia = "";
        h.setColor(Color.WHITE);
        h.fillRect(20,40, 600, 550);
        btnLinea.setEnabled(false);
        //Matriz.setText("");
        //btnAyacente.setEnabled(false);
        //btnIncidencia.setEnabled(false);
    }//GEN-LAST:event_btnSalir1ActionPerformed

    private void panelViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelViewMouseClicked
        if (panelView.getMousePosition() != null) {
            Point p = panelView.getMousePosition().getLocation();
            if (!L) {
                if (N) {
                    btnLinea.setEnabled(true);
                    btnCamino.setEnabled(true);
                    Vertice prueba = new Vertice();
                    prueba.setBounds(p.x - 15, p.y - 10, 31, 31);
                    panelView.add(prueba);
                    panel.add(prueba);
                    prueba.dibuja(prueba.getGraphics());
                }
            }
        }
    }//GEN-LAST:event_panelViewMouseClicked

    private void btnCaminoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaminoActionPerformed
        muestraAdyacencia();
        dijkstra(matrizAdyacencia, 0);
        int vinicio = 0;
        int vfin = 0;
        String ini = JOptionPane.showInputDialog("Ingresa el vertice de Inicio: ");
        String f = JOptionPane.showInputDialog("Ingresa el vertice final: ");
        String inicio = ini.toUpperCase();
        String fin = f.toUpperCase();        
        try {
        for (int n = 0; n < 9 ; n++) {
            if (nombreN[n].equals(inicio)) {
                vinicio = n;
            }
            if (nombreN[n].equals(fin)) {
                vfin = n;
            }            
        }
        if (vinicio == vfin){
            JOptionPane.showMessageDialog(null, "Vertices no encontrados, intenta de nuevo o incoherentes");
            return;
        }
        dijkstra(vinicio, vfin); 
        } catch (ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, "No es posible llegar del vertice "+inicio+" al vertice "+fin);
        }
    }//GEN-LAST:event_btnCaminoActionPerformed
    
    public void dijkstra(int nodoInicial, int nodoFinal) {
        int[] distancia = new int[panel.size()];
        int[] padre = new int[panel.size()];
        boolean[] visitado = new boolean[panel.size()];

        // Inicializar las distancias a todos los nodos como infinito
        for (int i = 0; i < panel.size(); i++) {
            distancia[i] = INF;
            padre[i] = -1;
            visitado[i] = false;
        }
        // La distancia al nodo inicial es 0
        distancia[nodoInicial] = 0;

        // Iterar mientras no se hayan visitado todos los nodos
        for (int i = 0; i < panel.size(); i++) {
            // Encontrar el nodo no visitado con la distancia más corta
            int u = -1;
            for (int j = 0; j < panel.size(); j++) {
                if (!visitado[j] && (u == -1 || distancia[j] < distancia[u])) {
                    u = j;
                }
            }
            if (u == -1 || distancia[u] == INF) {
                break; // No hay más nodos por visitar
            }
            visitado[u] = true;

            // Actualizar las distancias de los nodos adyacentes
            for (int v = 0; v < panel.size(); v++) {
                if (MAdyacencia[u][v]) {
                    int peso = matrizAdyacencia[u][v];
                    if (distancia[u] + peso < distancia[v]) {
                        distancia[v] = distancia[u] + peso;
                        padre[v] = u;
                    }
                }
            }
        }

        // Construir el camino más corto
        ArrayList<Integer> camino = new ArrayList<>();
        int nodoActual = nodoFinal;
        while (nodoActual != nodoInicial) {
            camino.add(nodoActual);
            nodoActual = padre[nodoActual];
        }
        camino.add(nodoInicial);
        Collections.reverse(camino);

        // Imprimir el camino y la distancia
        String caminoStr = "";
        for (int i = 0; i < camino.size(); i++) {
            int nodo = camino.get(i);
            caminoStr += nombreN[nodo];
            if (i < camino.size() - 1) {
                caminoStr += " -> ";
            }
        }
        String distanciaStr = "Distancia: " + distancia[nodoFinal];
        resaltarCamino(camino, h);
        JOptionPane.showMessageDialog(this, caminoStr + "\n" + distanciaStr, "Camino más corto", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void resaltarCamino(ArrayList<Integer> camino, Graphics g) {
        // Cambiar el color de las aristas y vértices correspondientes en el camino
        g.setColor(Color.GREEN); // cambiar a otro color que quieras utilizar
        for (int i = 0; i < camino.size() - 1; i++) {
            int v1 = camino.get(i);
            int v2 = camino.get(i + 1);
            g.drawLine(panel.get(v1).getX()+20, panel.get(v1).getY()+45, panel.get(v2).getX()+20, panel.get(v2).getY()+45);
        }
    }

    // Función auxiliar para encontrar el vértice con la distancia mínima
    static int minDistance(int dist[], Boolean visited[]) {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < panel.size(); v++) {
            if (visited[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        }

        return min_index;
    }

    // Función para imprimir la solución
    static void printSolution(int dist[]) {
        System.out.println("Distancia desde el origen a cada vértice:");
        for (int n = 0; n < panel.size(); n++) {
            System.out.println(i + " \t\t " + dist[n]);
        }
    }
 
   

    // Función que implementa el algoritmo de Dijkstra para un grafo representado por una matriz de adyacencia
    static void dijkstra(int graph[][], int src) {
        int dist[] = new int[panel.size()]; // dist[i] almacenará la distancia más corta desde src hasta i

        Boolean visited[] = new Boolean[panel.size()]; // visited[i] será verdadero si el vértice i ya fue visitado
        for (int n = 0; n < panel.size(); n++) {
            dist[n] = Integer.MAX_VALUE;
            visited[n] = false;
        }

        dist[src] = 0; // La distancia desde el origen a sí mismo es siempre 0

        // Encontrar la ruta más corta para todos los vértices
        for (int count = 0; count < panel.size() - 1; count++) {
            int u = minDistance(dist, visited);

            visited[u] = true;

            for (int v = 0; v < panel.size(); v++) {
                if (!visited[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        // Imprimir la solución
        printSolution(dist);
    }

    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCamino;
    private javax.swing.JButton btnLinea;
    private javax.swing.JButton btnSalir1;
    private javax.swing.JButton btnVertice;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JPanel panelView;
    // End of variables declaration//GEN-END:variables
}
