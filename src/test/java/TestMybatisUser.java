import com.web.dao.PersonDao;
import com.web.entity.Person;
import com.web.dto.IsUser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMybatisUser {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-spring-mybatis.xml");
		PersonDao dao = context.getBean(PersonDao.class);
		IsUser isUser = context.getBean(IsUser.class);
		Person person = dao.getPerson("buyer","37254660e226ea65ce6f1efd54233424");
		System.out.println(isUser.isUser("buyer","123"));
		System.out.println(person.getUserName()+" "+person.getUserPassword());
		((ConfigurableApplicationContext) context).close();
	}

}
