import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class PersistenceTime implements Serializable {

  static final long serialVersionUID = -3126998878902358585L;
//  transient private Date time;
  private Date time;
//  transient private String myName;
  private String myName;
  private String aNewField;
  private String aNewNewField;

  public PersistenceTime(String name) {
    time = Calendar.getInstance().getTime();
    myName = name;
  }

  public Date getTime() {
    return time;
  }

  public String getName() {
    return myName;
  }
}
