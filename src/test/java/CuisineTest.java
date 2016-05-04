import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;

public class CuisineTest {

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/best_restaurant_test", null, null);
  }

  @After
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
      // String deleteRestaurantsQuery = "DELETE FROM restaurants *;";
      String deleteCuisinesQuery = "DELETE FROM cuisines *;";
      // con.createQuery(deleteRestaurantsQuery).executeUpdate();
      con.createQuery(deleteCuisinesQuery).executeUpdate();
    }
  }

  @Test
  public void Cuisine_initiatesCorrectly_true() {
    Cuisine myCuisine = new Cuisine ("Italian");
    assertEquals(true, myCuisine instanceof Cuisine);
  }

  @Test
  public void Cuisine_getNameReturnName_String() {
    Cuisine myCuisine = new Cuisine ("Italian");
    assertEquals("Italian", myCuisine.getName());
  }

  @Test
  public void Cuisine_getTwoSameCuisines_true() {
    Cuisine firstCuisine = new Cuisine ("Italian");
    Cuisine secondCuisine = new Cuisine ("Italian");
    assertTrue(firstCuisine.equals(secondCuisine));
  }

  // @Test
  // public void Cuisine_getAllReturnAll_list() {
  //   Cuisine myCuisine = new Cuisine ("Italian");
  //   myCuisine.save();
  //   assertEquals(myCuisine.equals(Cuisine.all()));
  // }


  // @Test
  // public void Cuisine_getIdReturnId_int() {
  //   Cuisine myCuisine = new Cuisine ("Italian");
  //   assertEquals(1, myCuisine.getId());
  // }
}
