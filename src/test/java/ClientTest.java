import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ClientTest {
  private Client mClient;

  @Before
  public void initialize(){
    mClient = new Client("Client123", "This guy is great.", 1);
  }

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Client_instantiatesCorrectly_true() {
    assertEquals(true, mClient instanceof Client);
  }

  @Test
  public void Client_instantiesWithClient_String(){
    assertEquals("Client123", mClient.getClientName());
  }

  @Test
  public void Client_instantiesWithInfo_String(){
    assertEquals("This guy is great.", mClient.getInfo());
  }

  @Test
  public void getId_instantiesWithID_1(){
    mClient.save();
    assertTrue(mClient.getId() > 0);
  }

  // @Test
  // public void all_returnsAllInstancesOfClient_true() {
  //   mClient.save();
  //   Client secondClient = new Client("Steve Brule", "This man is insane", 1);
  //   secondClient.save();
  //   assertEquals(true, Client.all().get(0).equals(mClient));
  //   assertEquals(true, Client.all().get(1).equals(secondClient));
  // }

  @Test
  public void clear_emptiesAllClientsFromArrayList_0() {
    assertEquals(Client.all().size(), 0);
  }

}
