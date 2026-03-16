public class ArrayIndexDemo {

    static void generateException(){

        String[] names = {"Ram","Shyam","Mohan"};

        System.out.println(names[5]);
    }

    static void handleException(){

        String[] names = {"Ram","Shyam","Mohan"};

        try{
            System.out.println(names[5]);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOfBoundsException handled");
        }
        catch(RuntimeException e){
            System.out.println("Runtime Exception handled");
        }
    }

    public static void main(String[] args){

        //generateException();

        handleException();
    }
}