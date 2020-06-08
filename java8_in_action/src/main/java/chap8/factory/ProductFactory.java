package chap8.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @author : lh
 * @since : 2020/6/8, Mon
 **/
public class ProductFactory {
    public static Product createProduct(String name) {
        //switch (name) {
        //    case "loan":
        //        return new Loan();
        //    case "stock":
        //        return new Stock();
        //    case "bond":
        //        return new Bond();
        //    default:
        //        throw new RuntimeException("No such product " + name);
        //}
        Supplier<Product> p = map.get(name);
        if (p != null) {
            return p.get();
        }
        throw new RuntimeException("No such product " + name);
    }

    public static void main(String[] args) {
        Product p = ProductFactory.createProduct("loan");

        Supplier<Product> loanSupplier = Loan::new;
        Loan loan = (Loan) loanSupplier.get();


    }

    final static Map<String, Supplier<Product>> map = new HashMap<>();

    static {
        map.put("loan", Loan::new);
        map.put("stock", Stock::new);
        map.put("bond", Bond::new);
    }

    public static interface Product {
    }

    static private class Loan implements Product {
    }

    static private class Stock implements Product {
    }

    static private class Bond implements Product {
    }
}

