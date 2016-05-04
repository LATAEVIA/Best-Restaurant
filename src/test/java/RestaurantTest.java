import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
// import java.time.LocalDateTime;

public class RestaurantTest {

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/best_restaurant_test", null, null);
  }

  @After
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
      String deleteRestaurantsQuery = "DELETE FROM restaurants *;";
      String deleteCuisinesQuery = "DELETE FROM cuisines *;";
      con.createQuery(deleteRestaurantsQuery).executeUpdate();
      con.createQuery(deleteCuisinesQuery).executeUpdate();
    }
  }

  @Test
  public void restaurant_instantiatesCorrectly_true() {
    Restaurant myRestaurant = new Restaurant("Olive Garden");
    assertTrue(myRestaurant instanceof Restaurant);
  }
  @Test
  public void restaurant_instantiatesWithName_String() {
    Restaurant myRestaurant = new Restaurant("Olive Garden");
    assertEquals("Olive Garden", myRestaurant.getName());
  }

}
