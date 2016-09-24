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

  public static List<Client> all() {
    String sql = "SELECT * FROM clients;";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Client.class);
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO clients(clientName, info, stylistId) VALUES (:clientName, :info, :stylistId);";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("clientName", this.clientName)
        .addParameter("info", this.info)
        .addParameter("stylistId", this.stylistId)
        .executeUpdate()
        .getKey();
    }
  }

  public static Client find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM clients WHERE id=:id;";
      Client client = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Client.class);
      return client;
    }
  }

  public void delete() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM clients WHERE id=:id;";
      con.createQuery(sql)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

  public void update(String content) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE clients SET info = :info WHERE id=:id";
      con.createQuery(sql)
        .addParameter("info", info)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

  @Override
  public boolean equals(Object otherClient) {
    if(!(otherClient instanceof Client)) {
      return false;
    } else {
      Client newClient = (Client) otherClient;
      return this.getClientName().equals(newClient.getClientName()) &&
        this.getInfo().equals(newClient.getInfo()) &&
        this.getId() == newClient.getId() &&
        this.getStylistId() == newClient.getStylistId();
    }
  }
}
