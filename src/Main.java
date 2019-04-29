/**
 * Created by Amar on 20.05.2018.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        int index = 0;
        String name = "";
        double x = 0.0;
        double y = 0.0;
        String station = "";
        Points[] point = new Points[94068];
        TwoDTree twoDTree = new TwoDTree();
        String junc = "";
        int counter = 0;
        //Daten holen und speichern
        try (Scanner s = new Scanner(new File(System.getProperty("user.dir")+"/data/junctions.csv"),"UTF-8").useDelimiter(";")){
            while (s.hasNext()) {

                junc = s.next();
                switch (counter) {
                    case 0:
                        name = junc;
                        counter++;
                        break;
                    case 1:
                        x = Double.parseDouble(junc);
                        counter++;
                        break;
                    case 2:
                        y = Double.parseDouble(junc);
                        counter++;
                        break;
                    default:
                        station = junc;
                        counter++;

                        counter = 1;
                        String newname = "";
                            if (junc.charAt(0) == 'T') {
                            station = "TRAINSTATION";
                                for (int i = 13; i<junc.length();i++){
                                    newname +=junc.charAt(i);
                                }
                            }else if (junc.charAt(0) == 'A'){
                                station= "AIRPORT";
                                for (int i = 8; i<junc.length();i++){
                                    newname +=junc.charAt(i);
                                }
                            }
                        point[index] = new Points(name, x, y, station);
                        twoDTree.insert(point[index]);
                        index++;
                        name=newname;
                        break;
                }

            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
            System.exit(1);
        }




           methode1(point,15,20);
           methode1(point,1818.54657,5813.29982,100);
        System.out.println("Recursivly");
            methode2(twoDTree,15,20);
            methode2(twoDTree,1818.54657,5813.29982,100);

    }


        //methode 1 fur erste Abfrage
        public static void methode1( Points[] p,double x, double y, double radius){
        NaiveDatenstruktur naiveDatenstruktur = new NaiveDatenstruktur(p);
        int[] lsg = naiveDatenstruktur.methode1(x,y,radius);
        System.out.println("Junctions less than " + radius + " units from " + " x=" + x + " y=" + y );
        System.out.println("Airports :" + lsg[0] + "   Trainstations :" + lsg[1]);

    }
        //methode 1 fur 2 abfrage
    public static void methode1( Points[] p, double radius, int n){
        NaiveDatenstruktur naiveDatenstruktur = new NaiveDatenstruktur(p);
        System.out.println("Airports with at least " + n + " Trainstations less than " + radius + " units away");
        System.out.println(naiveDatenstruktur.methode2(n,radius));

    }


      //  methode 2 für zweite Abfrage
      public static void methode2(TwoDTree d, double radius, int stationen) {

            if (d==null){
                return;
            }else {

                System.out.println("Airports with at least " + stationen + " Trainstations less than " + radius + " units away");
                System.out.println(d.searchRnge(radius,stationen));

            }
      }
      //methode 2 , erste Abfrage
    public static void methode2(TwoDTree d, double x, double y, double radius) {

        if (d==null){
            return ;
        }else {
            int[] result = new int[2];
             result[0] = d.findTrAi(x,y,radius,"AIRPORT");
             result[1] = d.findTrAi(x,y,radius,"TRAINSTATION");
            System.out.println("Junctions less than " + radius + " units from " + " x=" + x + " y=" + y );
            System.out.println("Airports :" + result[0] + "   Trainstations :" + result[1]);
        }
    }
}
