
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
// import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import org.sql2o.*; // for DB support
import org.junit.*; // for @Before and @After

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
    public void rootTest() {
      goTo("http://localhost:4567/");
      assertThat(pageSource()).contains("Best Restaurants App");
      assertThat(pageSource()).contains("Cuisine");
      assertThat(pageSource()).contains("favorite cuisine");
    }

  @Test
    public void getCuisineReturnSamePage() {
      goTo("http://localhost:4567/");
      assertThat(pageSource()).contains("Best Restaurants App");
      fill("#cuisine-name").with("Italian");
      submit(".btn");
      assertThat(pageSource()).contains("Italian");
    }

  @Test
    public void getCuisineIdReturnRestaurantAppend() {
      goTo("http://localhost:4567/");
      fill("#cuisine-name").with("Italian");
      submit(".btn");
      click("a", withText("Italian"));
      assertThat(pageSource()).contains("List");
    }

  @Test
    public void getRestaurantReturnWithCuisineId() {
      goTo("http://localhost:4567/");
      fill("#cuisine-name").with("Italian");
      submit(".btn");
      click("a", withText("Italian"));
      assertThat(pageSource()).contains("List of all restaurants with Italian cuisine");
      fill("#restaurant-name").with("Olive garden");
    }

}
