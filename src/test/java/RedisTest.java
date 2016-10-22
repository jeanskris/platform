import com.smartcity.dao.redis.RedisDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ZJDX on 2016/10/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class RedisTest {

    @Autowired
    private RedisDao redisDao;

    @Test
    public void saveOne() throws InterruptedException{
        redisDao.save("test1","test1323");
    }
    @Test
    public void readOne() throws InterruptedException{
        System.out.println(redisDao.read("test1"));
    }
    @Test
    public void delete() throws InterruptedException{
         redisDao.delete("test");
    }
    @Test
    public void test() throws InterruptedException{
        List<String> l=new ArrayList<String>(1);
        int t=l.size();
         l.add(0,"1");
        l.add(1,"2");
        String s[]=new String[1];
        s[0]="1";
        List<String> m= Arrays.asList(s);
    }

}
