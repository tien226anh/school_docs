import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeAnimationThreadNotStarted {
  public static void main(String[] args) {
    PersistenceAnimation a = new PersistenceAnimation(1);

    FileOutputStream fos = null;
    ObjectOutputStream out = null;
    try {
      fos = new FileOutputStream("animation.ser");
      out = new ObjectOutputStream(fos);
      out.writeObject(a);
      out.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    PersistenceAnimation b = null;
    FileInputStream fis = null;
    ObjectInputStream in = null;
    try {
      fis = new FileInputStream("animation.ser");
      in = new ObjectInputStream(fis);
      b = (PersistenceAnimation) in.readObject();
      in.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}