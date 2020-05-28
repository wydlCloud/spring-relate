import com.wy.iocanno.SpringConfig;
import com.wy.iocanno.dao.AccountDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author wy
 */
public class IoCTest {


    @Test
    public void testIoC() throws Exception {

        // 通过读取classpath下的xml文件来启动容器（xml模式SE应用下推荐）
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);

        AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");

        System.out.println(accountDao);



    }
}
