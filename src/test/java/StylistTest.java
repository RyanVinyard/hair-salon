import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;

public class StylistTest {
  private Stylist mStylist;


  @Before
  public void initialize(){
    mStylist = new Stylist("Steve Brule", "He's a doctor too.");
  }

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Stylist_instantiatesCorrectly_true() {
    assertEquals(true, mStylist instanceof Stylist);
  }

  @Test
  public void Stylist_instantiatesWithName_String() {
    assertEquals("Steve Brule", mStylist.getStylistName());
  }

  @Test
  public void Stylist_instantiatesWithBio_String() {
    assertEquals("He's a doctor too.", mStylist.getBio());
  }

  @Test
  public void Stylist_instantiatesWithID_1() {
    mStylist.save();
    assertTrue(mStylist.getId() > 0);
  }

@Test
 public void find_returnsStylistWithSameId_secondStylist() {
   Stylist secondStylist = new Stylist("Dr. Jongy Brogan", "He's a nutritionist");
   secondStylist.save();
   assertEquals(Stylist.find(secondStylist.getId()), secondStylist);
 }

  @Test
  public void equals_returnsTrueIfNamesAretheSame() {
    Stylist secondStylist = new Stylist("Steve Brule", "He's a doctor too.");
    assertTrue(mStylist.equals(secondStylist));
  }

  @Test
  public void save_savesIntoDatabase_true() {
    mStylist.save();
    assertTrue(Stylist.all().get(0).equals(mStylist));
  }

  @Test
  public void save_assignsIdToObject() {
    mStylist.save();
    Stylist savedStylist = Stylist.all().get(0);
    assertEquals(mStylist.getId(), savedStylist.getId());
  }

  @Test
  public void getClients_retrievesAllClientsFromDatabase_clientsList() {
    mStylist.save();
    Client firstClient = new Client("Dave Dingle", "Not a doctor.", mStylist.getId());
    firstClient.save();
    Client secondClient = new Client("Sylvia Dangus", "Also not a doctor", mStylist.getId());
    secondClient.save();
    Client[] clients = new Client[] { firstClient, secondClient };
    assertTrue(mStylist.getClients().containsAll(Arrays.asList(clients)));
  }
}
