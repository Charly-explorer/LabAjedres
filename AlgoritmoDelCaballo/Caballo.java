/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AlgoritmoDelCaballo;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author Johel M
 */
public class Caballo {
    private static final int MIN = 1, MAX = 8;
    private static final int N = 8;
    private int[][] table = new int[N+1][N+1];
    private boolean exito = false;
    private int[][] movimientos = {{2, 1}, {1, 2}, {-1, 2}, {-2, 1},
    {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
    private int cont=0;

    public int getCont() {
        return cont;
    }
    

    public Caballo(int x, int y) {
            table[x][y] = 1;
    }

    public boolean resolverProblema(int x, int y) {
        saltoCaballo(x, y, 2);
        return exito;
    }

    public void saltoCaballo(int x, int y, int i) {
        int nx, ny;
        int k = 0;
        do {
            k++;
            cont++;
            nx = x + movimientos[k - 1][0];
            ny = y + movimientos[k - 1][1];
            if ((nx >= MIN) && (nx <= MAX) && (ny >= MIN)
                    && (ny <= MAX) && (table[nx][ny] == 0)) {
                if (i < 64) {
                    table[nx][ny] = i;
                    saltoCaballo(nx, ny, i + 1);
                    if (!exito) {
                        table[nx][ny] = 0;
                    }
                } else {
                    table[nx][ny] = i;
                    exito = true;
                }
            }
//            printTablero();
//             System.out.println("-------------------------------");
//            detenerPantalla(); 
        } while ((k < 8) && !exito);
    }

    public void printTable() {
        for (int i = MIN; i <= MAX; i++) {
            for (int j = MIN; j <= MAX; j++) {
                System.out.printf("%3d |", table[i][j]);
            }
            System.out.println();
            System.out.println("------------------------------------------");
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
