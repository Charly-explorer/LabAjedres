package OchoReinas;

public class Juego {

    public static void main(String[] args) {
        String table [] [] = new String [8][8];
        fullTable(table);
        System.out.println("Inserte la Columna ");
        
        
        printTable(table);

        putQueen(table);
        
    }
    
    public static void printTable(String[][] table){
        System.out.println("");
        for (int v = 0; v < 8; v++) {
            for (int h = 0; h < 8; h++) {
                System.out.print(table[v][h] + " | ");
            }
            System.out.println("");
        }
    }
    
    public static void fullTable(String[][] table){
        for (int v = 0; v < 8; v++) {
            for (int h = 0; h < 8; h++) {
                table[v][h] = "-";
            }
        }
    }
    
    public static void putQueen(String[][] table){
        for (int c = 0; c < 8; c++) {
            for (int l = 0; l < 8; l++) {
                if(seeColumn(table,c) == false){
                    if (seeLine(table,l) == false) {
                        table[c][l] = "R";
                        printTable(table);
                    }
                }
            }
        }
    }
    
    public static boolean seeColumn(String[][] table, int column){
        for (int h = 0; h < 8; h++) {
            if (table[h][column] == "R") {
                return true;
            }
        }
        return false;
    }
    
    public static boolean seeLine(String[][] table, int line){
        for (int v = 0; v < 8; v++) {
            if (table[line][v] == "R") {
                return true;
            }
        }
        return false;
    }
    
    
    
}
