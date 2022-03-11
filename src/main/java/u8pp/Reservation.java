package u8pp;

public class Reservation{
    String name;
    boolean frequentFlyer;

    public Reservation(String temp, boolean whatever){
        name = temp;
        frequentFlyer = whatever;
    }
    public String getPassengerName(){
        return this.name;
    }
    public boolean isFrequentFlyer(){
        return this.frequentFlyer;
    }
}

