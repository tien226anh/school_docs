import java.io.Serializable;

public class PersistenceAnimation implements Serializable, Runnable {

  transient private Thread animator;
  private int animationSpeed;

  public PersistenceAnimation(int animationSpeed) {
    this.animationSpeed = animationSpeed;
    startAnimation();
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    out.defaultWriteObject();
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    in.defaultReadObject();
    startAnimation();
  }

  private void startAnimation() {

    animator = new Thread(this);
    animator.start();
  }

  public void run() {
    System.out.println("PersistenceAnimation is started");
  }
}
