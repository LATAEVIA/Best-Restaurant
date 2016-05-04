import java.util.List;
import org.sql2o.*;
// import java.util.ArrayList;

public class Cuisine {
  private String name;
  private int id;
  private List cuisineAll;


  public Cuisine(String name) {
    this.name = name;

    // this.id=id;

  }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  public List<Cuisine> all(){
    String sql = "SELECT id, name FROM cuisines";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Cuisine.class);
    }
  }

  public boolean equals(Object otherCuisine) {
    if(!(otherCuisine instanceof Cuisine)) {
      return false;
    }else {
      Cuisine newCuisine = (Cuisine) otherCuisine;
      return this.getName().equals(newCuisine.getName());
    }
  }


}
