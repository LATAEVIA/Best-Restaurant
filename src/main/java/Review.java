
import java.util.List;
import org.sql2o.*;

public class Review {
  private int id;
  private String description;
  private int restaurant_id;

  public Review(String description, int restaurant_id) {
    this.description = description;
    this.restaurant_id = restaurant_id;
  }

  public String getDescription(){
    return description;
  }

  public int getId() {
    return id;
  }

  public int getRestaurantId() {
    return restaurant_id;
  }
  @Override
  public boolean equals(Object anotherReview) {
    if(!(anotherReview instanceof Review)){
      return false;
    }else {
      Review newReview = (Review) anotherReview;
      return this.getDescription().equals(newReview.getRestaurantId()) &&
        this.getId() == newReview.getId() &&
        this.getRestaurantId() == newReview.getRestaurantId();
    }
  }
  public static List <Review> all(){
    String sql = "SELECT id, description, id FROM reviews";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Review.class);
    }
  }

  public void save(){
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO reviews (description, restaurant_id) VALUES (:description, :restaurant_id)";
      this.id = (int) con.createQuery(sql, true)
      .addParameter("description", this.description)
      .addParameter("restaurant_id", this.restaurant_id)
      .executeUpdate()
      .getKey();
    }
  }

  public static Review find (int id){
    try(Connection con = DB.sql2o.open()) {
    String sql = "SELECT * FROM reviews WHERE id=:id";
    Review review = con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(Review.class);
       return review;
    }
  }
}
