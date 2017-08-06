import com.web.service.impl.ProductImpl;
import com.web.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

/**
 * Created by Mew on 2017/7/8.
 */
@ContextConfiguration(locations = {"classpath:application-spring-mybatis.xml"})
public class TestProductDto {

    @Autowired
    private static ProductImpl productImpl;
    public static void main(String[] args) {
        List<Product> productList = productImpl.getProductList();
        for (Product product : productList
                ) {
            System.out.println(product.getIsBuy() + ":" + product.getIsSell() + ":" + product.getTitle()+" "+ product.getPic());
        }
    }
}
