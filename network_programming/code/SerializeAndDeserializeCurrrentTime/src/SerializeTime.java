import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializeTime {
  public static void main(String[] args) {
    String filename = "time.ser";
    if(args.length > 0){
      filename = args[0];
    }

    // Create an object
    PersistenceTime time = new PersistenceTime("My name is AnhNt");

    // Serialize the object instance and save it in
    // a file
    FileOutputStream fos = null;
    ObjectOutputStream out = null;
    try {
      fos = new FileOutputStream(filename);
      out = new ObjectOutputStream(fos);
      out.writeObject(time);
      out.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    System.out.println("Current time is saved into " + filename);
  }
}