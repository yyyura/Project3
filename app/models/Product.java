/**
 * Created by yyyura on 02/04/17.
 */

package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Product extends Model {

    @Id
    public int id;

    @Constraints.Required
    public String name;

    @Constraints.Required
    public String description;

    @Constraints.Required
    public String category;

    @Constraints.Required
    public int stock;

    @Constraints.Required
    public double price;

    public Product() {
    }

    public Product(int id, String name, String description, String category, int stock, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.stock = stock;
        this.price = price;
    }

    //Generic query helper for entity Computer with id Long
    public static Finder<Long, Product> find = new Finder<Long, Product>(Long.class, Product.class);

    //Find all Products in the database
    public static List<Product> findAll() {
        return Product.find.all();
    }


}
