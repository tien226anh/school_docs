import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializeMyClassToBePersisted {

  public static void main(String[] args) {

    String filename = "myclass.ser";
    if(args.length > 0){
      filename = args[0];
    }

    // Deserialize the previously saved
    // MyClassToBePersisted object instance.
    MyClassToBePersisted myClass = null;
    FileInputStream fis = null;
    ObjectInputStream in = null;

    try {
      fis = new FileInputStream(filename);
      in = new ObjectInputStream(fis);
      myClass = (MyClassToBePersisted) in.readObject();
      in.close();
    } catch (ClassNotFoundException ex) {
      ex.printStackTrace();
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    System.out.println("Name: " + myClass.getName());
    System.out.println("Age: " + myClass.getAge());
    System.out.println("Hobby: " + myClass.getHobby());
    System.out.println("Name of school: " + myClass.getNameOfSchool());
    System.out.println("Year started: " + myClass.getYearStarted());
  }
}
