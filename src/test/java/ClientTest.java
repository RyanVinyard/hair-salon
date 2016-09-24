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

  @Test
  public void all_returnsAllInstancesOfClient_true() {
    mClient.save();
    Client secondClient = new Client("Steve Brule", "This man is insane", 1);
    secondClient.save();
    assertEquals(true, Client.all().get(0).equals(mClient));
    assertEquals(true, Client.all().get(1).equals(secondClient));
  }

  @Test
  public void clear_emptiesAllClientsFromArrayList_0() {
    assertEquals(Client.all().size(), 0);
  }

  @Test
  public void find_returnsClientWithSameId_secondClient() {
    mClient.save();
    Client secondClient = new Client("Lane21", "This movie sucks.", 1);
    secondClient.save();
    assertEquals(mClient.find(secondClient.getId()), secondClient);
  }

  @Test
  public void equals_returnsTrueIfClientsAreTheSame() {
    Client secondClient = new Client("Client123", "This guy is great.", 1);
    assertTrue(mClient.equals(secondClient));
  }

  @Test
  public void save_returnsTrueIfClientsAretheSame() {
    mClient.save();
    assertTrue(Client.all().get(0).equals(mClient));
  }

  @Test
  public void save_assignsIdToObject() {
    mClient.save();
    Client savedClient = Client.all().get(0);
    assertEquals(mClient.getId(), savedClient.getId());
  }

  @Test
  public void update_updatesClient_true() {
    mClient.save();
    mClient.update("This guy is okay.");
    assertEquals("This guy is great.", Client.find(mClient.getId()).getInfo());
  }

  @Test
  public void delete_deletesClient_true() {
    mClient.save();
    int mClientId = mClient.getId();
    mClient.delete();
    assertEquals(null, Client.find(mClientId));
  }
}
