import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Calendar;

public class DeserializeTime {

  public static void main(String[] args) {

    String filename = "time.ser";
    if(args.length > 0){
      filename = args[0];
    }

    // Deserialize the previously saved
    // PersistenceTime object instance.
    PersistenceTime time = null;
    FileInputStream fis = null;
    ObjectInputStream in = null;

    try {
      fis = new FileInputStream(filename);
      in = new ObjectInputStream(fis);
      time = (PersistenceTime) in.readObject();
      in.close();
    } catch (ClassNotFoundException ex) {
      ex.printStackTrace();
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    // Print the restored time
    System.out.println("Previously serialized time: " + time.getTime());

    // Print the current time
    System.out.println("Current time: " + Calendar.getInstance().getTime());

    // Print the name
    System.out.println("Name: " + time.getName());
  }
}
