/**
 * Created by Amar on 30.05.2018.
 */
public class NaiveDatenstruktur {

    Points[] point;

    public NaiveDatenstruktur(Points[] points){
        this.point = points;
    }

    int[] methode1(double x, double y, double radius){

        int airports = 0;
        int trainstation = 0;
        for (int i = 0 ;i<point.length; i++){
            double cX = Math.pow(point[i].getX()-x,2);
            double cY = Math.pow(point[i].getY()-y,2);
            double d = Math.sqrt(cX+cY);
            if (d<radius){
                if (point[i].getStation().startsWith("T")){
                    trainstation++;
                }else {
                    airports++;
                }
            }

        }

        return new int[]{airports,trainstation};
    }

    int methode2(int l, double radius){
        int airport = 0;
        for (int i = 0 ; i<point.length; i++){
            if (point[i].getStation().startsWith("A")){
                int counter = 0;
                for (int j = 0 ; j<point.length; j++){
                    if (point[j].getStation().equals("TRAINSTATION")){
                        double cX = Math.pow(point[i].getX()-point[j].getX(),2);
                        double cY = Math.pow(point[i].getY()-point[j].getY(),2);
                        double d = Math.sqrt(cX+cY);
                        if (d<radius){
                            counter++;
                    }

                    }
                    if (counter==l){
                        airport++;
                        break;
                    }
                }
            }
        }
        return airport;
    }
}
