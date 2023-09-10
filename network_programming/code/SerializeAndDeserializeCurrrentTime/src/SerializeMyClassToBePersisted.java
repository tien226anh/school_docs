import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializeMyClassToBePersisted {

  public static void main(String[] args) {
    String filename = "myclass.ser";
    if (args.length > 0) {
      filename = args[0];
    }

    // Create an object
    MyClassToBePersisted myClass = new MyClassToBePersisted("My name is AnhNt", 22, "Coding", "PTIT", 2020);

    FileOutputStream fos = null;
    ObjectOutputStream out = null;
    try {
      fos = new FileOutputStream(filename);
      out = new ObjectOutputStream(fos);
      out.writeObject(myClass);
      out.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    System.out.println("Current class is saved into " + filename);
  }
}
