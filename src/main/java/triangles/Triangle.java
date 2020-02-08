package triangles;

public class Triangle implements Comparable<Triangle>{

    double width;
    double height;
    double thirdSide;
    String name;


    Triangle(String name, double side){
        this(name,side,side,side);
    }

    Triangle(String name,double width, double height,double thirdSide){
        this.width=width;
        this.height=height;
        this.thirdSide= thirdSide;
        this.name = name;
    }

    double halfPerimetr(){
        return (width+height+thirdSide)/2;
    }

    double area(){
       double p =halfPerimetr();
       return ( Math.sqrt(p*(p-width)*(p-height)*(p-thirdSide)));
    }

    boolean canBeExist(){
        return (width + height) > thirdSide && (width + thirdSide) > height && (height + thirdSide) > width;
    }



    public int  compareTo(Triangle tri) {
         return (int) (this.area() - tri.area());
    }
}
