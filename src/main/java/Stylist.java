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

  public String getStylistName() {
    return stylistName;
  }

  public String getBio() {
    return bio;
  }

  public int getId() {
    return id;
  }

  public static List<Stylist> all() {
    String sql = "SELECT * FROM stylists ORDER BY stylistName;";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Stylist.class);
    }
  }

  public List<Client> getClients() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM clients WHERE stylistId=:id;";
      return con.createQuery(sql)
        .addParameter("id", this.id)
        .executeAndFetch(Client.class);
    }
  }

  public static Stylist find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM stylists WHERE id=:id;";
      Stylist stylist = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Stylist.class);
      return stylist;
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO stylists(stylistName, bio) VALUES (:stylistName, :bio);";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("stylistName", this.stylistName)
        .addParameter("bio", this.bio)
        .executeUpdate()
        .getKey();
    }
  }

  @Override
  public boolean equals(Object otherStylist) {
    if(!(otherStylist instanceof Stylist)) {
      return false;
    } else {
      Stylist newStylist = (Stylist) otherStylist;
      return this.getStylistName().equals(newStylist.getStylistName()) &&
             this.getBio().equals(newStylist.getBio()) &&
             this.getId() == newStylist.getId();
    }
  }

  public void delete() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM stylists WHERE id=:id;";
      con.createQuery(sql)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

  public void deleteClients(){
    for(Client client : this.getClients()){
      client.delete();
    }
  }
}
