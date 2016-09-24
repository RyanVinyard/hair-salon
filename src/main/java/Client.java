import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Client {
  private String clientName;
  private String info;
  private int id;
  private int stylistId;

  public Client(String clientName, String info, int stylistId) {
    this.clientName = clientName;
    this.info = info;
    this.stylistId = stylistId;
  }

  public String getClientName() {
    return clientName;
  }

  public String getInfo() {
    return info;
  }

  public int getStylistId() {
    return stylistId;
  }

  public int getId() {
    return id;
  }
}
