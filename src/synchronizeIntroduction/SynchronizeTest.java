package synchronizeIntroduction;
class ExampleOfStaticVariables { //It's not public, because there can be only one.
    public static int counter = 7;
    private String name;
    public void staticVariableIncrementation(int increaser) {
        counter+=increaser;
    };
    public void printStaticVariable() {
        System.out.println("Printing the variable within the object: "+counter);
    };
    public ExampleOfStaticVariables(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    };
    public void setName(String new_name) {
        this.name = new_name;
    };
}
public class SynchronizeTest {
    public static void main(String[] args) {
        ExampleOfStaticVariables staticObject = new ExampleOfStaticVariables("Apples");
        ExampleOfStaticVariables evenMoreStaticObject = new ExampleOfStaticVariables("Potatoes");
        System.out.println(staticObject.getName());
        System.out.println(evenMoreStaticObject.getName());
        System.out.println(ExampleOfStaticVariables.counter);
        ExampleOfStaticVariables.counter = 8;
        System.out.println("The value of the modified counter is: "+ExampleOfStaticVariables.counter);
        ExampleOfStaticVariables.counter+=10;
        System.out.println("My third favourite number is: "+ExampleOfStaticVariables.counter);
        //Static variables are accessed through the name of the class.
        staticObject.printStaticVariable(); //Non-static methods through objects.
        staticObject.staticVariableIncrementation(7);
        System.out.println("After incrementation: "+ExampleOfStaticVariables.counter);
    }
}
