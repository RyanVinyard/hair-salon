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
    assertEquals("Steve Brule", mStylist.getName());
  }

  @Test
  public void Stylist_instantiatesWithBio_String() {
    assertEquals("He's a doctor too.", mStylist.getBio());
  }

}
