import java.io.Serializable;

public class MyClassToBePersisted implements Serializable {

  static final long serialVersionUID = -2536398657643654174L;
  private String name;
  private int age;
  private String hobby;
  private String nameOfSchool;
  transient private int yearStarted;
  private String aNewField;
  private String aNewNewField;

  public MyClassToBePersisted(String name, int age, String hobby, String nameOfSchool, int yearStarted) {
    this.name = name;
    this.age = age;
    this.hobby = hobby;
    this.nameOfSchool = nameOfSchool;
    this.yearStarted = yearStarted;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public String getHobby() {
    return hobby;
  }

  public String getNameOfSchool() {
    return nameOfSchool;
  }

  public int getYearStarted() {
    return yearStarted;
  }
}
