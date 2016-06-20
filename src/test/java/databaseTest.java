import com.smartcity.dao.APIMapper;
import com.smartcity.models.API;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ZJDX on 2016/6/17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class databaseTest {
    private static Logger log = LoggerFactory.getLogger(databaseTest.class);

    @Autowired
    APIMapper apiMapper;

    @Test
    public void getAPI(){
        try {
            API api = apiMapper.selectByPrimaryKey(1);
            System.out.println(apiMapper.selectByPrimaryKey(1).getOriginalapi());
        } catch(Exception e) {
            log.info(e.getMessage());
        }
    }

}
