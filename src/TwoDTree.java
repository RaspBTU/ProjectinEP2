

public class TwoDTree {
    private int size;
    Node root;


    //insertRoot
    void insert(Points p) {
        if (p == null) {
            System.out.println("Kein Point");
        } else {
            if (root == null) {
                root = new Node(p, p.getX());
            } else {
                root.insert(p, 0);
            }
        }
    }

    int searchRnge( double radius, int n) {
        if (this.root == null) {
            return 0;
        } else {
            return this.root.searchRange( radius, n);
        }
    }

    int findTrAi(double x,double y, double radius, String s){
        if (root == null)
            return 0;
        return root.findTrAi(x,y,radius,s);

    }

    class Node {
        double valueOfNode;
        Node right, left;
        Points point;

        public Node(Points point, double value) {
            this.point = point;
            left = null;
            right = null;
            valueOfNode = value;
        }

        void insert(Points point, int compare) {
            if (compare % 2 == 0) {
                if (this.valueOfNode > point.getX()) {
                    if (this.left == null) {
                        left = new Node(point, point.getY());
                    } else {
                        left.insert(point, compare + 1);
                    }
                } else {
                    if (this.right == null) {
                        right = new Node(point, point.getY());
                    } else {
                        right.insert(point, compare + 1);
                    }
                }
            } else {
                if (this.valueOfNode > point.getY()) {
                    if (this.left == null) {
                        left = new Node(point, point.getX());
                    } else {
                        left.insert(point, compare + 1);
                    }
                } else {
                    if (this.right == null) {
                        right = new Node(point, point.getX());
                    } else {
                        right.insert(point, compare + 1);
                    }
                }
            }

        }

        int findTrAi(double x,double y,double radius, String s){
            int res = 0;

            if (this.left!=null)
                res+=left.findTrAi(x,y,radius,s);
            if (this.right!=null)
                res+= right.findTrAi(x,y,radius,s);

            if (this.point.getStation().equals(s)){
                double cX = Math.pow(this.point.getX() - x, 2);
                double cY = Math.pow(this.point.getY() - y, 2);
                double d = Math.sqrt(cX + cY);
                if (d < radius){

                    res++;



                }
            }


            return res;

        }




        int searchRange( double radius, int n) {
            int counter = 0;
            if (left != null) {
                counter += left.searchRange( radius, n);

            }
            if (right != null) {
                counter += right.searchRange( radius, n);
            }
            if (this.point.getStation().startsWith("A")) {

                int i = root.findT1( this.point.getX(), this.point.getY(),
                        radius, n);

                if (i >= n) {

                    counter++;

                }


            }
            return counter;

        }




        int findT1(double x,double y,double radius, int n){
            int res = 0;

            if (this.left!=null)
                res+=left.findT1(x,y,radius,n);
            if (this.right!=null)
                res+= right.findT1(x,y,radius,n);

            if (!this.point.getStation().startsWith("A")){
                double cX = Math.pow(this.point.getX() - x, 2);
                double cY = Math.pow(this.point.getY() - y, 2);
                double d = Math.sqrt(cX + cY);
                if (d < radius){

                    res++;



                }
            }


            return res;

        }
    }
}
