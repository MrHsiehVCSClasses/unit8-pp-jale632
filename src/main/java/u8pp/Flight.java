package u8pp;
import java.util.ArrayList;

public class Flight{
    Reservation[][] reservation;
    int r;
    int c;

    public Flight(int row, int col){
        r = row;
        c = col;
        reservation = new Reservation[r][c + 1];
            int current = (c + 1) / 2;
            for(int i = 0; i < reservation.length; i++)
                reservation[i][current] = new Reservation("AISLE", false);
            
        }
    public ArrayList<String> getFrequentFlyers(){
        ArrayList<String> peo = new ArrayList<String>();
            for(int r = 0; r < reservation.length; r++){
                for(int c = 0; c < reservation[0].length; c++){
                    if(reservation[r][c] != null){
                        if(reservation[r][c].isFrequentFlyer() == true && !reservation[r][c].getPassengerName().equals("AISLE")){
                            peo.add(reservation[r][c].getPassengerName());
                        }
                    }
                }
            }
        return peo;
    }


            
    
    public boolean reserveNextAvailableSeat(String name, boolean freqFlyer){
        for(int r = 0; r < reservation.length; r++){
            for(int c = 0; c < reservation[0].length; c++){
                if(reservation[r][c] == null){
                    reservation[r][c] = new Reservation(name, freqFlyer);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean reserveAdjacentSeats(String passengerName, boolean firstFrequentFlyer, String passengerNameTwo, boolean secondFrequentFlyer){
        for(int r = 0; r < reservation.length; r++){
            for(int c = 0; c < reservation[0].length - 1; c++){
                if(reservation[r][c] == null && reservation[r][c + 1] == null){
                    reservation[r][c] = new Reservation(passengerName, firstFrequentFlyer);
                    reservation[r][c+1] = new Reservation(passengerNameTwo,secondFrequentFlyer);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean reserveWindowSeat(String name, boolean freqFlyer){
        int temp = reservation[0].length - 1;
        for(int r = 0; r < reservation.length; r++){
                if(reservation[r][0] == null){
                    reservation[r][0] = new Reservation(name, freqFlyer);
                    return true;
                }
                else if(reservation[r][temp] == null){
                    reservation[r][temp] = new Reservation(name, freqFlyer);
                    return true;
                }
        }
        return false;
    }



    public boolean reserveAisleSeat(String name, boolean freqFlyer){
        boolean left = false;
        boolean right = false;
        for(int r=  0; r < reservation.length; r++){
            for(int c = 0; c < reservation[0].length; c++){
                if(reservation[r][c] == null){
                    if(c == 0){
                        left = false;
                    }
                    else if(reservation[r][c - 1] != null && reservation[r][c - 1].getPassengerName().equals("AISLE")){
                        left = true;
                    }
                    if(c == reservation[0].length -1){
                            right = false;
                        }
                    else if(reservation[r][c + 1] != null && reservation[r][c + 1].getPassengerName().equals("AISLE")){
                            right = true;
                     }
                }
                if(left == true || right == true){
                    reservation[r][c] = new Reservation(name, freqFlyer);
                    return true;
                }
            }
        }
        return false;
    }



    public ArrayList<String> getIsolatedPassengers(){
        ArrayList<String> list = new ArrayList<String>();
        for(int r = 0; r < reservation.length; r++){
            for(int c = 0; c < reservation[0].length; c++){
                if(reservation[r][c] != null && reservation[r][c].getPassengerName().equals("AISLE") != true){
                    boolean left = false;
                    boolean right = false;
                    if(c == 0){
                        left = true;
                    }
                    else if(reservation[r][c - 1] == null || reservation[r][c - 1].getPassengerName().equals("AISlE")){
                        left = true;
                    }
                    if(c == reservation[0].length - 1){
                        right = true;
                    }
                    else if(reservation[r][c + 1] == null || reservation[r][c + 1].getPassengerName().equals("AISlE")){
                        right = true;
                    }
                    if(left == true && right == true){
                        list.add(reservation[r][c].getPassengerName());
                    }
                }
            }
        }
        return list;
    }

    public String toString(){
        String list = "";
        for(int r = 0; r < reservation.length; r++){
            for(int c = 0; c < reservation[0].length; c++){
                if(reservation[r][c] != null){
                    if(reservation[r][c].getPassengerName().equals("AISLE")){
                        list += "AISLE";
                        if(c < reservation[0].length - 1){
                            list += " ";
                        }
                    }
                    if(!reservation[r][c].getPassengerName().equals("AISLE")){
                        list += reservation[r][c].getPassengerName();
                        if(c < reservation[0].length - 1){
                            list += " ";
                        }
                    }
                }
                else if(reservation[r][c] == null){
                    list += "EMPTY";
                    if(c < reservation[0].length - 1){
                        list += " ";
                       }
                    }
            }
            if(r < reservation.length -1){
            list += "\n";
            }
        }
        return list;
    }


    public boolean isIsolated(int row, int col){
        boolean leftEmpty = false;
        boolean rightEmpty = false;

        if((col + 1)>= 0){
            if(reservation[row][col - 1] != null || reservation[row][col - 1].getPassengerName().equals("AISLE")){
                leftEmpty = true;
            }
        }
        if((c + 1 < reservation[0].length)){
            if(reservation[row][col + 1] == null || reservation[row][col + 1].getPassengerName().equals("AISLE")){
                rightEmpty = true;
            }
        }
        return leftEmpty && rightEmpty;
    }

    public Reservation[][] getSeats(){
        return reservation;
    }

}
