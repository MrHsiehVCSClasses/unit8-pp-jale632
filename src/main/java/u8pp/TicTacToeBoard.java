package u8pp;


public class TicTacToeBoard {

    String[][] data;

    public TicTacToeBoard(String[][] data) {
        this.data = data;
    }

    public String toString() {
        String output = "";
        for(int r = 0; r < data.length; r++) {
            if(r != 0) {
                output += "\n";
                output += "-+".repeat(data[r].length - 1);
                output += "-";
                output += "\n";
            }
            for(int c = 0; c < data[r].length; c++) {
                if(c != 0) {
                    output += "|";
                }
                output += data[r][c];
            }
        }
        return output;
    }

    public boolean hasWin() {
        return hasDiagonalWin() || hasHorizontalWin() || hasVerticalWin();
    }

    public boolean hasHorizontalWin() {
        /* Your code here */
        for(int r = 0; r < data.length; r++){
            String current = data[r][0];
            boolean result = true;
            for(int c = 0; c < data[0].length; c++){
                if(!current.equals(data[r][c])){
                    result = false;
                }
            }
            if(!current.equals("O") && !current.equals("X")){
                result = false;
            }
            if(result == true){
                return true;
            }
        }
        return false;
    }

    public boolean hasVerticalWin() {
        /* Your code here */
        for(int c = 0; c < data[0].length; c++){
            String current = data[0][c];
            boolean result = true;
            for(int r = 0; r < data.length; r++){
                if(!current.equals(data[r][c])){
                    result = false;
                }
            }
            if(!current.equals("O") && !current.equals("X")){
                result = false;
            }
            if(result == true){
                return true;
            }
        }
        return false;
    }

    public boolean hasDiagonalWin() {
        /* Your code here */
        boolean result = true;
        String temp = data[0][0];
        if(!temp.equals("X") && !temp.equals("O")){
                result = false;
       }
       for(int r = 0; r < data.length; r++){
           for(int c = 0; c < data[0].length; c++){
                if(r == c){
                    if(!temp.equals(data[r][c])){
                        result = false;
                    }
                }
           }
       }        
       if(result == true){
           return true;
       }
       
       result = true;
       int jj = data.length - 1;
       temp = data[0][jj];
    
       for(int r = 0; r < data.length; r++){
           for(int c = 0; c < data[0].length; c++){
            int check = c + 1;
               if(!temp.equals("X") && !temp.equals("O")){
                    result = false;
               }
               if(r == data.length - check){
                   if(!temp.equals(data[r][c])){
                       result = false;
                   }
               }
           }
       }
       if(result == true){
           return true;
       }
    return false;
       
    }
}


    /* helper functions go here */
   



