import com.web.service.impl.TransactionImpl;
import com.web.entity.Transaction;

/**
 * Created by Mew on 2017/7/8.
 */
public class TestTransactionDao {

    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("application-spring-mybatis.xml");
//        TransactionDao dao = context.getBean(TransactionDao.class);
//        TransactionService transaction = dao.getTransaction(22);
//        System.out.println(transaction.getContentId()+" " + transaction.getPrice()+ " " + transaction.getTitle());
        TransactionImpl getTransaction = new TransactionImpl();
        Transaction transaction = getTransaction.getTransaction(24);
        System.out.println( transaction.getContentId() + " " + transaction.getPrice() +" "+ transaction.getContentId() );
    }
}
