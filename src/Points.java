/**
 * Created by Amar on 20.05.2018.
 */
public class Points {
    double x;
    double y;
    String name;
    String station;

    public Points(String name, double x, double y,String station){
        this.x=x;
        this.y=y;
        this.name=name;
        this.station=station;
    }


    public double getX() {
        return x;
    }
    public double getY(){
        return y;
    }
    public String getName(){
        return name;
    }
    public String getStation(){
        return station;
    }

}
