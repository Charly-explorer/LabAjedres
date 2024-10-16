/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package AlgoritmoDelCaballo;

import java.util.Scanner;

/**
 *
 * @author Johel M
 */
public class Recorrido {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x, y;

        do {
            System.out.println("Ingrese la posición en X (1-8):");
            x = scan.nextInt();
            scan.nextLine();
            System.out.println("Ingrese la posición en Y (1-8):");
            y = scan.nextInt();
            scan.nextLine();
            if (x < 1 || x > 8 || y < 1 || y > 8) {
                System.out.println("Posición fuera de rango. Ingrese valores entre 1 y 8.");
            }
        } while (x < 1 || x > 8 || y < 1 || y > 8);

        Caballo caballo = new Caballo(x, y);

        if (caballo.resolverProblema(x, y)) {
            caballo.printTable();
        } else {
            System.out.println("No se resolvio el problema");
        }
        System.out.println(caballo.getCont());

    }
}
