package java;

public class MainClass {

    static void printValue(Animal a){
        System.out.println("ONE");
    }

    static void printValue(Dog b){
        System.out.println("TWO");
    }

    static void printValue(Object c){
        System.out.println("THREE");
    }

    public static void main(String[] args) {
        Labrador c = new Labrador();
        printValue(c);
    }
}
