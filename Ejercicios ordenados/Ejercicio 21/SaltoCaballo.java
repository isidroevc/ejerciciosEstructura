

import javax.swing.JOptionPane;

public class SaltoCaballo {
    JOptionPane j;
    String aux;
    int N = 8;
    int t[][] = new int[N][N];
    
    void meta(){
        aux = "Programa que realice los 63 movimientos";
        aux += "\ndel salto del caballo usando técnica";
        aux += "\nde rastreo inverso.";
        j.showMessageDialog(null, aux);
    }

    boolean valido(int x, int y){
        if (x >= 0 && x < N && y >= 0 && y < N && t[x][y] == -1)
            return true;
        return false;
    }
    //Funcion para probar si i,j es valido en el tablero NxN
    
    void datos(){}//Creacion de tablero.
    
    boolean calculos(int x, int y, int movi, int xMov[],int yMov[]){
        int k, nextX, nextY;
        
        if (movi == N * N)
            return true;
        
        //Para probar los siguientes movimientos en la coordenada x,y
        for (k = 0; k < N; k++){
            nextX = x + xMov[k];
            nextY = y + yMov[k];
            if (valido(nextX, nextY)){
                t[nextX][nextY] = movi;
                if (calculos(nextX, nextY, movi + 1, xMov, yMov))
                    return true;
                else
                    t[nextX][nextY] = -1;
                    //Rastreo inverso
            }
        }
        return false;
    }
    //Funcion recursiva para resolver salto de caballo
    
    void impSol(){
        for (int x = 0; x < N; x++){
            for (int y = 0; y < N; y++)
                System.out.print("      " + t[x][y]);
            System.out.println();
        }
    }
    //Funcion para imprimir tablero resuelto
    
    boolean resultados(){
        for (int x = 0; x < N; x++)
            for (int y = 0; y < N; y++)
                t[x][y] = -1;
        //Inicializacion de matriz solucion
        
        int xMov[] = {2, 1, -1, -2, -2, -1, 1, 2};
        //Define el sig mov del Caballo en coordenada x
        int yMov[] = {1, 2, 2, 1, -1, -2, -2, -1};
        //Define el sig mov del Caballo en coordenada y
        t[0][0] = 0;
        //Iniciar caballo en posicion 0
        if (!calculos(0, 0, 1, xMov, yMov)){
            j.showMessageDialog(null, "La solucion no existe.");
            return false;
        } else
            impSol();
        //Empezar de 0,0 y explorar saltos usando funcion recursiva
        return true;
    }
    
    void navegabilidad(){}//Automatica.
    
    public static void main(String[] args) {
        SaltoCaballo sc = new SaltoCaballo();
        
        sc.meta();
        sc.resultados();
    }
}
