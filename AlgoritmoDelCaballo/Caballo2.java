package AlgoritmoDelCaballo;

import java.util.concurrent.TimeUnit;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author zuly
 */
public class Caballo2 {
     private static final int MIN = 1, MAX = 8;
    private int[][] tablero = new int[MAX+1][MAX+1]; 
    private boolean exito = false;
    private int[][] movimientos = {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};

    public Caballo2(int x, int y) {
        tablero[x][y] = 1;
    }

    // Método para iniciar el proceso de resolución
    public boolean resolverProblema(int x, int y) {
        saltoCaballo(x, y, 2, 0);  // Iniciar con el segundo movimiento y el primer índice de movimientos
        return exito;
    }

    // Método recursivo
    private void saltoCaballo(int x, int y, int i, int k) {
        // Caso base
        if (i > 64) {
            exito = true;
            return;
        }
        // Si hemos recorrido todos los movimientos posibles para esta posición y no hay éxito, regresar
        if (k >= 8 || exito) {
            return;
        }
        // Calcular nuevas posiciones
        int nx = x + movimientos[k][0];
        int ny = y + movimientos[k][1];
        // Verificar si el movimiento es válido
        if (esMovimientoValido(nx, ny)) {
            tablero[nx][ny] = i;  // Colocar el caballo en la nueva posición
            // Llamada recursiva para intentar el siguiente movimiento
            saltoCaballo(nx, ny, i + 1, 0);  // Reiniciar `k` a 0 para el siguiente nivel de recursión
            // Si no tuvo éxito, deshacer el movimiento (backtracking)
            if (!exito) {
                tablero[nx][ny] = 0;
            }
        }
        // Continuar probando con el siguiente movimiento (k+1)
        saltoCaballo(x, y, i, k + 1);
    }

    // Método auxiliar para verificar si un movimiento es válido
    private boolean esMovimientoValido(int nx, int ny) {
        return (nx >= MIN && nx <= MAX && ny >= MIN && ny <= MAX && tablero[nx][ny] == 0);
    }
    
    public void printTablero() {
        for (int i = MIN; i <= MAX; i++) {
            for (int j = MIN; j <= MAX; j++) {
                System.out.printf("%3d ║", tablero[i][j]);
            }
            System.out.println();
            System.out.println("════════════════════════════════════════════");
//            System.out.println("════╬═════╬════╬═════╬════╬═════╬═════╬════╬");
        }
    }
    
     public void detenerPantalla() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
