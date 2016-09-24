import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Stylist {
  private String stylistName;
  private String bio;
  private int id;

  public Stylist(String stylistName, String bio) {
    this.stylistName = stylistName;
    this.bio = bio;
  }

  public String getName() {
    return stylistName;
  }

  public String getBio() {
    return bio;
  }

  public int getId() {
    return id;
  }
}
