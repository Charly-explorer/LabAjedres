package OchoReinas;

public class Juego {

    public static void main(String[] args) {
        String table[][] = new String[8][8];
        fullTable(table);
        solveQueens(table, 0); 
    }

   
    public static void solveQueens(String[][] table, int row) {
        if (row == 8) {
            printTable(table); 
            return; 
        }

       
        for (int col = 0; col < 8; col++) {
            if (isSafe(table, row, col)) {
                table[row][col] = "R"; 

                
                solveQueens(table, row + 1);

               
                table[row][col] = "-";
            }
        }
    }

   
    public static boolean isSafe(String[][] table, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (table[i][col] == "R") {
                return false;
            }
        }

       //Diagonal izquierda
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (table[i][j] == "R") {
                return false;
            }
        }

        //Diagonal derecha
        for (int i = row, j = col; i >= 0 && j < 8; i--, j++) {
            if (table[i][j] == "R") {
                return false;
            }
        }

        return true;
    }

    
    public static void fullTable(String[][] table) {
        for (int v = 0; v < 8; v++) {
            for (int h = 0; h < 8; h++) {
                table[v][h] = "-";
            }
        }
    }

    
    public static void printTable(String[][] table) {
        System.out.println("Solución encontrada:");
        for (int v = 0; v < 8; v++) {
            for (int h = 0; h < 8; h++) {
                System.out.print(table[v][h] + " | ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
