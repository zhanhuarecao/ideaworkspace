package mongodb.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zk on 2017/6/23.
 */
public class TestUser {
    private static UserDao userDaoImpl;
    private static ClassPathXmlApplicationContext app;
    private static String collectionName;

    @BeforeClass
    public static void initSpring() {
        try {
            app = new ClassPathXmlApplicationContext(
                    "classpath:applicationContext.xml");
            userDaoImpl = (UserDao) app.getBean("userDaoImpl");
            collectionName = "doctest";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFind() {
        Map<String,Object> params=new HashMap<String,Object>();
        params.put("id", "0");
        List<User> users = userDaoImpl.findAll(params, collectionName);
        for (User u : users) {
            System.out.println(u);
        }
    }
}
